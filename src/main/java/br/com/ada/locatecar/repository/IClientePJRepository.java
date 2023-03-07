package br.com.ada.locatecar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ada.locatecar.model.ClientePJ;

public interface IClientePJRepository extends JpaRepository<ClientePJ, Long> {
    
}
