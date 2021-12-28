package com.deeplify.table.domain.contenttype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentIntroduceRepository extends JpaRepository<ContentIntroduce,Long> {
}
