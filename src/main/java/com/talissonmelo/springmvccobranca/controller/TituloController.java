package com.talissonmelo.springmvccobranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.talissonmelo.springmvccobranca.model.Titulo;

@Controller
@RequestMapping("/titulos")
public class TituloController {

	@RequestMapping("/cadastro")
	public String cadastro() {
		return "CadastroTitulo";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(Titulo titulo) {

		System.out.println("Título Descrição " + titulo.getDescricao());

		return "CadastroTitulo";
	}

}
