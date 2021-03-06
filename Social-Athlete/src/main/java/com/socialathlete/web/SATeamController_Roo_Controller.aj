// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.socialathlete.web;

import com.socialathlete.domain.SALeague;
import com.socialathlete.domain.SATeam;
import com.socialathlete.web.SATeamController;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect SATeamController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String SATeamController.create(@Valid SATeam SATeam_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, SATeam_);
            return "sateams/create";
        }
        uiModel.asMap().clear();
        SATeam_.persist();
        return "redirect:/sateams/" + encodeUrlPathSegment(SATeam_.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String SATeamController.createForm(Model uiModel) {
        populateEditForm(uiModel, new SATeam());
        return "sateams/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String SATeamController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("sateam_", SATeam.findSATeam(id));
        uiModel.addAttribute("itemId", id);
        return "sateams/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String SATeamController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("sateams", SATeam.findSATeamEntries(firstResult, sizeNo));
            float nrOfPages = (float) SATeam.countSATeams() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("sateams", SATeam.findAllSATeams());
        }
        return "sateams/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String SATeamController.update(@Valid SATeam SATeam_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, SATeam_);
            return "sateams/update";
        }
        uiModel.asMap().clear();
        SATeam_.merge();
        return "redirect:/sateams/" + encodeUrlPathSegment(SATeam_.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String SATeamController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, SATeam.findSATeam(id));
        return "sateams/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String SATeamController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        SATeam SATeam_ = SATeam.findSATeam(id);
        SATeam_.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/sateams";
    }
    
    void SATeamController.populateEditForm(Model uiModel, SATeam SATeam_) {
        uiModel.addAttribute("SATeam_", SATeam_);
        uiModel.addAttribute("saleagues", SALeague.findAllSALeagues());
    }
    
    String SATeamController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
