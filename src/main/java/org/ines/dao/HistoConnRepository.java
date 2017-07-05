package org.ines.dao;

import org.ines.entities.HistoConnection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoConnRepository extends JpaRepository<HistoConnection, Long>{
	
	
}
