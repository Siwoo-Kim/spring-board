package com.springboard.project.repository;

import com.springboard.project.domain.User;
import lombok.extern.java.Log;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;

@Log
@Repository @Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    SqlSession sqlSession;
    @Value("${mybatis.mapper.namespace.user}")
    private String NAMESPACE;

    @Override @Transactional(readOnly = false)
    public User create(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        log.warning(NAMESPACE);
        log.warning(email);
        log.warning(password);
        Map<String,Object> params = new HashMap<>();
        params.put("email",email);
        params.put("password",password);
        return sqlSession.selectOne(NAMESPACE+".findByEmailAndPassword",params);
    }
}
