package com.socialathlete.web;

import com.socialathlete.domain.SATeam;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sateams")
@Controller
@RooWebScaffold(path = "sateams", formBackingObject = SATeam.class)
public class SATeamController {
}
