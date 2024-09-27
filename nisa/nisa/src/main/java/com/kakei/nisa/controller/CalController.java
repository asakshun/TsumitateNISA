package com.kakei.nisa.controller;

import com.kakei.nisa.controller.form.IntUserInputForFinanceForm;
import com.kakei.nisa.controller.form.ResultForm;
import com.kakei.nisa.controller.form.UserInputForFinanceForm;
import com.kakei.nisa.service.CalService;
import com.kakei.nisa.service.CalServiceInterface;
import com.kakei.nisa.utility.ResultUtility;
import com.kakei.nisa.utility.UserInputFormUtility;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CalController {
    @Autowired
    CalServiceInterface calServiceInterface;
    @Autowired
    UserInputFormUtility userInputFormUtility;

    @PostMapping("/submit")
    public ModelAndView calResult(@Valid @ModelAttribute("userInputForm") UserInputForFinanceForm userInputForm, BindingResult bindingResult) {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("top");

        IntUserInputForFinanceForm intUserInputForFinanceForm = userInputFormUtility.userInputFormToInt(userInputForm);

        if (bindingResult.hasErrors()) {
            return mav;
        }

        ResultForm result = calServiceInterface.calMain(intUserInputForFinanceForm);

        mav.addObject("result", result.getRemarks());
        //計算結果の表示をオンにする
        mav.addObject("showResult", true);
        mav.addObject("resultForm", result);
        mav.addObject("userInputForm", userInputForm);
        return mav;

    }
}