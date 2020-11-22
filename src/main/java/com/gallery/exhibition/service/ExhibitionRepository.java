package com.gallery.exhibition.service;
import com.gallery.exhibition.model.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExhibitionRepository extends JpaRepository<Exhibition, UUID> {

}
