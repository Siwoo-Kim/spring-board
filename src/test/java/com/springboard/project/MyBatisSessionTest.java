package com.springboard.project;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/rootConfig.xml")
public class MyBatisSessionTest {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    /*mybatis session testing*/
    @Test
    public void sessionTest(){
      assertNotNull(sqlSessionFactory);

      try(SqlSession sqlSession = sqlSessionFactory.openSession()){
          System.out.println(sqlSession);
          assertNotNull(sqlSession);
      }catch(Exception e){
          e.printStackTrace();
          fail();
      }
    }
}
