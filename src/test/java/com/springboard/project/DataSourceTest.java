package com.springboard.project;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:rootConfig.xml")
public class DataSourceTest {

    @Autowired
    DataSource dataSource;

    /* OracleDataSource Testing */
    @Test
    public void dataSource() throws SQLException {

        try(Connection c = dataSource.getConnection()){

            System.out.println(c);
            assertNotNull(c);

        }catch (Exception e){

            e.printStackTrace();
            fail();

        }

    }
}
