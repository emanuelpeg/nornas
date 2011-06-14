/**
 * 
 */
package org.assembly.nornas.sandbox.service.example;

import org.assembly.nornas.sandbox.exception.SampleException;
import org.assembly.nornas.sandbox.model.Message;
import org.osoa.sca.annotations.Remotable;

/**
 * @author emanuel
 * 
 *         Sample Service
 * 
 */
@Remotable
public interface ExampleService {
	
	String sayHello();

	String sayHelloWithException() throws SampleException;
	
}
