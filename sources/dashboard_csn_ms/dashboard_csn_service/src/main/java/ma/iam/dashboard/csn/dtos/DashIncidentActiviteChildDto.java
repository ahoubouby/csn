package ma.iam.dashboard.csn.dtos;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
public class DashIncidentActiviteChildDto {
	private String day;
	private DashIncidentActiviteValueDto value;
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public DashIncidentActiviteValueDto getValue() {
		return value;
	}
	public void setValue(DashIncidentActiviteValueDto value) {
		this.value = value;
	}

	
}
