package com.cinquecento.repository;

import com.cinquecento.model.domain.SWOTDir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SWOTDirRepository extends JpaRepository<SWOTDir, Long> {
}
