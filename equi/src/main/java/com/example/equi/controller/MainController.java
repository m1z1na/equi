package com.example.equi.controller;

import com.example.equi.BtripRepository;
import com.example.equi.FinIndRepository;
import com.example.equi.FotRepository;
import com.example.equi.model.Btrip;
import com.example.equi.model.Equi;
import com.example.equi.EquiRepository;
import com.example.equi.model.FOT;
import com.example.equi.model.FinInd;
import com.example.equi.service.CalcBtrip;
import com.example.equi.service.CalcEqui;
import com.example.equi.service.CalcFOT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@org.springframework.stereotype.Controller
public class MainController {
    @Autowired
    private EquiRepository equiRepository;
    @Autowired
    private FinIndRepository finIndRepository;
    @Autowired
    private BtripRepository btripRepository;
    @Autowired
    private FotRepository fotRepository;

    @GetMapping(value = "/")
    public String index(Model model) {
        Iterable<FinInd> fin = finIndRepository.findAll();
        model.addAttribute("fin", fin);
        return "index";
    }

    @GetMapping(value = "/new")
    public String newform(Model model) {
        Iterable<Equi> equis = equiRepository.findAll();
        model.addAttribute("equis", equis);
        for (Equi equi : equis) {
            equi.setSum(CalcEqui.calcSum(equi.getAmount(), equi.getCost(), equi.getMarkup()));
        }
        Iterable<Btrip> btrips = btripRepository.findAll();
        for (Btrip btrip : btrips) {
            btrip.setSum(CalcBtrip.calcSum(btrip.getCostroad(), btrip.getCostliving(), btrip.getCostallowance(),
                    btrip.getDaysstay(), btrip.getDaystrip(), btrip.getPlannedtrips()));
        }
        model.addAttribute("btrips", btrips);

        Iterable<FOT> fots = fotRepository.findAll();
        for (FOT fot : fots) {
            fot.setSum(CalcFOT.calcSum(fot.getRate(), fot.getHours()));
        }
        model.addAttribute("fot", fots);

        return "new";
    }

    @GetMapping(value = "/admin")
    public String main(Model model) {
        Iterable<Equi> equis = equiRepository.findAll();
        // fore
//        CalcEqui calc = new CalcEqui;
        for (Equi equi : equis) {
            equi.setSum(CalcEqui.calcSum(equi.getAmount(), equi.getCost(), equi.getMarkup()));
        }

        model.addAttribute("equis", equis);
        return "admin";
    }

    @GetMapping("admin/add")
    public String AdminAdd(Model model) {
        Equi equi = new Equi();
        model.addAttribute("equi", equi);
        return "form";
//        return "new";

    }

    @PostMapping("new/add")
    public String AdminAddSubmit(@ModelAttribute Equi newequi, Model model) {
        equiRepository.save(newequi);
        Iterable<Equi> equis = equiRepository.findAll();
        for (Equi equi : equis) {
            equi.setSum(CalcEqui.calcSum(equi.getAmount(), equi.getCost(), equi.getMarkup()));
        }
        model.addAttribute("equis", equis);
        return "redirect:" + "/new";
    }

    @GetMapping("/admin/delete/{equiId}")
    public String AdminDelete(@PathVariable("equiId") Integer id, Model model) {
        equiRepository.deleteById(id);
        model.addAttribute("equis", equiRepository.findAll());
        return "new";
    }

    @GetMapping("/admin/edit/{equiId}")
    public String AdminEdit(@PathVariable("equiId") Integer id, Model model) {
        Equi equi = equiRepository.findById(id).orElse(null);
        model.addAttribute("equi", equi);
        return "form";
    }

    @GetMapping("/equi")
    @ResponseBody
    public List<Equi> getAllEqui() {
        return (List<Equi>) equiRepository.findAll();
    }

    @GetMapping("/fin")
    @ResponseBody
    public FinInd getAllfin() {
        return finIndRepository.findById(1).orElse(null);
    }
//    @GetMapping("/equi/{id}")
//    public ResponseEntity<Equi> getEquiById(@PathVariable(value = "id") Integer Id)
//            throws ResourceNotFoundException {
//        Equi employee = (Equi) equiRepository.findById(Id)
//                .orElseThrow(() -> new ResourceNotFoundException("Equi not found for this id :: " + Id));
//        return ResponseEntity.ok().body(employee);
//    }
//
//    @PostMapping("/equi")
//    @ResponseBody
//    public Equi createEqui(@Valid @RequestBody Equi equi) {
//        return equiRepository.save(equi);
//    }
//
//    @PutMapping("/equi/{id}")
//    @ResponseBody
//    public ResponseEntity<Equi> updateEqui(@PathVariable(value = "id") Integer Id,
//                                           @Valid @RequestBody Equi equiDetails) throws ResourceNotFoundException {
//        Equi equi = equiRepository.findById(Id).orElse(null);
////        Equi equi = (Equi) equi2;
////        model.addAttribute("equi", equi);
//        equi.setAmount(equiDetails.getAmount());
//        equi.setCost(equiDetails.getCost());
//        equi.setWaers(equiDetails.getWaers());
//        equi.setName(equiDetails.getName());
//        equi.setMarkup(equiDetails.getMarkup());
//        final Equi updatedEmployee = equiRepository.save(equi);
//        return ResponseEntity.ok(updatedEmployee);
//
//
////        Equi equi = (Equi) equiRepository.findById(Id)
////                .orElseThrow(() -> new ResourceNotFoundException("Equi not found for this id :: " + Id));
//
////        equi.setAmount(equiDetails.getAmount());
////        equi.setCost(equiDetails.getCost());
////        equi.setWaers(equiDetails.getWaers());
////        equi.setName(equiDetails.getName());
////        equi.setMarkup(equiDetails.getMarkup());
////        final Equi updatedEmployee = equiRepository.save(equi);
////        return ResponseEntity.ok(updatedEmployee);
//    }
//
//    @DeleteMapping("/equi/{id}")
//    @ResponseBody
//    public Map<String, Boolean> deleteEqui(@PathVariable(value = "id") Integer Id)
//            throws ResourceNotFoundException {
//        Equi equi = equiRepository.findById(Id)
//                .orElseThrow(() -> new ResourceNotFoundException("Equi not found for this id :: " + Id));
//
//        equiRepository.delete(equi);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }


}