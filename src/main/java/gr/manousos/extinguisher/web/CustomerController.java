package gr.manousos.extinguisher.web;

import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import gr.manousos.extinguisher.model.Customer;
import gr.manousos.extinguisher.model.OwnerType;
import gr.manousos.extinguisher.service.CustomerManager;
import gr.manousos.extinguisher.service.JobManager;
import gr.manousos.extinguisher.validator.CustomerValidator;

@Controller
@RequestMapping(value = "/customer")
@SessionAttributes({ "jobList", "ownerType" })
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	private static final String CREATE_PAGE = "CreateCustomer";

	private CustomerManager customerManager;
	private JobManager jobManager;
	private CustomerValidator validator;

	Map<Long, String> jobMap;
	OwnerType[] ownerAFMs;

	@Autowired
	public CustomerController(CustomerManager customerManager, JobManager jobManager, CustomerValidator validator) {
		super();
		this.customerManager = customerManager;
		this.jobManager = jobManager;
		this.validator = validator;
		ownerAFMs = OwnerType.values();
		jobMap = this.jobManager.getAllJobsAsMap();
	}

	// http://stackoverflow.com/questions/22286041/generic-translator-for-enums
	// https://bthurley.wordpress.com/2012/10/25/enum-translations-in-spring-mvc/
	@GetMapping
	public String setupForm(Locale locale, Model model) {
		logger.info("Welcome extinguisher! The client locale is {}.", locale);
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		model.addAttribute("jobList", jobMap);
		model.addAttribute("ownerType", ownerAFMs);

		return CREATE_PAGE;
	}

	@PostMapping
	public String createCustomer(@ModelAttribute("customer") @Validated Customer customer, BindingResult result,
			SessionStatus status) {

		validator.validate(customer, result);

		if (!result.hasErrors()) {
			customerManager.save(customer);
			status.setComplete();
		}

		return CREATE_PAGE;
	}
}
