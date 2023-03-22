package uea.cauteladrive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uea.cauteladrive.models.Coordenador;

@Repository
public interface CoordenadorRepository extends JpaRepository<Coordenador, Long>{

}
