package com.yaros.stuckstruder.repository;

import com.yaros.stuckstruder.model.PublicacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRepositorio extends JpaRepository<PublicacionEntity, Long> {
}
