package br.com.ada.locatecar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ada.locatecar.model.ClientePJ;
import br.com.ada.locatecar.service.ClientePJService;

@RestController
@RequestMapping("/clientepj")
public class ClientePJController {
    
    @Autowired
    private ClientePJService clientePJService;

    @PostMapping("/add")
    public void adicionarCliente(@RequestBody ClientePJ cliente){
        this.clientePJService.adicionarCliente(cliente);
    }

    @DeleteMapping("/remove/{id}")
    public void removerCliente(@PathVariable Long id){
        this.clientePJService.removerCliente(id);
    }

    @GetMapping("/todos")
    public List<ClientePJ> listarTodosOsClientesPJ(){
        return this.clientePJService.listarTodosOsClientesPJ();
    }
}
