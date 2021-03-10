load("@bazel_tools//tools/jdk:default_java_toolchain.bzl", "default_java_toolchain")
load("@rules_java//java:defs.bzl", "java_library", "java_package_configuration", "java_plugin")

default_java_toolchain(
    name = "toolchain_java11",
    package_configuration = [
        ":src_configuration",
    ],
    source_version = "11",
    target_version = "11",
    visibility = ["//visibility:public"],
    xlint = [
        "all",
        "-processing",
    ],
)

JAVACOPTS = [
    "-Werror",
    "-Xpkginfo:always",
    "-XepExcludedPaths:.*/bazel-out/.*",
    "-XepDisableWarningsInGeneratedCode",
    "-XepAllDisabledChecksAsWarnings",
    "-Xep:Java7ApiChecker:OFF",
    "-Xep:AndroidJdkLibsChecker:OFF",
    "-Xep:StaticOrDefaultInterfaceMethod:OFF",
    "-Xep:NoFunctionalReturnType:OFF",
    "-Xep:WildcardImport:OFF",
    "-Xep:NullAway:ERROR",
    "-XepOpt:NullAway:AnnotatedPackages=de.melsicon",
    "-XepOpt:NullAway:TreatGeneratedAsUnannotated",
    "-XepOpt:NullAway:CheckOptionalEmptiness",
    "-XepOpt:NullAway:AcknowledgeRestrictiveAnnotations",
    "-XepOpt:NullAway:ExternalInitAnnotations=javax.persistence.Entity,javax.persistence.Embeddable",
]

java_package_configuration(
    name = "src_configuration",
    javacopts = JAVACOPTS,
    packages = [":src_group"],
)

package_group(
    name = "src_group",
    packages = [
        "//src/...",
    ],
)

# ---
# https://github.com/uber/NullAway/wiki

java_plugin(
    name = "nullaway_processor",
    deps = ["@maven//:com_uber_nullaway_nullaway"],
)

java_library(
    name = "nullaway",
    exported_plugins = ["nullaway_processor"],
    neverlink = True,
    visibility = ["//visibility:public"],
    exports = [
        "@maven//:org_checkerframework_checker_qual",
    ],
)

# ---
# https://checkerframework.org/manual/#nullness-checker

java_plugin(
    name = "checker_processor",
    processor_class = "org.checkerframework.checker.nullness.NullnessChecker",
    deps = ["@maven//:org_checkerframework_checker"],
)

java_library(
    name = "checker",
    exported_plugins = ["checker_processor"],
    neverlink = True,
    visibility = ["//visibility:public"],
    exports = ["@maven//:org_checkerframework_checker_qual"],
)

# ---
# https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-scanning-index

java_plugin(
    name = "spring_context_processor",
    processor_class = "org.springframework.context.index.processor.CandidateComponentsIndexer",
    deps = ["@maven//:org_springframework_spring_context_indexer"],
)

java_library(
    name = "spring_context",
    exported_plugins = ["spring_context_processor"],
    visibility = ["//visibility:public"],
    exports = [
        "@maven//:org_springframework_spring_context",
    ],
)

# ---
# http://www.querydsl.com

java_plugin(
    name = "querydsl_processor",
    generates_api = True,
    processor_class = "com.querydsl.apt.jpa.JPAAnnotationProcessor",
    deps = [
        "@maven//:com_querydsl_querydsl_apt",
        "@maven//:jakarta_annotation_jakarta_annotation_api",
    ],
)

java_library(
    name = "querydsl",
    exported_plugins = ["querydsl_processor"],
    visibility = ["//visibility:public"],
    exports = [
        "@maven//:com_querydsl_querydsl_core",
        "@maven//:jakarta_annotation_jakarta_annotation_api",
    ],
)

# ---
# https://assertj.github.io/doc/

java_library(
    name = "assertj",
    testonly = True,
    visibility = ["//visibility:public"],
    exports = [
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
        "@maven//:org_assertj_assertj_guava",
    ],
)

# ---
