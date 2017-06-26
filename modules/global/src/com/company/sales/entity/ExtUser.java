/*
 * Copyright (c) 2017 com.company.sales.entity
 */
package com.company.sales.entity;

import javax.persistence.Entity;
import javax.persistence.Column;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.core.entity.annotation.Extends;

/**
 * @author wangxh
 */
@Extends(User.class)
@Entity(name = "sales$ExtUser")
public class ExtUser extends User {
    private static final long serialVersionUID = -8657084715250224427L;

    @Column(name = "IMEI", unique = true)
    protected String imei;

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getImei() {
        return imei;
    }


}