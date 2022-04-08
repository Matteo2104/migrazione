package it.prova.migrazione.new_schema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.prova.migrazione.new_schema.model.AssicuratoNotProcessed;

public interface AssicuratoNotProcessedRepository extends JpaRepository<AssicuratoNotProcessed, Long> {

}
