package com.app.coad.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.coad.entity.Cliente;
import com.app.coad.service.ClienteService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService cs;

	@RequestMapping(value = "/cadastraCliente", method = RequestMethod.GET)
	public ModelAndView formCadastraCliente() {
		ModelAndView mv = new ModelAndView("cliente/formCliente");
		mv.addObject("cliente", new Cliente());
		return mv;
	}

	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public ModelAndView listaCliente() {
		ModelAndView mv = new ModelAndView("cliente/tabelaCliente");
		mv.addObject("clientes", cs.searchAll());
		return mv;
	}

	@RequestMapping(value = "/alteraCliente/{id}", method = RequestMethod.GET)
	public ModelAndView alteraCliente(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("cliente/alteraClienteModal");
		mv.addObject("cliente", cs.search(id));
		return mv;
	}

	@RequestMapping(value = "/alteraCliente", method = RequestMethod.POST)
	public ModelAndView alteraCliente(Cliente cliente) throws ObjectNotFoundException {
		cs.edit(cliente);
		return listaCliente();
	}

	@RequestMapping(value = "/salvaCliente", method = RequestMethod.POST)
	public ModelAndView salvaCliente(Cliente cliente) {
		cs.save(cliente);
		return listaCliente();
	}
	
	@RequestMapping(value = "/formSalvaCliente", method = RequestMethod.POST)
	public String formSalvaCliente(@Valid Cliente cliente, RedirectAttributes redirectAttributes) {
		cs.save(cliente);
		redirectAttributes.addFlashAttribute("msg_resultado", "Cliente salvo com sucesso!");
		return "redirect:/cadastraCliente";
	}

	@RequestMapping(value = "/visualizaCliente/{id}", method = RequestMethod.GET)
	public ModelAndView visualizaCliente(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("cliente/visualizaClienteModal");
		mv.addObject("cliente", cs.search(id));
		return mv;
	}
}