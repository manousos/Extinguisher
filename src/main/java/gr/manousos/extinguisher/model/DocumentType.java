package gr.manousos.extinguisher.model;

public enum DocumentType {
	CONSIGMENT_NOTE(0), INVOICE(1), EXTINGUISHER_MAINTENANCE(2), MIX(3), CANCEL_CONSIGMENT_NOTE(4), CANCEL_INVOICE(5), CANCEL_MIX(6);
	private final int value;

	private DocumentType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
