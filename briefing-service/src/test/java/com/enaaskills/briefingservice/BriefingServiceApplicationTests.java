package com.enaaskills.briefingservice;

import com.enaaskills.briefingservice.model.Brief;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BriefingServiceApplicationTests {

    @Test
    void contextLoads() {
            Brief brief = new Brief();
            brief.setTitle("title brief");
            brief.setDescription("description brief");

            Brief addBrief = BriefService.addBrief(brief);

            assertNotnull(addBrief)
    }

}
