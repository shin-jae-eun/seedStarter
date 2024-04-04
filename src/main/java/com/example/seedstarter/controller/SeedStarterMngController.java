package com.example.seedstarter.controller;

import com.example.seedstarter.entity.SeedStarter;
import com.example.seedstarter.entity.SeedStarterAddForm;
import com.example.seedstarter.service.SeedStarterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class SeedStarterMngController {
    private final SeedStarterService seedStarterService;
    private final ObjectMapper mapper;
    @ModelAttribute
    public void addttribute(Model model){
        model.addAttribute("seedStarterAddForm", new SeedStarterAddForm());
    }
    @RequestMapping({"/", "/seedstartermng"})
    public String showSeedstarters(final SeedStarter seedStarter, Model model) throws JsonProcessingException {
        List<SeedStarter> seedStarterWithFeature = seedStarterService.findWithFeature();
        List<SeedStarter> seedStarterWithDetail = seedStarterService.findWithDetail();

        model.addAttribute("seedStarterWithFeature", seedStarterWithFeature);
        model.addAttribute("seedStarterWithDetail", seedStarterWithDetail);

        return "seedstartermng";

    }
    @PostMapping("/seedstartermng")
    public String addSeedStarter(@ModelAttribute SeedStarterAddForm seedStarterAddForm, Model model){
        System.out.println("seedStarterAddForm.getDatePlanted() = " + seedStarterAddForm.getDatePlanted());
        System.out.println("seedStarterAddForm.isCovered() = " + seedStarterAddForm.isCovered());
        System.out.println("seedStarterAddForm.getType() = " + seedStarterAddForm.getType());
        System.out.println("seedStarterAddForm.getFertilizer() = " + seedStarterAddForm.getFertilizer());
        System.out.println("seedStarterAddForm.getSubstrate() = " + seedStarterAddForm.getSubstrate());
        System.out.println("seedStarterAddForm.getPhCorrector() = " + seedStarterAddForm.getPhCorrector());
        return "redirect:/";
    }
}
