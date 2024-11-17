package com.cinquecento.service;

import com.cinquecento.model.domain.Param;
import com.cinquecento.model.domain.PrmValue;
import com.cinquecento.repository.ParamRepository;
import com.cinquecento.repository.PrmValueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PrmValueService {

    private final PrmValueRepository prmValueRepository;

    public PrmValue savePrmValue(PrmValue prmValue) {
        return prmValueRepository.save(prmValue);
    }

    public PrmValue getPrmValue(Long id) {
        return prmValueRepository.findById(id).orElse(null);
    }

    public List<PrmValue> getPrmValuesByAnalyzeObjId(Long analyzeObjId) {
        return prmValueRepository.findAllByAnalyzeObj_Id(analyzeObjId);
    }

    public List<PrmValue> getAllPrmValues() {
        return prmValueRepository.findAll();
    }
}
