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
package com.company.sales.gui.customer;

import com.company.sales.entity.Customer;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.export.FileDataProvider;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;
import java.util.Map;

public class CustomerBrowse extends AbstractLookup {
    @Inject
    private ComponentsFactory componentsFactory;

    @Inject
    private Table<Customer> customersTable;

    @Override
    public void init(Map<String, Object> params) {
      /*  customersTable.addGeneratedColumn("files", entity -> {
            Embedded embedded = componentsFactory.createComponent(Embedded.class);

            embedded.setType(Embedded.Type.IMAGE);
            embedded.setWidth("40px");
            embedded.setHeight("40px");

            FileDescriptor userImageFile = entity.getFiles().get(0);
            FileDataProvider dataProvider = new FileDataProvider(userImageFile);
            embedded.setSource(userImageFile.getId() + "." + userImageFile.getExtension(), dataProvider);

            Label userLogin = componentsFactory.createComponent(Label.class);
            userLogin.setValue(entity.getName());
            userLogin.setAlignment(Alignment.MIDDLE_LEFT);

            HBoxLayout hBox = componentsFactory.createComponent(HBoxLayout.class);
            hBox.setSpacing(true);
            hBox.add(embedded);
            hBox.add(userLogin);

            return hBox;
        });*/
    }

    public Component generateFilesCell(Customer entity) {


        Embedded embedded = componentsFactory.createComponent(Embedded.class);

        embedded.setType(Embedded.Type.IMAGE);
        embedded.setWidth("40px");
        embedded.setHeight("40px");

        FileDescriptor userImageFile = entity.getFiles().get(0);
        FileDataProvider dataProvider = new FileDataProvider(userImageFile);
        embedded.setSource(userImageFile.getId() + "." + userImageFile.getExtension(), dataProvider);

		return embedded;
    }
}