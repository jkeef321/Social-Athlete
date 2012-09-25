package com.socialathlete.web;

import com.socialathlete.domain.SAAccountType;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/saaccounttypes")
@Controller
@RooWebScaffold(path = "saaccounttypes", formBackingObject = SAAccountType.class)
public class SAAccountTypeController {
}
