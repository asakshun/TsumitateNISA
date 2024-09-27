package com.kakei.nisa.service;

import com.kakei.nisa.controller.form.IntUserInputForFinanceForm;
import com.kakei.nisa.controller.form.ResultForm;

import java.util.List;

public interface CalServiceInterface {
    ResultForm calMain(IntUserInputForFinanceForm userInputForFinanceForm);
}
