package com.enaaskills.briefingservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "skill-service", url = "${skill-service.url}", path = "/api/v1/skill")
public interface SkillInterface {

    @GetMapping("/skill-id/{id}")
    ResponseEntity<?> getSkillId (@PathVariable Long id);

}