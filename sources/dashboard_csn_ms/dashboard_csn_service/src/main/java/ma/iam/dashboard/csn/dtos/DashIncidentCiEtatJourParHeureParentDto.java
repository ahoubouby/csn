package ma.iam.dashboard.csn.dtos;

import java.util.List;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
public class DashIncidentCiEtatJourParHeureParentDto {	
	private String name;
	private List<DashIncidentCiEtatJourParHeureChildDto> value;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<DashIncidentCiEtatJourParHeureChildDto> getValue() {
		return value;
	}
	public void setValue(List<DashIncidentCiEtatJourParHeureChildDto> value) {
		this.value = value;
	}
	
}
