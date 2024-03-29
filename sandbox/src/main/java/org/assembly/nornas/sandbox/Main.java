/**
 * 
 */
package org.assembly.nornas.sandbox;

import java.io.IOException;

import org.apache.tuscany.sca.host.embedded.SCADomain;

/**
 * 
 * @author emanuel
 *
 */
public class Main {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Starting ...");
        SCADomain scaDomain = SCADomain.newInstance("Example.composite");
        System.out.println("Example in "+scaDomain.getURI());
        System.in.read();
        System.out.println("Stopping ...");
        scaDomain.close();
        System.out.println();
	}

}
