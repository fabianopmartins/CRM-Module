package com.app.coad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.app.coad.entity.TipoSolicitacao;
import com.app.coad.service.TipoSolicitacaoService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
public class TipoSolicitacaoController {

	@Autowired
	private TipoSolicitacaoService tss;

	@RequestMapping(value = "/cadastraTipoSolicitacao", method = RequestMethod.GET)
	public ModelAndView formCadastraTipoSolicitacao() {
		ModelAndView mv = new ModelAndView("tipoSolicitacao/formTipoSolicitacaoModal");
		mv.addObject("tipoSolicitacao", new TipoSolicitacao());
		return mv;
	}

	@RequestMapping(value = "/tipoSolicitacoes", method = RequestMethod.GET)
	public ModelAndView listaTipoSolicitacao() {
		ModelAndView mv = new ModelAndView("tipoSolicitacao/tabelaTipoSolicitacao");
		mv.addObject("tipos", tss.searchAll());
		return mv;
	}

	@RequestMapping(value = "/alteraTipoSolicitacao/{id}", method = RequestMethod.GET)
	public ModelAndView alteraTipoSolicitacao(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("tipoSolicitacao/alteraTipoSolicitacaoModal");
		mv.addObject("tipoSolicitacao", tss.search(id));
		return mv;
	}

	@RequestMapping(value = "/alteraTipoSolicitacao", method = RequestMethod.POST)
	public ModelAndView alteraTipoSolicitacao(TipoSolicitacao tipoSolicitacao) throws ObjectNotFoundException {
		tss.edit(tipoSolicitacao);
		return listaTipoSolicitacao();
	}

	@RequestMapping(value = "/salvaTipoSolicitacao", method = RequestMethod.POST)
	public ModelAndView salvaTipoSolicitacao(TipoSolicitacao tipoSolicitacao) {
		tss.save(tipoSolicitacao);
		return listaTipoSolicitacao();
	}
}
