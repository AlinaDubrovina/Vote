package by.it_academy.vote.web.listener;

import by.it_academy.vote.dao.db.ds.fabrics.DataSourceSingleton;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        File confDir = new File(System.getenv("catalina_base") + "/conf");
        File prop = new File(confDir + "/application.properties");
        try {
            Properties properties = new Properties();
            properties.load(new FileReader(prop));
            DataSourceSingleton.setProperties(properties);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File with properties not found.", e);
        } catch (IOException e) {
            throw new RuntimeException("Settings file read error.", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
