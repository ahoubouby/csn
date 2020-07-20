package ma.iam.dashboard.csn.mapper;

public class BaseMapper {

	protected String readDomain(Object domain) {
		return domain != null ? domain.toString() : "";
	}
}
