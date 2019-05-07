mvn clean generate-sources spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=local -Dhttps.proxyHost=localhost -Dhttps.proxyPort=3128 -Dhttp.nonProxyHosts=*.corpintra.net|localhost"
