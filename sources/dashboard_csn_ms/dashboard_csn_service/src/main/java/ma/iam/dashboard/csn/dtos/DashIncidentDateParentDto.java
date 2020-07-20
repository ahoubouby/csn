package ma.iam.dashboard.csn.dtos;

import java.util.List;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
public class DashIncidentDateParentDto {
	private String name;
	private List<DashIncidentChildDto> value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<DashIncidentChildDto> getValue() {
		return value;
	}
	public void setValue(List<DashIncidentChildDto> value) {
		this.value = value;
	}
}
