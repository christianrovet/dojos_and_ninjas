package com.christian.dojos_and_ninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.christian.dojos_and_ninjas.models.*;
import com.christian.dojos_and_ninjas.services.*;

@Controller
public class HomeController {
	private final Dojos_And_NinjasService dojoNinjaService;
	
	public HomeController(Dojos_And_NinjasService dojoNinjaService) {
		this.dojoNinjaService = dojoNinjaService;
	}
	//GET ROUTES
	
	//Homepage
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	//New Dojo Form
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo")Dojo dojo) {
		return "dojos/Dojo.jsp";
	}
	//New Ninja Form
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoNinjaService.getAllDojos();
		model.addAttribute("dojos",dojos);
		return "ninjas/Ninja.jsp";
	}
	//show all ninjas per dojo id
	@GetMapping("/dojos/{id}")
	public String showDojos(@PathVariable("id") long id, Model model) {
		Dojo dojo = dojoNinjaService.findDojoById(id);
		model.addAttribute("dojo",dojo);
		return "dojos/showDojo.jsp";
	}
	
	//POST ROUTES
	
	//New Dojo
	@PostMapping("/dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "dojos/Dojo.jsp";
		} else {
			dojoNinjaService.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	//New Ninja
	@PostMapping("/ninjas/new")
	public String createNinja(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Dojo> dojos = dojoNinjaService.getAllDojos();
			model.addAttribute("dojos", dojos);
			return "ninjas/Ninja.jsp";
		} else {
			dojoNinjaService.createNinja(ninja);
			Long dojo_id = ninja.getDojo().getId();
			return "redirect:/dojos/" + dojo_id;
		}
	}
	
}
