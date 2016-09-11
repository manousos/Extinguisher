package gr.manousos.extinguisher.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

@Entity(name = "printedDoc")
@Table(name = "DocumentPrint")
public class DocumentPrint extends GenericEntity<DocumentPrint> {
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "doc"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(nullable = false, unique = true)
	private Long id;
	@Lob
	@Column(nullable = false)
	private String XMLdata;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Document doc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getXMLdata() {
		return XMLdata;
	}

	public void setXMLdata(String xMLdata) {
		XMLdata = xMLdata;
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}
}
