package uea.cauteladrive.dto;

import java.time.LocalDate;

import uea.cauteladrive.models.enums.Situacao;

public class ResumoDevolutivaDto {
	private Long id;
	private LocalDate dataDevolutiva;
	private Situacao situacao;
	private String requisicao;
	private String motorista;
	private String descricao;
	
	public ResumoDevolutivaDto() {	}
	
	public ResumoDevolutivaDto(Long id, LocalDate dataDevolutiva, Situacao situacao, String requisicao,
			String motorista, String descricao) {
		super();
		this.id = id;
		this.dataDevolutiva = dataDevolutiva;
		this.situacao = situacao;
		this.requisicao = requisicao;
		this.motorista = motorista;
		this.descricao = descricao;
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

	public String getNomeCoordenador() {
		return requisicao;
	}

	public void setNomeCoordenador(String requisicao) {
		this.requisicao = requisicao;
	}

	public String getNomeMotorista() {
		return motorista;
	}

	public void setNomeMotorista(String motorista) {
		this.motorista = motorista;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
