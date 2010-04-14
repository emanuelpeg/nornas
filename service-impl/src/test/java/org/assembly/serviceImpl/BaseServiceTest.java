package org.assembly.serviceImpl;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Base de todos los test.
 *
 * @author pgoette
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"/test-dataSource-context.xml",
        "/spring-dao.xml",
  		"/spring-dozer.xml", 
        "/spring-services.xml",
        "/spring-synchronizer.xml",
		"/spring-transaction.xml"	
        })
public abstract class BaseServiceTest {
	
	@Resource(name="&sessionFactory")
	private LocalSessionFactoryBean sessionFactory;
	
	public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Before
	public void setter() {
		this.sessionFactory.dropDatabaseSchema();
		this.sessionFactory.createDatabaseSchema();
	}	
	
}