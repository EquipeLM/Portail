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
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("cgi.lemans.portail")
@EnableTransactionManagement
@PropertySource(value = { "classpath:application.config.properties" })
public class PortailAppContextConfig {

	@Autowired
    private Environment environment;
	
	/**
	 * Gestion des vues retournées par les controllers spring.</br>
	 * Attention! Les vues de ce projet sont gérés par Angular</br>
	 * Il ne devrait pas, sauf cas spécifiques, avoir de retour de vue (juste
	 * JSON Object as return)
	 * 
	 * @return
	 */
	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/vues/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Autowired
	@Bean(name = "sessionFactoryNewPortal")
	public SessionFactory getSessionFactoryNewPortal(DataSource dataSourceNewPortal) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSourceNewPortal);
//	    sessionBuilder.addAnnotatedClasses(User.class);
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
		properties.put("hibernate.current_session_context_class", environment.getRequiredProperty("newportal.hibernate.current_session_context_class"));
		properties.put("hibernate.connection.pool_size", environment.getRequiredProperty("newportal.hibernate.connection.pool_size"));
		return properties;        
	}
	
	/***********************************************************************
	******************************Datasource GAMAWEB************************
	***********************************************************************/
	
	@Autowired
	@Bean(name = "sessionFactoryGamaweb")
	public SessionFactory getSessionFactoryGamaweb(DataSource dataSourceGamaweb) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSourceGamaweb);
//	    sessionBuilder.addAnnotatedClasses(User.class);
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
        properties.put("hibernate.current_session_context_class", environment.getRequiredProperty("gamaweb.hibernate.current_session_context_class"));
        properties.put("hibernate.connection.pool_size", environment.getRequiredProperty("gamaweb.hibernate.connection.pool_size"));
        return properties;        
    }
}
