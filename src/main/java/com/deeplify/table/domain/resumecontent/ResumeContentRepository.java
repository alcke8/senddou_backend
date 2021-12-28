package com.deeplify.table.domain.resumecontent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeContentRepository extends JpaRepository<ResumeContent,Long> {
}
