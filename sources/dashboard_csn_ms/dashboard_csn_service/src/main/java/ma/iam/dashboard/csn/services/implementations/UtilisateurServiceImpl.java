package ma.iam.dashboard.csn.services.implementations;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import ma.iam.dashboard.csn.dtos.UserDto;
import ma.iam.dashboard.csn.dtos.UtilisateurDto;
import ma.iam.dashboard.csn.services.IUtilisateurService;
import ma.iam.dashboard.csn.utils.Utils;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
@Service
public class UtilisateurServiceImpl implements IUtilisateurService {

	private final Logger logger = LoggerFactory.getLogger(UtilisateurServiceImpl.class);

	@Autowired
	private KeycloakRestTemplate keycloakRestTemplate;
	@Value("${keycloak.auth-server-url}")
	private String endpoint;
	@Value("${keycloak.realm}")
	private String realm;

	public UtilisateurDto getUserInformation() {
		UtilisateurDto dto = new UtilisateurDto();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.getPrincipal() != null) {			
			@SuppressWarnings("unchecked")
			KeycloakPrincipal<KeycloakSecurityContext> userDetails = (KeycloakPrincipal<KeycloakSecurityContext>) authentication.getPrincipal();
			if (userDetails != null && userDetails.getKeycloakSecurityContext() != null && userDetails.getKeycloakSecurityContext().getToken() != null) {
				String login = userDetails.getKeycloakSecurityContext().getToken().getPreferredUsername();
				String nom = userDetails.getKeycloakSecurityContext().getToken().getFamilyName();
				String prenom = userDetails.getKeycloakSecurityContext().getToken().getGivenName();
				String email = userDetails.getKeycloakSecurityContext().getToken().getEmail();
				dto.setLogin(login);
				dto.setNom(nom);
				dto.setPrenom(prenom);
				dto.setEmail(email);
			}
		}
		logger.info(Utils.getLogParam() + "Mise à jour informations utilisateur");
		return dto;
	}

	public UtilisateurDto getCurrentUtilisateur() {
		UtilisateurDto dto = new UtilisateurDto();
		logger.info(Utils.getLogParam() + " Recuperer l'utilisateur connecte ");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.getPrincipal() != null) {
			@SuppressWarnings("unchecked")
			KeycloakPrincipal<KeycloakSecurityContext> userDetails = (KeycloakPrincipal<KeycloakSecurityContext>) authentication.getPrincipal();
			if (userDetails != null && userDetails.getKeycloakSecurityContext() != null && userDetails.getKeycloakSecurityContext().getToken() != null) {
				String login = userDetails.getKeycloakSecurityContext().getToken().getPreferredUsername();
				String nom = userDetails.getKeycloakSecurityContext().getToken().getFamilyName();
				String prenom = userDetails.getKeycloakSecurityContext().getToken().getGivenName();
				String email = userDetails.getKeycloakSecurityContext().getToken().getEmail();
				dto.setLogin(login);
				dto.setNom(nom);
				dto.setPrenom(prenom);
				dto.setEmail(email);
			}
		}
		return dto;
	}

	@Override
	public ResponseEntity<List<UtilisateurDto>> getUtilisateursByParam(String name) {
		String param = name.replace(" ", "%20");
		List<UtilisateurDto> dtos = new ArrayList<UtilisateurDto>();
		try {
			if(param.length() >= 3){
				UserDto[] usersDto = keycloakRestTemplate.getForObject(URI.create(endpoint + "admin/realms/" + realm + "/users?search=" + param), UserDto[].class);	
				UtilisateurDto dto = null;
				if(usersDto != null && usersDto.length > 0 ) {
					for(UserDto userDto : usersDto){
						if(userDto != null){				
							dto = new UtilisateurDto();
							dto.setLogin(userDto.getUsername());
							dto.setNom(userDto.getLastName());
							dto.setPrenom(userDto.getFirstName());
							dto.setEmail(userDto.getEmail());
							dtos.add(dto);
						}
					}
					logger.info(Utils.getLogParam() + "Recuperer Total: " + dtos.size() + " utilisateurs par parametre : " + name);
					return new ResponseEntity<List<UtilisateurDto>>( dtos, HttpStatus.OK);
				} else {
					logger.info(Utils.getLogParam() + "Recuperer Total: " + dtos.size() + " utilisateurs par parametre : " + name);
					return new ResponseEntity<List<UtilisateurDto>>( dtos, HttpStatus.OK);
				}
			} else {
				logger.info(Utils.getLogParam() + "Recuperer Total: " + dtos.size() + " utilisateurs par parametre : " + name);
				return new ResponseEntity<List<UtilisateurDto>>( dtos, HttpStatus.OK);
			}

		}catch(HttpClientErrorException e){
			logger.info(Utils.getLogParam() + "Erreur : " + e.getMessage() + " dans la recherche utilisateur par parametre : " + name);
			return new ResponseEntity<List<UtilisateurDto>>( dtos, HttpStatus.FORBIDDEN);
		}catch(Exception e){
			logger.info(Utils.getLogParam() + "Erreur : " + e.getMessage() + " dans la recherche utilisateur par parametre : " + name);
			return new ResponseEntity<List<UtilisateurDto>>( dtos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
