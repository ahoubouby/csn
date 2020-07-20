package ma.iam.dashboard.csn.dtos;

import java.util.List;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
public class DashIncidentNameParentDto {
	private String day;
	private List<DashIncidentNameChildDto> value;
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public List<DashIncidentNameChildDto> getValue() {
		return value;
	}
	public void setValue(List<DashIncidentNameChildDto> value) {
		this.value = value;
	}
	
}
