package ma.iam.dashboard.csn.dtos;

import java.util.List;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
public class DashIncidentCiEtatSemaineParJourParentDto {	
	private String name;
	private List<DashIncidentCiEtatSemaineParJourChildDto> value;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<DashIncidentCiEtatSemaineParJourChildDto> getValue() {
		return value;
	}
	public void setValue(List<DashIncidentCiEtatSemaineParJourChildDto> value) {
		this.value = value;
	}
	
}
