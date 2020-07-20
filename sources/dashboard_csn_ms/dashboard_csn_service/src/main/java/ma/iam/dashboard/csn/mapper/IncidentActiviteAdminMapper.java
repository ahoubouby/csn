package ma.iam.dashboard.csn.mapper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import ma.iam.dashboard.csn.dtos.IncidentActiviteAdminDto;
import ma.iam.dashboard.csn.utils.DateUtils;
/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
@Service
public class IncidentActiviteAdminMapper extends BaseMapper {
	
	public IncidentActiviteAdminDto toDto(Object[] domain) throws ParseException{
		IncidentActiviteAdminDto dto = null;
		if(domain != null){
			dto = new IncidentActiviteAdminDto();
			Date dt = DateUtils.stringToDate(readDomain(domain[0]).substring(0, 10), "yyyy-MM-dd");
			dto.setJour(DateUtils.dateToString(dt));
			dto.setActivite(readDomain(domain[1]));
			dto.setNombre(Integer.valueOf(readDomain(domain[2])));	
			dto.setCommentaire(readDomain(domain[3]));
			return dto;
		}
		return null;
	} 
	
    public List <IncidentActiviteAdminDto> toDtos(List<Object[]> domains) throws ParseException{
    	List<IncidentActiviteAdminDto> dtos = null;
    	if(domains != null && domains.size() > 0){
    		dtos = new ArrayList<IncidentActiviteAdminDto>();
        	for(Object[] domain : domains){
        		dtos.add(toDto(domain));
        	}
    		return dtos;
    	}
		return null;		
	}

}
