package com.topkapi.jobsearch.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CheckEmailService {
    boolean isValid(String email);

    default Map<String, Boolean> isValid(List<String> emails) {
        Map<String, Boolean> checkedEmails = new HashMap<>();
        for (String email : emails) {
            checkedEmails.put(email, isValid(email));
        }
        return checkedEmails;
    }
}
