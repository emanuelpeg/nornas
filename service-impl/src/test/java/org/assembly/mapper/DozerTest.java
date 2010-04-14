/**
 * 
 */
package org.assembly.mapper;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author emanuel
 * 
 * Test of Dozer's mapping 
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations={
    "/spring-dozer.xml"
})
public abstract class DozerTest {

}
