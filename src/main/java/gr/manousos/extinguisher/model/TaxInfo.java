package gr.manousos.extinguisher.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

/**
 * Δεδομένα εφορίας
 * 
 * @author manousos
 *
 */
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
	private OwnerType ownerType;

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
	 * Θέτει τον πελάτη.
	 * 
	 * @return customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Επιστρέφει τον πελάτη.
	 * 
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Επιστρέφει το ΑΦΜ του πελάτη.
	 * 
	 * @return afm
	 */
	public String getAfm() {
		return afm;
	}

	/**
	 * Θέτει το ΑΦΜ του πελάτη.
	 * 
	 * @param afm
	 */
	public void setAfm(String afm) {
		this.afm = afm;
	}

	/**
	 * Επιστρέφει τη ΔΟΥ υπαγωγής του πελάτη.
	 * 
	 * @return doy
	 */
	public String getDoy() {
		return doy;
	}

	/**
	 * Θέτει τη ΔΟΥ υπαγωγής του πελάτη.
	 * 
	 * @param doy
	 */
	public void setDoy(String doy) {
		this.doy = doy;
	}

	/**
	 * Επιστρέφει τον τύπο του προσώπου.
	 * 
	 * @return ownerType
	 */
	public OwnerType getOwnerAFM() {
		return ownerType;
	}

	/**
	 * Θέτει τον τύπο του προσώπου.
	 * 
	 * @param ownerType
	 */
	public void setOwnerAFM(OwnerType ownerType) {
		this.ownerType = ownerType;
	}
}
