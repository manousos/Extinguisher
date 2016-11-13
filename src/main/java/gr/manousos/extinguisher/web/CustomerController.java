package gr.manousos.extinguisher.web;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import gr.manousos.extinguisher.model.Customer;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	private static final String CREATE_PAGE = "CreateCustomer";

	@GetMapping
	public String setupForm(Locale locale, Model model) {
		logger.info("Welcome extinguisher! The client locale is {}.", locale);
		model.addAttribute("customer", new Customer());

		return CREATE_PAGE;
	}

	@PostMapping
	public String createCustomer(@ModelAttribute("customer") @Validated Customer customer, BindingResult result,
			SessionStatus status) {

		if (!result.hasErrors()) {
			//customerManager.save(extinguisher);
			status.setComplete();
		}

		return CREATE_PAGE;
	}
}
