package gr.manousos.extinguisher.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.manousos.extinguisher.model.Job;
import gr.manousos.extinguisher.repository.JobPsRepository;
import gr.manousos.extinguisher.service.JobManager;

/**
 * Υλοποίηση του {@link JobManager}
 * 
 * @author manousos
 *
 */
@Service
@Transactional(readOnly = true)
public class JobManagerImpl implements JobManager {
	@Autowired
	JobPsRepository repository;

	public void setRepository(JobPsRepository repository) {
		this.repository = repository;
	}

	@Override
	public <S extends Job> S save(S entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <S extends Job> Iterable<S> save(Iterable<S> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Job findOne(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean exists(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterable<Job> findAll() {
		return repository.findAll();
	}

	@Override
	public Iterable<Job> findAll(Iterable<Long> ids) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long count() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(Job entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(Iterable<? extends Job> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteAll() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Map<Long, String> getAllJobsAsMap() {
		Map<Long, String> jobMap = new HashMap<Long, String>();
		for (Job j : findAll()) {
			jobMap.put(j.getId(), j.getTitle());
		}

		return jobMap;
	}
}
