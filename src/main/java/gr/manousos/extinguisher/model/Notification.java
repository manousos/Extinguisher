package gr.manousos.extinguisher.model;

import java.util.Date;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

@Entity(name = "notification")
@Table(name = "Notification")
public class Notification extends GenericEntity<Notification> {
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "extinguisher"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(nullable = false, unique = true)
	private Long id;
	@OneToOne
	@PrimaryKeyJoinColumn
	private Extinguisher extinguisher;
	private boolean disableAlert;
	private Date nextMaintenance;

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

	public boolean isDisableAlert() {
		return disableAlert;
	}

	public void setDisableAlert(boolean disableAlert) {
		this.disableAlert = disableAlert;
	}

	public Date getNextMaintenance() {
		return nextMaintenance;
	}

	public void setNextMaintenance(Date nextMaintenance) {
		this.nextMaintenance = nextMaintenance;
	}
}
