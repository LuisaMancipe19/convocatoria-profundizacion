package com.convo.profundizacion.repository;

import com.convo.profundizacion.entity.ProfesorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<ProfesorEntity, Long> {

    ProfesorEntity findByNumeroDocumento(String numeroDocumento);

    ProfesorEntity findById(int id);
}
