package com.talissonmelo.springmvccobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.talissonmelo.springmvccobranca.model.Titulo;
import com.talissonmelo.springmvccobranca.model.enums.StatusTitulo;
import com.talissonmelo.springmvccobranca.repository.TitulosRepository;

@Controller
@RequestMapping("/titulos")
public class TituloController {

	@Autowired
	private TitulosRepository repository;

	@RequestMapping("/cadastro")
	public ModelAndView cadastro() {
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo) {
		repository.save(titulo);
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject("mensagem", "Título : " + titulo.getDescricao() + ", cadastrado com sucesso!.");
		return mv;
	}
	
	@RequestMapping
	public String pesquisar() {
		return "PesquisaTitulos";
	}
	
	@ModelAttribute("statusTitulos")
	public List<StatusTitulo> todosStatusTitulo(){
		return Arrays.asList(StatusTitulo.values());
	}

}
