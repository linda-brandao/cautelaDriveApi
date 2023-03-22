package uea.cauteladrive.repositories.devolutiva;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import uea.cauteladrive.dto.ResumoDevolutivaDto;
import uea.cauteladrive.models.Devolutiva;
import uea.cauteladrive.repositories.filters.DevolutivaFilter;

public class DevolutivaRepositoryQueryImpl implements DevolutivaRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<ResumoDevolutivaDto> filtrar(DevolutivaFilter devolutivaFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		
		CriteriaQuery<ResumoDevolutivaDto> criteria = builder.createQuery(ResumoDevolutivaDto.class);
		Root<Devolutiva> root = criteria.from(Devolutiva.class);
		
		criteria.select(builder.construct(ResumoDevolutivaDto.class, root.get("id"), root.get("dataDevolutiva"), root.get("situacao"), root.get("requisicao").get("descricao"), root.get("requisicao").get("coordenador").get("nome"), root.get("motorista").get("nome"), root.get("veiculo").get("modelo")));
		
		Predicate[] predicates = criarRestricoes(devolutivaFilter, builder, root);
		if(predicates.length > 0) {
			criteria.where(predicates);
		}
		
		TypedQuery<ResumoDevolutivaDto> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(devolutivaFilter));
	}

	private Long total(DevolutivaFilter devolutivaFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Devolutiva> root = criteria.from(Devolutiva.class);
		
		Predicate[] predicates = criarRestricoes(devolutivaFilter, builder, root);
		if(predicates.length > 0) {
			criteria.where(predicates);
		}
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<ResumoDevolutivaDto> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalDeRegistroPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalDeRegistroPorPagina; //quantidade de regitros por pagina
		
		//pegar de tanto até tanto
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalDeRegistroPorPagina);
		
	}

	private Predicate[] criarRestricoes(DevolutivaFilter devolutivaFilter, CriteriaBuilder builder,
			Root<Devolutiva> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if(!ObjectUtils.isEmpty(devolutivaFilter.getSituacao())) {
			predicates.add(builder.like(builder.lower(root.get("situacao")), "%" + devolutivaFilter.getSituacao().toLowerCase() + "%"));
		}
		
		if(devolutivaFilter.getDataDevolutivaDe() != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("dataDevolutiva"), devolutivaFilter.getDataDevolutivaDe()));
		}
		
		if(devolutivaFilter.getDataDevolutivaAte() != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get("dataDevolutiva"), devolutivaFilter.getDataDevolutivaAte()));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
}
