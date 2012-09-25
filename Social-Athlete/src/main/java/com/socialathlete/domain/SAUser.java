package com.socialathlete.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class SAUser {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String emailAddress;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<SASocialAccount> socialAccounts = new HashSet<SASocialAccount>();

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<SAPlayer> following = new HashSet<SAPlayer>();
}
