package ma.iam.dashboard.csn.dtos;

import java.util.List;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
public class DashboardIncidentDateDto {
	private String name;
	private List<DashboardIncidentTraiteDto> value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<DashboardIncidentTraiteDto> getValue() {
		return value;
	}
	public void setValue(List<DashboardIncidentTraiteDto> value) {
		this.value = value;
	}
	
}
