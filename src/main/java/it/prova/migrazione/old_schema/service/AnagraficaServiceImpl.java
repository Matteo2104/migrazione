package it.prova.migrazione.old_schema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.migrazione.old_schema.dto.AnagraficaCountDTO;
import it.prova.migrazione.old_schema.repository.AnagraficaRepository;

@Service
public class AnagraficaServiceImpl implements AnagraficaService {
	@Autowired
	private AnagraficaRepository anagraficaRepository;
	
	
	@Override
	@Transactional("primaryTransactionManager")
	public List<AnagraficaCountDTO> trovaTuttiEager() {
		// STEP 1
		// carico in una lista di anagrafica tutti i dati dal vecchio DB con join su
		// tutte le altre tabelle
		return anagraficaRepository.findAllWithCodFisAndSinistri();
	
	}
}
