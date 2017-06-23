package com.company.sales.desktop;

import javax.swing.*;

public class App extends com.haulmont.cuba.desktop.App {

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                app = new App();
                app.init(args);
                app.show();
                app.showLoginDialog();
            }
        });
    }
    
    @Override
    protected String getDefaultAppComponents() {
        return "com.haulmont.cuba";
    }
    
    @Override
    protected String getDefaultAppPropertiesConfig() {
        return "/cuba-desktop-app.properties /com/company/sales/desktop-app.properties";
    }

    @Override
    protected String getDefaultHomeDir() {
        return System.getProperty("user.home") + "/.cuba/sales";
    }

    @Override
    protected String getDefaultLogConfig() {
        return "desktop-logback.xml";
    }
}
