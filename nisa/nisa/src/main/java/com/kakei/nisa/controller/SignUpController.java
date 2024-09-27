package com.kakei.nisa.controller;

import com.kakei.nisa.controller.form.UserForm;
import com.kakei.nisa.controller.form.UserInputForFinanceForm;
import com.kakei.nisa.service.SignUpServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUpController {
    @Autowired
    SignUpServiceInterface signUpServiceInterface;

    @GetMapping("/signup")
    public ModelAndView signup () {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("signup");
        mav.addObject("userForm", new UserForm());
        return mav;

    }

    @PostMapping("/signup/submit")
    public ModelAndView signup (@ModelAttribute("userForm") UserForm userForm) {
        ModelAndView mav = new ModelAndView();
        signUpServiceInterface.signUp(userForm);
        mav.setViewName("top");
        mav.addObject("userInputForm", new UserInputForFinanceForm());
        return mav;
    }

}
