package it.prova.migrazione.new_schema.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "new_schema", name = "assicurato")
public class Assicurato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "dataDiNascita")
	private Date dataDiNascita;
	@Column(name = "codiceFiscale")
	private String codiceFiscale;
	@Column(name = "nSinistri")
	private Long nSinistri;
	
	
	public Assicurato() {}
	public Assicurato(String nome, String cognome, Date dataDiNascita, String codiceFiscale, Long nSinistri) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.codiceFiscale = codiceFiscale;
		this.nSinistri = nSinistri;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Long getnSinistri() {
		return nSinistri;
	}
	public void setnSinistri(Long nSinistri) {
		this.nSinistri = nSinistri;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Assicurato [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataDiNascita=" + dataDiNascita
				+ ", codiceFiscale=" + codiceFiscale + ", nSinistri=" + nSinistri + "]";
	}
	
	
}
