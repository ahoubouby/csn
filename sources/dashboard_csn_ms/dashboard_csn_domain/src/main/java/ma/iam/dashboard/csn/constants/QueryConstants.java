package ma.iam.dashboard.csn.constants;

public abstract class QueryConstants {

	public static String REQ_INCIDENT_CUMUL_DETAILS = "Select execution from parametrage where requete='req1'";
	public static String REQ_INCIDENT_CUMUL = "Select * from req1";
	public static String REQ_INCIDENT_ETAT_SEMAINE = "Select * from req2";
	public static String REQ_INCIDENT_DIRECTION_OUVERT = "Select * from req3";
	public static String REQ_INCIDENT_DIRECTION_FERME = "Select * from req4";
	public static String REQ_INCIDENT_ACTIVITE_OUVERT = "Select * from req5";
	public static String REQ_INCIDENT_ACTIVITE_FERME = "Select * from req6";

	public static String REQ_INCIDENT_ACTIVITE_OUVERT_LIST_COMMENTAIRE = "Select * from req5 order by jour desc";
	public static String REQ_UPDATE_COMMENTAIRE = "update req5 set commentaire = ? where jour like ? and equipe=?";
	public static String REQ_INCIDENT_ACTIVITE_OUVERT_FOR_COMMENTAIRE = "Select * from req5 where jour like ? and equipe=?";
	
	public static String REQ_DR = "Select * from dr";
	public static String REQ_DC = "Select * from dc where :dr = ParentId";
	public static String REQ_FOURNISSEUR = "Select * from fournisseur WHERE COALESCE(TypeEquipement, '') = ?";
	
}
