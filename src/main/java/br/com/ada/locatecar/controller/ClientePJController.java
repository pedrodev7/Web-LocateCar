package br.com.ada.locatecar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.ada.locatecar.model.ClientePJ;
import br.com.ada.locatecar.service.ClientePJService;
import jakarta.validation.Valid;

@Controller
public class ClientePJController {

    @Autowired
    private ClientePJService clientePJService;

    @GetMapping("/clientepj")
    public String clientespj(Model model) {
        List<ClientePJ> clientes = this.clientePJService.listarTodosOsClientesPJ();
        model.addAttribute("clientespj", clientes);
        return "clientepj";
    }

    @GetMapping("/clientepj/add")
    public String clienteAdd(Model model) {
        model.addAttribute("clientepj", new ClientePJ());
        return "clientepj-add";
    }

    @PostMapping("/clientepj/add")
    public String adicionarCliente(@Valid @ModelAttribute("clientepj") ClientePJ cliente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "clientepj-add";
        }

        try {
            this.clientePJService.adicionarCliente(cliente);
            return "redirect:/clientepj";
        } catch (Exception e) {
            model.addAttribute("erroCnpj", "Esse CNPJ já Existe!");
            return "clientepj-add";
        }

    }

    @GetMapping("/clientepj/{id}/delete")
    public String removerCliente(@PathVariable("id") Long id) {
        this.clientePJService.removerCliente(id);
        return "redirect:/clientepj";
    }

    @GetMapping("/clientepj/{id}/edit")
    public String mostrarEditarCliente(Model model, @PathVariable("id") Long id) {
        Optional<ClientePJ> optionalCliente = this.clientePJService.buscarClientePorId(id);

        optionalCliente.ifPresent(cliente -> model.addAttribute("clientepj", cliente));

        return "clientepj-edit";
    }

    @PostMapping("/clientepj/{id}/edit")
    public String editarCliente(@ModelAttribute("clientepj") ClientePJ cliente, @PathVariable("id") Long id) {
        cliente.setId(id);
        this.clientePJService.adicionarCliente(cliente);
        return "redirect:/clientepj";
    }

    @GetMapping("/clientepj/{id}/view")
    public String mostrarViewCliente(Model model, @PathVariable("id") Long id) {
        Optional<ClientePJ> optionalCliente = this.clientePJService.buscarClientePorId(id);
        optionalCliente.ifPresent(cliente -> model.addAttribute("clientepj", cliente));
        return "clientepj-view";
    }

}
