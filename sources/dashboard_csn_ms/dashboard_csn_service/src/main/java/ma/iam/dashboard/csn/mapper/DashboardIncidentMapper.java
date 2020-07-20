package ma.iam.dashboard.csn.mapper;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ma.iam.dashboard.csn.dtos.CumulDetailDto;
import ma.iam.dashboard.csn.dtos.DashIncidentActiviteChildDto;
import ma.iam.dashboard.csn.dtos.DashIncidentActiviteParentDto;
import ma.iam.dashboard.csn.dtos.DashIncidentActiviteValueDto;
import ma.iam.dashboard.csn.dtos.DashIncidentChildDto;
import ma.iam.dashboard.csn.dtos.DashIncidentCiEtatJourParHeureChildDto;
import ma.iam.dashboard.csn.dtos.DashIncidentCiEtatJourParHeureParentDto;
import ma.iam.dashboard.csn.dtos.DashIncidentCiEtatSemaineParJourChildDto;
import ma.iam.dashboard.csn.dtos.DashIncidentCiEtatSemaineParJourParentDto;
import ma.iam.dashboard.csn.dtos.DashIncidentDateParentDto;
import ma.iam.dashboard.csn.dtos.DashIncidentNameChildDto;
import ma.iam.dashboard.csn.dtos.DashIncidentNameParentDto;
import ma.iam.dashboard.csn.dtos.DashbIncidentOuvertFermeDto;
import ma.iam.dashboard.csn.dtos.DashboardIncidentDateDto;
import ma.iam.dashboard.csn.dtos.DashboardIncidentEnCoursDto;
import ma.iam.dashboard.csn.dtos.DashboardIncidentTraiteDto;
import ma.iam.dashboard.csn.utils.DateUtils;

import org.springframework.stereotype.Service;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */

@Service
public class DashboardIncidentMapper extends BaseMapper {

	private LocalDate getDateDebutSemaine() {
		return getDateFinSemaine().minusDays(7);
	}

	private LocalDate getDateFinSemaine() {
		return LocalDate.now();
	}
	
	public DashboardIncidentTraiteDto toIncidentTraiteDto(Object[] domain) throws ParseException{
		DashboardIncidentTraiteDto dto = null;
		if(domain != null){
			dto = new DashboardIncidentTraiteDto();
			Date dt = DateUtils.stringToDate(readDomain(domain[0]).substring(0, 10), "yyyy-MM-dd");
			dto.setDay(DateUtils.dateToString(dt));
			dto.setValue(Integer.valueOf(readDomain(domain[2])));			
			return dto;
		}
		return null;
	} 
	
    public List <DashboardIncidentTraiteDto> toIncidentTraiteDtos(List<Object[]> domains) throws ParseException{
    	List<DashboardIncidentTraiteDto> dtos = null;
    	if(domains != null && domains.size() > 0){
    		dtos = new ArrayList<DashboardIncidentTraiteDto>();
        	for(Object[] domain : domains){
        		dtos.add(toIncidentTraiteDto(domain));
        	}
    		return dtos;
    	}
		return null;		
	}
    
	public DashboardIncidentEnCoursDto toCiDerangementDto(Object[] domain){
		DashboardIncidentEnCoursDto dto = null;
		if(domain != null){
			dto = new DashboardIncidentEnCoursDto();
			dto.setName(readDomain(domain[0]));
			dto.setValue(Integer.valueOf(readDomain(domain[1])));			
			return dto;
		}
		return null;
	} 
	
    public List <DashboardIncidentEnCoursDto> toCiDerangementDtos(List<Object[]> domains){
    	List<DashboardIncidentEnCoursDto> dtos = null;
    	if(domains != null && domains.size() > 0){
    		dtos = new ArrayList<DashboardIncidentEnCoursDto>();
        	for(Object[] domain : domains){
        		dtos.add(toCiDerangementDto(domain));
        	}
    		return dtos;
    	}
		return null;		
	}

