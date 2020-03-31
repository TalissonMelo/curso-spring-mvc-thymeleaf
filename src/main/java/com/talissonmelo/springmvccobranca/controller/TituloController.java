package com.talissonmelo.springmvccobranca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String salvar(Titulo titulo) {

		System.out.println("Título Descrição " + titulo.getDescricao());

		repository.save(titulo);
		return "CadastroTitulo";
	}

}
