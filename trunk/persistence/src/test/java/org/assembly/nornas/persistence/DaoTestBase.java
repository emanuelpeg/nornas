package org.assembly.nornas.persistence;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Clase base para test de los daos
 * @author Emanuel
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations={
    "/spring-dao.xml",
    "/test-dataSource-context.xml",
    "/spring-transaction.xml"
})
public abstract class DaoTestBase {
	
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
