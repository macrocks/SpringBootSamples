package com.example;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;


@RestController
public class Snippet {
	@Autowired
	private DataSource dataSource;

	@RequestMapping("/migrate")
	public @ResponseBody void migrate() {
		//call do Migration method
		doMigration();
	}



public void doMigration(){
	try {
	java.sql.Connection connection = dataSource.getConnection();

	Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));

	Liquibase liquibase = new liquibase.Liquibase("db/changelog/changelog.xml", new ClassLoaderResourceAccessor(), database);

	//liquibase.getLog().setLogLevel(LogLevel.DEBUG);
	liquibase.update(new Contexts(), new LabelExpression());
	}catch(Exception e){
		System.out.println("Exception Occured while doing Migration" + e.toString());
	}
}

}