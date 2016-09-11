package gr.manousos.extinguisher.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

@Entity(name = "tax")
@Table(name = "TaxInfo")
public class TaxInfo extends GenericEntity<TaxInfo> implements Serializable {
	private static final long serialVersionUID = -516807449448051444L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_id")
	private Customer customer;
	@Column(name = "afm", length = 10, unique = true)
	@Length(max = 10, min = 8)
	@NotNull()
	@Pattern(regexp = "^[0-9]*$")
	private String afm;
	@NotNull()
	@Column(length = 20)
	@Length(min = 2, max = 20)
	private String doy;
	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private OwnerType ownerAFM;

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

	public String getAfm() {
		return afm;
	}

	public void setAfm(String afm) {
		this.afm = afm;
	}

	public String getDoy() {
		return doy;
	}

	public void setDoy(String doy) {
		this.doy = doy;
	}

	public OwnerType getOwnerAFM() {
		return ownerAFM;
	}

	public void setOwnerAFM(OwnerType ownerAFM) {
		this.ownerAFM = ownerAFM;
	}
}
