package ma.iam.dashboard.csn.job.postgres.constants;

public abstract class QueryConstants {
	
	public static String QUERY_INCIDENTS_OUVERT_FERME = "Select * from \"Req1\"";

	public static boolean REQ2_USE_SECOND_PARAM = false;
	public static String QUERY_INCIDENTS_CI_ETAT_SEMAINE = "Select * from \"Req2\" WHERE Date(\"jour\") >= CURRENT_DATE - (? || ' DAY') \\:\\:INTERVAL;";

	public static String QUERY_INCIDENTS_CI_DIVISION_OUVERT = "Select * from \"Req3\" WHERE Date(\"jour\") >= CURRENT_DATE - (? || ' DAY') \\:\\:INTERVAL;";
	public static String QUERY_INCIDENTS_CI_DIVISION_FERME= "Select * from \"Req4\" WHERE Date(\"jour\") >= CURRENT_DATE - (? || ' DAY') \\:\\:INTERVAL;";

	public static String QUERY_INCIDENTS_CI_ACTIVITE_OUVERT = "Select * from \"Req5\" WHERE Date(\"jour\") >= CURRENT_DATE - (? || ' DAY') \\:\\:INTERVAL;";
	public static String QUERY_INCIDENTS_CI_ACTIVITE_FERME = "Select * from \"Req6\" WHERE Date(\"jour\") >= CURRENT_DATE - (? || ' DAY') \\:\\:INTERVAL;";

	public static String QUERY_INCIDENTS_EQUIP = "Select * from \"ReqEquip\" WHERE 1=1";
	public static String QUERY_INCIDENTS_EQUIP_2G = "Select * from \"ReqEquip2g\" WHERE 1=1";
	public static String QUERY_INCIDENTS_EQUIP_3G = "Select * from \"ReqEquip3g\" WHERE 1=1";
	public static String QUERY_INCIDENTS_EQUIP_4G = "Select * from \"ReqEquip4g\" WHERE 1=1";
	public static String QUERY_INCIDENTS_MSAN = "Select * from \"ReqMSAN\" WHERE 1=1";
	
