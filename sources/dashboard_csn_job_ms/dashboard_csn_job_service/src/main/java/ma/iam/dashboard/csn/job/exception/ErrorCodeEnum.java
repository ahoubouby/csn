package ma.iam.dashboard.csn.job.exception;

/**
 * 
 * @author K.ELBAGUARI
 *
 */
public enum ErrorCodeEnum implements IErrorCode{
	
	EQUIPMENT_ERR("10"),
	;
	
	private String code;
	
	private ErrorCodeEnum(String code){
		this.code=code;
	}
	
	@Override
	public String value() {
		return code;
	}
	
	
		

}
