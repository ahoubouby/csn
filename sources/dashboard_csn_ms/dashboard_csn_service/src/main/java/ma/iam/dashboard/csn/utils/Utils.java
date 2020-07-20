package ma.iam.dashboard.csn.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
public class Utils {
	/**
	 * 
	 * @return logParam
	 */
	public static String getLogParam(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		@SuppressWarnings("unchecked")
		KeycloakPrincipal<KeycloakSecurityContext> userDetails = (KeycloakPrincipal<KeycloakSecurityContext>) authentication.getPrincipal();
		String login = userDetails.getKeycloakSecurityContext().getToken().getPreferredUsername();
		String logParam="Requette login: " + login + ", ip: " + fetchClientIpAddr() + ", Action: " ;;
		return logParam;
	}

	/**
	 * GET ADDRESS IP EXTERNAL CLIENT
	 * @return
	 */
	private static String fetchClientIpAddr() {
		String ip = "";
		HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest();
		if (request != null) {
			ip = request.getHeader("X-FORWARDED-FOR");
			if (ip == null || "".equals(ip)) {
				ip = request.getRemoteAddr();
			}
		}
		if ("0:0:0:0:0:0:0:1".equals(ip)) 
			ip = "127.0.0.1";
		return ip;
	}


	/**
	 * 
	 * @param numero
	 * @return
	 */
	public static Boolean isTelephoneNumber(String numero){
		Pattern pattern1 = Pattern.compile("[0-9]{10}");
		Pattern pattern2 = Pattern.compile("[0-9]{12}");
		Matcher matcher1 = pattern1.matcher(numero);
		Matcher matcher2 = pattern2.matcher(numero);
		if (matcher1.matches() || matcher2.matches())
			return true;
		else return false;
	}
	/**
	 * 
	 * @param alphanumeric
	 * @return
	 */
	public static Boolean isOnlyAlphaNumeric(String alphanumeric){
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]+");
		Matcher matcher = pattern.matcher(alphanumeric);
		if (matcher.matches()) {

			return true;
		}
		else
		{

			return false;
		}
	}

	/**
	 * 	Evolution Date Operation en input 	
	 */
	public static boolean isValidStringDate(String text) {
		SimpleDateFormat df = null;
		if (text == null || !text.matches("[0-3]\\d/[01]\\d/\\d{4}") && !text.matches("[0-3]\\d/[01]\\d/\\d{4}\\s[0-2]\\d((:[0-5]\\d)?){2}"))
			return false;
		if(text.matches("[0-3]\\d/[01]\\d/\\d{4}"))
			df = new SimpleDateFormat("dd/MM/yyyy");
		else df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		df.setLenient(false);
		try {
			df.parse(text);
			return true;
		} catch (ParseException ex) {
			return false;
		}
	}


	public static Boolean isSpecAlphaNumeric(String str){
		if(str.contains("$") || str.contains("&")){
			return true;
		}
		return false;

	}
	/**
	 * @author Z.BELGHAOUTI
	 * @return Path Project
	 */
	public static String getFullPathProject(){

		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		if(null != requestAttributes && requestAttributes instanceof ServletRequestAttributes) {
			HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
			if ( ( request.getServerPort() == 80 ) || ( request.getServerPort() == 443 ) )
				return request.getScheme() + "://" +
				request.getServerName() +
				request.getContextPath();
			else
				return request.getScheme() + "://" +
				request.getServerName() + ":" + request.getServerPort() +
				request.getContextPath();
		}
		return null;
	}
}
