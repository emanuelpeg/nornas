/**
 * 
 */
package org.assembly.nornas.sandbox.serviceImpl.example;

import org.assembly.nornas.sandbox.service.example.ExampleService;
import org.osoa.sca.annotations.Init;
import org.osoa.sca.annotations.Service;


/**
 * @author emanuel
 * 
 *         Implementation of ExampleService
 * 
 */

@Service(ExampleService.class)
public class ExampleServiceImpl implements
		ExampleService {

	/**
	 * @see org.assembly.nornas.ExampleService#sayHello()
	 */
	@Override
	public String sayHello() {
	    System.out.print("llamaron a Say");
		return "Holasss !!! \n";
	}

	@Init
	public void init() {
		System.out.println("Starting with "+ExampleServiceImpl.class + " \n");
	}

}
