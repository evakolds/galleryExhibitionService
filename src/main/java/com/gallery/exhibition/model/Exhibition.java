package com.gallery.exhibition.model;

import com.gallery.exhibition.ExhibitionRequest;
import com.gallery.exhibition.ExhibitionResponse;
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

    public static Exhibition fromExhibitionRequest(ExhibitionRequest exhibitionRequest) {
        return new Exhibition(UUID.randomUUID(),
                exhibitionRequest.getName(),
                exhibitionRequest.getOpen(),
                exhibitionRequest.getPrice());
    }

    public ExhibitionResponse toExhibitionResponse() {
        return ExhibitionResponse.newBuilder().
                setId(exhId.toString()).
                setName(name).
                setOpen(open).
                setPrice(price).
                build();
    }
}

