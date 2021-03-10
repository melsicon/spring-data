load("@rules_java//java:defs.bzl", "java_library")

java_library(
    name = "entity",
    srcs = glob(["*.java"]),
    visibility = ["//visibility:public"],
    deps = [
        "//toolchain:nullaway",
        "//toolchain:querydsl",
        "//toolchain:spring_context",
        "@maven//:com_google_errorprone_error_prone_annotations",
        "@maven//:com_google_guava_guava",
        "@maven//:jakarta_persistence_jakarta_persistence_api",
    ],
)
