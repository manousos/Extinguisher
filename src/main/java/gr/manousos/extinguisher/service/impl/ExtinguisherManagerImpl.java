package gr.manousos.extinguisher.service.impl;

import gr.manousos.extinguisher.model.*;
import gr.manousos.extinguisher.repository.*;
import gr.manousos.extinguisher.service.ExtinguisherManager;

import java.util.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author manousos
 *
 */
@Service
@Transactional(readOnly = true)
public class ExtinguisherManagerImpl implements ExtinguisherManager {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ExtinguisherManagerImpl.class);
	@Autowired
	private ExtinguiesherPsRepository repository;
	@Autowired
	private TaxPsRepository taxRepo;
	@Autowired
	private NotificationPsRepository notifRepo;

	public void setRepository(ExtinguiesherPsRepository repository) {
		this.repository = repository;
	}

	public void setTaxRepo(TaxPsRepository taxRepo) {
		this.taxRepo = taxRepo;
	}

	public void setNotifRepo(NotificationPsRepository notifRepo) {
		this.notifRepo = notifRepo;
	}

	/*
	 * Αποθηκεύει και ενημερώνει έναν πυροσβεστήρα
	 */
	@Override
	@Transactional
	public <S extends Extinguisher> S save(S entity) {
		String afm = entity.getAfm().trim();
		// set customer
		if (!afm.isEmpty()) {
			TaxInfo taxInfo = taxRepo.findByAfm(afm);
			if (taxInfo != null) {
				entity.setCustomer(taxInfo.getCustomer());
			} else {
				// TODO: extinguisher with customer relation validations
				logger.debug("Δεν βρέθηκε πελάτης με αυτό το ΑΦΜ \n Θέλετε να αποθηκευτεί ο πυροσβεστήρας;");
				// if (JOptionPane.showConfirmDialog(panel, "Δεν βρέθηκε πελάτης με αυτό το ΑΦΜ \n Θέλετε να αποθηκευτεί ο πυροσβεστήρας;", Literals.INFO_TITLE,
				// JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION)
				// return null;
			}
		} else {
			entity.setCustomer(null);
		}

		// Set notification
		if (entity.getNotification() == null) { // Case save
			Notification nf = new Notification();
			nf.setExtinguisher(entity);

			entity.setNotification(nf);
		} else { // Case update
			entity.setNotification(notifRepo.findOne(entity.getId()));
		}

		return repository.save(entity);
	}

	// Δεν ενημερώνει τον πελάτη !!
	@Override
	@Transactional
	public <S extends Extinguisher> int update(S entity) {

		return repository.update(entity.getId(), entity.getBottlePartNumber(), entity.getContentItem(), entity.getContentWeightVolume(), entity.getYearBuild(),
				entity.getManufacture(), new Date(), entity.getVersion() + 1);
	}

	@Override
	public <S extends Extinguisher> Iterable<S> save(Iterable<S> entities) {
		return repository.save(entities);
	}

	@Override
	public Extinguisher findOne(Long id) {
		return repository.findOne(id);
	}

	@Override
	public boolean exists(Long id) {
		return repository.exists(id);
	}

	@Override
	public Iterable<Extinguisher> findAll() {
		return repository.findAll();
	}

	@Override
	public Iterable<Extinguisher> findAll(Iterable<Long> ids) {
		return repository.findAll(ids);
	}

	@Override
	public long count() {
		return repository.count();
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

	@Override
	public void delete(Extinguisher entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Extinguisher> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public Extinguisher findBybottlePartNumber(String sn) {
		Extinguisher result = repository.findBybottlePartNumber(sn);
		if (result != null && result.getCustomer() != null) {
			// TODO: βρες τον σωστό ΑΦΜ όταν έχει πολλές δραστηριότητες --> * αφμ
			result.setAfm(result.getCustomer().getTax().get(0).getAfm());
		}
		// result.getNotification();
		return result;
	}

	@Override
	public Set<Extinguisher> getNotifications(Date period) {
		// TODO Auto-generated method stub
		return null;
	}

}
