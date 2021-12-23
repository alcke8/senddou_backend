package com.deeplify.tutorial.oauthlogin.table.repository;

import com.deeplify.tutorial.oauthlogin.table.domain.resume.Resume;
import com.deeplify.tutorial.oauthlogin.table.web.dto.ResumeRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ResumeRepository{

    private final EntityManager em;

    public void save(ResumeRequestDto resumeRequestDto){
        em.persist(resumeRequestDto);
    }

    public Resume findResume(Long id)
    {
        return em.find(Resume.class,id);
    }

    public List<Resume> findAll(){
        return em.createQuery("select r from Resume r", Resume.class)
                .getResultList();
    }

    public List<Resume> findByResumeId(Long id){
        return em.createQuery("select r from Resume r where r.re_id =:id",Resume.class)
                .setParameter("id",id)
                .getResultList();
     }


}
