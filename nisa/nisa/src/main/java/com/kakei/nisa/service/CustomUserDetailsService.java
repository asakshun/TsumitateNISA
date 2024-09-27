package com.kakei.nisa.service;

import com.kakei.nisa.controller.form.UserInputForFinanceForm;
import com.kakei.nisa.repository.UserRepository;
import com.kakei.nisa.repository.entity.User;
import com.kakei.nisa.utility.UserUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.springframework.security.core.userdetails.User.withUsername;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserUtility userUtility;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        UserBuilder builder = withUsername(username);
        builder.password(user.getPassword());
        builder.roles(user.getRole());

        return builder.build();
    }
}
