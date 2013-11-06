package sgg;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import sgg.model.MicroMarket;
import sgg.model.service.MicroMarketService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sgg_CasoJPA_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        MicroMarketService service = new MicroMarketService(em);
        
        Collection<MicroMarket> mms = service.findAll();
        for(MicroMarket mm :mms){
            System.out.println("MicroMarket: "+mm+"\n");
        }
    }
}
