package gr.manousos.extinguisher.model;

import java.util.List;

import javax.persistence.*;

import org.hibernate.validator.constraints.Length;

/**
 * Δεδομένα πελάτη
 * 
 * @author manousos
 *
 */
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
	private String fatherName;

	/**
	 * Επιστρέφει τον κωδικό πελάτη.
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Θέτει τον κωδικό πελάτη.
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Επιστρέφει την διεύθυνση του πελάτη για φυσικό πρόσωπο. Στα νομικά
	 * πρόσωπα την διεύθυνση της έδρας.
	 * 
	 * @return address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Θέτει την διεύθυνση του πελάτη για φυσικό πρόσωπο. Στα νομικά πρόσωπα την
	 * διεύθυνση της έδρας.
	 * 
	 * @param address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Επιστρέφει το επάγγελμα του πελάτη.
	 * 
	 * @return job
	 */
	public Job getJob() {
		return job;
	}

	/**
	 * Θέτει το επάγγελμα του πελάτη.
	 * 
	 * @param job
	 */
	public void setJob(Job job) {
		this.job = job;
	}

	/**
	 * Επιστρέφει λίστα με δεδεομένα εφορίας που αφορούν τον πελάτη. Ένας
	 * πελάτης μπορεί να έχει ΑΦΜ ως φυσικό πρόσωπο αλλά και ως εκπρόσωπος
	 * νομικού προσώπου
	 * 
	 * @return taxInfos
	 */
	public List<TaxInfo> getTax() {
		return tax;
	}

	/**
	 * Θέτει λίστα με δεδεομένα εφορίας που αφορούν τον πελάτη. Ένας πελάτης
	 * μπορεί να έχει ΑΦΜ ως φυσικό πρόσωπο αλλά και ως εκπρόσωπος νομικού
	 * προσώπου
	 * 
	 * @param taxInfos
	 */
	public void setTax(List<TaxInfo> taxInfos) {
		this.tax = taxInfos;
	}

	/**
	 * Επιστρέφει το όνομα του πελάτη για φυσικά πρόσωπα. Στα νομικά πρόσωπα το
	 * όνομα του νομικού εκπροσώπου.
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Θέτει το όνομα του πελάτη. Στα νομικά πρόσωπα το όνομα του νομικού
	 * εκπροσώπου.
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Επιστρέφει το επίθετο του πελάτη για φυσικά πρόσωπα. Στα νομικά πρόσωπα
	 * το επίθετο του νομικού εκπροσώπου.
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Θέτει το επίθετο του πελάτη. Στα νομικά πρόσωπα το επίθετο του νομικού
	 * εκπροσώπου.
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Επιστρέφει τον αριθμός αστυνομικής ταυτότητας του πελάτη για φυσικά
	 * πρόσωπα. Στα νομικά πρόσωπα τον αριθμός αστυνομικής ταυτότητας του
	 * νομικού εκπροσώπου.
	 * 
	 * @return identity
	 */
	public String getIdentity() {
		return identity;
	}

	/**
	 * Θέτει τον αριθμός αστυνομικής ταυτότητας του πελάτη. Στα νομικά πρόσωπα
	 * τον αριθμός αστυνομικής ταυτότητας του νομικού εκπροσώπου.
	 * 
	 * @param identity
	 */
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	/**
	 * Επιστρέφει το παρατσούκλιτου πελάτη για φυσικά πρόσωπα. Στα νομικά
	 * πρόσωπα το παρατσούκλιτου του νομικού εκπροσώπου.
	 * 
	 * @return nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * Θέτει το παρατσούκλιτου πελάτη για φυσικά πρόσωπα. Στα νομικά πρόσωπα το
	 * παρατσούκλιτου του νομικού εκπροσώπου.
	 * 
	 * @param nickName
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * Επιστρέφει τον τίτλο της εταιρείας.
	 * 
	 * @return companyTitle
	 */
	public String getCompanyTitle() {
		return companyTitle;
	}

	/**
	 * Θέτει τον τίτλο της εταιρείας.
	 * 
	 * @param companyTitle
	 */
	public void setCompanyTitle(String companyTitle) {
		this.companyTitle = companyTitle;
	}

	/**
	 * Επιστρέφει το όνομα πατρώς του πελάτη. Στα νομικά πρόσωπα το όνομα πατρώς
	 * του νομικού εκπροσώπου.
	 * 
	 * @return fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}

	/**
	 * Θέτει το όνομα πατρώς του πελάτη. Στα νομικά πρόσωπα το όνομα πατρώς του
	 * νομικού εκπροσώπου.
	 * 
	 * @param fatherName
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	/**
	 * Επιστρέφει τα έγγραφα του πελάτη.
	 * 
	 * @return docs
	 */
	public List<Document> getDocs() {
		return docs;
	}

	/**
	 * Θετει τα έγγραφα του πελάτη.
	 * 
	 * @param docs
	 */
	public void setDocs(List<Document> docs) {
		this.docs = docs;
	}

	/**
	 * Επιστρέφει τους πυροσβεστήρες του πελάτη.
	 * 
	 * @return extinguishers
	 */
	public List<Extinguisher> getExtinguishers() {
		return extinguishers;
	}

	/**
	 * Θέτει τους πυροσβεστήρες του πελάτη.
	 * 
	 * @param extinguishers
	 */
	public void setExtinguishers(List<Extinguisher> extinguishers) {
		this.extinguishers = extinguishers;
	}

	/**
	 * Επιστρέφει τα στοιχεία επικοινωνίας του πελάτη.
	 * 
	 * @return contacts
	 */
	public List<ContactInfo> getContacts() {
		return contacts;
	}

	/**
	 * Θέτει τα στοιχεία επικοινωνίας του πελάτη.
	 * 
	 * @param contacts
	 */
	public void setContacts(List<ContactInfo> contacts) {
		this.contacts = contacts;
	}

	/**
	 * Επιστρέφει τις επαγγελματικές δραστηριότητες του πελάτη
	 * 
	 * @return activities
	 */
	public List<Activity> getActivities() {
		return activities;
	}

	/**
	 * Θέτει τις επαγγελματικές δραστηριότητες του πελάτη
	 * 
	 * @param activities
	 */
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