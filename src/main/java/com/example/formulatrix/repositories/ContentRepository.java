package com.example.formulatrix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.formulatrix.entities.ContentEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContentRepository extends JpaRepository<ContentEntity, String> {
    
    Optional<ContentEntity> findByItemName(String itemName);

    Long deleteByItemName(String itemName);
}