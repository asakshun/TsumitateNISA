package com.kakei.nisa.service;

import com.kakei.nisa.controller.form.IntUserInputForFinanceForm;
import com.kakei.nisa.controller.form.ResultForm;
import com.kakei.nisa.utility.ResultUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalService implements CalServiceInterface {

    @Autowired
    ResultUtility resultUtility;

    public ResultForm calMain  (IntUserInputForFinanceForm intUserInput) {

        int monthlyIncome = intUserInput.getMonthlyIncome();
        int monthlyLivingCost = intUserInput.getMonthlyLivingCost();
        int totalMoney = intUserInput.getTotalMoney();
        int xMonthsForEmergencyFund = intUserInput.getXMonthsForEmergencyFund();
        int bonus = intUserInput.getBonus();
        int currentSavingGoal = intUserInput.getCurrentSavingGoal();
        int savingDeadline = intUserInput.getSavingDeadline();

        int emergencyFund = monthlyLivingCost * xMonthsForEmergencyFund;
        int finalGoal = currentSavingGoal + emergencyFund ;


        ResultForm resultForm = new ResultForm();



        if ((totalMoney - emergencyFund) < 0) {
            //生活防衛費が足りないため、生活費を引いた世帯収入を全て貯金に回す
            resultForm.setMonthlySavingResult(monthlyIncome - monthlyLivingCost);
            resultForm.setRemarks("生活防衛費を早くためてください！！死にたいんですか！！");
            return resultUtility.addCommaAndYen(resultForm);
        }

        int monthlySavingResult = (finalGoal - totalMoney - bonus) / savingDeadline;
        int monthlyResult = monthlyIncome - monthlySavingResult - monthlyLivingCost;
        resultForm.setMonthlySavingResult(monthlySavingResult);
        resultForm.setMonthlyResult(monthlyResult);

        if (monthlySavingResult < 0) {
            resultForm.setRemarks("Nisaには" + monthlyResult + "円までなら投資可能です！（ただし"+ monthlyResult +"円全額投資は貯金が月に" + - monthlySavingResult + "円ずつ減りま～～）");
        } else {
            resultForm.setRemarks("月に" + monthlySavingResult + "円貯金してください！！ Nisaには" + monthlyResult + "円までなら投資可能です！");
        }
        return resultUtility.addCommaAndYen(resultForm);
    }
}
