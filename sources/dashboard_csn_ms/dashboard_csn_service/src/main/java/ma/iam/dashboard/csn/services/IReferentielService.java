package ma.iam.dashboard.csn.services;

import java.util.List;

import ma.iam.dashboard.csn.dtos.DcDto;
import ma.iam.dashboard.csn.dtos.DrDto;
import ma.iam.dashboard.csn.dtos.FournisseurDto;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
public interface IReferentielService {
	
	List<DrDto> getAllDr();

	List<DcDto> getAllDcByDr(Long idDr);
	
	List<FournisseurDto> getFournisseurs(String typeEquipement);
	
}
