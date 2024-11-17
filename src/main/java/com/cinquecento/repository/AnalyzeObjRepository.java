package com.cinquecento.repository;

import com.cinquecento.model.domain.AnalyzeObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyzeObjRepository extends JpaRepository<AnalyzeObj, Long> {
}
