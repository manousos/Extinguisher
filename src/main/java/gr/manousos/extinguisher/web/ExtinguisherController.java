package gr.manousos.extinguisher.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import gr.manousos.extinguisher.model.Extinguisher;
import gr.manousos.extinguisher.service.ExtinguisherManager;

@Controller
@RequestMapping(value = "/extinguisher")
public class ExtinguisherController {
	private static final Logger logger = LoggerFactory.getLogger(ExtinguisherController.class);
	private static final String CREATE_PAGE = "CreateExtinguisher";
	private static final String UPDATE_PAGE = "UpdateExtinguisher";
	private static final String VIEW_PAGE = "ViewExtinguisher";

	private ExtinguisherManager extinguisherManager;

	@Autowired
	public ExtinguisherController(ExtinguisherManager extinguisherManager) {
		this.extinguisherManager = extinguisherManager;
	}

	@Transactional
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView all(Locale locale, Model model) throws JsonGenerationException, JsonMappingException, IOException {
		logger.info("Welcome home! The client locale is {}.", locale);
		List<Extinguisher> list = new ArrayList<Extinguisher>();
		// extinguisherManager.findAll().iterator().forEachRemaining(list::add);

		for (Extinguisher ex : extinguisherManager.findAll()) {
			ex.setMaintenances(null);
			ex.setDocItems(null);
			ex.setCustomer(null);
			list.add(ex);
		}
		// circular reference problem
		// Gson gson = new GsonBuilder().setPrettyPrinting().create();
		// String json2 = gson.toJson(list.iterator().next());
		// No Json result --> it's string
		// ObjectMapper mapper = new ObjectMapper();
		// String json=mapper.writeValueAsString(list);
		// model.addAttribute("extinguisherList", list.iterator().next());
		ModelAndView mv = new ModelAndView("jsExtinguisher");
		mv.addObject("extinguisherList", list.iterator().next());

		return mv;
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public @ResponseBody Iterator<Extinguisher> getAll() {
		Iterator<Extinguisher> results = extinguisherManager.findAll().iterator();
		return results;
	}

	@GetMapping(value = "/getBySn/{sn}")
	public @ResponseBody Extinguisher getExtinguisher(@PathVariable String sn) {
		return extinguisherManager.findBybottlePartNumber(sn);
	}

	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	public @ResponseBody Extinguisher getExtinguisherById(@PathVariable Long id) {
		return extinguisherManager.findOne(id);
	}

	@GetMapping
	public String setupForm(Locale locale, Model model) {
		logger.info("Welcome extinguisher! The client locale is {}.", locale);
		model.addAttribute("extinguisher", new Extinguisher());

		return CREATE_PAGE;
	}

	@RequestMapping(value = "/showAll", method = RequestMethod.GET)
	public String showAll(Model model) {
		model.addAttribute("extinguisherList", extinguisherManager.findAll());

		return VIEW_PAGE;
	}

	@PostMapping
	public String createExtinguisher(@ModelAttribute("extinguisher") @Validated Extinguisher extinguisher, BindingResult result, SessionStatus status) {

		if (!result.hasErrors()) {
			extinguisherManager.save(extinguisher);
			status.setComplete();
		}

		return CREATE_PAGE;
	}

	@GetMapping("/edit")
	public String updateForm(Model model) {
		model.addAttribute("extinguisher", new Extinguisher());

		return UPDATE_PAGE;
	}

	@Transactional
	@PostMapping(value = "/edit", params = "update")
	public String updateExtinguisher(@ModelAttribute("extinguisher") @Validated Extinguisher extinguisher, BindingResult result, SessionStatus status) {
		if (extinguisher.getId() == null) {
			return UPDATE_PAGE;
		}
		if (!result.hasErrors()) {
			extinguisherManager.save(extinguisher);
			status.setComplete();
		}

		return UPDATE_PAGE;
	}

	@Transactional
	@PostMapping(value = "/edit", params = "delete")
	public String deleteExtinguisher(@ModelAttribute("extinguisher") @Validated Extinguisher extinguisher, BindingResult result, SessionStatus status) {
		if (extinguisher.getId() == null) {
			return UPDATE_PAGE;
		}
		extinguisherManager.delete(extinguisher.getId());
		status.setComplete();

		return UPDATE_PAGE;
	}
}
