package ma.iam.dashboard.csn.job.mysql.constants;

public abstract class QueryConstants {

	public static String CLEAN_REQ_1 = "TRUNCATE req1";

	public static String INSERT_REQ_1 = "INSERT INTO req1 (etat, nombre) VALUES (?,?)";
	
	public static String CLEAN_REQ_2 = "DELETE FROM req2 " + 
			"WHERE DATE_SUB(CURDATE(), INTERVAL 1 DAY) <= DATE(jour)";
	
	public static String INSERT_REQ_2 = "INSERT INTO req2 (jour, etat, nombre) VALUES (?,?,?)";

	public static String CLEAN_REQ_3 = "DELETE FROM req3 " + 
			"WHERE DATE_SUB(CURDATE(), INTERVAL 1 DAY) <= DATE(jour)";
	
	public static String INSERT_REQ_3 = "INSERT INTO req3 (jour, division, nombre) VALUES (?,?,?)";

	public static String CLEAN_REQ_4 = "DELETE FROM req4 " + 
			"WHERE DATE_SUB(CURDATE(), INTERVAL 1 DAY) <= DATE(jour)";
	
	public static String INSERT_REQ_4 = "INSERT INTO req4 (jour, division, nombre) VALUES (?,?,?)";

	public static String CLEAN_REQ_5 = "DELETE FROM req5 " + 
			"WHERE DATE_SUB(CURDATE(), INTERVAL 1 DAY) <= DATE(jour)";
	
	public static String INSERT_REQ_5 = "INSERT INTO req5 (jour, equipe, nombre) VALUES (?,?,?)";

	public static String CLEAN_REQ_6 = "DELETE FROM req6 " + 
			"WHERE DATE_SUB(CURDATE(), INTERVAL 1 DAY) <= DATE(jour)";
	
	public static String INSERT_REQ_6 = "INSERT INTO req6 (jour, equipe, nombre) VALUES (?,?,?)";

	public static String SQL_GET_DIFF_LAST_DAY = "SELECT DATEDIFF(CURDATE(), MAX(jour))-1 FROM ";

	public static String CLEAN_REQ_EQUIP = "TRUNCATE reqEquip";
	
	public static String INSERT_REQ_EQUIP = "INSERT INTO reqEquip "
			+ "(Description, Latitude, Longitude, DateDebut, symptome, infra, dr, iddr, dc, iddc, categorie, fournisseur, idfournisseur) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static String CLEAN_REQ_EQUIP2G = "TRUNCATE reqEquip2g";
	
	public static String INSERT_REQ_EQUIP2G = "INSERT INTO reqEquip2g "
			+ "(Description, Latitude, Longitude, DateDebut, symptome, infra, dr, iddr, dc, iddc, categorie, fournisseur, idfournisseur) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static String CLEAN_REQ_EQUIP3G = "TRUNCATE reqEquip3g";
	
	public static String INSERT_REQ_EQUIP3G = "INSERT INTO reqEquip3g "
			+ "(Description, Latitude, Longitude, DateDebut, symptome, infra, dr, iddr, dc, iddc, categorie, fournisseur, idfournisseur) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static String CLEAN_REQ_EQUIP4G = "TRUNCATE reqEquip4g";
	
	public static String INSERT_REQ_EQUIP4G = "INSERT INTO reqEquip4g "
			+ "(Description, Latitude, Longitude, DateDebut, symptome, infra, dr, iddr, dc, iddc, categorie, fournisseur, idfournisseur) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static String CLEAN_REQ_MSAN = "TRUNCATE reqmsan";
	
	public static String INSERT_REQ_MSAN = "INSERT INTO reqmsan "
			+ "(Description, GpsLatitude, Observation, DateDebut, symptome, infra, dr, iddr, dc, iddc, categorie, fournisseur, idfournisseur) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static String CLEAN_REQ_DR = "TRUNCATE dr";
	
	public static String INSERT_REQ_DR = "INSERT INTO dr (id, description) VALUES (?,?)";

	public static String CLEAN_REQ_DC = "TRUNCATE dc";
	
	public static String INSERT_REQ_DC = "INSERT INTO dc (id, description, parentid) VALUES (?,?,?)";

	public static String CLEAN_REQ_FOURNISSEUR = "TRUNCATE fournisseur";

	public static String INSERT_REQ_FOURNISSEUR = "INSERT INTO fournisseur (id, description, typeEquipement) VALUES (?,?,?)";

	public static String CLEAN_REQ_STAT_MBTS = "TRUNCATE req_stat_mbts";

	public static String INSERT_REQ_STAT_MBTS = "INSERT INTO req_stat_mbts (dr, nombre) VALUES (?,?)";

	public static String CLEAN_REQ_STAT_MSAN = "TRUNCATE req_stat_msan";

	public static String INSERT_REQ_STAT_MSAN = "INSERT INTO req_stat_msan (dr, nombre) VALUES (?,?)";

	public static String SQL_GET_FREQUENCE = "Select frequence from parametrage where requete=?";
	public static String SQL_GET_NEXT_EXECUTION = "Select next_execution from parametrage where requete=?";
	public static String SQL_UPDATE_PARAMETRAGE = "update parametrage set execution=NOW(),"
			+ " next_execution = DATE_ADD(DATE_FORMAT(NOW(), ?), INTERVAL frequence HOUR)"
			+ " where requete=?";
	
}
