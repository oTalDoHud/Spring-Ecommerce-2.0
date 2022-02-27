package com.hudlucas.springeccomerce.repositories;

import com.hudlucas.springeccomerce.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
