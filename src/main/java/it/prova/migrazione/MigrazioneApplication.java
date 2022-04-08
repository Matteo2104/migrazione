package it.prova.migrazione;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import it.prova.migrazione.new_schema.model.Assicurato;
import it.prova.migrazione.new_schema.model.AssicuratoNotProcessed;
import it.prova.migrazione.new_schema.repository.AssicuratoRepository;
import it.prova.migrazione.new_schema.service.assicurato.AssicuratoService;
import it.prova.migrazione.new_schema.service.assicuratonotprocessed.AssicuratoNotProcessedService;
import it.prova.migrazione.old_schema.dto.AnagraficaCountDTO;
import it.prova.migrazione.old_schema.model.Anagrafica;
import it.prova.migrazione.old_schema.repository.AnagraficaRepository;
import it.prova.migrazione.old_schema.service.AnagraficaService;

@SpringBootApplication
@ComponentScan(basePackages = "it.prova.migrazione")
public class MigrazioneApplication implements CommandLineRunner {
	
	@Autowired
	private AnagraficaService anagraficaService;
	
	@Autowired
	private AssicuratoService assicuratoService;
	
	@Autowired
	private AssicuratoNotProcessedService assicuratoNotProcessedService;
	
	
//	@Autowired
//	private AnagraficaRepository anagraficaRepository;
//	@Autowired
//	private AssicuratoRepository assicuratoRepository;

	public static void main(String[] args) {
		SpringApplication.run(MigrazioneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		List<AnagraficaCountDTO> listaDiAnagrafici = anagraficaService.trovaTuttiEager();
		//List<AnagraficaCountDTO> listaDiAnagrafici = anagraficaRepository.findAllWithCodFisAndSinistri();
		
		//System.out.println(listaDiAnagrafici);
		
		// costruisco la lista di assicurati (eventualmente eseguo validazione campi)
		List<Assicurato> listaDiAssicurati = new ArrayList<>();
		List<AssicuratoNotProcessed> listaDiAssicuratiInvalid = new ArrayList<>();
		
		for (AnagraficaCountDTO anagraficaItem : listaDiAnagrafici) {
			if (!StringUtils.isEmpty(anagraficaItem.getNome()) &&
					!StringUtils.isEmpty(anagraficaItem.getCognome()) &&
					anagraficaItem.getDataDiNascita() != null &&
					!StringUtils.isEmpty(anagraficaItem.getCodiceFiscale()) &&
					anagraficaItem.getCodiceFiscale().length() == 16) {
				
				listaDiAssicurati.add(new Assicurato(anagraficaItem.getNome(), anagraficaItem.getCognome(),
						anagraficaItem.getDataDiNascita(), anagraficaItem.getCodiceFiscale(), anagraficaItem.getCount()));
				
			} else {
				listaDiAssicuratiInvalid.add(new AssicuratoNotProcessed(anagraficaItem.getCodiceFiscale(), anagraficaItem.getOldId()));
			}
			
			//System.out.println(listaDiAssicurati.get(listaDiAssicurati.size() - 1));
		}
		
		
		assicuratoService.inserisciTutti(listaDiAssicurati);
		assicuratoNotProcessedService.inserisciTutti(listaDiAssicuratiInvalid);
		
	}
	
	

}
