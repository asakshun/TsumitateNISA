package com.kakei.nisa.controller.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultForm {

    private int monthlyResult;
    private int monthlySavingResult;
    private String monthlyResultWithComma;
    private String monthlySavingResultWithComma;
    private String remarks;
}
