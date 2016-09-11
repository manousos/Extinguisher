package gr.manousos.extinguisher.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "extinguisher")
@Table(name = "Extinguisher")
public class Extinguisher extends GenericEntity<Extinguisher> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private Long id;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "extinguisher")
	@JsonIgnore
	private List<ExtinguisherMaintenance> maintenances;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "extinguisher")
	@JsonIgnore
	private List<DocumentItem> docItems;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn
	@JsonIgnore
	private Customer customer;
	@OneToOne(mappedBy = "extinguisher", cascade = CascadeType.ALL)
	@JsonIgnore
	private Notification notification;
	@Transient
	private int incrementNumber;
	@Column(name = "bottlePartNumber", length = 20, unique = true)
	// @NotEmpty(message = Literals.MANDATORY_FIELD)
	@NotBlank()
	private String bottlePartNumber;
	@Column(name = "contentItem", length = 30)
	private String contentItem;
	@Min(value = 0)
	private float contentWeightVolume;
	@Min(value = 1920)
	private int yearBuild;
	@Column(length = 50)
	private String manufacture;
	@Transient
	private String afm;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<DocumentItem> getDocItems() {
		return docItems;
	}

	public void setDocItems(List<DocumentItem> docItems) {
		this.docItems = docItems;
	}

	public List<ExtinguisherMaintenance> getMaintenances() {
		return maintenances;
	}

	public void setMaintenances(List<ExtinguisherMaintenance> maintenances) {
		this.maintenances = maintenances;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

	/**
	 * επιστρέφει τον αύξων αριθμός που αναγομώνει η εταιρεία για τη τρέχουσα περίοδο
	 * 
	 * @return
	 */
	public int getIncrementNumber() {
		return incrementNumber;
	}

	public void setIncrementNumber(int incrementNumber) {
		this.incrementNumber = incrementNumber;
	}

	public String getBottlePartNumber() {
		return bottlePartNumber;
	}

	public void setBottlePartNumber(String bottlePartNumber) {
		this.bottlePartNumber = bottlePartNumber;
	}

	public String getContentItem() {
		return contentItem;
	}

	public void setContentItem(String contentItem) {
		this.contentItem = contentItem;
	}

	public float getContentWeightVolume() {
		return contentWeightVolume;
	}

	public void setContentWeightVolume(float contentWeightVolume) {
		this.contentWeightVolume = contentWeightVolume;
	}

	public int getYearBuild() {
		return yearBuild;
	}

	public void setYearBuild(int yearBuild) {
		this.yearBuild = yearBuild;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public String getAfm() {
		return afm;
	}

	public void setAfm(String afm) {
		this.afm = afm;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[id=");
		builder.append(id);
		builder.append(", bottlePartNumber=");
		builder.append(bottlePartNumber);
		builder.append(", contentItem=");
		builder.append(contentItem);
		builder.append(", contentWeightVolume=");
		builder.append(contentWeightVolume);
		builder.append(", yearBuild=");
		builder.append(yearBuild);
		builder.append(", manufacture=");
		builder.append(manufacture);
		builder.append("]");
		return builder.toString();
	}

	// @Override
	// public String toString() {
	// return String.format("%s %s %s %s / %s", contentItem, contentWeightVolume, manufacture == null ? "" : manufacture, bottlePartNumber, yearBuild);
	// }
}
