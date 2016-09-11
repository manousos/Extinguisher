package gr.manousos.extinguisher.repository;

import gr.manousos.extinguisher.model.*;

import java.util.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface DocumentPsRepository extends PagingAndSortingRepository<Document, Long> {
	// int countByDocType(DocumentType type);

	@Query("Select d FROM doc d JOIN FETCH d.cust  c WHERE d.docIdentityNum= ?1")
	List<Document> findByDocIdentityNum(long docIdentityNum);

	@Query("Select d FROM doc d JOIN FETCH d.cust c JOIN FETCH d.items it JOIN FETCH it.extinguisher e WHERE d.docIdentityNum= ?1 AND d.docType= ?2")
	Document findByDocIdentityNumAndDocType(long docIdentityNum, DocumentType docType);

	@Query("Select d FROM doc d JOIN FETCH d.items it JOIN FETCH it.extinguisher e JOIN FETCH d.cust c WHERE d.id= ?1")
	Document findById(Long id);

	@Query("Select d FROM doc d JOIN FETCH d.cust  c WHERE d.dateIssue between :start and :end Order By d.docIdentityNum desc")
	List<Document> findByDateIssueBetweenOrderByDocIdentityNumDesc(@Param("start") Date start, @Param("end") Date end);

	@Query("Select d FROM doc d JOIN FETCH d.cust  c WHERE d.dateIssue between :start and :end AND d.docType= :type Order By d.docIdentityNum desc")
	List<Document> findByDateIssueBetweenAndDocTypeOrderByDocIdentityNumDesc(@Param("start") Date start, @Param("end") Date end, @Param("type") DocumentType docType);

	@Query("Select d FROM doc d JOIN FETCH d.cust  c JOIN c.tax t where t.afm= :afm")
	List<Document> findByAfm(@Param("afm") String afm);

	List<Document> findByCust(Customer cust);

	@Query("Select d FROM doc d JOIN FETCH d.cust c JOIN c.tax t where t.afm= :afm  AND d.docType= :type")
	List<Document> findByAfmAndDocType(@Param("afm") String afm, @Param("type") DocumentType docType);

	@Query("Select d FROM doc d JOIN FETCH d.cust c JOIN c.tax t where t.afm= :afm  AND d.docType= :type AND d.dateIssue between :start and :end")
	List<Document> findByAfmAndDocTypeAndDateIssueBetween(@Param("afm") String afm, @Param("type") DocumentType docType, @Param("start") Date start,
			@Param("end") Date end);

	@Query("Select  count(itd.extinguisher) FROM itemDoc itd JOIN itd.doc d WHERE d.dateIssue>?1 AND d.docType= ?2")
	int countByExtinguisher(Date dateIssue, DocumentType docType);

	@Query("Select  Max(d.docIdentityNum) FROM doc d WHERE d.docType= ?1")
	Long getMaxDocIdentityNumByDocType(DocumentType docType);
}
