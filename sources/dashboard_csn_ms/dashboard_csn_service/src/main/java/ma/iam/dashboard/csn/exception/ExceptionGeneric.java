package ma.iam.dashboard.csn.exception;

/**
 * 
 * @author  K.ELBAGUARI && O.SLAAOUITER
 *
 */
public abstract  class ExceptionGeneric extends Exception implements IErrorCodeGeneric{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3111106304334126628L;
	private IErrorCode code;
	/**
	 * @return the code
	 */
	public IErrorCode getCode() {
		return code;
	}
	public String codeValue(){
		return this.code.value();
	}
	public ExceptionGeneric(IErrorCode code,String message) {
		super(message);
		this.code = code;
	}
	public ExceptionGeneric(IErrorCode code, String message, Throwable cause) {
		super(message,cause);
		this.code = code;
	}
	

}
