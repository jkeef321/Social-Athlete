// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.socialathlete.domain;

import com.socialathlete.domain.SAAccountType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

privileged aspect SAAccountType_Roo_Jpa_Entity {
    
    declare @type: SAAccountType: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long SAAccountType.id;
    
    @Version
    @Column(name = "version")
    private Integer SAAccountType.version;
    
    public Long SAAccountType.getId() {
        return this.id;
    }
    
    public void SAAccountType.setId(Long id) {
        this.id = id;
    }
    
    public Integer SAAccountType.getVersion() {
        return this.version;
    }
    
    public void SAAccountType.setVersion(Integer version) {
        this.version = version;
    }
    
}