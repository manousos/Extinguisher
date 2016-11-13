package gr.manousos.extinguisher.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.manousos.extinguisher.model.Customer;
import gr.manousos.extinguisher.repository.CustomerPsRepository;
import gr.manousos.extinguisher.service.CustomerManager;

/**
 * Υλοποίηση του {@link CustomerManager}
 * 
 * @author manousos
 */
@Service
@Transactional(readOnly = true)
public class CustomerManagerImpl implements CustomerManager {
	private static final Logger logger = LoggerFactory.getLogger(CustomerManagerImpl.class);

	@Autowired
	CustomerPsRepository customerRepo;

	public void setCustomerRepo(CustomerPsRepository customerRepo) {
		this.customerRepo = customerRepo;
	}

	@Override
	public <S extends Customer> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Customer> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Customer> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Customer entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Customer> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
