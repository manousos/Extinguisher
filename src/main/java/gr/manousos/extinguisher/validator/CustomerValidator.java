package gr.manousos.extinguisher.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import gr.manousos.extinguisher.model.Customer;
import gr.manousos.extinguisher.model.TaxInfo;

@Component
public class CustomerValidator implements Validator {
	// TODO:http://docs.spring.io/spring/docs/current/spring-framework-reference/html/validation.html
	@Override
	public boolean supports(Class<?> clazz) {
		return Customer.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Customer customer = (Customer) target;
		int companyAfmCount = 0, legalRepAfmCount = 0, personAfmCount = 0;
		/*
		 * Επιτρέπεται 1 με OwnerType.PERSON ή 2 με OwnerType.COMPANY &
		 * OwnerType.LEGAL_REPRESENTATIVE
		 * 
		 */
		for (TaxInfo t : customer.getTax()) {
			if (t.getAfm().isEmpty()) {
				continue;
			}
			if (t.getOwnerAFM() == null) {
				errors.rejectValue("tax[0].ownerAFM", "errorCodei18n", "afm type is required");
			}
			switch (t.getOwnerAFM()) {
			case COMPANY:
				companyAfmCount++;
				break;
			case LEGAL_REPRESENTATIVE:
				legalRepAfmCount++;
				break;
			case PERSON:
				personAfmCount++;
				break;
			default:
				break;
			}
		}

		if (companyAfmCount > 1 || legalRepAfmCount > 1 || personAfmCount > 1) {
			errors.rejectValue("tax[0].ownerAFM", "errorCodei18n", "not allowed dublicate types of afm types");
		}

		if (companyAfmCount == 1 && legalRepAfmCount == 1 && personAfmCount == 0) {
			// OK is legal entity
		} else if (companyAfmCount == 0 && legalRepAfmCount == 0 && personAfmCount == 1) {
			// OK is individual
		} else {
			errors.rejectValue("tax[0].ownerAFM", "errorCodei18n", "the compine values for afm types is not valid");
		}

	}

}
