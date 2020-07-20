package ma.iam.dashboard.csn.dtos;

/**
 * 
 * @author  K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
public class UtilisateurDto {

	private Long idt;
	
	private String login;

	private String nom;

	private String prenom;

	private String matricule;

	private String email;

	private String dr;

	private String dc;

	private Long idtDr;

	private Long idtDc;

	private String entite;

	private Boolean modification;

	public Long getIdt() {
		return idt;
	}

	public void setIdt(Long idt) {
		this.idt = idt;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDr() {
		return dr;
	}

	public void setDr(String dr) {
		this.dr = dr;
	}

	public String getDc() {
		return dc;
	}

	public void setDc(String dc) {
		this.dc = dc;
	}

	public Long getIdtDr() {
		return idtDr;
	}

	public void setIdtDr(Long idtDr) {
		this.idtDr = idtDr;
	}

	public Long getIdtDc() {
		return idtDc;
	}

	public void setIdtDc(Long idtDc) {
		this.idtDc = idtDc;
	}

	public String getEntite() {
		return entite;
	}

	public void setEntite(String entite) {
		this.entite = entite;
	}

	public Boolean getModification() {
		return modification;
	}

	public void setModification(Boolean modification) {
		this.modification = modification;
	}

}
