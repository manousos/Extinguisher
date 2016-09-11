package gr.manousos.extinguisher.repository;

import java.util.List;

import gr.manousos.extinguisher.model.*;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContactInfoPsRepository extends PagingAndSortingRepository<ContactInfo, Long> {
	List<ContactInfo> findByCustAndType(Customer c, ContactType type);

	List<ContactInfo> findByCust(Customer c);
}
