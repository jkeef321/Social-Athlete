package com.socialathlete.web;

import com.socialathlete.domain.SALeague;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/saleagues")
@Controller
@RooWebScaffold(path = "saleagues", formBackingObject = SALeague.class)
public class SALeagueController {
}
