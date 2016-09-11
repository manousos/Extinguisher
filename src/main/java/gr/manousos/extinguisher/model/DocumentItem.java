package gr.manousos.extinguisher.model;

import gr.manousos.extinguisher.Literals;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity(name = "itemDoc")
@Table(name = "DocumentItem")
public class DocumentItem extends GenericEntity<DocumentItem> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doc_id")
	private Document doc;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Extinguisher extinguisher;
	@Column(nullable = false)
	@NotNull(message = Literals.MANDATORY_FIELD)
	@Digits(integer = 9, fraction = 2, message = Literals.NO_VALID_VALUE)
	@Min(value = 0)
	private float quantity;
	@Column(nullable = true)
	@Min(value = 0)
	private float priceUnit;
	@Transient
	private String itemDescr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public Extinguisher getExtinguisher() {
		return extinguisher;
	}

	public void setExtinguisher(Extinguisher extinguisher) {
		this.extinguisher = extinguisher;
	}

	public float getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(float priceUnit) {
		this.priceUnit = priceUnit;
	}

	public String getItemDescr() {
		return itemDescr;
	}

	public void setItemDescr(String itemDescr) {
		this.itemDescr = itemDescr;
	}

}
