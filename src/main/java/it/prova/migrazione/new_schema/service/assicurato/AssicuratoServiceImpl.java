package it.prova.migrazione.new_schema.service.assicurato;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.prova.migrazione.new_schema.model.Assicurato;
import it.prova.migrazione.new_schema.repository.AssicuratoRepository;

@Service
public class AssicuratoServiceImpl implements AssicuratoService {
	@Autowired
	private AssicuratoRepository assicuratoRepository;
	
	@Override
	@Transactional("secondaryTransactionManager")
	public void inserisciTutti(List<Assicurato> listaDiAssicurati) {
		// STEP 3
		// carico sul nuovo DB tutti i record di assicurato
		for (Assicurato assicuratoItem : listaDiAssicurati) {
			assicuratoRepository.save(assicuratoItem);
		}
		
	}
}
