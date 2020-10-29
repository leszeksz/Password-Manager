package com.leszeksz.passwordmanager.web;

import com.leszeksz.passwordmanager.entity.Data;
import com.leszeksz.passwordmanager.entity.Portal;
import com.leszeksz.passwordmanager.passwordGenerator.EncDec;
import com.leszeksz.passwordmanager.service.DataService;
import com.leszeksz.passwordmanager.service.PortalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("data")
public class DataController {

    private DataService dataService;
    private PortalService portalService;

    public DataController(DataService dataService, PortalService portalService) {
        this.dataService = dataService;
        this.portalService = portalService;
    }

    @GetMapping("add/{id}")
    public String dataAdd(Model model, @PathVariable long id) {
        model.addAttribute("portal", portalService.findOneById(id));
        return "generatePassword";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Portal portal) {
        String secretKey = "boooooooooom!!!!";
        Data data = new Data();
//        String data1 = data.getRandomGeneratedPassword();
//        String decodedPassword = EncDec.decrypt(data1,secretKey);
//        data.setRandomGeneratedPassword(decodedPassword);
        Data savedData=dataService.save(data);
        portal.setData(data);
        portalService.save(portal);
        return "redirect:/portal";
    }
}