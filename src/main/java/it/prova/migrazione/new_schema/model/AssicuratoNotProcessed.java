package it.prova.migrazione.new_schema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "new_schema", name = "not_processed")
public class AssicuratoNotProcessed {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "codiceFiscale")
	private String codiceFiscale;
	
	@Column(name = "old_id")
	private Long old_id;
	
	public AssicuratoNotProcessed() {}
	public AssicuratoNotProcessed(String codiceFiscale, Long old_id) {
		this.codiceFiscale = codiceFiscale;
		this.old_id = old_id;
	}
	
	
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
	public Long getOld_id() {
		return old_id;
	}
	public void setOld_id(Long old_id) {
		this.old_id = old_id;
	}
	
	
	@Override
	public String toString() {
		return "AssicuratoNotProcessed [id=" + id + ", codiceFiscale=" + codiceFiscale + ", old_id=" + old_id + "]";
	}
	
	
}
