package io.programeday.service;

import io.programeday.modelo.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Pedro Zacarias
 */
@Stateless
public class ServicoCliente {

    @PersistenceContext
    EntityManager em;
   
    public void savar(Cliente cliente){
        em.persist(cliente);
    }
    
    public List<Cliente> findClientes(){
        String jpql = "select c from Cliente c";
        
        Query query = em.createQuery(jpql);
        
        return query.getResultList();
    }
    
    public Cliente find(Long id){
        return em.find(Cliente.class, id);
    }
}
