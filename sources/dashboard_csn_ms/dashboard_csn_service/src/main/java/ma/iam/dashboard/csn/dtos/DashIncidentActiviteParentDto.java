package ma.iam.dashboard.csn.dtos;

import java.util.List;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
public class DashIncidentActiviteParentDto {
	private String name;
	private List<DashIncidentActiviteChildDto> value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<DashIncidentActiviteChildDto> getValue() {
		return value;
	}
	public void setValue(List<DashIncidentActiviteChildDto> value) {
		this.value = value;
	}
}
