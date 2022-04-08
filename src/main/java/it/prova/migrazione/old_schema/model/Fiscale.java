package it.prova.migrazione.old_schema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "old_schema", name = "fiscale")
public class Fiscale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "codiceFiscale")
	private String codiceFiscale;
	
	@OneToOne(mappedBy = "codiceFiscale")
	private Anagrafica anagrafica;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
	
	
	@Override
	public String toString() {
		return "Fiscale [id=" + id + ", codiceFiscale=" + codiceFiscale + "]";
	}
	
	
}
