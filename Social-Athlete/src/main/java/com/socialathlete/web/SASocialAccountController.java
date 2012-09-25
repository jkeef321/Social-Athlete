package com.socialathlete.web;

import com.socialathlete.domain.SASocialAccount;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sasocialaccounts")
@Controller
@RooWebScaffold(path = "sasocialaccounts", formBackingObject = SASocialAccount.class)
public class SASocialAccountController {
}
