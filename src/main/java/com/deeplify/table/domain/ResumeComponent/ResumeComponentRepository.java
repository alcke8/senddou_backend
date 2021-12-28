package com.deeplify.table.domain.ResumeComponent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeComponentRepository extends JpaRepository<ResumeComponent,Long> {
}
