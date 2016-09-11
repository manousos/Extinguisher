package gr.manousos.extinguisher.model;

import gr.manousos.extinguisher.Literals;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.validator.constraints.Length;

@Entity(name = "extinguisherMaintenance")
@Table(name = "ExtinguisherMaintenance")
public class ExtinguisherMaintenance extends GenericEntity<ExtinguisherMaintenance> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Extinguisher extinguisher;
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(length = 50)
	@Length(max = 50, message = Literals.NO_VALID_VALUE)
	private String setup;
	private String bottleSituation;
	@Temporal(TemporalType.DATE)
	private Date previousDateMaintenance;
	private boolean ode_2;
	private boolean ode_3;
	private boolean ode_4;
	private boolean newExtinguisher;
	private String notes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Extinguisher getExtinguisher() {
		return extinguisher;
	}

	public void setExtinguisher(Extinguisher extinguisher) {
		this.extinguisher = extinguisher;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSetup() {
		return setup;
	}

	public void setSetup(String setup) {
		this.setup = setup;
	}

	public String getBottleSituation() {
		return bottleSituation;
	}

	public void setBottleSituation(String bottleSituation) {
		this.bottleSituation = bottleSituation;
	}

	public Date getPreviousDateMaintenance() {
		return previousDateMaintenance;
	}

	public void setPreviousDateMaintenance(Date previousDateMaintenance) {
		this.previousDateMaintenance = previousDateMaintenance;
	}

	public boolean isOde_2() {
		return ode_2;
	}

	public void setOde_2(boolean ode_2) {
		this.ode_2 = ode_2;
	}

	public boolean isOde_3() {
		return ode_3;
	}

	public void setOde_3(boolean ode_3) {
		this.ode_3 = ode_3;
	}

	public boolean isOde_4() {
		return ode_4;
	}

	public void setOde_4(boolean ode_4) {
		this.ode_4 = ode_4;
	}

	public boolean isNewExtinguisher() {
		return newExtinguisher;
	}

	public void setNewExtinguisher(boolean newExtinguisher) {
		this.newExtinguisher = newExtinguisher;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
