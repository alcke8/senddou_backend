package com.deeplify.tutorial.oauthlogin.table.repository;

import com.deeplify.tutorial.oauthlogin.table.domain.user.User;
import com.deeplify.tutorial.oauthlogin.table.web.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserResumeRepository {

    private final EntityManager em;

    public void save(UserSaveRequestDto userSaveRequestDto){
        em.persist(userSaveRequestDto);
    }

    public User findUser(Long id){
        return em.find(User.class,id);
    }

    public List<User> findAll(){
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }

    public List<User> findByName(String name){
        return em.createQuery("select u from User u where u.us_nickname :name", User.class)
                .setParameter("name", name)
                .getResultList();
    }

}