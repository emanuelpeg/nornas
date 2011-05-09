/**
 * 
 */
package org.assembly.nornas.synchronizer.style;

import org.assembly.dto.style.StyleDTO;
import org.assembly.nornas.model.style.Style;
import org.assembly.nornas.repository.style.StyleRepository;
import org.assembly.nornas.synchronizer.Synchronizer;

/**
 * @author emanuel
 * 
 *  class responsible of synchronize Style with StyleDTO
 *
 */
public class SynchronizerStyle implements Synchronizer<StyleDTO, Style>{
	
	private StyleRepository styleDAO; 
	
	public void setStyleDAO(StyleRepository styleDAO) {
		this.styleDAO = styleDAO;
	}

	
	public Style synchronize(StyleDTO dto) {
		Style aStyle = null;
		
		if (dto.getId() != null) {
			aStyle = this.styleDAO.findBy(dto.getId());
			aStyle.setCss(dto.getCss());
		} else {
			aStyle = new Style(dto.getCss());
		}
		
		return aStyle; 
	}

}
