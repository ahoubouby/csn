package ma.iam.dashboard.csn.mapper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ma.iam.dashboard.csn.dtos.DrDto;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */

@Service
public class DrMapper extends BaseMapper {

	public DrDto toDto(Object[] domain) throws ParseException{
		DrDto dto = null;
		if(domain != null){
			dto = new DrDto();
			dto.setIdt(Long.parseLong(readDomain(domain[0])));
			dto.setLabel(readDomain(domain[1]));
			return dto;
		}
		return null;
	} 
	
    public List<DrDto> toDtos(List<Object[]> domains) throws ParseException{
    	List<DrDto> dtos = null;
    	if(domains != null && domains.size() > 0){
    		dtos = new ArrayList<DrDto>();
        	for(Object[] domain : domains){
        		dtos.add(toDto(domain));
        	}
    		return dtos;
    	}
		return null;		
	}
    
}
