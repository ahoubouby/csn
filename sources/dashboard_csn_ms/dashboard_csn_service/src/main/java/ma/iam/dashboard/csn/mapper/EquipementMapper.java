package ma.iam.dashboard.csn.mapper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import ma.iam.dashboard.csn.dtos.EquipementDto;
import ma.iam.dashboard.csn.dtos.SyntheseDto;
import ma.iam.dashboard.csn.utils.DateUtils;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */

@Service
public class EquipementMapper extends BaseMapper {

	public EquipementDto toDto(Object[] domain) throws ParseException{
		EquipementDto dto = null;
		if(domain != null){
			dto = new EquipementDto();
			dto.setDescription(readDomain(domain[0]));
			if(domain[1] != null) {
				dto.setLatitude(readDomain(domain[1]).replace(",", "."));
			}
			if(domain[2] != null) {
				dto.setLongitude(readDomain(domain[2]).replace(",", "."));
			}
			if(domain[3] != null) {
				Date dt = DateUtils.stringToDate(readDomain(domain[3]).substring(0, 10), "yyyy-MM-dd");
				dto.setDatedebut(DateUtils.dateToString(dt));
			}
			dto.setSymptome(readDomain(domain[4]));
			dto.setInfrastructure(readDomain(domain[5]));
			dto.setDr(readDomain(domain[6]));
			dto.setIdDr(readDomain(domain[7]));
			dto.setDc(readDomain(domain[8]));
			dto.setIdDc(readDomain(domain[9]));
			dto.setCategorie(readDomain(domain[10]));
			dto.setFournisseur(readDomain(domain[11]));
			dto.setIdFournisseur(readDomain(domain[12]));
			return dto;
		}
		return null;
	} 
	
    public List <EquipementDto> toDtos(List<Object[]> domains) throws ParseException{
    	List<EquipementDto> dtos = null;
    	if(domains != null && domains.size() > 0){
    		dtos = new ArrayList<EquipementDto>();
        	for(Object[] domain : domains){
        		dtos.add(toDto(domain));
        	}
    		return dtos;
    	}
		return null;		
	}
    
    public SyntheseDto toSyntheseDto(Object[] domain) {
    	SyntheseDto dto = null;
		if(domain != null){
			dto = new SyntheseDto();
			dto.setLabel(readDomain(domain[0]));
			dto.setNombre(readDomain(domain[1]));
			return dto;
		}
		return null;
	} 
	
    public List <SyntheseDto> toSyntheseDtos(List<Object[]> domains) {
    	List<SyntheseDto> dtos = null;
    	if(domains != null && domains.size() > 0){
    		dtos = new ArrayList<SyntheseDto>();
        	for(Object[] domain : domains){
        		dtos.add(toSyntheseDto(domain));
        	}
    		return dtos;
    	}
		return null;		
	}
    
}
