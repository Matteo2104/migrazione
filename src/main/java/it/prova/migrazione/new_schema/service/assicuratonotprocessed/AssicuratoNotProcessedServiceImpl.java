package it.prova.migrazione.new_schema.service.assicuratonotprocessed;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.prova.migrazione.new_schema.model.AssicuratoNotProcessed;
import it.prova.migrazione.new_schema.repository.AssicuratoNotProcessedRepository;

@Service
public class AssicuratoNotProcessedServiceImpl implements AssicuratoNotProcessedService {
	@Autowired
	private AssicuratoNotProcessedRepository assicuratoNotProcessedRepository;
	
	
	@Override
	@Transactional("secondaryTransactionManager")
	public void inserisciTutti(List<AssicuratoNotProcessed> listaDiAssicuratiInvalidi) {
		// STEP 3
		// carico sul nuovo DB tutti i record di assicurato
		for (AssicuratoNotProcessed assicuratoItem : listaDiAssicuratiInvalidi) {
			assicuratoNotProcessedRepository.save(assicuratoItem);
		}
		
	}
}
