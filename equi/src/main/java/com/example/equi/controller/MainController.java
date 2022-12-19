package com.example.equi.controller;

import com.example.equi.Cache;
import com.example.equi.model.*;
import com.example.equi.service.FinIndicatorServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class MainController {

    @Autowired
    private final FinIndicatorServiceApi finIndicatorService;

    @Autowired
    private final Cache cache;

    public MainController(FinIndicatorServiceApi finIndicatorService, Cache cache) {
        this.finIndicatorService = finIndicatorService;
        this.cache = cache;
    }

    @GetMapping(value = "/fot_db")
    @ResponseBody
    public List<FOT> fot() {
        List<FOT> list = finIndicatorService.getFOT(1);
        for (FOT element : list) {
            cache.put(element, element);
        }
        return finIndicatorService.getFOT(1);
    }

    @GetMapping(value = "/equi_db")
    @ResponseBody
    public List<Equi> test2() {

        return finIndicatorService.getEqui(1);
    }
    //для теста
    @GetMapping(value = "/cache")
    @ResponseBody
    public List test4() {

        return finIndicatorService.getEquiCache(1);
    }
    //для теста
    @GetMapping(value = "/cache2")
    @ResponseBody
    public List test42() {

        return finIndicatorService.getEquiCacheAll();
    }


    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("fins", finIndicatorService.getAll());
        return "index";
    }

    @GetMapping(value = "/{finId}")

    public String newform(@PathVariable("finId") Integer id, Model model) throws InterruptedException {
        model.addAttribute("fin", finIndicatorService.getFin(id));
        model.addAttribute("btrips", finIndicatorService.getBtrip(id));
        model.addAttribute("equis", finIndicatorService.getEqui(id));
        model.addAttribute("fot", finIndicatorService.getFOT(id));
        return "new";

    }



    @PostMapping("new/addequi")
    public String AdminAddSubmit(@ModelAttribute Equi newequi, Model model) {
        finIndicatorService.addEqui(newequi);
        model.addAttribute("fin", finIndicatorService.getFin(newequi.getFinind()));
        model.addAttribute("btrips", finIndicatorService.getBtrip(newequi.getFinind()));
        model.addAttribute("equis", finIndicatorService.getEqui(newequi.getFinind()));
        model.addAttribute("fot", finIndicatorService.getFOT(newequi.getFinind()));
        return "redirect:" + "/new/" + newequi.getFinind();
    }

    //
    @GetMapping("/admin/delete/{equiId}")
    public String AdminDelete(@PathVariable("equiId") Integer id, Model model) {
        finIndicatorService.deleteEqui(id);

        return "index";
    }

    //
    @GetMapping("/admin/edit/{equiId}")
    public String AdminEdit(@PathVariable("equiId") Integer id, Model model) {
        Equi equi = finIndicatorService.getEquiById(id).orElse(null);
        model.addAttribute("equi", equi);
        return "formequi";
    }

    //
//    // КОМАНДИРОВКИ
    @GetMapping("/addbtrip")
    public String BtripAdd(Model model) {
        model.addAttribute("btrip", new Btrip());
        return "formbtrip";
    }

    @PostMapping("btripadd")
    public String BtripAddSubmit(@ModelAttribute Btrip newbtrip, Model model) {
        finIndicatorService.addBtrip(newbtrip);
        model.addAttribute("fin", finIndicatorService.getFin(newbtrip.getFinind()));
        model.addAttribute("btrips", finIndicatorService.getBtrip(newbtrip.getFinind()));
        model.addAttribute("equis", finIndicatorService.getEqui(newbtrip.getFinind()));
        model.addAttribute("fot", finIndicatorService.getFOT(newbtrip.getFinind()));
        return "redirect:" + "/new/" + newbtrip.getFinind();
    }

    @GetMapping("/deletebtrip/{btripId}")
    public String BtripDelete(@PathVariable("btripId") Long id, Model model) {
        finIndicatorService.deleteBtrip(id);
        return "redirect:" + "/new";
    }


    @GetMapping("/editbtrip/{btripId}")
    public String BtripEdit(@PathVariable("btripId") Long id, Model model) {
        Btrip btrip = finIndicatorService.getBtripById(id).orElse(null);
        model.addAttribute("btrip", btrip);
        return "formbtrip";
    }

    // ФОТ
    @GetMapping("/addfot")
    public String fotAdd(Model model) {
        model.addAttribute("fot", new FOT());
        return "formfot";

    }

    @PostMapping("fotadd")
    public String fotAddSubmit(@ModelAttribute FOT newfot, Model model) {
        System.out.println(newfot.toString());
        finIndicatorService.addFOT(newfot);
        model.addAttribute("fin", finIndicatorService.getFin(newfot.getFinind()));
        model.addAttribute("btrips", finIndicatorService.getBtrip(newfot.getFinind()));
        model.addAttribute("equis", finIndicatorService.getEqui(newfot.getFinind()));
        model.addAttribute("fot", finIndicatorService.getFOT(newfot.getFinind()));
        return "redirect:" + "/new/" + newfot.getFinind();
    }


    @GetMapping("/deletefot/{fotId}")
    public String fotDelete(@PathVariable("fotId") Integer id, Model model) {
        finIndicatorService.getFOTById(id);
        return "redirect:" + "/new";
    }

    @GetMapping("/editfot/{fotId}")
    public String BtripEdit(@PathVariable("fotId") Integer id, Model model) {
        FOT fot = finIndicatorService.getFOTById(id).orElse(null);
        model.addAttribute("fot", fot);
        return "formfot";
    }


    @GetMapping("admin/addequi")
    public String AdminAdd(Model model) {
        Equi equi = new Equi();

        model.addAttribute("equi", equi);
        return "formequi";
    }

//    @PostMapping("/addfin")
//    public String FinAddSubmit(@ModelAttribute FinInd newFin, Model model) {
//        finIndicatorService.addFinInd(newequi);
//        model.addAttribute("fin",  finIndicatorService.getFin(newequi.getFinind()));
//        model.addAttribute("btrips", finIndicatorService.getBtrip(newequi.getFinind()));
//        model.addAttribute("equis", finIndicatorService.getEqui(newequi.getFinind()));
//        model.addAttribute("fot", finIndicatorService.getFOT(newequi.getFinind()));
//        return "redirect:" + "/new/" + newFin.getId();
//    }
}