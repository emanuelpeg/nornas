/**
 * 
 */
package org.assembly.nornas.synchronizer;

/**
 * @author emanuel
 *
 *
 */
public interface Synchronizer<S,D> {

	D synchronize(S dto);
	
}
