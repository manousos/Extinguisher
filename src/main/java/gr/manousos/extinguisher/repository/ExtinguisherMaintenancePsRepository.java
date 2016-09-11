package gr.manousos.extinguisher.repository;

import gr.manousos.extinguisher.model.ExtinguisherMaintenance;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExtinguisherMaintenancePsRepository extends PagingAndSortingRepository<ExtinguisherMaintenance, Long> {

}
