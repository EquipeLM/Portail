package cgi.lemans.portail.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import cgi.lemans.portail.domaine.entites.gamaweb.Absence;
import cgi.lemans.portail.domaine.entites.gamaweb.CufAbsence;
import cgi.lemans.portail.domaine.entites.gamaweb.CufRessourceAbsence;
import cgi.lemans.portail.domaine.entites.gamaweb.RessourceTma;
import cgi.lemans.portail.domaine.entites.gamaweb.TypeAbsence;
import cgi.lemans.portail.domaine.entites.newportal.Icones;
import cgi.lemans.portail.domaine.entites.newportal.IconesByUser;

@Configuration
@ComponentScan("cgi.lemans.portail")
@EnableTransactionManagement
@EnableWebMvc
@PropertySource(value = { "classpath:application.config.properties" })
public class PortailAppContextConfig {

	@Autowired
    private Environment environment;
	
	
	@Autowired
	@Bean(name = "sessionFactoryNewPortal")
	public SessionFactory getSessionFactoryNewPortal(DataSource dataSourceNewPortal) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSourceNewPortal);
		sessionBuilder.addAnnotatedClasses(Icones.class);
	    sessionBuilder.addAnnotatedClasses(IconesByUser.class);
		sessionBuilder.addProperties(getHibernatePropertiesNewPortal());
		return sessionBuilder.buildSessionFactory();
	}
	
	@Bean(name = "dataSourceNewPortal")
	public DataSource getDataSourceNewPortal() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("newportal.hibernate.connection.driver_class"));
		dataSource.setUrl(environment.getRequiredProperty("newportal.hibernate.connection.url"));
		dataSource.setUsername(environment.getRequiredProperty("newportal.hibernate.connection.username"));
		dataSource.setPassword(environment.getRequiredProperty("newportal.hibernate.connection.password"));
		return dataSource;
	}
	
	
	private Properties getHibernatePropertiesNewPortal() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("newportal.hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("newportal.hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("newportal.hibernate.format_sql"));
		properties.put("hibernate.connection.pool_size", environment.getRequiredProperty("newportal.hibernate.connection.pool_size"));
		return properties;        
	}
	
	@Autowired
	@Bean(name="txManagerNewPortal")
    public HibernateTransactionManager txManagerNewPortal() {
        return new HibernateTransactionManager(getSessionFactoryNewPortal(getDataSourceNewPortal()));
    }	
	
	/***********************************************************************
	******************************Datasource GAMAWEB************************
	***********************************************************************/
	
	@Autowired
	@Bean(name = "sessionFactoryGamaweb")
	public SessionFactory getSessionFactoryGamaweb(DataSource dataSourceGamaweb) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSourceGamaweb);
		sessionBuilder.addAnnotatedClasses(RessourceTma.class);
		sessionBuilder.addAnnotatedClasses(Absence.class);
		sessionBuilder.addAnnotatedClasses(CufAbsence.class);
		sessionBuilder.addAnnotatedClasses(CufRessourceAbsence.class);
		sessionBuilder.addAnnotatedClasses(TypeAbsence.class);
		sessionBuilder.addProperties(getHibernatePropertiesGamaweb());
		return sessionBuilder.buildSessionFactory();
	}
	
	@Bean(name = "dataSourceGamaweb")
	public DataSource getDataSourceGamaweb() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("gamaweb.hibernate.connection.driver_class"));
		dataSource.setUrl(environment.getRequiredProperty("gamaweb.hibernate.connection.url"));
		dataSource.setUsername(environment.getRequiredProperty("gamaweb.hibernate.connection.username"));
		dataSource.setPassword(environment.getRequiredProperty("gamaweb.hibernate.connection.password"));
		return dataSource;
	}
	
	private Properties getHibernatePropertiesGamaweb() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("gamaweb.hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("gamaweb.hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("gamaweb.hibernate.format_sql"));
        properties.put("hibernate.connection.pool_size", environment.getRequiredProperty("gamaweb.hibernate.connection.pool_size"));
        return properties;        
    }
	
	@Autowired
	@Bean(name="txManagerGamaweb")
	public HibernateTransactionManager txManagerGamaweb(SessionFactory sessionFactoryGamaweb) {
		final HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactoryGamaweb);
		return hibernateTransactionManager;
	}
}
