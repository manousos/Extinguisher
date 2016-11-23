package gr.manousos.extinguisher.model;

import gr.manousos.extinguisher.Literals;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

/**
 * Δεδομένα διεύθυνσης πελάτη
 * 
 * @author manousos
 *
 */
@Entity(name = "contact")
@Table(name = "ContactInfo")
public class ContactInfo extends GenericEntity<ContactInfo> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Customer cust;
	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private ContactType type;
	@Column(length = 60, nullable = true)
	private String contactValue;
	@Transient
	@Email
	private String email;
	@Transient
	@Pattern(regexp = "[0-9]{10}", message = Literals.NO_VALID_VALUE)
	private String phone;
	@Transient
	@Pattern(regexp = "69[0-9]{8}", message = Literals.NO_VALID_VALUE)
	private String cellPhone;

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

	public ContactType getType() {
		return type;
	}

	public void setType(ContactType type) {
		this.type = type;
	}

	public String getContactValue() {
		switch (this.type) {
		case PHONE:
			this.phone = contactValue;
			break;
		case MOBILE:
			this.cellPhone = contactValue;
		default:
			break;
		}

		return contactValue;
	}

	public void setContactValue(String contactValue) {
		this.contactValue = contactValue;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		this.contactValue = email;
		this.type = ContactType.EMAIL;
	}

	public String getPhone() {
		if (this.type == ContactType.PHONE)
			phone = this.contactValue;

		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
		this.contactValue = phone;
		this.type = ContactType.PHONE;
	}

	public String getCellPhone() {
		if (this.type == ContactType.MOBILE)
			cellPhone = this.contactValue;

		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
		this.contactValue = cellPhone;
		this.type = ContactType.MOBILE;
	}

	@Override
	public String toString() {
		return "ContactInfo [type=" + type + ", contactValue=" + contactValue + "]";
	}

}
