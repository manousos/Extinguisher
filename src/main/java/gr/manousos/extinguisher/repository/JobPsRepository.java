package gr.manousos.extinguisher.repository;

import gr.manousos.extinguisher.model.Job;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface JobPsRepository extends PagingAndSortingRepository<Job, Long> {

}
