package uea.cauteladrive.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.cauteladrive.models.Coordenador;
import uea.cauteladrive.models.Requisicao;
import uea.cauteladrive.repositories.CoordenadorRepository;
import uea.cauteladrive.repositories.RequisicaoRepository;

@Service
public class RequisicaoService {
	
	@Autowired
	private RequisicaoRepository requisicaoRepository;
	
	@Autowired
	private CoordenadorRepository coordenadorRepository;
	
	public Requisicao criar(Requisicao requisicao) {
		Coordenador coordenador = coordenadorRepository.findById(requisicao.getCoordenador().getId()).orElseThrow();
		return requisicaoRepository.save(requisicao);
	}
	
	public List<Requisicao> listar(){
		return requisicaoRepository.findAll();
	}
	
	public Requisicao buscarPorCodigo(Long id) {
		Requisicao requisicao = requisicaoRepository.findById(id).orElseThrow();
		return requisicao;
	}
	
	public Requisicao atualizar(Long id, Requisicao requisicao) {
		Requisicao requisicaoSalvo = requisicaoRepository.findById(id).orElseThrow();
		Coordenador coordenador = coordenadorRepository.findById(requisicao.getCoordenador().getId()).orElseThrow();
		BeanUtils.copyProperties(requisicao, requisicaoSalvo, "id");
		return requisicaoRepository.save(requisicaoSalvo);
	}
	
	public void excluir(Long id) {
		requisicaoRepository.deleteById(id);
	}
}