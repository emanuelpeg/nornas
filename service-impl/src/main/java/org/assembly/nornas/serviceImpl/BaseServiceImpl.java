package org.assembly.nornas.serviceImpl;

import org.dozer.DozerBeanMapper;


/**
 * Esta clase tiene la responsabilidad de proveer el comportamiento base a todos los servicios de la aplicacion.
 *
 * @author lacosta
 */
public abstract class BaseServiceImpl {

	/**
	 * Mapeador de DTOs a objetos del dominio y viceversa.
	 */
	private DozerBeanMapper dtoMapper = null;

	protected DozerBeanMapper getDtoMapper() {
		return dtoMapper;
	}

	public void setDtoMapper(DozerBeanMapper dtoMapper) {
		this.dtoMapper = dtoMapper;
	}

}
