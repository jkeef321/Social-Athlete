package com.socialathlete.web;

import com.socialathlete.domain.SAPlayer;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/saplayers")
@Controller
@RooWebScaffold(path = "saplayers", formBackingObject = SAPlayer.class)
public class SAPlayerController {
}
