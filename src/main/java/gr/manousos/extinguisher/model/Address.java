package gr.manousos.extinguisher.model;

import gr.manousos.extinguisher.Literals;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.*;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.Length;

@Entity(name = "address")
@Table(name = "Address")
public class Address extends GenericEntity<Address> {
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "customer"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(nullable = false, unique = true)
	private Long id;
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Customer customer;
	@NotNull(message = "Το πεδίο είναι υποχρεωτικό")
	@Column(length = 50, nullable = false)
	@Length(max = 50, message = Literals.NO_VALID_VALUE)
	private String address;
	@Column(length = 4)
	@Pattern(regexp = "^[0-9]*$", message = Literals.NO_VALID_VALUE)
	@Length(max = 4, message = Literals.NO_VALID_VALUE)
	private String addrNum;
	@NotNull(message = "Το πεδίο είναι υποχρεωτικό")
	@Column(length = 30, nullable = false)
	@Pattern(regexp = "^[^0-9]*$", message = Literals.NO_VALID_VALUE)
	@Length(min = 2, max = 30, message = Literals.NO_VALID_VALUE)
	private String city;
	@NotNull(message = "Το πεδίο είναι υποχρεωτικό")
	@Column(length = 6, nullable = false)
	@Pattern(regexp = "^[0-9]{5}$", message = "Επιτρέπονται μόνο αριθμοί")
	private String postCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddrNum() {
		return addrNum;
	}

	public void setAddrNum(String addrNum) {
		this.addrNum = addrNum;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s, %s", address, addrNum, city, postCode);
	}
}
