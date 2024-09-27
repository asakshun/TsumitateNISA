package com.kakei.nisa.controller;

import com.kakei.nisa.controller.form.UserInputForFinanceForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TopController {

    @GetMapping("/")
    public ModelAndView top() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("top");
        //計算結果の表示をオフにする
        mav.addObject("showResult", false);
        mav.addObject("userInputForm", new UserInputForFinanceForm());
        return mav;
    }
}
