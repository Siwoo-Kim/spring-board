package com.springboard.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:rootConfig.xml")
public class ConnectionTest {


    /*database properties*/
    private static final String URL = "jdbc:oracle:thin://localhost:1521/orcl";
    private static final String USERNAME = "java";
    private static final String PASSWORD = "java";

    /* Connection Testing */
    @Test
    public void connection() throws ClassNotFoundException {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)){

            assertNotNull(connection);
            System.out.println(connection.toString());

        }catch (Exception e){

            e.printStackTrace();
            fail();

        }

    }
}
