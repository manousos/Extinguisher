package gr.manousos.extinguisher.model;

public enum ContactType {
	PHONE(0), MOBILE(1), FAX(2), EMAIL(3);

	private final int value;

	private ContactType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
