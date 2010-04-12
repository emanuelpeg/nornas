
package org.assembly.norna.common.util.transformer;

import java.util.Collection;
import java.util.List;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.dozer.DozerBeanMapper;

/**
 * Clase encargada de Manejo de transformaciones de listas.
 * @author pgoette
 *
 *@param <Z> tipo de objetos de la lista a la que se quiere aplicar la transformacion
 *@param <T> tipo de objetos de la lista destino
 *
 */
public class DozerTransformer<T, Z> {
	
	private DozerBeanMapper dtoMapper;
	
	private Class<T> clazz;
	
	public DozerTransformer(DozerBeanMapper dtoMapper, Class<T> clazz) {
		this.dtoMapper=dtoMapper;
		this.clazz=clazz;
	}
	
	/**
	 * Transforma de una lista de objetos del dominio a una lista de DTOs.
	 * 
	 * @param domainObjects
	 *            Lista de objetos de dominio a transformar.
	 * @return DTOs.
	 */
	@SuppressWarnings("unchecked")
	public List<T> transformar(Collection<Z> domainObjects) {
		return (List<T>) CollectionUtils.collect(domainObjects, new Transformer() {

			public Object transform(Object domainObject) {
				Z object = (Z) domainObject;
				return dtoMapper.map(object, clazz);
			}
		});
	}

	/**
	 * Transforma de una lista de objetos del dominio a una lista de DTOs segun el 
	 * mapId pasado por parametro
	 * 
	 * @param domainObjects
	 *            Lista de objetos de dominio a transformar.
	 * @return DTOs.
	 */
	@SuppressWarnings("unchecked")
	public List<T> transformar(Collection<Z> domainObjects, final String mapId) {
		return (List<T>) CollectionUtils.collect(domainObjects, new Transformer() {

			public Object transform(Object domainObject) {
				Z object = (Z) domainObject;
				return dtoMapper.map(object, clazz, mapId);
			}
		});
	}
}
