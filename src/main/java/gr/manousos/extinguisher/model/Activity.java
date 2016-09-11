package gr.manousos.extinguisher.model;

import javax.persistence.*;

@Entity(name = "activity")
@Table(name = "Activity")
public class Activity extends GenericEntity<Activity> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_id")
	private Customer customer;
	@Column(nullable = false, length = 50)
	private String title;
	@Transient
	private boolean isForPrint;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isForPrint() {
		return isForPrint;
	}

	public void setForPrint(boolean isForPrint) {
		this.isForPrint = isForPrint;
	}
}
