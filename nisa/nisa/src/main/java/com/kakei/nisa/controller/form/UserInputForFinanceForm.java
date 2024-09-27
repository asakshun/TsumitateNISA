package com.kakei.nisa.controller.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
public class UserInputForFinanceForm {
    @NotBlank(message = "必須項目です")
    private String monthlyIncome;
    @NotBlank(message = "必須項目です")
    private String monthlyLivingCost;
    @NotBlank(message = "必須項目です")
    private String totalMoney;
    @NotBlank(message = "必須項目です")
    private String xMonthsForEmergencyFund;
    @NotBlank(message = "必須項目です")
    private String currentSavingGoal;
    @NotBlank(message = "必須項目です")
    private String savingDeadline;
    private String bonus;

}
