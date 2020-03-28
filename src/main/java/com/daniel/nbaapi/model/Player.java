package com.daniel.nbaapi.model;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private final UUID id;
    private final String name;

    public Player(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
