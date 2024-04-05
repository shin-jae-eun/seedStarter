package com.example.seedstarter.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class SeedStarterAddForm {
    private LocalDateTime datePlanted;
    private boolean covered;
    private Type type;
    private String features; // FeatureType로 변경
    private String substrate;
    private String fertilizer;
    private String phCorrector;
    private String variety; // 품종

}
