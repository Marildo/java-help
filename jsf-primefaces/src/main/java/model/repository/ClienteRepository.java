package model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.ClienteModel;


@Repository
public interface ClienteRepository  extends JpaRepository<ClienteModel,Integer> {
	
}
