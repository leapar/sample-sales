/*
 * Copyright (c) 2016 Haulmont
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.company.sales.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.List;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@NamePattern("%s|name")
@Table(name = "SALES_CUSTOMER")
@Entity(name = "sales$Customer")
public class Customer extends StandardEntity {
    private static final long serialVersionUID = -1591695782019653224L;

    @Column(name = "NAME", nullable = false, length = 100)
    protected String name;

    @Column(name = "EMAIL", length = 100)
    protected String email;

    @JoinTable(name = "SALES_CUSTOMER_FILE_DESCRIPTOR_LINK",
        joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
        inverseJoinColumns = @JoinColumn(name = "FILE_DESCRIPTOR_ID"))
    @OnDelete(DeletePolicy.CASCADE)
    @ManyToMany(fetch = FetchType.LAZY)
    protected List<FileDescriptor> files;

    public List<FileDescriptor> getFiles() {
        return files;
    }

    public void setFiles(List<FileDescriptor> files) {
        this.files = files;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


}