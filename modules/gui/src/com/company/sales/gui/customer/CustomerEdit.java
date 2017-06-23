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

import com.haulmont.cuba.core.app.FileStorageService;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.sales.entity.Customer;

import com.haulmont.cuba.gui.components.Embedded;
import com.haulmont.cuba.gui.components.FileMultiUploadField;
import com.haulmont.cuba.gui.components.VBoxLayout;
import com.haulmont.cuba.gui.data.DataSupplier;
import com.haulmont.cuba.gui.export.FileDataProvider;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import org.slf4j.Logger;


import javax.imageio.ImageIO;
import javax.inject.Inject;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

public class CustomerEdit extends AbstractEditor<Customer> {
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private FileMultiUploadField multiUpload;
    @Inject
    private DataSupplier dataSupplier;
    @Inject
    private ComponentsFactory componentsFactory;
    @Inject
    private VBoxLayout vboxImages;

    @Inject
    private FileStorageService fileStorageService;
    @Inject
    private Logger log;
    private static final int IMG_HEIGHT = 190;
    private static final int IMG_WIDTH = 220;

    @Override
    public void init(Map<String, Object> params) {
        multiUpload.addQueueUploadCompleteListener(() -> {
            ArrayList<FileDescriptor> files = new ArrayList<FileDescriptor>();

            for (Map.Entry<UUID, String> entry : multiUpload.getUploadsMap().entrySet()) {
                UUID fileId = entry.getKey();
                String fileName = entry.getValue();
                FileDescriptor fd = fileUploadingAPI.getFileDescriptor(fileId, fileName);
                // save file to FileStorage
                try {
                    fileUploadingAPI.putFileIntoStorage(fileId, fd);
                } catch (FileStorageException e) {
                    new RuntimeException("Error saving file to FileStorage", e);
                }
                // save file descriptor to database
                FileDescriptor committedFd = dataSupplier.commit(fd);
                files.add(committedFd);
                System.out.println(fileName);
                //addThumbnail(committedFd);

                Embedded embedded = componentsFactory.createComponent(Embedded.class);

                embedded.setType(Embedded.Type.IMAGE);
                embedded.setWidth("200px");
                embedded.setHeight("200px");

                FileDataProvider dataProvider = new FileDataProvider(committedFd);
                embedded.setSource(committedFd.getId() + "." + committedFd.getExtension(), dataProvider);

                vboxImages.add(embedded);
            }
            getItem().setFiles(files);
            multiUpload.clearUploads();


        });

    }

    @Override
    protected void postInit() {
        displayImage();
    }

    private void displayImage() {
        byte[] bytes = null;
        if (getItem().getFiles() != null) {

            for (FileDescriptor file: getItem().getFiles()
                 ) {
                try {
                    bytes = fileStorageService.loadFile(file);

                    if (bytes != null) {
                        Embedded embeddedImage = componentsFactory.createComponent(Embedded.class);


                        embeddedImage.setSource(file.getName(), new ByteArrayInputStream(bytes));
                        embeddedImage.setType(Embedded.Type.IMAGE);
                        BufferedImage image;
                        try {
                            image = ImageIO.read(new ByteArrayInputStream(bytes));
                            int width = image.getWidth();
                            int height = image.getHeight();

                            if (((double) height / (double) width) > ((double) IMG_HEIGHT / (double) IMG_WIDTH)) {
                                embeddedImage.setHeight(String.valueOf(IMG_HEIGHT));
                                embeddedImage.setWidth(String.valueOf(width * IMG_HEIGHT / height));
                            } else {
                                embeddedImage.setWidth(String.valueOf(IMG_WIDTH));
                                embeddedImage.setHeight(String.valueOf(height * IMG_WIDTH / width));
                            }
                        } catch (IOException e) {
                            log.error("Unable to resize image", e);
                        }
                        vboxImages.add(embeddedImage);
                    } else {

                    }
                } catch (FileStorageException e) {
                    log.error("Unable to load image file", e);
                    showNotification("Unable to load image file", NotificationType.HUMANIZED);
                }
            }

        }

    }
}