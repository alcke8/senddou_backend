package com.deeplify.tutorial.oauthlogin.table.repository;

import com.deeplify.tutorial.oauthlogin.table.domain.user.UserResume;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserResumeRepository {

    private final EntityManager em;

    public void save(UserResume userResume){
        em.persist(userResume);
    }

    public UserResume findUser(Long id){
        return em.find(UserResume.class,id);
    }

    public List<UserResume> findAll(){
        return em.createQuery("select u from UserResume u", UserResume.class)
                .getResultList();
    }

    public List<UserResume> findByName(String name){
        return em.createQuery("select u from UserResume u where u.us_name= :name", UserResume.class)
                .setParameter("name", name)
                .getResultList();
    }

}