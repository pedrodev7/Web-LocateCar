package br.com.ada.locatecar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ada.locatecar.model.ClientePJ;
import br.com.ada.locatecar.repository.IClientePJRepository;

@Service
public class ClientePJService {
    @Autowired
    private IClientePJRepository clientePJRepository;


    public void adicionarCliente(ClientePJ cliente){
        this.clientePJRepository.save(cliente);
    }

    public List<ClientePJ> listarTodosOsClientesPJ(){
        return this.clientePJRepository.findAll();
    }

    public void removerCliente(ClientePJ cliente){
        this.clientePJRepository.delete(cliente);
    }

}
