package it.prova.migrazione.new_schema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.prova.migrazione.new_schema.model.Assicurato;

public interface AssicuratoRepository extends JpaRepository<Assicurato, Long> {

}