    public List <DashboardIncidentDateDto> toIncidentsFermesDtos(List<Object[]> domains) throws ParseException{
     	List<DashboardIncidentDateDto> dtos = null;
    	if(domains != null && domains.size() > 0){
    		dtos = new ArrayList<DashboardIncidentDateDto>();
    		Map<String, Map<Date,Integer>> map = new HashMap<String, Map<Date,Integer>>();
        	for(Object[] domain : domains){
        		if(domain != null){
        			String name = readDomain(domain[1]);
        			Map<Date,Integer> traiteDtos  = map.get(name);
        			if(traiteDtos == null) {
        				traiteDtos = new HashMap<Date,Integer>();
        			}
            		Date dt = null;
            		if(readDomain(domain[0]).length() > 9){
            			dt = DateUtils.stringToDate(readDomain(domain[0]).substring(0, 10), "yyyy-MM-dd");
            			
            		}else{
            			dt = DateUtils.stringToDate(readDomain(domain[0]));
            		}
        			Integer v = Integer.valueOf(readDomain(domain[2]));	
        			traiteDtos.put(dt, v);
        			map.put(name, traiteDtos);
        		}
        	}

        	LocalDate startDate = getDateDebutSemaine();
        	LocalDate endDate = getDateFinSemaine();
        	
        	for (Map.Entry<String,  Map<Date,Integer>> entry : map.entrySet()) {

    			List<DashboardIncidentTraiteDto> traiteDtos = new ArrayList<DashboardIncidentTraiteDto>();
        		for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1))
            	{
        			Date dt = DateUtils.convertToDateViaSqlDate(date); 
        			Integer v = entry.getValue().get(dt);
        			if(v == null) {
        				v = 0;
        			}
        			DashboardIncidentTraiteDto traiteDto = new DashboardIncidentTraiteDto();
        			String day = DateUtils.dateToString(dt);
        			traiteDto.setDay(day);
        			traiteDto.setValue(v);
        			traiteDtos.add(traiteDto);
            	}
    		    DashboardIncidentDateDto dateDto = new DashboardIncidentDateDto();
    		    dateDto.setName(entry.getKey());
    		    dateDto.setValue(traiteDtos);
        		dtos.add(dateDto);
    		}
    		return dtos;
    	}
		return null;
	}
    
    public List <DashIncidentCiEtatSemaineParJourParentDto> toIncidentsCiEtatSemaineParJourDtos(List<Object[]> domains) throws ParseException{
    	List<DashIncidentCiEtatSemaineParJourParentDto> dtos = null;
    	if(domains != null && domains.size() > 0){
    		dtos = new ArrayList<DashIncidentCiEtatSemaineParJourParentDto>();
    		Map<String, Map<Date, Integer>> mapParent =new HashMap<String, Map<Date,Integer>>();
        	for(Object[] domain : domains){
        		String name = readDomain(domain[1]);
        		Map<Date, Integer> mapChild = mapParent.get(name);
        		if(mapChild == null) {
        			mapChild = new HashMap<Date, Integer>();
        		}
        		Date day = null;
        		if(readDomain(domain[0]).length() > 9){
        			day = DateUtils.stringToDate(readDomain(domain[0]).substring(0, 10), "yyyy-MM-dd");
        			
        		}else{
        			day = DateUtils.stringToDate(readDomain(domain[0]));
        		}
        		Integer value = Integer.valueOf(readDomain(domain[2]));
        		
        		mapChild.put(day, value);
        		
        		mapParent.put(name, mapChild);
        		
        	}
        	
        	//Remplir valeur par 0 si un jour de la semaine existe mais ne contient pas de valeur
        	LocalDate startDate = getDateDebutSemaine();
        	LocalDate endDate = getDateFinSemaine();
        	
        	for(Map.Entry<String, Map<Date, Integer>> mapEntry : mapParent.entrySet()) {
        		List<DashIncidentCiEtatSemaineParJourChildDto> childDtos = new ArrayList<DashIncidentCiEtatSemaineParJourChildDto>();
        		for(LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)){
        			Date day = DateUtils.convertToDateViaSqlDate(date);
        			Integer value = mapEntry.getValue().get(day);
        			if(value == null) {
        				value = 0;
        			}
        			DashIncidentCiEtatSemaineParJourChildDto childDto = new DashIncidentCiEtatSemaineParJourChildDto();
        			String dayS = DateUtils.dateToString(day);
        			childDto.setDay(dayS);
        			childDto.setValue(value);
        			childDtos.add(childDto);        			
        		}
        		
        		DashIncidentCiEtatSemaineParJourParentDto parentDto = new DashIncidentCiEtatSemaineParJourParentDto();
        		parentDto.setName(mapEntry.getKey());
        		parentDto.setValue(childDtos);
        		dtos.add(parentDto);        		
        	}
        	
    		return dtos;
    	}
		return null;	
	}
    
    public List <DashIncidentCiEtatJourParHeureParentDto> incidentsCiEtatJourParHeure(List<Object[]> domains) throws ParseException{
    	List<DashIncidentCiEtatJourParHeureParentDto> dtos = null;
    	if(domains != null && domains.size() > 0){
    		dtos = new ArrayList<DashIncidentCiEtatJourParHeureParentDto>();
    		Map<String, Map<Integer, Integer>> mapParent =new HashMap<String, Map<Integer,Integer>>();
    		Set<Integer> hours = new HashSet<Integer>();
        	for(Object[] domain : domains){
        		String name = readDomain(domain[1]);
        		Map<Integer, Integer> mapChild = mapParent.get(name);
        		if(mapChild == null) {
        			mapChild = new HashMap<Integer, Integer>();
        		}
        		Integer hour = null;
        		if(readDomain(domain[0]).length() > 10){        			
        			hour = Integer.valueOf(readDomain(domain[0]).substring(11, 13));
        			hours.add(hour);
        			
        		}
        		Integer value = Integer.valueOf(readDomain(domain[2]));
        		
        		mapChild.put(hour, value);
        		
        		mapParent.put(name, mapChild);
        		
        	}
        	
        	//Remplir valeur par 0 si une heure de la journée existe mais ne contient pas de valeur      	
        	for(Map.Entry<String, Map<Integer, Integer>> mapEntry : mapParent.entrySet()) {
        		List<DashIncidentCiEtatJourParHeureChildDto> childDtos = new ArrayList<DashIncidentCiEtatJourParHeureChildDto>();
        		for(Integer hour: hours){        			
        			Integer value = mapEntry.getValue().get(hour);
        			if(value == null) {
        				value = 0;
        			}
        			DashIncidentCiEtatJourParHeureChildDto childDto = new DashIncidentCiEtatJourParHeureChildDto();        			
        			childDto.setHour(hour);
        			childDto.setValue(value);
        			childDtos.add(childDto);        			
        		}
        		
        		DashIncidentCiEtatJourParHeureParentDto parentDto = new DashIncidentCiEtatJourParHeureParentDto();
        		parentDto.setName(mapEntry.getKey());
        		parentDto.setValue(childDtos);
        		dtos.add(parentDto);        		
        	}
        	
    		return dtos;
    	}
		return null;	
	}
    
    public List <DashIncidentNameParentDto> toIncidentsNameDtos(List<Object[]> domains) throws ParseException{
     	List<DashIncidentNameParentDto> dtos = null;
    	if(domains != null && domains.size() > 0){
    		dtos = new ArrayList<DashIncidentNameParentDto>();
    		Map<String, Map<Date,Integer>> mapParent = new HashMap<String, Map<Date,Integer>>();
        	for(Object[] domain : domains){
        		if(domain != null){
        			String name = readDomain(domain[1]);
        			Map<Date,Integer> mapChild  = mapParent.get(name);
        			if(mapChild == null) {
        				mapChild = new HashMap<Date,Integer>();
        			}
            		Date dt = null;
            		if(readDomain(domain[0]).length() > 9){
            			dt = DateUtils.stringToDate(readDomain(domain[0]).substring(0, 10), "yyyy-MM-dd");
            			
            		}else{
            			dt = DateUtils.stringToDate(readDomain(domain[0]));
            		}
        			Integer v = Integer.valueOf(readDomain(domain[2]));	
        			mapChild.put(dt, v);
        			mapParent.put(name, mapChild);
        		}
        	}
        	LocalDate startDate = getDateDebutSemaine();
        	LocalDate endDate = getDateFinSemaine();
        	

    		for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
    			Date dt = DateUtils.convertToDateViaSqlDate(date); 
    			DashIncidentNameParentDto dateDto = new DashIncidentNameParentDto();
    			String day = DateUtils.dateToString(dt);
    		    dateDto.setDay(day);
    		    dateDto.setValue(new ArrayList<DashIncidentNameChildDto>());
        		dtos.add(dateDto);
    		}
        	
        	for (Map.Entry<String,  Map<Date,Integer>> entry : mapParent.entrySet()) {

    			int i = 0;
        		for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1))
            	{
        			List<DashIncidentNameChildDto> childDtos = dtos.get(i++).getValue(); // new ArrayList<DashIncidentNameChildDto>();
        			Date dt = DateUtils.convertToDateViaSqlDate(date); 
        			Integer v = entry.getValue().get(dt);
        			if(v == null) {
        				v = 0;
        			}
        			DashIncidentNameChildDto childDto = new DashIncidentNameChildDto();
        			childDto.setName(entry.getKey());
        			childDto.setValue(v);
        			childDtos.add(childDto);
            	}
    		}
    		return dtos;
    	}
		return null;
	}
    
	public DashbIncidentOuvertFermeDto toIncidentsOuvertFermeEnNombre(Object[] domain){
		DashbIncidentOuvertFermeDto dto = null;
		if(domain != null){
			dto = new DashbIncidentOuvertFermeDto();
			dto.setName(readDomain(domain[0]));
			dto.setValue(Integer.valueOf(readDomain(domain[1])));			
			return dto;
		}
		return null;
	}
	
    public List <DashbIncidentOuvertFermeDto> toIncidentsOuvertFermeEnNombreDtos(List<Object[]> domains){
    	List<DashbIncidentOuvertFermeDto> dtos = null;
    	if(domains != null && domains.size() > 0){
    		dtos = new ArrayList<DashbIncidentOuvertFermeDto>();
        	for(Object[] domain : domains){
        		dtos.add(toIncidentsOuvertFermeEnNombre(domain));
        	}
    		return dtos;
    	}
		return null;		
	}
    

    
    public List <DashIncidentDateParentDto> toIncidentsDateDtos(List<Object[]> domains) throws ParseException {
     	List<DashIncidentDateParentDto> dtos = null;
    	if(domains != null && domains.size() > 0){
    		dtos = new ArrayList<DashIncidentDateParentDto>();
    		Map<String, Map<Date,Integer>> mapParent = new HashMap<String, Map<Date,Integer>>();
        	for(Object[] domain : domains){
        		if(domain != null){
        			String name = readDomain(domain[1]);
        			Map<Date,Integer> mapChild  = mapParent.get(name);
        			if(mapChild == null) {
        				mapChild = new HashMap<Date,Integer>();
        			}
            		Date dt = null;
            		if(readDomain(domain[0]).length() > 9){
            			dt = DateUtils.stringToDate(readDomain(domain[0]).substring(0, 10), "yyyy-MM-dd");
            			
            		}else{
            			dt = DateUtils.stringToDate(readDomain(domain[0]));
            		}
        			Integer v = Integer.valueOf(readDomain(domain[2]));	
        			mapChild.put(dt, v);
        			mapParent.put(name, mapChild);
        		}
        	}
        	LocalDate startDate = getDateDebutSemaine();
        	LocalDate endDate = getDateFinSemaine();
        	
        	for (Map.Entry<String,  Map<Date,Integer>> entry : mapParent.entrySet()) {

    			List<DashIncidentChildDto> childDtos = new ArrayList<DashIncidentChildDto>();
        		for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1))
            	{
        			Date dt = DateUtils.convertToDateViaSqlDate(date); 
        			Integer v = entry.getValue().get(dt);
        			if(v == null) {
        				v = 0;
        			}
        			DashIncidentChildDto childDto = new DashIncidentChildDto();
        			String day = DateUtils.dateToString(dt);
        			childDto.setDay(day);
        			childDto.setValue(v);
        			childDtos.add(childDto);
            	}
    		    DashIncidentDateParentDto dateDto = new DashIncidentDateParentDto();
    		    dateDto.setName(entry.getKey());
    		    dateDto.setValue(childDtos);
        		dtos.add(dateDto);
    		}
    		return dtos;
    	}
		return null;
	}

	public CumulDetailDto toCumulDetailsDto(Object domain) throws ParseException{
		CumulDetailDto dto = null;
		if(domain != null){
			dto = new CumulDetailDto();
			if(domain.toString().length() > 9){
				Date dt = DateUtils.stringToDate(domain.toString().substring(0, 10), "yyyy-MM-dd");
				dto.setDay(DateUtils.dateToString(dt));
				String hour = "";
				if(domain.toString().length() > 10){        			
					hour = domain.toString().substring(11, 16);
					dto.setHour(hour);
				}			
				return dto;
			}
		}
		return null;
	} 
	
    public List <DashIncidentActiviteParentDto> toIncidentsActiviteDtos(List<Object[]> domains) throws ParseException {
     	List<DashIncidentActiviteParentDto> dtos = null;
    	if(domains != null && domains.size() > 0){
    		dtos = new ArrayList<DashIncidentActiviteParentDto>();
    		Map<String, Map<Date,DashIncidentActiviteValueDto>> mapParent = new HashMap<String, Map<Date,DashIncidentActiviteValueDto>>();
        	for(Object[] domain : domains){
        		if(domain != null){
        			String name = readDomain(domain[1]);
        			Map<Date,DashIncidentActiviteValueDto> mapChild  = mapParent.get(name);
        			if(mapChild == null) {
        				mapChild = new HashMap<Date,DashIncidentActiviteValueDto>();
        			}
            		Date dt = null;
            		if(readDomain(domain[0]).length() > 9){
            			dt = DateUtils.stringToDate(readDomain(domain[0]).substring(0, 10), "yyyy-MM-dd");
            			
            		}else{
            			dt = DateUtils.stringToDate(readDomain(domain[0]));
            		}
            		DashIncidentActiviteValueDto valueCommentDto = new DashIncidentActiviteValueDto();

        			valueCommentDto.setValue(Integer.valueOf(readDomain(domain[2])));
        			valueCommentDto.setComment(readDomain(domain[3]));
        			
        			mapChild.put(dt, valueCommentDto);
        			mapParent.put(name, mapChild);
        		}
        	}
        	LocalDate startDate = getDateDebutSemaine();
        	LocalDate endDate = getDateFinSemaine();
        	
        	for (Map.Entry<String,  Map<Date,DashIncidentActiviteValueDto>> entry : mapParent.entrySet()) {

    			List<DashIncidentActiviteChildDto> childDtos = new ArrayList<DashIncidentActiviteChildDto>();
        		for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1))
            	{
        			Date dt = DateUtils.convertToDateViaSqlDate(date); 
        			DashIncidentActiviteValueDto valueCommentDto = entry.getValue().get(dt);
        			if(valueCommentDto == null){
        				valueCommentDto = new DashIncidentActiviteValueDto();
            			valueCommentDto.setComment("");
            			valueCommentDto.setValue(0);
        			}
        			DashIncidentActiviteChildDto childDto = new DashIncidentActiviteChildDto();
        			String day = DateUtils.dateToString(dt);
        			childDto.setDay(day);
        			childDto.setValue(valueCommentDto);
        			childDtos.add(childDto);
            	}
    		    DashIncidentActiviteParentDto dateDto = new DashIncidentActiviteParentDto();
    		    dateDto.setName(entry.getKey());
    		    dateDto.setValue(childDtos);
        		dtos.add(dateDto);
    		}
    		return dtos;
    	}
		return null;
	}
}
