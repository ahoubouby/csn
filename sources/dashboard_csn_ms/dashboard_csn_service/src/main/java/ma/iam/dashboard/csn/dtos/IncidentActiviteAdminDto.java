package ma.iam.dashboard.csn.dtos;

/**
 * 
 * @author  K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
public class IncidentActiviteAdminDto {
	private String jour;
	private String activite;
	private Integer nombre;
	private String commentaire;
	
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public String getActivite() {
		return activite;
	}
	public void setActivite(String activite) {
		this.activite = activite;
	}
	public Integer getNombre() {
		return nombre;
	}
	public void setNombre(Integer nombre) {
		this.nombre = nombre;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

}
