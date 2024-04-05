package com.example.seedstarter.controller;

import com.example.seedstarter.entity.Feature;
import com.example.seedstarter.entity.FeatureType;
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

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class SeedStarterMngController {
    private final SeedStarterService seedStarterService;
    private final ObjectMapper mapper;

    @ModelAttribute
    public void addAttribute(Model model){
        model.addAttribute("seedStarterAddForm", new SeedStarterAddForm());
    }

    @RequestMapping({"/", "/seedstartermng"})
    public String showSeedstarters(Model model) throws JsonProcessingException {
        List<SeedStarter> seedStarterWithFeature = seedStarterService.findWithFeature();
        List<SeedStarter> seedStarterWithDetail = seedStarterService.findWithDetail();

        model.addAttribute("seedStarterWithFeature", seedStarterWithFeature);
        model.addAttribute("seedStarterWithDetail", seedStarterWithDetail);

        return "seedstartermng";
    }

    @PostMapping("/seedstartermng")
    public String addSeedStarter(@ModelAttribute SeedStarterAddForm seedStarterAddForm, Model model){
        SeedStarter seedStarter = toSeedStarter(seedStarterAddForm);
        seedStarterService.save(seedStarter); // 저장 메소드 호출

        return "redirect:/";
    }

    // SeedStarterAddForm 객체를 SeedStarter 객체로 변환하는 메소드
    private SeedStarter toSeedStarter(SeedStarterAddForm seedStarterAddForm){
        SeedStarter seedStarter = new SeedStarter();
        seedStarter.setDatePlanted(seedStarterAddForm.getDatePlanted());
        seedStarter.setCovered(seedStarterAddForm.isCovered());
        seedStarter.setType(seedStarterAddForm.getType());
        seedStarter.setFeatures(seedStarterAddForm.getFeatures());

        return seedStarter;
    }


}
