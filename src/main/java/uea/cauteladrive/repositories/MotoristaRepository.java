package uea.cauteladrive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uea.cauteladrive.models.Motorista;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Long>{

}