	public static String QUERY_INCIDENTS_DR = "Select * from \"dr\" WHERE 1=1";
	public static String QUERY_INCIDENTS_DC = "Select * from \"dc\" WHERE 1=1";
	public static String QUERY_INCIDENTS_FOURNISSEUR = "Select * from \"fournisseur\" WHERE 1=1";
	public static String SQL_TAB_MBTS = "Select * from \"req_stat_mbts\" WHERE 1=1";
	public static String SQL_TAB_MSAN = "Select * from \"req_stat_msan\" WHERE 1=1";

	
//	public static String QUERY_INCIDENTS_OUVERT_FERME = "SELECT 'Ouvert' as Ouvert, count(*) " + 
//			"FROM \"IncidentCi\" " + 
//			"WHERE \"DateDebut\"\\:\\:timestamp\\:\\:date = ('now'\\:\\:date) " + 
//			"AND EXTRACT(HOUR FROM \"DateDebut\") <= EXTRACT(HOUR FROM now() - interval '1 hour') " + 
//			"AND \"DateFin\" is not null " + 
//			"GROUP BY Ouvert " + 
//			"UNION " + 
//			"SELECT 'Ferme' as Ferme, count(*) " + 
//			"FROM \"IncidentCi\" " + 
//			"WHERE \"DateDebut\"\\:\\:timestamp\\:\\:date = ('now'\\:\\:date) " + 
//			"AND EXTRACT(HOUR FROM \"DateDebut\") <= EXTRACT(HOUR FROM now() - interval '1 hour') " + 
//			"AND \"DateFin\" is null " + 
//			"GROUP BY Ferme ";
//
//	public static boolean REQ2_USE_SECOND_PARAM = true;
//	public static String QUERY_INCIDENTS_CI_ETAT_SEMAINE = "SELECT * FROM ( " + 
//			"(SELECT date_trunc('day', \"IncidentCi\".\"DateDebut\") AS Jour, " + 
//			"'ouvert' AS etat, " + 
//			"count(*) as Nombre_ouvert " + 
//			"FROM \"IncidentCi\" WHERE \"IncidentCi\".\"DateFin\" is null " + 
//			"AND \"IncidentCi\".\"DateDebut\" \\:\\:timestamp\\:\\:date >= ('now'\\:\\:date - ?) " + 
//			"group by Jour " + 
//			"order by Jour) " + 
//			"UNION " + 
//			"(SELECT date_trunc('day', \"IncidentCi\".\"DateDebut\") AS Jour, " + 
//			"'ferme' AS etat, " + 
//			"count(*) as Nombre_ferme " + 
//			"FROM \"IncidentCi\" WHERE \"IncidentCi\".\"DateFin\" is not null " + 
//			"AND \"IncidentCi\".\"DateDebut\" \\:\\:timestamp\\:\\:date >= ('now'\\:\\:date - ?) " + 
//			"group by Jour " + 
//			"order by Jour) " + 
//			") " + 
//			"AS incidents " + 
//			"ORDER BY jour ; ";
//
//	public static String QUERY_INCIDENTS_CI_DIVISION_OUVERT = "SELECT date_trunc('day', \"IncidentCi\".\"DateDebut\") AS Jour, " + 
//			"t2.\"Description\" AS Division, count(*) as Nombre " + 
//			"FROM \"IncidentCi\",\"NetworkElement\",\"LookUp\" t1,\"LookUp\" t2 " + 
//			"WHERE \"NetworkElement\".\"Id\"=\"IncidentCi\".\"Ci\" " + 
//			"AND \"NetworkElement\".\"Division\" = t1.\"Id\" " + 
//			"AND t1.\"ParentId\" = t2.\"Id\" " + 
//			"AND \"IncidentCi\".\"DateFin\" is null " + 
//			"AND \"IncidentCi\".\"DateDebut\" \\:\\:timestamp\\:\\:date >= ('now'\\:\\:date - ?) " + 
//			"group by Jour, t2.\"Description\" " + 
//			"order by Jour, t2.\"Description\" ";
//	public static String QUERY_INCIDENTS_CI_DIVISION_FERME= "SELECT date_trunc('day', \"IncidentCi\".\"DateDebut\") AS Jour, " + 
//			"t2.\"Description\" AS Division, count(*) as Nombre " + 
//			"FROM \"IncidentCi\",\"NetworkElement\",\"LookUp\" t1,\"LookUp\" t2 " + 
//			"WHERE \"NetworkElement\".\"Id\"=\"IncidentCi\".\"Ci\" " + 
//			"AND \"NetworkElement\".\"Division\" = t1.\"Id\" " + 
//			"AND t1.\"ParentId\" = t2.\"Id\" " + 
//			"AND \"IncidentCi\".\"DateFin\" is not null " + 
//			"AND \"IncidentCi\".\"DateDebut\" \\:\\:timestamp\\:\\:date >= ('now'\\:\\:date - ?) " + 
//			"group by Jour, t2.\"Description\" " + 
//			"order by Jour, t2.\"Description\" ";
//
//	public static String QUERY_INCIDENTS_CI_ACTIVITE_OUVERT = "SELECT date_trunc('day', \"IncidentCi\".\"DateDebut\") AS Jour, t1.\"Description\" AS Equipe, count(*) as Nombre " + 
//			"FROM \"TeamCsnInfra\",\"IncidentCi\",\"NetworkElement\",\"LookUp\" t1 " + 
//			"WHERE \"NetworkElement\".\"Id\"=\"IncidentCi\".\"Ci\" " + 
//			"AND \"TeamCsnInfra\".\"TeamCsn\" = t1.\"Id\" " + 
//			"AND \"NetworkElement\".\"Infrastructure\" = \"TeamCsnInfra\".\"Infrastructure\" " + 
//			"AND \"IncidentCi\".\"DateFin\" is null " + 
//			"AND \"IncidentCi\".\"DateDebut\" \\:\\:timestamp\\:\\:date >= ('now'\\:\\:date - ?) " + 
//			"group by Jour, t1.\"Description\" " + 
//			"order by Jour, t1.\"Description\" ";
//	public static String QUERY_INCIDENTS_CI_ACTIVITE_FERME = "SELECT date_trunc('day', \"IncidentCi\".\"DateDebut\") AS Jour, t1.\"Description\" AS Equipe, count(*) as Nombre " + 
//			"FROM \"TeamCsnInfra\",\"IncidentCi\",\"NetworkElement\",\"LookUp\" t1 " + 
//			"WHERE \"NetworkElement\".\"Id\"=\"IncidentCi\".\"Ci\" " + 
//			"AND \"TeamCsnInfra\".\"TeamCsn\" = t1.\"Id\" " + 
//			"AND \"NetworkElement\".\"Infrastructure\" = \"TeamCsnInfra\".\"Infrastructure\" " + 
//			"AND \"IncidentCi\".\"DateFin\" is not null " + 
//			"AND \"IncidentCi\".\"DateDebut\" \\:\\:timestamp\\:\\:date >= ('now'\\:\\:date - ?) " + 
//			"group by Jour, t1.\"Description\" " + 
//			"order by Jour, t1.\"Description\" ";
//
//	public static String QUERY_INCIDENTS_EQUIP = "SELECT \"MBTS\".\"Description\",\"MBTS\".\"Latitude\",\"MBTS\".\"Longitude\",\"IncidentCi\".\"DateDebut\", t1.\"Description\" as Symptome, t2.\"Description\" as Infra, t3.\"Description\" as DR, t3.\"Id\" as IdDR, t5.\"Description\" AS DC, t5.\"Id\" as IdDC, " + 
//			" t4.\"Description\" AS Categorie, t6.\"Description\" AS Fournisseur, t6.\"Id\" as IdFournisseur " + 
//			" FROM \"IncidentCi\",\"MBTS\",\"Incident\",\"LookUp\" t1,\"LookUp\" t2,\"LookUp\" t3,\"LookUp\" t4,\"LookUp\" t5,\"LookUp\" t6 " + 
//			" WHERE \"IncidentCi\".\"Ci\" = \"MBTS\".\"Id\" " + 
//			" AND \"Incident\".\"Id\"=\"IncidentCi\".\"Incident\" " + 
//			" AND \"IncidentCi\".\"Symptom\" = t1.\"Id\" " + 
//			" AND \"MBTS\".\"Infrastructure\" = t2.\"Id\" " + 
//			" AND \"MBTS\".\"Division\" = t5.\"Id\" " + 
//			" AND t5.\"ParentId\" = t3.\"Id\" " + 
//			" AND \"MBTS\".\"Brand\" = t6.\"Id\" " + 
//			" AND \"Incident\".\"Category\" = t4.\"Id\" " + 
//			" AND \"IncidentCi\".\"Symptom\" IN (SELECT \"Id\" FROM \"LookUp\" WHERE \"Type\" = 'CI Symptome' AND \"Description\" IN ('NE HS','CI HS par intermittence','NE HS par intermittence')) " + 
//			" AND \"IncidentCi\".\"DateFin\" IS NULL " + 
//			" AND \"MBTS\".\"Latitude\" IS NOT NULL " + 
//			" AND \"MBTS\".\"Longitude\" IS NOT NULL ";
//	public static String QUERY_INCIDENTS_EQUIP_2G = "SELECT \"MBTS2G\".\"Description\",\"MBTS2G\".\"Latitude\",\"MBTS2G\".\"Longitude\",\"IncidentCi\".\"DateDebut\", " + 
//			" t1.\"Description\" as Symptome, t2.\"Description\" as Infra, t3.\"Description\" as DR, t3.\"Id\" as IdDR, t5.\"Description\" AS DC, t5.\"Id\" as IdDC, " + 
//			" t4.\"Description\" AS Categorie, t6.\"Description\" AS Fournisseur, t6.\"Id\" as IdFournisseur " + 
//			" FROM \"IncidentCi\",\"MBTS2G\",\"Incident\",\"LookUp\" t1,\"LookUp\" t2,\"LookUp\" t3,\"LookUp\" t4,\"LookUp\" t5,\"LookUp\" t6 " + 
//			" WHERE \"IncidentCi\".\"Ci\" = \"MBTS2G\".\"Id\" " + 
//			" AND \"Incident\".\"Id\"=\"IncidentCi\".\"Incident\" " + 
//			" AND \"IncidentCi\".\"Symptom\" = t1.\"Id\" " + 
//			" AND \"MBTS2G\".\"Infrastructure\" = t2.\"Id\" " + 
//			" AND \"MBTS2G\".\"Division\" = t5.\"Id\" " + 
//			" AND t5.\"ParentId\" = t3.\"Id\" " + 
//			" AND \"MBTS2G\".\"Brand\" = t6.\"Id\" " + 
//			" AND \"Incident\".\"Category\" = t4.\"Id\" " + 
//			" AND \"IncidentCi\".\"Symptom\" IN (SELECT \"Id\" FROM \"LookUp\" WHERE \"Type\" = 'CI Symptome' AND \"Description\" IN ('NE HS','CI HS par intermittence','NE HS par intermittence')) " + 
//			" AND \"IncidentCi\".\"DateFin\" IS NULL " + 
//			" AND \"MBTS2G\".\"Latitude\" IS NOT NULL " + 
//			" AND \"MBTS2G\".\"Longitude\" IS NOT NULL ";
//	public static String QUERY_INCIDENTS_EQUIP_3G = "SELECT \"MBTS3G\".\"Description\",\"MBTS3G\".\"Latitude\",\"MBTS3G\".\"Longitude\",\"IncidentCi\".\"DateDebut\", " + 
//			" t1.\"Description\" as Symptome, t2.\"Description\" as Infra, t3.\"Description\" as DR, t3.\"Id\" as IdDR, t5.\"Description\" AS DC, t5.\"Id\" as IdDC, " + 
//			" t4.\"Description\" AS Categorie, t6.\"Description\" AS Fournisseur, t6.\"Id\" as IdFournisseur " + 
//			" FROM \"IncidentCi\",\"MBTS3G\",\"Incident\",\"LookUp\" t1,\"LookUp\" t2,\"LookUp\" t3,\"LookUp\" t4,\"LookUp\" t5,\"LookUp\" t6 " + 
//			" WHERE \"IncidentCi\".\"Ci\" = \"MBTS3G\".\"Id\" " + 
//			" AND \"Incident\".\"Id\"=\"IncidentCi\".\"Incident\" " + 
//			" AND \"IncidentCi\".\"Symptom\" = t1.\"Id\" " + 
//			" AND \"MBTS3G\".\"Infrastructure\" = t2.\"Id\" " + 
//			" AND \"MBTS3G\".\"Division\" = t5.\"Id\" " + 
//			" AND t5.\"ParentId\" = t3.\"Id\" " + 
//			" AND \"MBTS3G\".\"Brand\" = t6.\"Id\" " + 
//			" AND \"Incident\".\"Category\" = t4.\"Id\" " + 
//			" AND \"IncidentCi\".\"Symptom\" IN (SELECT \"Id\" FROM \"LookUp\" WHERE \"Type\" = 'CI Symptome' AND \"Description\" IN ('NE HS','CI HS par intermittence','NE HS par intermittence')) " + 
//			" AND \"IncidentCi\".\"DateFin\" IS NULL " + 
//			" AND \"MBTS3G\".\"Latitude\" IS NOT NULL " + 
//			" AND \"MBTS3G\".\"Longitude\" IS NOT NULL ";
//	public static String QUERY_INCIDENTS_EQUIP_4G = "SELECT \"MBTS4G\".\"Description\",\"MBTS4G\".\"Latitude\",\"MBTS4G\".\"Longitude\",\"IncidentCi\".\"DateDebut\", " + 
//			" t1.\"Description\" as Symptome, t2.\"Description\" as Infra, t3.\"Description\" as DR, t3.\"Id\" as IdDR, t5.\"Description\" AS DC, t5.\"Id\" as IdDC, " + 
//			" t4.\"Description\" AS Categorie, t6.\"Description\" AS Fournisseur, t6.\"Id\" as IdFournisseur " + 
//			" FROM \"IncidentCi\",\"MBTS4G\",\"Incident\",\"LookUp\" t1,\"LookUp\" t2,\"LookUp\" t3,\"LookUp\" t4,\"LookUp\" t5,\"LookUp\" t6 " + 
//			" WHERE \"IncidentCi\".\"Ci\" = \"MBTS4G\".\"Id\" " + 
//			" AND \"Incident\".\"Id\"=\"IncidentCi\".\"Incident\" " + 
//			" AND \"IncidentCi\".\"Symptom\" = t1.\"Id\" " + 
//			" AND \"MBTS4G\".\"Infrastructure\" = t2.\"Id\" " + 
//			" AND \"MBTS4G\".\"Division\" = t5.\"Id\" " + 
//			" AND t5.\"ParentId\" = t3.\"Id\" " + 
//			" AND \"MBTS4G\".\"Brand\" = t6.\"Id\" " + 
//			" AND \"Incident\".\"Category\" = t4.\"Id\" " + 
//			" AND \"IncidentCi\".\"Symptom\" IN (SELECT \"Id\" FROM \"LookUp\" WHERE \"Type\" = 'CI Symptome' AND \"Description\" IN ('NE HS','CI HS par intermittence','NE HS par intermittence')) " + 
//			" AND \"IncidentCi\".\"DateFin\" IS NULL " + 
//			" AND \"MBTS4G\".\"Latitude\" IS NOT NULL " + 
//			" AND \"MBTS4G\".\"Longitude\" IS NOT NULL ";
//	public static String QUERY_INCIDENTS_MSAN = "SELECT \"MSAN\".\"Description\", \"MSAN\".\"GpsLatitude\",\"MSAN\".\"Observation\",\"IncidentCi\".\"DateDebut\", " + 
//			"t1.\"Description\" as Symptome, t2.\"Description\" as Infra, t3.\"Description\" as DR, t3.\"Id\" as IdDR, t5.\"Description\" AS DC, t5.\"Id\" as IdDC, " + 
//			"t4.\"Description\" AS Categorie, t6.\"Description\" AS Fournisseur, t6.\"Id\" as IdFournisseur " + 
//			"FROM \"IncidentCi\",\"MSAN\",\"Incident\",\"LookUp\" t1,\"LookUp\" t2,\"LookUp\" t3,\"LookUp\" t4,\"LookUp\" t5,\"LookUp\" t6 " + 
//			"WHERE \"IncidentCi\".\"Ci\" = \"MSAN\".\"Id\" " + 
//			"AND \"Incident\".\"Id\"=\"IncidentCi\".\"Incident\" " + 
//			"AND \"IncidentCi\".\"Symptom\" = t1.\"Id\" " + 
//			"AND \"MSAN\".\"Infrastructure\" = t2.\"Id\" " + 
//			"AND \"MSAN\".\"Division\" = t5.\"Id\" " + 
//			"AND t5.\"ParentId\" = t3.\"Id\" " + 
//			"AND \"MSAN\".\"Brand\" = t6.\"Id\" " + 
//			"AND \"Incident\".\"Category\" = t4.\"Id\" " + 
//			"AND \"IncidentCi\".\"Symptom\" IN (SELECT \"Id\" FROM \"LookUp\" WHERE \"Type\" = 'CI Symptome' AND \"Description\" IN ('NE HS','CI HS par intermittence','NE HS par intermittence')) " + 
//			"AND \"IncidentCi\".\"DateFin\" IS NULL " + 
//			"AND \"MSAN\".\"GpsLatitude\" IS NOT NULL " + 
//			"AND \"MSAN\".\"Observation\" IS NOT NULL";
//	
//	public static String QUERY_INCIDENTS_DR = "SELECT \"Id\", \"Description\" FROM \"LookUp\" " +
//			"WHERE \"Description\" LIKE 'DR_' AND \"Type\" = 'IM Direction' AND \"Status\" = 'A'";
//	public static String QUERY_INCIDENTS_DC = "SELECT \"Id\", \"Description\", \"ParentId\" FROM \"LookUp\" " + 
//			"WHERE \"Description\" LIKE 'DC %' " + 
//			"AND \"Type\" = 'IM Division' " + 
//			"AND \"Status\" = 'A' ";
//	public static String QUERY_INCIDENTS_FOURNISSEUR = "SELECT \"Id\", \"Description\", '' FROM \"LookUp\" WHERE \"Status\" = 'A' AND \"Id\" IN ('1535','1525','1528')" + 
//			" UNION " +
//			"SELECT \"Id\", \"Description\", 'MSAN' FROM \"LookUp\" WHERE \"Status\" = 'A' AND \"Id\" IN ('1535','1542','1522','1528')";
//	
//
//	public static String SQL_TAB_MBTS = "SELECT t1.\"Description\" as DR, count(*)" + 
//			" FROM \"IncidentCi\",\"MBTS\",\"Incident\",\"LookUp\" t1,\"LookUp\" t2" + 
//			" WHERE \"IncidentCi\".\"Ci\" = \"MBTS\".\"Id\"" + 
//			" AND \"Incident\".\"Id\"=\"IncidentCi\".\"Incident\"" + 
//			" AND \"MBTS\".\"Division\" = t2.\"Id\"" + 
//			" AND t2.\"ParentId\" = t1.\"Id\"" + 
//			" AND \"IncidentCi\".\"Symptom\" IN (SELECT \"Id\" FROM \"LookUp\" WHERE \"Type\" = 'CI Symptome' AND \"Description\" IN ('NE HS','CI HS','CI HS par intermittence','NE HS par intermittence'))" + 
//			" AND \"IncidentCi\".\"DateFin\" IS NULL" + 
//			" AND \"MBTS\".\"Latitude\" IS NOT NULL" + 
//			" AND \"MBTS\".\"Longitude\" IS NOT NULL" + 
//			" GROUP BY DR";
//	public static String SQL_TAB_MSAN = " SELECT t1.\"Description\" as DR,count(*)" + 
//			" FROM \"IncidentCi\",\"MSAN\",\"Incident\",\"LookUp\" t1,\"LookUp\" t2" + 
//			" WHERE \"IncidentCi\".\"Ci\" = \"MSAN\".\"Id\"" + 
//			" AND \"Incident\".\"Id\"=\"IncidentCi\".\"Incident\"" + 
//			" AND \"MSAN\".\"Division\" = t2.\"Id\"" + 
//			" AND t2.\"ParentId\" = t1.\"Id\"" + 
//			" AND \"IncidentCi\".\"Symptom\" IN  (SELECT \"Id\" FROM \"LookUp\" WHERE \"Type\" = 'CI Symptome' AND \"Description\" IN ('NE HS','CI HS','CI HS par intermittence','NE HS par intermittence'))" + 
//			" AND \"IncidentCi\".\"DateFin\" IS NULL" + 
//			" AND \"MSAN\".\"GpsLatitude\" IS NOT NULL" + 
//			" AND \"MSAN\".\"Observation\" IS NOT NULL" + 
//			" GROUP BY dr";
}
