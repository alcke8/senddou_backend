package com.deeplify.tutorial.oauthlogin.table.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class ResumeContentRepository {

    private final EntityManager em;

}
