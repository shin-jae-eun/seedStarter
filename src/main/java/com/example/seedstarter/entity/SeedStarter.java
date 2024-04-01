package com.example.seedstarter.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NamedEntityGraphs(
        {
                @NamedEntityGraph(name = "SeedStarter.withFeature", attributeNodes = {
                        @NamedAttributeNode("features")
                }),
                @NamedEntityGraph(name = "SeedStarter.withDetail", attributeNodes = {
                        @NamedAttributeNode("details")
                })
        }
)

@Entity
public class SeedStarter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEED_STARTER_ID")
    private Long id;
    private LocalDateTime datePlanted;
    private boolean covered;
    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToMany(mappedBy = "seedStarter", cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JsonManagedReference
    private List<Feature> features = new ArrayList<>();

    @OneToMany(mappedBy = "seedStarter", cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JsonManagedReference
    private List<Detail> details = new ArrayList<>();

    public void setFeature(Feature feature) {
        this.features.add(feature);
        feature.setSeedStarter(this);
    }

    public void setDetail(Detail detail) {
        this.details.add(detail);
        detail.setSeedStarter(this);
    }
}