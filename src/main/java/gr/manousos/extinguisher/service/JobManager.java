package gr.manousos.extinguisher.service;

import java.util.Map;

import gr.manousos.extinguisher.model.Job;

/**
 * Λειτουργίες που αφορούν το επάγγελμα
 * 
 * @author manousos
 */
public interface JobManager extends AbstractService<Job, Long> {
	Map<Long, String> getAllJobsAsMap();
}
