package uea.cauteladrive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uea.cauteladrive.models.Requisicao;

@Repository
public interface RequisicaoRepository extends JpaRepository<Requisicao, Long>{

}
