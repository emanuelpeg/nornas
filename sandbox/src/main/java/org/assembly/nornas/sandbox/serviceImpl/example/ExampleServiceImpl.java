/**
 * 
 */
package org.assembly.nornas.sandbox.serviceImpl.example;

import org.assembly.nornas.sandbox.exception.SampleException;
import org.assembly.nornas.sandbox.service.example.ExampleService;
import org.osoa.sca.annotations.Init;
import org.osoa.sca.annotations.Property;
import org.osoa.sca.annotations.Service;

/**
 * @author emanuel
 * 
 *         Implementation of ExampleService
 * 
 */

@Service(ExampleService.class)
public class ExampleServiceImpl implements ExampleService {

	private String hello = "Holasss ";

	@Property
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @see org.assembly.nornas.ExampleService#sayHello()
	 */
	@Override
	public String sayHello() {
		System.out.print("llamaron a Say");
		return hello + name;
	}

	@Init
	public void init() {
		System.out.println("Starting with " + ExampleServiceImpl.class + " \n");
	}

	@Override
	public String sayHelloWithException() throws SampleException {
		System.out.print("llamaron a Say");
		throw new SampleException("Esto es una prueba.." + hello);
	}


}
