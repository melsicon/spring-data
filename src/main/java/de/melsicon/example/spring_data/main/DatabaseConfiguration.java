package de.melsicon.example.spring_data.main;

import de.melsicon.example.spring_data.entity.EntityMarker;
import de.melsicon.example.spring_data.repository.RepositoryMarker;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = {EntityMarker.class})
@EnableJpaRepositories(basePackageClasses = {RepositoryMarker.class})
public class DatabaseConfiguration {}
