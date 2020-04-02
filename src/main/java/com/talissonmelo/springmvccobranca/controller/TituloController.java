package com.talissonmelo.springmvccobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.talissonmelo.springmvccobranca.model.Titulo;
import com.talissonmelo.springmvccobranca.model.enums.StatusTitulo;
import com.talissonmelo.springmvccobranca.repository.TitulosRepository;

@Controller
@RequestMapping("/titulos")
public class TituloController {

	private static final String CADASTRO_VIEW = "CadastroTitulo";

	@Autowired
	private TitulosRepository repository;

	@RequestMapping("/cadastro")
	public ModelAndView cadastro() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Titulo());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return CADASTRO_VIEW;
		}

		repository.save(titulo);

		attributes.addFlashAttribute("mensagem", "Título : " + titulo.getDescricao() + ", cadastrado com sucesso!.");
		return "redirect:/titulos/cadastro";
	}

	@RequestMapping
	public ModelAndView pesquisar() {
		List<Titulo> list = repository.findAll();
		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		mv.addObject("titulos", list);
		return mv;
	}

	@RequestMapping("/{id}")
	public ModelAndView edicao(@PathVariable("id") Titulo titulo) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(titulo);
		return mv;
	}

	@ModelAttribute("statusTitulos")
	public List<StatusTitulo> todosStatusTitulo() {
		return Arrays.asList(StatusTitulo.values());
	}

}
