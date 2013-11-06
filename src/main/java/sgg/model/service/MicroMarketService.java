/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgg.model.service;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import sgg.model.MicroMarket;

/**
 *
 * @author franqlin
 */
public class MicroMarketService {
    protected EntityManager em;

    public MicroMarketService(EntityManager em) {
        this.em = em;
    }
    
    public MicroMarket create(){
        return null;
    }
    public void remove(String zipcode){
        
    }
    
    public MicroMarket find(String zipcode){
        return em.find(MicroMarket.class, zipcode);
    }
    public Collection<MicroMarket>findAll(){
        Query query = em.createQuery("SELECT m FROM MicroMarket m");
        return(Collection<MicroMarket> )query.getResultList();
    }
    
}
