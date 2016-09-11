package gr.manousos.extinguisher.model;

import gr.manousos.extinguisher.Literals;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.Length;

@Entity(name = "job")
@Table(name = "Job")
public class Job extends GenericEntity<Job> {
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "customer"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(nullable = false, unique = true)
	private Long id;
	@Column(length = 50, nullable = true)
	@Length(max = 50, message = Literals.NO_VALID_VALUE)
	private String title;
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Customer customer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}