package de.melsicon.example.spring_data.runner;

import com.google.common.flogger.FluentLogger;
import de.melsicon.example.spring_data.config.HelloConfiguration;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.boot.CommandLineRunner;

@Named
public final class HelloWorld implements CommandLineRunner {
  private static final FluentLogger logger = FluentLogger.forEnclosingClass();

  private final String name;

  @Inject
  public HelloWorld(HelloConfiguration config) {
    this.name = config.name();
  }

  @Override
  public void run(String... args) {
    logger.atInfo().log("Hello, %s", name);
  }
}
