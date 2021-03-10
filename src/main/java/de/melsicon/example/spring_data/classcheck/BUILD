load("@rules_java//java:defs.bzl", "java_library")

java_library(
    name = "classcheck",
    srcs = glob(["*.java"]),
    visibility = ["//visibility:public"],
    runtime_deps = [
        "//src/main/java/de/melsicon/example/spring_data/main:main-rest",
    ],
    deps = [
        "//toolchain:checker",
        "//toolchain:nullaway",
        "@maven//:com_google_errorprone_error_prone_annotations",
        "@maven//:com_google_flogger_flogger",
        "@maven//:io_github_classgraph_classgraph",
    ],
)
