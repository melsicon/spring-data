package de.melsicon.example.spring_data.main;

import de.melsicon.example.spring_data.config.ConfigMarker;
import de.melsicon.example.spring_data.runner.RunnerMarker;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackageClasses = {RunnerMarker.class})
@ConfigurationPropertiesScan(basePackageClasses = {ConfigMarker.class})
@Import({DatabaseConfiguration.class})
public class ApplicationConfiguration {}
