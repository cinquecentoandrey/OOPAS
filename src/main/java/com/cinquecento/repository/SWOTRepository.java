package com.cinquecento.repository;

import com.cinquecento.model.domain.SWOT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SWOTRepository extends JpaRepository<SWOT, Long> {
}
