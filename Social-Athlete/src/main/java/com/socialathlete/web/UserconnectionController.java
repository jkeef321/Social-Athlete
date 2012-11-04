package com.socialathlete.web;

import com.socialathlete.domain.Userconnection;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/userconnections")
@Controller
@RooWebScaffold(path = "userconnections", formBackingObject = Userconnection.class)
public class UserconnectionController {
}
