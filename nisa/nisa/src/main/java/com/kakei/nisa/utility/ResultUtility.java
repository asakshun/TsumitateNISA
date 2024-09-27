package com.kakei.nisa.utility;

import com.kakei.nisa.controller.form.ResultForm;
import org.springframework.stereotype.Component;

import javax.xml.transform.Result;

@Component
public class ResultUtility {

    public ResultForm addCommaAndYen (ResultForm resultForm) {
        resultForm.setMonthlyResultWithComma(addCommaAndYen(resultForm.getMonthlyResult()));
        resultForm.setMonthlySavingResultWithComma(addCommaAndYen(resultForm.getMonthlySavingResult()));
        return resultForm;
    }

    private String addCommaAndYen (int input) {

        String strInput = Integer.toString(input);
        //次のfor文でi=1にするため（i=0,0%3==0がTRUEになってしまう）、.lengthから-1。
        int strInputLength = strInput.length() - 1;
        StringBuilder sb = new StringBuilder(strInput);

        for (int i = 1; strInputLength > 0 ; i++) {

            if (i % 3 == 0) {
                sb.insert(strInputLength, ",");
            }
            strInputLength--;
        }
        sb.insert(0, "¥");
        return sb.toString();
    }

}
