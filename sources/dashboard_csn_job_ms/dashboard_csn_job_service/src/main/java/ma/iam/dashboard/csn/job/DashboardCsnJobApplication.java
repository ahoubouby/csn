package ma.iam.dashboard.csn.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
@SpringBootApplication
public class DashboardCsnJobApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DashboardCsnJobApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DashboardCsnJobApplication.class, args);
	}

}
