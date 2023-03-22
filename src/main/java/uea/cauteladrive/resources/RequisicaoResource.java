package uea.cauteladrive.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import uea.cauteladrive.models.Requisicao;
import uea.cauteladrive.services.RequisicaoService;

@RestController
@RequestMapping("/requisicoes")
public class RequisicaoResource {
	@Autowired
	private RequisicaoService requisicaoService;
	
	@PostMapping
	public ResponseEntity<Requisicao> criar(@Valid @RequestBody Requisicao requisicao){
		Requisicao requisicaoSalvo = requisicaoService.criar(requisicao);
		return ResponseEntity.ok().body(requisicaoSalvo);
	}
	
	@GetMapping
	public ResponseEntity<List<Requisicao>> listar(){
		List<Requisicao> requisicoes = requisicaoService.listar();
		return ResponseEntity.ok().body(requisicoes);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Requisicao> buscarPorCodigo(@PathVariable Long id){
		Requisicao requisicao = requisicaoService.buscarPorCodigo(id);
		return ResponseEntity.ok().body(requisicao);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Requisicao> atualizar(@Valid @PathVariable Long id, @RequestBody Requisicao requisicao){
		Requisicao requisicaoSalvo = requisicaoService.atualizar(id, requisicao);
		return ResponseEntity.ok().body(requisicaoSalvo);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Requisicao> excluir(@PathVariable Long id){
		requisicaoService.excluir(id);
		return ResponseEntity.noContent().build();
	}	
}