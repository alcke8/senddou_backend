package com.deeplify.table.domain.resumedetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeDetailRepository extends JpaRepository<ResumeDetail,Long> {
}
