package com.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Date;

public class c3p0test {

    @Test
    private static  void test() throws SQLException {
        DataSource dataSource=new ComboPooledDataSource("webApp");
        System.out.println(dataSource.getConnection());

        QueryRunner queryRunner=new QueryRunner();

    }


}
