import org.apache.log4j.BasicConfigurator;
import org.junit.Test;

import cgi.lemans.portail.domaine.utils.HibernateUtil;

public class HibernateTest {
	@Test
	public  void testhib(){
		BasicConfigurator.configure();
		HibernateUtil.createSessionFactory();
	}
}
