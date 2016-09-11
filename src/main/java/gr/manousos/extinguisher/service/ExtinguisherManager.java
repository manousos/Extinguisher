package gr.manousos.extinguisher.service;

import gr.manousos.extinguisher.model.Extinguisher;

import java.io.Serializable;
import java.util.*;

public interface ExtinguisherManager extends AbstractService<Extinguisher, Long>, Serializable {
	Extinguisher findBybottlePartNumber(String sn);

	Set<Extinguisher> getNotifications(Date period);

	/**
	 * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the entity instance completely.
	 * 
	 * @param entity
	 * @return the saved entity
	 */
	<S extends Extinguisher> int update(S entity);
}
