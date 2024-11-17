package com.cinquecento.config;

import com.sun.tools.javac.Main;
import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

//@Slf4j
public class LiquibaseInit {

    public static void init() {
        try {
            Properties properties = new Properties();
            try (InputStream input = Main.class.getClassLoader().getResourceAsStream("liquibase.properties")) {
                if (input == null) {
                    throw new FileNotFoundException("props wast found");
                }
                properties.load(input);
            }
            String changeLogFile = properties.getProperty("changeLogFile");
            String databaseUrl = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");

            Database database = DatabaseFactory.getInstance()
                    .openDatabase(databaseUrl, username, password, null, new ClassLoaderResourceAccessor());

            Liquibase liquibase = new Liquibase(changeLogFile, new ClassLoaderResourceAccessor(), database);
            liquibase.update(new Contexts(), new LabelExpression());
            //log.info("migrations successful");
        } catch (Exception e) {
            //log.error("migrations unsuccessful due {}", e.getMessage());
        }
    }
}
