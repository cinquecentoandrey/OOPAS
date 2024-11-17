package com.cinquecento.service;

import com.cinquecento.model.domain.Param;
import com.cinquecento.repository.ParamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParamService {

    private final ParamRepository paramRepository;

    public Param saveParam(Param param) {
        return paramRepository.save(param);
    }
    public Param getParam(Long id) {
        return paramRepository.findById(id).orElse(null);
    }

    public List<Param> getAllParams() {
        return paramRepository.findAll();
    }
}
