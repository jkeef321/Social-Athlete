// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.socialathlete.web;

import com.socialathlete.domain.SALeague;
import com.socialathlete.web.SALeagueController;
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

privileged aspect SALeagueController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String SALeagueController.create(@Valid SALeague SALeague_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, SALeague_);
            return "saleagues/create";
        }
        uiModel.asMap().clear();
        SALeague_.persist();
        return "redirect:/saleagues/" + encodeUrlPathSegment(SALeague_.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String SALeagueController.createForm(Model uiModel) {
        populateEditForm(uiModel, new SALeague());
        return "saleagues/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String SALeagueController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("saleague_", SALeague.findSALeague(id));
        uiModel.addAttribute("itemId", id);
        return "saleagues/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String SALeagueController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("saleagues", SALeague.findSALeagueEntries(firstResult, sizeNo));
            float nrOfPages = (float) SALeague.countSALeagues() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("saleagues", SALeague.findAllSALeagues());
        }
        return "saleagues/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String SALeagueController.update(@Valid SALeague SALeague_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, SALeague_);
            return "saleagues/update";
        }
        uiModel.asMap().clear();
        SALeague_.merge();
        return "redirect:/saleagues/" + encodeUrlPathSegment(SALeague_.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String SALeagueController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, SALeague.findSALeague(id));
        return "saleagues/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String SALeagueController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        SALeague SALeague_ = SALeague.findSALeague(id);
        SALeague_.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/saleagues";
    }
    
    void SALeagueController.populateEditForm(Model uiModel, SALeague SALeague_) {
        uiModel.addAttribute("SALeague_", SALeague_);
    }
    
    String SALeagueController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
