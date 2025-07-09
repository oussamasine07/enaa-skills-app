package com.enaaskills.briefingservice.service;


import com.enaaskills.briefingservice.model.Brief;
import com.enaaskills.briefingservice.repository.BriefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BriefService {

    @Autowired
    private BriefRepository briefRepository;


    public ResponseEntity<?> addBrief(Brief brief) {
        Brief savedBrief = briefRepository.save(brief);

        return new ResponseEntity<>(savedBrief, HttpStatus.CREATED);
    }

    public ResponseEntity<?> getAllBriefs() {
        List<Brief> allBriefs = briefRepository.findAll();
        return new ResponseEntity<>(allBriefs, HttpStatus.OK);
    }

    public ResponseEntity<?> getBriefById(Long id) {
        Brief brief = briefRepository.findById(id).orElse(null);
        return new ResponseEntity<>(brief, HttpStatus.OK);
    }
}
