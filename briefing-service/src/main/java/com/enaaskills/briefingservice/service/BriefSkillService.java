package com.enaaskills.briefingservice.service;
import com.enaaskills.briefingservice.model.Brief;
import com.enaaskills.briefingservice.repository.BriefRepository;
import com.enaaskills.briefingservice.repository.BriefSkillRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public class BriefSkillService {

    private final BriefSkillRepository briefSkillRepository;
    private final BriefRepository briefRepository;

    public BriefSkillService (
            final BriefSkillRepository briefSkillRepository,
            final BriefRepository briefRepository
    ) {
        this.briefSkillRepository = briefSkillRepository;
        this.briefRepository = briefRepository;
    }

    public ResponseEntity<?> assignSkillToBrief (Long briefId, Long skillId) {
        Brief brief = briefRepository.findById( briefId )
                .orElseThrow();

        return null;
    }

}





















