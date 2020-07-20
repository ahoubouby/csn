package ma.iam.dashboard.csn.mapper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ma.iam.dashboard.csn.dtos.FournisseurDto;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */

@Service
public class FournisseurMapper extends BaseMapper {

	public FournisseurDto toDto(Object[] domain) throws ParseException{
		FournisseurDto dto = null;
		if(domain != null){
			dto = new FournisseurDto();
			 dto.setIdt(Long.parseLong(readDomain(domain[0])));
			if(domain[1] != null) {
				dto.setLabel(readDomain(domain[1]));
			}
			return dto;
		}
		return null;
	} 
	
    public List <FournisseurDto> toDtos(List<Object[]> domains) throws ParseException{
    	List<FournisseurDto> dtos = null;
    	if(domains != null && domains.size() > 0){
    		dtos = new ArrayList<FournisseurDto>();
        	for(Object[] domain : domains){
        		dtos.add(toDto(domain));
        	}
    		return dtos;
    	}
		return null;		
	}
    
}
