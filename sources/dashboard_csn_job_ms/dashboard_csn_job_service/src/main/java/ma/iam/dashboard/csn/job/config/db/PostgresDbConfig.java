package ma.iam.dashboard.csn.job.config.db;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "pgEntityManagerFactory",
  transactionManagerRef = "pgTransactionManager",
  basePackages = { "ma.iam.dashboard.csn.job.postgres.repository" }
)
public class PostgresDbConfig {
	  @Bean(name = "pgDataSource")
	  @ConfigurationProperties(prefix = "pg.datasource")
	  public DataSource dataSource() {
	    return DataSourceBuilder.create().build();
	  }
	  
	  @Bean(name = "pgEntityManagerFactory")
	  public LocalContainerEntityManagerFactoryBean 
	  pgEntityManagerFactory(
	    EntityManagerFactoryBuilder builder,
	    @Qualifier("pgDataSource") DataSource dataSource
	  ) {
	    return
	      builder
	        .dataSource(dataSource)
	        .packages("ma.iam.dashboard.csn.job.postgres.domain")
	        .persistenceUnit("pg")
	        .build();
	  }
	  @Bean(name = "pgTransactionManager")
	  public PlatformTransactionManager pgTransactionManager(
	    @Qualifier("pgEntityManagerFactory") EntityManagerFactory
	    pgEntityManagerFactory
	  ) {
	    return new JpaTransactionManager(pgEntityManagerFactory);
	  }
}
