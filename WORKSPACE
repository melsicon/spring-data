workspace(name = "de_melsicon_spring_data")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

# ---

http_archive(
    name = "bazel_skylib",
    sha256 = "1c531376ac7e5a180e0237938a2536de0c54d93f5c278634818e0efc952dd56c",
    urls = [
        "https://github.com/bazelbuild/bazel-skylib/releases/download/1.0.3/bazel-skylib-1.0.3.tar.gz",
        "https://mirror.bazel.build/github.com/bazelbuild/bazel-skylib/releases/download/1.0.3/bazel-skylib-1.0.3.tar.gz",
    ],
)

load("@bazel_skylib//:workspace.bzl", "bazel_skylib_workspace")

bazel_skylib_workspace()

# ---

http_archive(
    name = "rules_jvm_external",
    sha256 = "995ea6b5f41e14e1a17088b727dcff342b2c6534104e73d6f06f1ae0422c2308",
    strip_prefix = "rules_jvm_external-4.1",
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/4.1.tar.gz",
)

load("@rules_jvm_external//:defs.bzl", "maven_install")
load("@rules_jvm_external//:specs.bzl", "maven")

# ---

http_archive(
    name = "rules_java",
    sha256 = "34b41ec683e67253043ab1a3d1e8b7c61e4e8edefbcad485381328c934d072fe",
    url = "https://github.com/bazelbuild/rules_java/releases/download/4.0.0/rules_java-4.0.0.tar.gz",
)

load("@rules_java//java:repositories.bzl", "rules_java_dependencies", "rules_java_toolchains")

rules_java_dependencies()

rules_java_toolchains()

# ---

maven_install(
    artifacts = [
        "com.fasterxml.jackson.core:jackson-databind:2.13.0-rc1",
        "com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.13.0-rc1",
        "com.google.errorprone:error_prone_annotations:2.7.1",
        "com.google.flogger:flogger-log4j2-backend:0.5.1",
        "com.google.flogger:flogger:0.5.1",
        "com.google.guava:guava:30.1.1-jre",
        "com.h2database:h2:1.4.200",
        "com.lmax:disruptor:3.4.4",
        "com.querydsl:querydsl-apt:5.0.0",
        "com.querydsl:querydsl-core:5.0.0",
        "com.querydsl:querydsl-jpa:5.0.0",
        "io.github.classgraph:classgraph:4.8.110",
        "jakarta.activation:jakarta.activation-api:1.2.2",
        "jakarta.annotation:jakarta.annotation-api:1.3.5",
        "jakarta.persistence:jakarta.persistence-api:2.2.3",
        "jakarta.transaction:jakarta.transaction-api:1.3.3",
        "jakarta.validation:jakarta.validation-api:2.0.2",
        "jakarta.xml.bind:jakarta.xml.bind-api:2.3.3",
        "org.apache.logging.log4j:log4j-api:2.14.1",
        "org.apache.logging.log4j:log4j-jcl:2.14.1",
        "org.apache.logging.log4j:log4j-jul:2.14.1",
        "org.apache.logging.log4j:log4j-slf4j18-impl:2.14.1",
        "org.apache.logging.log4j:log4j-web:2.14.1",
        "org.checkerframework:checker-qual:3.16.0",
        "org.checkerframework:checker:3.16.0",
        "org.eclipse.jetty:jetty-webapp:10.0.6",
        "org.glassfish:jakarta.el:3.0.3",
        "org.hibernate.validator:hibernate-validator:6.2.0.Final",
        "org.hibernate:hibernate-core:5.5.4.Final",
        "org.jetbrains:annotations:21.0.1",
        "org.ow2.asm:asm:9.2",
        "org.springframework.boot:spring-boot-autoconfigure:2.5.2",
        "org.springframework.boot:spring-boot:2.5.2",
        "org.springframework.data:spring-data-jpa:2.5.3",
        "org.springframework.data:spring-data-rest-core:3.5.3",
        "org.springframework.data:spring-data-rest-hal-explorer:3.5.3",
        "org.springframework.data:spring-data-rest-webmvc:3.5.3",
        "org.springframework:spring-context-indexer:5.3.9",
        "org.springframework:spring-core:5.3.9",
        maven.artifact(
            "junit",
            "junit",
            "4.13.2",
            testonly = True,
        ),
        maven.artifact(
            "org.assertj",
            "assertj-core",
            "3.20.2",
            testonly = True,
        ),
        maven.artifact(
            "org.assertj",
            "assertj-guava",
            "3.4.0",
            testonly = True,
        ),
        maven.artifact(
            "org.mockito",
            "mockito-core",
            "3.11.2",
            testonly = True,
        ),
        maven.artifact(
            "org.springframework.boot",
            "spring-boot-test",
            "2.5.2",
            testonly = True,
        ),
        maven.artifact(
            "org.springframework.boot",
            "spring-boot-test-autoconfigure",
            "2.5.2",
            testonly = True,
        ),
        maven.artifact(
            "org.springframework",
            "spring-test",
            "5.3.9",
            testonly = True,
        ),
    ],
    excluded_artifacts = [
        "org.springframework:spring-jcl",
    ],
    fetch_sources = True,
    maven_install_json = "@de_melsicon_spring_data//:maven_install.json",
    override_targets = {
        # Java EE is now Jakarta EE
        "javax.activation:javax.activation-api": ":jakarta_activation_jakarta_activation_api",
        "javax.persistence:javax.persistence-api": ":jakarta_persistence_jakarta_persistence_api",
        "javax.transaction:javax.transaction-api": ":jakarta_transaction_jakarta_transaction_api",
        "javax.xml.bind:jaxb-api": ":jakarta_xml_bind_jakarta_xml_bind_api",
        "org.jboss.spec.javax.transaction:jboss-transaction-api_1.2_spec": ":jakarta_transaction_jakarta_transaction_api",
    },
    repositories = [
        "https://maven-central-eu.storage-download.googleapis.com/maven2",
        "https://repo1.maven.org/maven2",
    ],
)

load("@maven//:defs.bzl", "pinned_maven_install")

pinned_maven_install()

# ---
