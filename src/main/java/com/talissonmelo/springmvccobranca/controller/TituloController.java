package com.talissonmelo.springmvccobranca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.talissonmelo.springmvccobranca.model.Titulo;
import com.talissonmelo.springmvccobranca.repository.TitulosRepository;

@Controller
@RequestMapping("/titulos")
public class TituloController {

	@Autowired
	private TitulosRepository repository;

	@RequestMapping("/cadastro")
	public String cadastro() {
		return "CadastroTitulo";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo) {
		repository.save(titulo);
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject("mensagem", "Título : " + titulo.getDescricao() + ", cadastrado com sucesso!.");
		return mv;
	}

}
