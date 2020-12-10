package com.gallery.exhibition.api;

import com.gallery.exhibition.model.Exhibition;
import com.gallery.exhibition.service.ExhibitionService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/exhibition")
@AllArgsConstructor
@NoArgsConstructor
public class ExhibitionRestController {

    @Autowired
    ExhibitionService exhibitionsService;

    @PostMapping
    public Exhibition createExhibition(@RequestBody Exhibition exhibition) {
        return exhibitionsService.addExhibition(exhibition);
    }

    @GetMapping
    public List<Exhibition> getAll() {
        return exhibitionsService.getAll();
    }

    @GetMapping("{exhibitionId}")
    public Exhibition getById(@PathVariable(value = "exhibitionId") UUID id) {
        return exhibitionsService.getById(id);
    }

    @DeleteMapping("{filmId}")
    public ResponseEntity<Void> deleteExhibition(@PathVariable(value = "exhibitionId") UUID id) {
        exhibitionsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
