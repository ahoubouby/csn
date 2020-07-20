package ma.iam.dashboard.csn.mapper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ma.iam.dashboard.csn.dtos.DcDto;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */

@Service
public class DcMapper extends BaseMapper{

	public DcDto toDto(Object[] domain) throws ParseException{
		DcDto dto = null;
		if(domain != null){
			dto = new DcDto();
			dto.setIdt(Long.parseLong(readDomain(domain[0])));
			dto.setLabel(readDomain(domain[1]));
			return dto;
		}
		return null;
	} 
	
    public List <DcDto> toDtos(List<Object[]> domains) throws ParseException{
    	List<DcDto> dtos = null;
    	if(domains != null && domains.size() > 0){
    		dtos = new ArrayList<DcDto>();
        	for(Object[] domain : domains){
        		dtos.add(toDto(domain));
        	}
    		return dtos;
    	}
		return null;		
	}
    
}
