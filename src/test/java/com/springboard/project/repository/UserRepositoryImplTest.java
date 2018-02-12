package com.springboard.project.repository;

import com.springboard.project.domain.User;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

@Log
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/rootConfig.xml")
public class UserRepositoryImplTest {

    @Autowired UserRepository userRepository;
    @PersistenceContext EntityManager entityManager;

    @Test
    public void create(){

        User user = createUser();
        userRepository.create(user);
        User foundUser = entityManager.createQuery(
                "select u from User u where u.email = :email",User.class
        ).setParameter("email",user.getEmail()).getSingleResult();

        assertNotNull(foundUser);
        assertThat(user.getEmail(),is(foundUser.getEmail()));
        assertThat(user.getUsername(),is(foundUser.getUsername()));

    }

    @Test
    public void findByEmailAndPassword(){

        User user = createUser();
        userRepository.create(user);
        entityManager.flush();

        User foundUser = userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
        assertNotNull(foundUser);
        log.warning(foundUser::toString);

    }
    public static User createUser() {
        return User.builder()
                .username("user1")
                .password("1234")
                .email("user1@email.com")
                .build();
    }
}
