package gr.manousos.extinguisher.model;

import gr.manousos.extinguisher.Literals;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

@Entity(name = "doc")
@Table(name = "Document")
public class Document extends GenericEntity<Document> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private Long id;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "doc", cascade = CascadeType.ALL)
	private DocumentPrint printedDoc;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Customer cust;
	// bi-directional many-to-one association to Answer
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doc", cascade = CascadeType.ALL)
	private List<DocumentItem> items;
	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private DocumentType docType;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	@NotNull(message = Literals.MANDATORY_FIELD)
	private Date dateIssue;
	@NotNull(message = Literals.MANDATORY_FIELD)
	private long docIdentityNum;
	@Column(nullable = true, length = 45)
	@Pattern(regexp = "^[0-9]*$", message = Literals.NO_VALID_VALUE)
	private String dispatchDocNum;
	@Column(nullable = true)
	private float taxPercent;
	private String totalLiteral;	
	private String consigmentOrBillingNum;
	private String transferScope;
	@Temporal(TemporalType.TIME)
	private Date start;
	@Temporal(TemporalType.TIME)
	private Date end;
	/** Αριθμός καταχώρησης καρτέλας εργασιών */
	@Column(length = 45)
	@Length(max = 45, message = Literals.NO_VALID_VALUE)
	private String registerTabNum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public List<DocumentItem> getItems() {
		return items;
	}

	public void setItems(List<DocumentItem> items) {
		this.items = items;
	}

	public DocumentType getDocType() {
		return docType;
	}

	public void setDocType(DocumentType docType) {
		this.docType = docType;
	}

	public long getDocIdentityNum() {
		return docIdentityNum;
	}

	public void setDocIdentityNum(long docIdentityNum) {
		this.docIdentityNum = docIdentityNum;
	}

	public String getConsigmentOrBillingNum() {
		return consigmentOrBillingNum;
	}

	public void setConsigmentOrBillingNum(String consigmentOrBillingNum) {
		this.consigmentOrBillingNum = consigmentOrBillingNum;
	}

	public Date getDateIssue() {
		return dateIssue;
	}

	public void setDateIssue(Date dateIssue) {
		this.dateIssue = dateIssue;
	}

	public String getDispatchDocNum() {
		return dispatchDocNum;
	}

	public void setDispatchDocNum(String dispatchDocNum) {
		this.dispatchDocNum = dispatchDocNum;
	}

	public float getTaxPercent() {
		return taxPercent;
	}

	public void setTaxPercent(float taxPercent) {
		this.taxPercent = taxPercent;
	}

	public String getTotalLiteral() {
		return totalLiteral;
	}

	public void setTotalLiteral(String totalLiteral) {
		this.totalLiteral = totalLiteral;
	}

	public String getTransferScope() {
		return transferScope;
	}

	public void setTransferScope(String transferScope) {
		this.transferScope = transferScope;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public DocumentPrint getPrintedDoc() {
		return printedDoc;
	}

	public void setPrintedDoc(DocumentPrint printedDoc) {
		this.printedDoc = printedDoc;
	}

	public String getRegisterTabNum() {
		return registerTabNum;
	}

	public void setRegisterTabNum(String registerTabNum) {
		this.registerTabNum = registerTabNum;
	}

}
