package it.prova.migrazione.new_schema.service.assicuratonotprocessed;

import java.util.List;

import it.prova.migrazione.new_schema.model.AssicuratoNotProcessed;

public interface AssicuratoNotProcessedService {

	public void inserisciTutti(List<AssicuratoNotProcessed> listaDiAssicuratiInvalidi);

}
