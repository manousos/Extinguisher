package gr.manousos.extinguisher.repository;

import gr.manousos.extinguisher.model.*;

import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ExtinguiesherPsRepository extends PagingAndSortingRepository<Extinguisher, Long> {

	Extinguisher findBybottlePartNumber(String sn);

	@Query("Select ext.yearBuild FROM extinguisher ext")
	Set<Extinguisher> getNotifications(Date period);

	@Transactional
	@Modifying
	@Query("update extinguisher ext set ext.bottlePartNumber = ?2, ext.contentItem = ?3, ext.contentWeightVolume = ?4, ext.yearBuild = ?5, ext.manufacture = ?6, ext.timestamp=?7, ext.version = ?8 WHERE ext.id= ?1")
	int update(long id, String bottlePartNumber, String contentItem, float contentWeightVolume, int yearBuild, String manufacture, Date timestamp, int version);
}
