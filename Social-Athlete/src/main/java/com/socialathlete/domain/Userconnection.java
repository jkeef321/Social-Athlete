package com.socialathlete.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Userconnection {

    @NotNull
    @Size(max = 255)
    private String userid;

    @NotNull
    @Size(max = 255)
    private String providerid;

    @Size(max = 255)
    private String provideruserid;

    @NotNull
    private Integer rank;

    @Size(max = 255)
    private String displayname;

    @Size(max = 512)
    private String profileurl;

    @Size(max = 512)
    private String imageurl;

    @NotNull
    @Size(max = 255)
    private String accesstoken;

    @Size(max = 255)
    private String secret;

    @Size(max = 255)
    private String refreshtoken;

    private Long expiretime;
}
