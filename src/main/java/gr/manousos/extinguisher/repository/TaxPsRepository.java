package gr.manousos.extinguisher.repository;

import gr.manousos.extinguisher.model.TaxInfo;

import java.util.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaxPsRepository extends PagingAndSortingRepository<TaxInfo, Long> {
	@Query("FROM tax t JOIN FETCH t.customer WHERE t.afm= ?1")
	TaxInfo findByAfm(String afm);

	@Query("FROM tax t JOIN FETCH t.customer c WHERE c.id= ?1")
	List<TaxInfo> findByCustomerId(long custId);

	@Query("Select t.doy From tax t order by t.doy")
	Set<String> getAllTaxOffices();
}
