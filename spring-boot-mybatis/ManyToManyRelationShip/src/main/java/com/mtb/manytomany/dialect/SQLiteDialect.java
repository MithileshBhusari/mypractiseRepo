package com.mtb.manytomany.dialect;

import org.hibernate.dialect.Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.lang.reflect.Type;
import java.sql.DriverManager;
import java.sql.Types;

/**
 * @author MithileshB
 * @created 04/07/2020 - 7:36 PM
 * @project spring-boot-mybatis
 *
 * org.hibernate.dialect.Dialect  class to register the data types provided by SQLite
 */

public class SQLiteDialect extends Dialect {

    @Autowired
    private Environment environment;

    public SQLiteDialect(){
        registerColumnType(Types.BIT,"integer");
        registerColumnType(Types.TINYINT,"tinyint");
        registerColumnType(Types.SMALLINT,"smallint");
        registerColumnType(Types.INTEGER,"integer");
    }

    /***DISABLE Constraints Handling****
     *
     * SQLite doesn't have support for database constraints ,so we will need to disable those
     * by again overriding the appropriate methods for both primary and foreign keys
     */

    @Override
    public boolean hasAlterTable() {
        return false;
    }

    @Override
    public boolean dropConstraints() {
        return false;
    }

    @Override
    public String getDropForeignKeyString() {
        return "";
    }

    @Override
    public String getAddForeignKeyConstraintString(String constraintName, String[] foreignKey, String referencedTable, String[] primaryKey, boolean referencesPrimaryKey) {
        return "";
    }

    @Override
    public String getAddPrimaryKeyConstraintString(String constraintName) {
        return "";
    }

    @Bean
    public DataSource dataSource(){
        final DriverManagerDataSource dataSource= new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("driverClassName"));
        dataSource.setUrl(environment.getProperty("url"));
        dataSource.setUsername(environment.getProperty("user"));
        dataSource.setPassword(environment.getProperty("password"));
        return dataSource;
    }
}
