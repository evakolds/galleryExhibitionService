package com.gallery.exhibition.service;

import com.gallery.exhibition.model.Exhibition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public final class ExhibitionServiceImpl implements ExhibitionService {

    @Autowired
    private ExhibitionRepository exhibitionRepository;

    @Override
    public Exhibition addExhibition(Exhibition exhibition) {
        Exhibition savedExhibition = exhibitionRepository.save(exhibition);
        return savedExhibition;
    }

    @Override
    public List<Exhibition> getAll() {
        return exhibitionRepository.findAll();
    }

    @Override
    public Exhibition getById(UUID id) {
        return exhibitionRepository.getOne(id);
    }

    @Override
    public void deleteById(UUID id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://gallery/delete-by-exhibition/" + id.toString());
        exhibitionRepository.deleteById(id);
    }

}
