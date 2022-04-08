package it.prova.migrazione;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import it.prova.migrazione.new_schema.model.Assicurato;
import it.prova.migrazione.new_schema.repository.AssicuratoRepository;
import it.prova.migrazione.old_schema.dto.AnagraficaCountDTO;
import it.prova.migrazione.old_schema.model.Anagrafica;
import it.prova.migrazione.old_schema.repository.AnagraficaRepository;

@SpringBootApplication
@ComponentScan(basePackages = "it.prova.migrazione")
public class MigrazioneApplication implements CommandLineRunner {
	/*
	@Autowired
	private AnagraficaService anagraficaService;
	
	@Autowired
	private AssicuratoService assicuratoService;
	*/
	
	@Autowired
	private AnagraficaRepository anagraficaRepository;
	@Autowired
	private AssicuratoRepository assicuratoRepository;

	public static void main(String[] args) {
		SpringApplication.run(MigrazioneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		//List<Anagrafica> listaDiAnagrafici = anagraficaService.trovaTuttiEager();
		List<AnagraficaCountDTO> listaDiAnagrafici = anagraficaRepository.findAllWithCodFisAndSinistri();
		
		//System.out.println(listaDiAnagrafici);
		
		List<Assicurato> listaDiAssicurati = new ArrayList<>();
		for (AnagraficaCountDTO anagraficaItem : listaDiAnagrafici) {
			listaDiAssicurati.add(new Assicurato(anagraficaItem.getNome(), anagraficaItem.getCognome(),
					anagraficaItem.getDataDiNascita(), anagraficaItem.getCodiceFiscale(), anagraficaItem.getCount()));
			System.out.println(listaDiAssicurati.get(listaDiAssicurati.size() - 1));
		}
		
		
		for (Assicurato assicuratoItem : listaDiAssicurati) {
			assicuratoRepository.save(assicuratoItem);
		}
		

		
		
		
		
		//migrationService.executeMigration();
	}
	
	

}
