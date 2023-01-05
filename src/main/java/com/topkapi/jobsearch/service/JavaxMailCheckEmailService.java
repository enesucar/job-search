package com.topkapi.jobsearch.service;

import org.springframework.stereotype.Component;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@Component("javaxMailCheckEmailService")
public class JavaxMailCheckEmailService implements CheckEmailService{
    @Override
    public boolean isValid(String email) {
        System.out.println(this.hashCode());
        try {
            InternetAddress internetAddress = new InternetAddress(email);
            internetAddress.validate();
        } catch (AddressException ex) {
            return false;
        }
        return true;
    }
}
