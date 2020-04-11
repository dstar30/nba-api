package com.daniel.nbaapi.model;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private final UUID id;
    private final String name;
    private int yearStart;
    private int yearEnd;
    private int height;
    private int weight;
    private Date birthDate;
    private String college;

    public Player(@JsonProperty("id") UUID id, @JsonProperty("name") String name){
        this.id = id;
        this.name = name;
    }

    public Player(UUID id, String name, int height, int weight){
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public Player(UUID id, String name, int yearStart, int yearEnd, int height, int weight, Date birthDate, String college) {
        this.id = id;
        this.name = name;
        this.yearStart = yearStart;
        this.yearEnd = yearEnd;
        this.height = height;
        this.weight = weight;
        this.birthDate = birthDate;
        this.college = college;
    }
}
