package ma.iam.dashboard.csn.dtos;

/**
 * 
 * @author  K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
public class InjectionMassErrorDto {
	private Integer lineNumber;
	private String errorMsg;
	private String valeur;

	public InjectionMassErrorDto() {
	}

	public Integer getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
}
