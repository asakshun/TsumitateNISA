package com.kakei.nisa.controller.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntUserInputForFinanceForm {

    private int monthlyIncome;
    private int monthlyLivingCost;
    private int totalMoney;
    private int xMonthsForEmergencyFund;
    private int currentSavingGoal;
    private int savingDeadline;
    private int bonus;
}
