package gr.manousos.extinguisher.model;

import java.util.List;

import javax.persistence.*;

import org.hibernate.validator.constraints.Length;

@Entity(name = "customer")
@Table(name = "Customer")
public class Customer extends GenericEntity<Customer> {
	public Customer() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private Long id;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
	private Address address;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
	private List<TaxInfo> tax;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
	private Job job;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cust", cascade = CascadeType.ALL)
	private List<Document> docs;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	private List<Extinguisher> extinguishers;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cust", cascade = CascadeType.ALL)
	private List<ContactInfo> contacts;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Activity> activities;
	@Column(length = 30)
	@Length(min = 2, max = 30)
	private String firstName;
	// @NotNull(message = Literals.MANDATORY_FIELD)
	@Column(length = 50, nullable = false)
	@Length(min = 2, max = 50)
	private String lastName;
	@Column(length = 20, name = "identity")
	@Length(max = 20)
	private String identity;
	@Column(length = 20)
	private String nickName;
	@Column(length = 50)
	private String companyTitle;
	@Column(length = 30)
	@Length(min = 2, max = 30)
	private String fatherName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public List<TaxInfo> getTax() {
		return tax;
	}

	public void setTax(List<TaxInfo> tax) {
		this.tax = tax;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getCompanyTitle() {
		return companyTitle;
	}

	public void setCompanyTitle(String companyTitle) {
		this.companyTitle = companyTitle;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public List<Document> getDocs() {
		return docs;
	}

	public void setDocs(List<Document> docs) {
		this.docs = docs;
	}

	public List<Extinguisher> getExtinguishers() {
		return extinguishers;
	}

	public void setExtinguishers(List<Extinguisher> extinguishers) {
		this.extinguishers = extinguishers;
	}

	public List<ContactInfo> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactInfo> contacts) {
		this.contacts = contacts;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (this.companyTitle.isEmpty()) {
			sb.append(this.lastName);
			sb.append(" ");
			sb.append(this.firstName);
		} else
			sb.append(this.companyTitle);

		return sb.toString();
	}

}