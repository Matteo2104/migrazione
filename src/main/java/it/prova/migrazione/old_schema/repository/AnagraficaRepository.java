package it.prova.migrazione.old_schema.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.prova.migrazione.old_schema.dto.AnagraficaCountDTO;
import it.prova.migrazione.old_schema.model.Anagrafica;

public interface AnagraficaRepository extends JpaRepository<Anagrafica, Long> {
	
	@Query("select distinct new it.prova.migrazione.old_schema.dto.AnagraficaCountDTO(a.nome as nome, a.cognome as cognome, a.dataDiNascita as dataDiNascita, c.codiceFiscale as codiceFiscale, count(s.anagrafica) as count) from Anagrafica a left join a.sinistri s left join a.codiceFiscale c group by s.anagrafica")
	public List<AnagraficaCountDTO> findAllWithCodFisAndSinistri();
}
