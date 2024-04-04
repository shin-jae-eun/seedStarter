package com.example.seedstarter.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeedStarterAddForm {
    private String datePlanted;
    private boolean covered;
    private String type;
    private String substrate;
    private String fertilizer;
    private String phCorrector;
}
