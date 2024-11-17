package com.cinquecento.service;

import com.cinquecento.model.domain.SWOTDir;
import com.cinquecento.repository.SWOTDirRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SWOTDirService {

    private final SWOTDirRepository swotDirRepository;

    public SWOTDir saveSWOTDir(SWOTDir swotDir) {
        return swotDirRepository.save(swotDir);
    }

    public SWOTDir getSWOTDir(Long id) {
        return swotDirRepository.findById(id).orElse(null);
    }

    public List<SWOTDir> getAllSWOTDirs() {
        return swotDirRepository.findAll();
    }
}
