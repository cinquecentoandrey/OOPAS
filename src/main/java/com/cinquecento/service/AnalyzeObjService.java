package com.cinquecento.service;

import com.cinquecento.model.domain.AnalyzeObj;
import com.cinquecento.repository.AnalyzeObjRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalyzeObjService {

    private final AnalyzeObjRepository analyzeObjRepository;

    public AnalyzeObj saveAnalyzeObj(AnalyzeObj analyzeObj) {
        return analyzeObjRepository.save(analyzeObj);
    }

    public AnalyzeObj getAnalyzeObj(Long id) {
        return analyzeObjRepository.findById(id).orElse(null);
    }

    public List<AnalyzeObj> getAllAnalyzeObjs() {
        return analyzeObjRepository.findAll();
    }

}
