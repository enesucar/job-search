package com.topkapi.jobsearch.service;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;

@Component("commonsCheckEmailService")
public class CommonsCheckEmailService implements  CheckEmailService{
    @Override
    public boolean isValid(String email) {
        return EmailValidator.getInstance().isValid(email);
    }
}
