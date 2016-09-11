package gr.manousos.extinguisher.model;

public enum OwnerType {
	/**
	 * ΑΦΜ ιδιώτη
	 */
	PERSON(0),
	/**
	 * ΑΦΜ νόμιμου εκπροσώπου εταιρείας
	 */
	LEGAL_REPRESENTATIVE(1),
	/**
	 * ΑΦΜ εταιρείας
	 */
	COMPANY(2);
	
	private final int value;

	private OwnerType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
