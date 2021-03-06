package ma.iam.dashboard.csn.job.config.db;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
  entityManagerFactoryRef = "entityManagerFactory",
  basePackages = { "ma.iam.dashboard.csn.job.mysql.repository" }
)
public class MysqlDbConfig {
	@Primary
	  @Bean(name = "dataSource")
	  @ConfigurationProperties(prefix = "spring.datasource")
	  public DataSource dataSource() {
	    return DataSourceBuilder.create().build();
	  }
	  
	  @Primary
	  @Bean(name = "entityManagerFactory")
	  public LocalContainerEntityManagerFactoryBean 
	  entityManagerFactory(
	    EntityManagerFactoryBuilder builder,
	    @Qualifier("dataSource") DataSource dataSource
	  ) {
	    return builder
	      .dataSource(dataSource)
	      .packages("ma.iam.dashboard.csn.job.mysql.domain")
	      .persistenceUnit("mysql")
	      .build();
	  }
	    
	  @Primary
	  @Bean(name = "transactionManager")
	  public PlatformTransactionManager transactionManager(
	    @Qualifier("entityManagerFactory") EntityManagerFactory 
	    entityManagerFactory
	  ) {
	    return new JpaTransactionManager(entityManagerFactory);
	  }
}
