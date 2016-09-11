package gr.manousos.extinguisher.model;

import java.util.Date;

import javax.persistence.*;

@MappedSuperclass
public class GenericEntity<T> {
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp = new Date();
	@Version
	private int version;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		if (timestamp == null)
			this.timestamp = new Date();
		else
			this.timestamp = timestamp;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
