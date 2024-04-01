package com.example.seedstarter.controller;

import com.example.seedstarter.entity.SeedStarter;
import com.example.seedstarter.service.SeedStarterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class SeedStarterMngController {
    private final SeedStarterService seedStarterService;
    private final ObjectMapper mapper;
    @RequestMapping({"/", "/seedstartermng"})
    public String showSeedstarters(final SeedStarter seedStarter, Model model) throws JsonProcessingException {
        List<SeedStarter> seedStarterWithFeature = seedStarterService.findWithFeature();
        List<SeedStarter> seedStarterWithDetail = seedStarterService.findWithDetail();


        model.addAttribute("seedStarterWithFeature", seedStarterWithFeature);
        model.addAttribute("seedStarterWithDetail", seedStarterWithDetail);
        return "seedstartermng";

    }
}
