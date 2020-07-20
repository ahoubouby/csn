package ma.iam.dashboard.csn.job.job.services;

import ma.iam.dashboard.csn.job.job.services.interfaces.IDashboardCsnService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author K.ELBAGUARI
 *
 */
@Service
public class JobService {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired IDashboardCsnService service;
	
    public void executeJob() {
    	
        logger.info("Debut lancement des requetes de chargement de donnees ...");
        // System.out.println("Debut lancement des requete de de chargement de donnses ...");
        try {
        	//appel service
        	service.loadData();
        } finally {
            logger.info("Fin d\'execution des requetes de chargement de donnees");
            // System.out.println("Fin d\'execution des requetes de chargement de donnees");
        }
    }
}
