package com.app.coad.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.coad.entity.Solicitacao;
import com.app.coad.repository.SolicitacaoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class SolicitacaoService {

	@Autowired
	SolicitacaoRepository sr;

	public Solicitacao search(Integer id) throws ObjectNotFoundException {
		Optional<Solicitacao> solicitacao = sr.findById(id);

		return solicitacao.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + Solicitacao.class.getName()));
	}

	public List<Solicitacao> searchAll() {
		return sr.findAll();
	}

	public Solicitacao save(Solicitacao solicitacao) {
		return sr.save(solicitacao);
	}

	public List<Solicitacao> saveAll(List<Solicitacao> solicitacoes) {
		return sr.saveAll(solicitacoes);
	}

	public Solicitacao edit(Solicitacao solicitacao) throws ObjectNotFoundException {
		Solicitacao solicitacaoAntigo = search(solicitacao.getId());
		solicitacaoAntigo.setTitulo(solicitacao.getTitulo());
		solicitacaoAntigo.setDescricao(solicitacao.getDescricao());
		solicitacaoAntigo.setData(solicitacao.getData());
		solicitacaoAntigo.setTipoSolicitacao(solicitacao.getTipoSolicitacao());
		solicitacaoAntigo.setCliente(solicitacao.getCliente());
		solicitacaoAntigo.setTipoSolicitacao(solicitacao.getTipoSolicitacao());
		solicitacaoAntigo.setStatus(solicitacao.getStatus());
		return save(solicitacaoAntigo);
	}

	public void delete(Integer id) {
		sr.deleteById(id);
	}
}