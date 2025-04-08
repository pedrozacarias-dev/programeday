package io.programeday.managers;

import io.programeday.modelo.Cliente;
import io.programeday.service.ServicoCliente;
import io.programeday.utilitario.Mensagem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Pedro Zacarias
 */
@Named
@ViewScoped
public class ManagerCliente implements Serializable {

    @EJB
    ServicoCliente servicoCliente;

    Cliente cliente;
    List<Cliente> clientes;

    @PostConstruct
    public void instanciar() {
        cliente = new Cliente();
        clientes = new ArrayList<>();
        carregarParametro();
    }

    /**
     * Usado para salvar varios clientes na lista do datatabel*
     */
    public void adicionarvarios() {
        if (cliente.getNome().isEmpty() || cliente.getContato().isEmpty()) {
            Mensagem.mensagemAlerta("Campos Nome e Contato são obrigatórios!");
        } else {
            clientes.add(cliente);
            cliente = new Cliente();
        }

    }

    /**
     * Usado para adicionar varios clientes na lista do datatabel*
     */
    public void adicionar() {
        if (cliente.getNome().isEmpty() || cliente.getContato().isEmpty()) {
            Mensagem.mensagemAlerta("Campos Nome e Contato são obrigatórios!");
        } else {
            clientes.add(cliente);
            cliente = new Cliente();
        }

    }

    /**
     * Usado para salvar varios clientes na lista do datatabel*
     */
    public void salvar() {
        if (clientes.isEmpty()) {
            Mensagem.mensagemAlerta("Adicionar Cliente!");
        } else {
            for (Cliente c : clientes) {
                servicoCliente.savar(c);
            }
            Mensagem.mensagemInformacao("Operação realizada com sucesso!");
            instanciar();
        }
    }

    /**
     * Usado para salvar clientes individual
     */
    public void salvar2() {
        if (cliente.getNome().isEmpty() || cliente.getContato().isEmpty()) {
            Mensagem.mensagemAlerta("Campo Nome e Contato são OBRIGATÓRIOS!");
        } else {
            servicoCliente.savar(cliente);
            Mensagem.mensagemInformacao("Operação realizada com sucesso!");
            instanciar();
        }

    }

    public void carregarParametro(){
        Map<String, String> parametro = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String visualizar = parametro.get("visualizar");
        
        if(visualizar != null){
            cliente = servicoCliente.find(Long.valueOf(visualizar));
        }
    }
    
    public void pesquisar() {
        clientes = servicoCliente.findClientes();
    }

    public ServicoCliente getServicoCliente() {
        return servicoCliente;
    }

    public void setServicoCliente(ServicoCliente servicoCliente) {
        this.servicoCliente = servicoCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

}
