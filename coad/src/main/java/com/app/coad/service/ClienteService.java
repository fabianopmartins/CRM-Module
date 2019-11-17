package com.app.coad.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.coad.entity.Cliente;
import com.app.coad.repository.ClienteRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository cr;

	public Cliente search(Integer id) throws ObjectNotFoundException {
		Optional<Cliente> Cliente = cr.findById(id);

		return Cliente.orElseThrow(
				() -> new ObjectNotFoundException("não encontrado. id: " + id + ", Tipo!" + Cliente.class.getName()));
	}

	public List<Cliente> searchAll() {
		return cr.findAll();
	}

	public Cliente save(Cliente cliente) {
		return cr.save(cliente);
	}

	public List<Cliente> saveAll(List<Cliente> clientes) {
		return cr.saveAll(clientes);
	}

	public Cliente edit(Cliente cliente) throws ObjectNotFoundException {
		Cliente clienteAntigo = search(cliente.getId());
		clienteAntigo.setNome(cliente.getNome());
		clienteAntigo.setEmail(cliente.getEmail());
		clienteAntigo.setFoneResidencial(cliente.getFoneResidencial());
		clienteAntigo.setFoneComercial(cliente.getFoneComercial());
		clienteAntigo.setFoneCelular(cliente.getFoneCelular());
		return save(clienteAntigo);
	}

	public void delete(Integer id) {
		cr.deleteById(id);
	}
}