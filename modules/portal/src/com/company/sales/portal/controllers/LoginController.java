/*
 * Copyright (c) 2017 
 */
package com.company.sales.portal.controllers;

import com.company.sales.portal.command.LoginUserCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author wangxiaohua
 */
@Controller
public class LoginController {

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model) {
        final LoginUserCommand loginUserCommand = new LoginUserCommand();
        model.addAttribute(loginUserCommand);

        return "login";
    }

}