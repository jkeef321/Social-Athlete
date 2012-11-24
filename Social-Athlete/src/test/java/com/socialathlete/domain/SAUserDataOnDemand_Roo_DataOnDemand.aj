// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.socialathlete.domain;

import com.socialathlete.domain.SAUser;
import com.socialathlete.domain.SAUserDataOnDemand;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.stereotype.Component;

privileged aspect SAUserDataOnDemand_Roo_DataOnDemand {
    
    declare @type: SAUserDataOnDemand: @Component;
    
    private Random SAUserDataOnDemand.rnd = new SecureRandom();
    
    private List<SAUser> SAUserDataOnDemand.data;
    
    public SAUser SAUserDataOnDemand.getNewTransientSAUser(int index) {
        SAUser obj = new SAUser();
        setEmailAddress(obj, index);
        setEnabled(obj, index);
        setFirstName(obj, index);
        setLastName(obj, index);
        setPassword(obj, index);
        setRole(obj, index);
        setUsername(obj, index);
        return obj;
    }
    
    public void SAUserDataOnDemand.setEmailAddress(SAUser obj, int index) {
        String emailAddress = "foo" + index + "@bar.com";
        obj.setEmailAddress(emailAddress);
    }
    
    public void SAUserDataOnDemand.setEnabled(SAUser obj, int index) {
        Boolean enabled = Boolean.TRUE;
        obj.setEnabled(enabled);
    }
    
    public void SAUserDataOnDemand.setFirstName(SAUser obj, int index) {
        String firstName = "firstName_" + index;
        obj.setFirstName(firstName);
    }
    
    public void SAUserDataOnDemand.setLastName(SAUser obj, int index) {
        String lastName = "lastName_" + index;
        obj.setLastName(lastName);
    }
    
    public void SAUserDataOnDemand.setPassword(SAUser obj, int index) {
        String password = "password_" + index;
        obj.setPassword(password);
    }
    
    public void SAUserDataOnDemand.setRole(SAUser obj, int index) {
        String role = "role_" + index;
        obj.setRole(role);
    }
    
    public void SAUserDataOnDemand.setUsername(SAUser obj, int index) {
        String username = "username_" + index;
        obj.setUsername(username);
    }
    
    public SAUser SAUserDataOnDemand.getSpecificSAUser(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        SAUser obj = data.get(index);
        Long id = obj.getId();
        return SAUser.findSAUser(id);
    }
    
    public SAUser SAUserDataOnDemand.getRandomSAUser() {
        init();
        SAUser obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return SAUser.findSAUser(id);
    }
    
    public boolean SAUserDataOnDemand.modifySAUser(SAUser obj) {
        return false;
    }
    
    public void SAUserDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = SAUser.findSAUserEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'SAUser' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<SAUser>();
        for (int i = 0; i < 10; i++) {
            SAUser obj = getNewTransientSAUser(i);
            try {
                obj.persist();
            } catch (ConstraintViolationException e) {
                StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getConstraintDescriptor()).append(":").append(cv.getMessage()).append("=").append(cv.getInvalidValue()).append("]");
                }
                throw new RuntimeException(msg.toString(), e);
            }
            obj.flush();
            data.add(obj);
        }
    }
    
}
