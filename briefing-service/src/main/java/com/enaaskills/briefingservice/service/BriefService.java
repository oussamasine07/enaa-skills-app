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

    public ResponseEntity<Long> getBriefId(Long id) {
        Brief brief = briefRepository.findById(id).orElse(null);
        return new ResponseEntity<>(brief.getId(), HttpStatus.OK);
    }

    public ResponseEntity<?> updateBrief(Long id, Brief brief) {
        Brief updatedBrief = briefRepository.findById(id).orElseThrow();
        updatedBrief.setTitle(brief.getTitle());
        updatedBrief.setDescription(brief.getDescription());
        updatedBrief.setStartDate(brief.getStartDate());
        updatedBrief.setEndDate(brief.getEndDate());
        updatedBrief.setDuration(brief.getDuration());
        updatedBrief.setEngagement(brief.getEngagement());
        return new ResponseEntity<>( briefRepository.save(updatedBrief), HttpStatus.OK );
    }

    public void deleteBrief (Long id) {
        briefRepository.deleteById(id);

    }


}
