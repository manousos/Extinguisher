package gr.manousos.extinguisher.repository;

import gr.manousos.extinguisher.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ActivityPsRepository extends PagingAndSortingRepository<Activity, Long> {
	@Query("Select distinct(actv.title) From activity actv")
	List<String> findAllTitle();

	List<Activity> findAllByCustomer(Customer c);

	Activity findByTitleAndCustomer(String title, Customer c);
}
