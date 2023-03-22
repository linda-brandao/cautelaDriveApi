package uea.cauteladrive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uea.cauteladrive.models.Devolutiva;

@Repository
public interface DevolutivaRepository extends JpaRepository<Devolutiva, Long>{

}
