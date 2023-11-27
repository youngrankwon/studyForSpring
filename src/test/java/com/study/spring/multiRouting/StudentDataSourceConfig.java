package com.study.spring.multiRouting;

import com.study.spring.multiRouting.repository.student.Student;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
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

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	basePackages = "com.study.spring.multiRouting.repository.student",
	entityManagerFactoryRef = "studentEntityManager",
	transactionManagerRef = "studentTransactionManager"
)
public class StudentDataSourceConfig {

	@Bean
	@Primary
	@ConfigurationProperties("datasource.student")
	public DataSourceProperties studentDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@Primary
	public DataSource studentDataSource() {
		return studentDataSourceProperties()
			.initializeDataSourceBuilder()
			.type(HikariDataSource.class)
			.build();
	}

	@Bean(name = "studentEntityManager")
	@Primary
	public LocalContainerEntityManagerFactoryBean studentEntityManager(
		EntityManagerFactoryBuilder builder) {
		return builder.dataSource(studentDataSource()).packages(Student.class)
			.build();
	}

	@Bean(name = "studentTransactionManager")
	@Primary
	public PlatformTransactionManager studentTransactionManager(
		@Qualifier("studentEntityManager") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
		return new JpaTransactionManager(entityManagerFactoryBean.getObject());
	}
}
