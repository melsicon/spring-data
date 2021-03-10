package de.melsicon.example.spring_data.classcheck;

import com.google.common.flogger.FluentLogger;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.Resource;

public final class ClassCheck {
  private static final FluentLogger logger = FluentLogger.forEnclosingClass();

  private ClassCheck() {}

  public static void main(String... args) {
    var classGraph = new ClassGraph();
    try (var scan = classGraph.scan();
        var resourceList = scan.getAllResources().filter(ClassCheck::resourceFilter)) {
      for (var duplicate : resourceList.findDuplicatePaths()) {
        logger.atWarning().log("Duplicate resource: %s", duplicate.getKey());
        try (var duplicates = duplicate.getValue()) {
          for (var resource : duplicates) {
            logger.atWarning().log(" -> %s", resource.getURI());
          }
        }
      }
    }
    logger.atInfo().log("Check finished");
  }

  private static boolean resourceFilter(Resource resource) {
    var path = resource.getPath();
    if (path.equals("module-info.class")) {
      return false;
    }
    if (!path.endsWith(".class") || path.length() < 7) {
      return false;
    }
    // Check filename is not simply ".class"
    var c = path.charAt(path.length() - 7);
    return c != '/' && c != '.';
  }
}
