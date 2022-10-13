package com.example.equi.controller;


import com.example.equi.model.Equi;
import com.example.equi.EquiRepository;
//import jdk.nashorn.internal.ir.IdentNode;
//import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EquiController {
    @Autowired
//   @Autowired(required = false)
    private EquiRepository equiRepository;
    private Equi equis;
    private Model model;


    @RequestMapping(value = {"/test"}, method = RequestMethod.GET)
//    @GetMapping("/test")
    public String welcome(Model model) {
//        Iterable<Equi> equi = equiRepository.findAll();
//        model.addAttribute("equi", equi);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("admin");
//        return modelAndView;
        return "admin";
    }

    //    @GetMapping(value = "/admin")
    @GetMapping(value = "/admin")
    public String main(Model model) {
//    public String mainn(String firstName) {
        Iterable<Equi> equis = equiRepository.findAll();
//       Equi equi = equiRepository.findById(6).orElse( null );
//        model.addAttribute("all", new Equi());
        model.addAttribute("equis", equis);
//        this.firstName = "test";
//       ModelAndView admin = new ModelAndView("admin.html");
        return "admin";
//        return "admin";
    }

    @GetMapping("admin/add")
    public String AdminAdd(Model model) {
        Equi equi = new Equi();
        model.addAttribute("equi", equi);
        return "form";

    }

    @PostMapping("admin/add")
    public String AdminAddSubmit(@ModelAttribute Equi equi, Model model) {
        equiRepository.save(equi);
        model.addAttribute("equis", equiRepository.findAll());
        return "admin";
    }

    @GetMapping("/admin/delete/{equiId}")
    public String AdminDelete(@PathVariable("equiId") Integer id, Model model) {
        equiRepository.deleteById(id);
        model.addAttribute("equis", equiRepository.findAll());
        return "admin";
    }

    @GetMapping("/admin/edit/{equiId}")
    public String AdminEdit(@PathVariable("equiId") Integer id, Model model) {
        Equi equi = equiRepository.findById(id).orElse(null);
        model.addAttribute("equi", equi);
        return "form";
    }

//    @GetMapping("/equi")
//    @ResponseBody
//    public List<Equi> getAllEqui() {
//        return (List<Equi>) equiRepository.findAll();
//    }

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