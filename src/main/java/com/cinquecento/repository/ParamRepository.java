package com.cinquecento.repository;

import com.cinquecento.model.domain.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParamRepository extends JpaRepository<Param, Long> {
}
