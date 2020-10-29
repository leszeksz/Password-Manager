package com.leszeksz.passwordmanager.web;

import com.leszeksz.passwordmanager.entity.Data;
import com.leszeksz.passwordmanager.entity.Portal;
import com.leszeksz.passwordmanager.service.DataService;
import com.leszeksz.passwordmanager.service.PortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("portal")
public class PortalController {
    private PortalService portalService;
    private DataService dataService;

    @Autowired
    public PortalController(PortalService portalService, DataService dataService) {

        this.dataService = dataService;
        this.portalService = portalService;
    }

    @GetMapping("add")
    public String addPortal(Model model) {
        model.addAttribute("portal", new Portal());
        return "addPortal";
    }

    @PostMapping("/save")
    public String save(@Valid Portal portal, BindingResult validation) {
        if (validation.hasErrors()) {
            return "addPortal";
        }
        portalService.save(portal);
        return "redirect:/portal";
    }

    @GetMapping()
    public String allPortals(Model model) {
        List<Portal> portalList = this.portalService.findAll();
        List<Data> dataList = dataService.findAll();



        model.addAttribute("portalList", portalList);
        model.addAttribute("data", dataList);
        return "tablePortals";
    }

    @GetMapping("/edit/{id}")
    public String portalEdit(@PathVariable Long id, Model model) {
        Portal portal = portalService.findOneById(id);
        model.addAttribute("portal", portal);
        return "addPortal";
    }

    @GetMapping("/delete/{id}")
    public String deletePortal(@PathVariable long id, Model model,
                               @RequestParam(required = false, defaultValue = "false") boolean accept) {
        Portal portal = portalService.findOneById(id);
        if (!accept) {
            model.addAttribute("portal", portal);
            return "deletePortal";
        }
        portalService.delete(portal);
        return "redirect:/portal";
    }
}