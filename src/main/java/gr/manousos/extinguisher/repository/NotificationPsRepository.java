package gr.manousos.extinguisher.repository;

import gr.manousos.extinguisher.model.Notification;

import java.util.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NotificationPsRepository extends PagingAndSortingRepository<Notification, Long> {

	@Query("Select notif FROM notification notif JOIN FETCH notif.extinguisher ext JOIN FETCH ext.customer c WHERE notif.disableAlert=0 AND notif.nextMaintenance between ?1 and ?2")
	Set<Notification> findByNextMaintenanceBetween(Date after, Date defore);

	@Query("Select notif FROM notification notif JOIN FETCH notif.extinguisher ext JOIN FETCH ext.customer c JOIN FETCH c.address a WHERE notif.disableAlert=0 AND a.city = ?1")
	Set<Notification> findByCity(String city);
	
	@Query("Select notif FROM notification notif JOIN FETCH notif.extinguisher ext JOIN FETCH ext.customer c JOIN FETCH c.address a WHERE notif.disableAlert=0 AND a.city = ?3 AND notif.nextMaintenance between ?1 and ?2")
	Set<Notification> findByNextMaintenanceBetweenAndCity(Date after, Date before, String city);
}
