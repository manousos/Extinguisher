package gr.manousos.extinguisher.repository;

import gr.manousos.extinguisher.model.Customer;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerPsRepository extends PagingAndSortingRepository<Customer, Long> {
	List<Customer> findByLastName(String lastName);

	List<Customer> findByLastNameAndFirstName(String lastName, String firstName);

	List<Customer> findByCompanyTitleContaining(String companyTitle);

	Customer findByIdentity(String identityCode);

	@Query("Select c From customer c JOIN FETCH c.address a WHERE a.city= ?1")
	List<Customer> findByCity(String city);

	@Query("Select c From customer c JOIN FETCH c.address a WHERE a.address = ?1")
	List<Customer> findByStreet(String street);
}
