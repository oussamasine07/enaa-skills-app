package com.enaaskills.validationservice.feignclient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "briefing-service", url = "${briefing-service.url}", path = "/briefs")
public interface BriefInterface {

    @GetMapping("/get-brief-by-id/{id}")
    public ResponseEntity<?> getBriefId(@PathVariable Long id);

    @GetMapping("/{id}")
    ResponseEntity<?> getBriefById(@PathVariable Long id);

}
