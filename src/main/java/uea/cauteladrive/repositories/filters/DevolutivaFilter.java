package uea.cauteladrive.repositories.filters;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class DevolutivaFilter {
	private String situacao;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataDevolutivaDe;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataDevolutivaAte;

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public LocalDate getDataDevolutivaDe() {
		return dataDevolutivaDe;
	}

	public void setDataDevolutivaDe(LocalDate dataDevolutivaDe) {
		this.dataDevolutivaDe = dataDevolutivaDe;
	}

	public LocalDate getDataDevolutivaAte() {
		return dataDevolutivaAte;
	}

	public void setDataDevolutivaAte(LocalDate dataDevolutivaAte) {
		this.dataDevolutivaAte = dataDevolutivaAte;
	}

}
