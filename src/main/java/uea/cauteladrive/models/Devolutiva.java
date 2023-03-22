package uea.cauteladrive.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import uea.cauteladrive.models.enums.Situacao;

public class Devolutiva implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Enumerated(EnumType.STRING)
	private Long id;
	private LocalDate dataDevolutiva;
	
	@Enumerated(EnumType.STRING)
	private Situacao situacao;

	@OneToOne
	@JoinColumn(name = "id_requisicao")
	private Requisicao requisicao;
	
	@ManyToOne
	@JoinColumn(name = "id_veiculo")
	private Veiculo veiculo;
	
	@ManyToOne
	@JoinColumn(name = "id_motorista")
	private Motorista motorista;
	
	public Devolutiva() {	}

	public Devolutiva(Long id, LocalDate dataDevolutiva, Situacao situacao, Requisicao requisicao, Veiculo veiculo,
			Motorista motorista) {
		super();
		this.id = id;
		this.dataDevolutiva = dataDevolutiva;
		this.situacao = situacao;
		this.requisicao = requisicao;
		this.veiculo = veiculo;
		this.motorista = motorista;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataDevolutiva() {
		return dataDevolutiva;
	}

	public void setDataDevolutiva(LocalDate dataDevolutiva) {
		this.dataDevolutiva = dataDevolutiva;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Requisicao getRequisicao() {
		return requisicao;
	}

	public void setRequisicao(Requisicao requisicao) {
		this.requisicao = requisicao;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Devolutiva other = (Devolutiva) obj;
		return Objects.equals(id, other.id);
	}
	
}
