package com.enaaskills.briefingservice.service;


import com.enaaskills.briefingservice.model.Brief;
import com.enaaskills.briefingservice.model.Engagement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

@ActiveProfiles("test")
@SpringBootTest
public class BriefServiceTest {

    @Autowired
    private BriefService briefService;

    @Test
    void testAddBrief() {
        Brief brief = new Brief();
        brief.setTitle("Test brief");
        brief.setDescription("Test description");
        brief.setLaunchDate(LocalDate.now());
        brief.setStartDate(LocalDate.of(2025, 7, 10));
        brief.setEndDate(LocalDate.of(2025, 7, 20));
        brief.setDuration(10);
        brief.setEngagement(Engagement.INDIVIDUAL);

        var response = briefService.addBrief(brief);

        Assertions.assertNotNull(response.getBody());
    }
}
