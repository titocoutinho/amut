package desenv.util.banco;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory manager ; 
	private JpaUtil() {
		
	}
	
	static{
		manager = Persistence.createEntityManagerFactory("site_PU");
		
	}

	public static EntityManager getManager() {
		
		try{
		if(manager == null){
			manager = Persistence.createEntityManagerFactory("site_PU");
		}
		return manager.createEntityManager();
		} catch (Exception e){
			return Persistence.createEntityManagerFactory("site_PU").createEntityManager();
		}
		
	}

}

/**
if (emf == null) {  
emf = Persistence.createEntityManagerFactory("default");  
}  
return emf.createEntityManager();  
*/