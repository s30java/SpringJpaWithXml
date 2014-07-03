package com.asai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.asai.jpa.modal.Person;
import com.asai.jpa.service.IPersonService;



@Controller
public class HomeController {


	@Autowired
	private IPersonService personRepo;
	
	@RequestMapping(value={"/home"},  method = RequestMethod.GET)
	public ModelAndView listAll(Model model){
	
		List<Person> personlist=personRepo.createNativeQuery("getAllPersons_StoredProcedure");
		model.addAttribute("persons", personlist);
		
		//model.addAttribute("persons", personRepo.findAll());
		
		System.out.println("IS Person name not present ver 2.0::: "+personRepo.findByName("greater").isEmpty());
		
	    return new ModelAndView("home","person",new Person());
	}
	
	
	@RequestMapping(value={"/addPerson"},method=RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person person){
		
		personRepo.save(person);	
		
		return "redirect:/";
		
	}
}
