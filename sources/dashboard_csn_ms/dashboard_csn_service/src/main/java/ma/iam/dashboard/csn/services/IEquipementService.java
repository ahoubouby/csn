package ma.iam.dashboard.csn.services;

import java.util.List;

import ma.iam.dashboard.csn.dtos.EquipementDto;
import ma.iam.dashboard.csn.dtos.SyntheseDto;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
public interface IEquipementService {
		
	List<EquipementDto> getListEquipementsByParams(String dr, String dc, String fournisseur, String typeEquipement, String technologie);

	List<SyntheseDto> getTabSyntheseEquipement(String typeEquipement);
}
