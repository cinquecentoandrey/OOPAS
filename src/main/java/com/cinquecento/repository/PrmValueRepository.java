package com.cinquecento.repository;

import com.cinquecento.model.domain.PrmValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrmValueRepository extends JpaRepository<PrmValue, Long> {

    List<PrmValue> findAllByAnalyzeObj_Id(Long id);
}
