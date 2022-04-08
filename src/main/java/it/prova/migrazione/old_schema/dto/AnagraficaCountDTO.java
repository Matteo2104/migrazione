package it.prova.migrazione.old_schema.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import it.prova.migrazione.old_schema.model.Anagrafica;
import it.prova.migrazione.old_schema.model.Fiscale;


public class AnagraficaCountDTO {
private String nome;
	private String cognome;
	private Date dataDiNascita;
	private String codiceFiscale;
	private Long count;
	private Long oldId;
	
	
	public AnagraficaCountDTO() {
	}
	public AnagraficaCountDTO(String nome, String cognome, Date dataDiNascita, String codiceFiscale, Long count, Long oldId) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.codiceFiscale = codiceFiscale;
		this.count = count;
		this.oldId = oldId;
	}
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Long getOldId() {
		return oldId;
	}
	public void setOldId(Long oldId) {
		this.oldId = oldId;
	}
	
	
	
	@Override
	public String toString() {
		return "AnagraficaCountDTO [nome=" + nome + ", cognome=" + cognome + ", dataDiNascita=" + dataDiNascita
				+ ", codiceFiscale=" + codiceFiscale + ", count=" + count + "]";
	}
	
	
	

}
