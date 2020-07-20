package ma.iam.dashboard.csn.dtos;

/**
 * 
 * @author  K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
public class ReportingDto {

	private Long idt;
	private String dr;
	private String dc;
	private String adresse;
	private String titre;
	private String latitude;
	private String longitude;
	private String infos;
	private String type;
	private String chambre;
	private String chambreLatitude;
	private String chambreLongitude;	
	private String equipementRattachement;
	private String statut;
	private String fournisseur;
	private String infrastructure;
	
	public Long getIdt() {
		return idt;
	}
	public void setIdt(Long idt) {
		this.idt = idt;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getInfos() {
		return infos;
	}
	public void setInfos(String infos) {
		this.infos = infos;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getChambre() {
		return chambre;
	}
	public void setChambre(String chambre) {
		this.chambre = chambre;
	}
	public String getChambreLatitude() {
		return chambreLatitude;
	}
	public void setChambreLatitude(String chambreLatitude) {
		this.chambreLatitude = chambreLatitude;
	}
	public String getChambreLongitude() {
		return chambreLongitude;
	}
	public void setChambreLongitude(String chambreLongitude) {
		this.chambreLongitude = chambreLongitude;
	}
	public String getEquipementRattachement() {
		return equipementRattachement;
	}
	public void setEquipementRattachement(String equipementRattachement) {
		this.equipementRattachement = equipementRattachement;
	}
	
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}
	public String getInfrastructure() {
		return infrastructure;
	}
	public void setInfrastructure(String infrastructure) {
		this.infrastructure = infrastructure;
	}
	
	
}
