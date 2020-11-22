package com.gallery.exhibition.service;

import com.gallery.exhibition.model.Exhibition;

import java.util.List;
import java.util.UUID;

public interface ExhibitionService {
    Exhibition addExhibition(Exhibition exhibition);
    List<Exhibition> getAll();
    Exhibition getById(UUID id);
    void deleteById(UUID id);
}
