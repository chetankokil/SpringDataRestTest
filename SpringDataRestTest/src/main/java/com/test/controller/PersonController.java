package com.test.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.test.model.Person;
import com.test.repository.PersonRepository;

@Controller
public class PersonController {

	@Autowired
	PersonRepository repository;
	
	@RequestMapping(value="/persons",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Person>> getAllPersons() {
		List<Person> personLst = repository.findAll();
		Type type = new TypeToken<List<Person>>() {
		}.getType();
		
		return new ResponseEntity(new Gson().toJson(personLst, type), HttpStatus.OK);
	}
	
	
}
