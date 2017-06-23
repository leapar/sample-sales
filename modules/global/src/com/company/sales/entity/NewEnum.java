/*
 * Copyright (c) 2017 com.company.sales.entity
 */
package com.company.sales.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;

/**
 * @author wangxiaohua
 */
public enum NewEnum implements EnumClass<Integer> {

    a(1),
    b(2);

    private Integer id;

    NewEnum(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static NewEnum fromId(Integer id) {
        for (NewEnum at : NewEnum.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}