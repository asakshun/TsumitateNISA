package com.kakei.nisa.utility;

import com.kakei.nisa.controller.form.IntUserInputForFinanceForm;
import com.kakei.nisa.controller.form.UserInputForFinanceForm;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserInputFormUtility {

    public IntUserInputForFinanceForm userInputFormToInt (UserInputForFinanceForm userInputForm) {
        IntUserInputForFinanceForm intForm = new IntUserInputForFinanceForm();
        intForm.setMonthlyIncome(stringToInt(userInputForm.getMonthlyIncome()));
        intForm.setMonthlyLivingCost(stringToInt(userInputForm.getMonthlyLivingCost()));
        intForm.setTotalMoney(stringToInt(userInputForm.getTotalMoney()));
        intForm.setXMonthsForEmergencyFund(stringToInt(userInputForm.getXMonthsForEmergencyFund()));
        if (userInputForm.getBonus().isBlank()) {
            intForm.setBonus(0);
        } else {
            intForm.setBonus(stringToInt(userInputForm.getBonus()));
        }
        intForm.setCurrentSavingGoal(stringToInt(userInputForm.getCurrentSavingGoal()));
        intForm.setSavingDeadline(stringToInt(userInputForm.getSavingDeadline()));

        return intForm;
    }

    private  int stringToInt (String before) {
        int after = Integer.parseInt(before.replace(",", ""));
        return after;
    }
}
