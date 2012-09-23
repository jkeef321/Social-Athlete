package com.socialathlete.web;

import com.socialathlete.domain.SAUser;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sausers")
@Controller
@RooWebScaffold(path = "sausers", formBackingObject = SAUser.class)
public class SAUserController {
}
