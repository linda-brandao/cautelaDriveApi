package uea.cauteladrive.repositories.devolutiva;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import uea.cauteladrive.dto.ResumoDevolutivaDto;
import uea.cauteladrive.repositories.filters.DevolutivaFilter;

public interface DevolutivaRepositoryQuery {
	public Page<ResumoDevolutivaDto> filtrar(DevolutivaFilter devolutivaFilter, Pageable pageable);
}
