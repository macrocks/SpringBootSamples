Spring Boot With Liquibase (On Demand Data Migration)

Spring Boot supports Liquibase for data migration on database and you just need to do provide
liquibase properties in Property file.

In case if you want to run Liquibase migration manually(on demand) then use this as sample project

Make sure you have excluded liquibaseuatoconfiguration.class from Spring Auto COnfiguration

####Build

>gradle build

###Run
>cd build\libs
>gradle run demo-0.0.1-SNAPSHOT.jar

Open browser - > http://localhost:8080/migrate
this will start liquibase data migration on demand.

Done .. cheers :)