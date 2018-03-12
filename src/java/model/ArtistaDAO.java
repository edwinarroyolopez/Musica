/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Artista;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author zero
 */
@Service
public class ArtistaDAO {
    
    @PersistenceContext
    /* Sirve para ejecutar metodos creados por spring  */
    private EntityManager em;
    
    @Transactional(rollbackFor = {ServicioException.class})
    
    public void create(Artista dto) throws ServicioException{
        em.persist(dto);
        /*
            em.merge(dto); => Actualiza
            em.remove(dto); => Elimina
            
        */
    }
    
    public Artista readByNombre(String nombre) throws SecurityException{
        return em.find(Artista.class, nombre);
    }
    
    /* Otra forma de query JPQL (Consulta simple) */
    public Artista readByNombreJPQL(String nombre) throws SecurityException{
        String sql ="Select a from Artista a Where a.nombre = :nombre";
        Query q = em.createQuery(sql);
        q.setParameter("nombre", nombre);
        try{
            return (Artista)q.getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
    /*
        La entity cuando es creada, realmente le está haciendo un duplicado a la bd
        y todo lo que haga en la clase se verá reflejado en la bd: Concepto de persistencia
    */
    /* Consulta multiple */
    public List<Artista> readAllJPQL() throws SecurityException{
        String sql = "Select a from Artista a";
        Query q = em.createQuery(sql);
        
        return q.getResultList();
    }
    
    public boolean readByNombreJPQLCreate(String nombre) throws SecurityException{
        String sql = "Select a from Artista a where a.nombre = :nombre";
        
        Query q = em.createQuery(sql);
        q.setParameter("nombre", nombre);
        
        if(q.getResultList().size()>0){
            return true;
        }else{
            return false;
        }
        
    }
    
    public int createJPQL(Artista dto) throws SecurityException{
        
        if(readByNombreJPQLCreate(dto.getNombre())){
            return 0;
        }else{
            em.persist(dto);
            return 1;
        }
        
    }
    
}
