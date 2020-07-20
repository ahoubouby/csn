package ma.iam.dashboard.csn.exception;

/**
 * 
 * @author  K.ELBAGUARI && O.SLAAOUITER
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
