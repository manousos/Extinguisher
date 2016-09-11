package gr.manousos.extinguisher.repository;

import gr.manousos.extinguisher.model.Address;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressPsRepository extends PagingAndSortingRepository<Address, Long> {
	@Query("Select addr.city From address addr")
	Set<String> getAllCities();

	@Query("Select addr.address From address addr")
	Set<String> getAllAddress();
}
