package com.kakei.nisa.service;

import com.kakei.nisa.controller.form.UserForm;
import com.kakei.nisa.repository.UserRepository;
import com.kakei.nisa.repository.entity.User;
import com.kakei.nisa.utility.UserInputFormUtility;
import com.kakei.nisa.utility.UserUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SignUpService implements SignUpServiceInterface{

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserUtility userUtility;
    @Override
    public void signUp(UserForm userForm) {
        //passwordをBCryptでエンコードして詰めなおす
        userForm.setPassword(userUtility.BCryptEncode(userForm.getPassword()));
        userForm.setRole("USER");
        userRepository.save(fromUserFormToUser(userForm));
    }

    private User fromUserFormToUser (UserForm userForm) {
        User user = new User();
        user.setId(userForm.getId());
        user.setUsername(userForm.getUsername());
        user.setPassword(userForm.getPassword());
        user.setRole(userForm.getRole());
        return user;
    }
}
