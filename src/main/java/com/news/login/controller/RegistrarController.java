package com.news.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.news.login.model.Administrador;
import com.news.login.repositorio.AdministradoresRepo;

@Controller
public class RegistrarController {

	@Autowired
	private AdministradoresRepo repoRegis;
	  
	  @GetMapping("/registrar")
	  public String regis(){
	    return "login/registrar";
	  }
	  
	  @PostMapping("/registrar/criar")
	  public String postRegis(Administrador administrador){
		  repoRegis.save(administrador);
		  return "redirect:/login";
	  }
	  
}
