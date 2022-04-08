package it.prova.migrazione.old_schema.service;

import java.util.List;
import it.prova.migrazione.old_schema.dto.AnagraficaCountDTO;

public interface AnagraficaService {

	public List<AnagraficaCountDTO> trovaTuttiEager();
}
