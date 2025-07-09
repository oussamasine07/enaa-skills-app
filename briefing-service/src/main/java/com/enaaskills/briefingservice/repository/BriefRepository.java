package com.enaaskills.briefingservice.repository;

import com.enaaskills.briefingservice.model.Brief;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BriefRepository extends JpaRepository<Brief, Long> {

}
