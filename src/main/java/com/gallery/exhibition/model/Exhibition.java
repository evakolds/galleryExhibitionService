package com.gallery.exhibition.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.UUID;

@EnableAutoConfiguration
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public final class Exhibition {

    @Id
    private UUID exhId;

    @Column(unique = true)
    private String name;
    private Boolean open;
    private Integer price;

    public Exhibition(String name, Boolean open, Integer price) {
        exhId = UUID.randomUUID();
        this.name = name;
        this.open = open;
        this.price = price;
    }

}

