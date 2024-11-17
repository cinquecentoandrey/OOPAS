package com.cinquecento.service;

import com.cinquecento.model.domain.SWOT;
import com.cinquecento.repository.SWOTRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SWOTService {

    private final SWOTRepository swotRepository;

    public SWOT saveSWOT(SWOT swot) {
        return swotRepository.save(swot);
    }

    public SWOT getSWOT(Long id) {
        return swotRepository.findById(id).orElse(null);
    }

    public List<SWOT> getAllSWOTs() {
        return swotRepository.findAll();
    }
}
