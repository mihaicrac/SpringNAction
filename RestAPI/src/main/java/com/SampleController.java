package com;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.domain.Spitter;
import com.repository.SpitterRepository;

@Controller
@SpringBootApplication
public class SampleController {
	
	SpitterRepository db;
	
	
	@Autowired
	public void setDb(SpitterRepository db) {
		this.db = db;
	}
	
	
	@RequestMapping("/")
	@ResponseBody
	@Transactional
	String home() {
		
		Spitter sp = new Spitter("asdads","sadfhfh","dghhfg","fdgfdgghgf");
		db.save(sp);
		return "Hello World!";
	}
	
	@RequestMapping("/find/{username}")
	@ResponseBody
	@Transactional
	String find(@PathVariable("username") String username) {
		
		Spitter s = db.findByUsername(username);
		return s.getFirstName()+":"+s.getLastName();
	}
	
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleController.class, args);
	}
}