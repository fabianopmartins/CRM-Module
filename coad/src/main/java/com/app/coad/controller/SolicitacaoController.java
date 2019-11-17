package com.app.coad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.coad.entity.Solicitacao;
import com.app.coad.service.ClienteService;
import com.app.coad.service.SolicitacaoService;
import com.app.coad.service.TipoSolicitacaoService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
public class SolicitacaoController {

	@Autowired
	private SolicitacaoService ss;
	
	@Autowired
	private TipoSolicitacaoService tss;
	
	@Autowired
	private ClienteService cs;

	@RequestMapping(value = "/cadastraSolicitacao", method = RequestMethod.GET)
	public ModelAndView formCadastraSolicitacao() {
		ModelAndView mv = new ModelAndView("solicitacao/formSolicitacao");
		mv.addObject("clientes", cs.searchAll());
		mv.addObject("tipos", tss.searchAll());
		mv.addObject("solicitacao", new Solicitacao());
		return mv;
	}

	@RequestMapping(value = "/solicitacoes", method = RequestMethod.GET)
	public ModelAndView listaSolicitacao() {
		ModelAndView mv = new ModelAndView("solicitacao/tabelaSolicitacao");
		mv.addObject("solicitacoes", ss.searchAll());
		return mv;
	}

	@RequestMapping(value = "/alteraSolicitacao/{id}", method = RequestMethod.GET)
	public ModelAndView alteraSolicitacao(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("solicitacao/alteraSolicitacaoModal");
		mv.addObject("clientes", cs.searchAll());
		mv.addObject("tipos", tss.searchAll());
		mv.addObject("solicitacao", ss.search(id));
		return mv;
	}

	@RequestMapping(value = "/alteraSolicitacao", method = RequestMethod.POST)
	public ModelAndView alteraSolicitacao(Solicitacao solicitacao) throws ObjectNotFoundException {
		ss.edit(solicitacao);
		return listaSolicitacao();
	}

	@RequestMapping(value = "/salvaSolicitacao", method = RequestMethod.POST)
	public ModelAndView salvaSolicitacao(Solicitacao solicitacao) {
		ss.save(solicitacao);
		return listaSolicitacao();
	}

	@RequestMapping(value = "/formSalvaSolicitacao", method = RequestMethod.POST)
	public ModelAndView formSalvaSolicitacao(Solicitacao solicitacao) {
		ss.save(solicitacao);
		return formCadastraSolicitacao();
	}

	@RequestMapping(value = "/deletaSolicitacao/{id}", method = RequestMethod.GET)
	public ModelAndView deletaSolicitacao(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("solicitacao/deletaSolicitacaoModal");
		mv.addObject("solicitacao", ss.search(id));
		return mv;
	}

}