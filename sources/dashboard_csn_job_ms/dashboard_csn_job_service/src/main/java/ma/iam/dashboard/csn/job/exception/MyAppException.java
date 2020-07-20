package ma.iam.dashboard.csn.job.exception;

/**
 * 
 * @author K.ELBAGUARI
 *
 */
public class MyAppException extends ExceptionGeneric{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7352236534101826975L;

	public MyAppException(IErrorCode code, String message) {
		super(code,message);
	}
    
	public MyAppException(IErrorCode code, String message,Throwable cause) {
		super(code,message,cause);
	}

	@Override
	public IErrorCode getErrorCode() {		
		return null;
	}
}
