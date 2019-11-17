package com.app.coad.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.coad.entity.TipoSolicitacao;
import com.app.coad.repository.TipoSolicitacaoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class TipoSolicitacaoService {

	@Autowired
	TipoSolicitacaoRepository tsr;

	public TipoSolicitacao search(Integer id) throws ObjectNotFoundException {
		Optional<TipoSolicitacao> TipoSolicitacao = tsr.findById(id);

		return TipoSolicitacao.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + TipoSolicitacao.class.getName()));
	}

	public List<TipoSolicitacao> searchAll() {
		return tsr.findAll();
	}

	public TipoSolicitacao save(TipoSolicitacao TipoSolicitacao) {
		return tsr.save(TipoSolicitacao);
	}

	public List<TipoSolicitacao> saveAll(List<TipoSolicitacao> TipoSolicitacaos) {
		return tsr.saveAll(TipoSolicitacaos);
	}

	public TipoSolicitacao edit(TipoSolicitacao TipoSolicitacao) throws ObjectNotFoundException {
		TipoSolicitacao TipoSolicitacaoAntigo = search(TipoSolicitacao.getId());
		TipoSolicitacaoAntigo.setDescricao(TipoSolicitacao.getDescricao());
		return save(TipoSolicitacaoAntigo);
	}

	public void delete(Integer id) {
		tsr.deleteById(id);
	}
}