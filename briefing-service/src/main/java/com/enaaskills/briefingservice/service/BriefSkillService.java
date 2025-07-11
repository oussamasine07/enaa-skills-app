package com.enaaskills.briefingservice.service;
import com.enaaskills.briefingservice.feignclient.SkillInterface;
import com.enaaskills.briefingservice.model.Brief;
import com.enaaskills.briefingservice.model.BriefSkill;
import com.enaaskills.briefingservice.repository.BriefRepository;
import com.enaaskills.briefingservice.repository.BriefSkillRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public class BriefSkillService {

    private final BriefSkillRepository briefSkillRepository;
    private final BriefRepository briefRepository;
    private final SkillInterface skillInterface;

    public BriefSkillService (
            final BriefSkillRepository briefSkillRepository,
            final BriefRepository briefRepository,
            final SkillInterface skillInterface
    ) {
        this.briefSkillRepository = briefSkillRepository;
        this.briefRepository = briefRepository;
        this.skillInterface = skillInterface;
    }

    public ResponseEntity<?> assignSkillToBrief (Long briefId, Long skillId) {
        Brief brief = briefRepository.findById( briefId )
                .orElseThrow();

        ResponseEntity res = skillInterface.getSkillId( skillId );

        System.out.println(res.getBody());
        Long resSkillId = ((Number) res.getBody()).longValue();

        BriefSkill briefSkill = new BriefSkill();

        briefSkill.setBrief( brief );
        briefSkill.setSkillId( resSkillId );

        return new ResponseEntity<>( briefSkillRepository.save( briefSkill ), HttpStatus.OK);
    }

}





















