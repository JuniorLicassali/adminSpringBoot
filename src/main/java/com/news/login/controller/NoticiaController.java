package com.news.login.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.news.login.model.Noticia;
import com.news.login.repositorio.NoticiaRepo;


@Controller
public class NoticiaController {

		
	@Autowired
	private NoticiaRepo repo2;
	  
	  @GetMapping("/noticias")
	  public String index(Model model){
	    List<Noticia> noticias = (List<Noticia>)repo2.findAll();
	    model.addAttribute("noticias", noticias);
	    return "noticias/index";
	  }

	  @GetMapping("/noticias/novo")
	  public String novo(){
	    return "noticias/novo";
	  }

	  @PostMapping("/noticias/criar")
	  public String criar(Noticia noticia){
	    repo2.save(noticia);
	    return "redirect:/noticias";
	  }

	  @GetMapping("/noticias/{id}")
	  public String busca(@PathVariable Long id, Model model){
	    Optional<Noticia> noti = repo2.findById(id);
	    try{
	      model.addAttribute("noticias", noti.get());
	    }
	    catch(Exception err){ return "redirect:/noticias"; }

	    return "/noticias/editar";
	  }

	  @PostMapping("/noticias/{id}/atualizar")
	  public String atualizar(@PathVariable Long id, Noticia noticia){
	    // if(!repo.exist(id)){
	    if(!repo2.existsById(id)){
	      return "redirect:/administradores";
	    }

	    repo2.save(noticia);

	    return "redirect:/noticias";
	  }


	  @GetMapping("/noticias/{id}/excluir")
	  public String excluir(@PathVariable Long id){
	    repo2.deleteById(id);
	    return "redirect:/noticias";
	  }
}
