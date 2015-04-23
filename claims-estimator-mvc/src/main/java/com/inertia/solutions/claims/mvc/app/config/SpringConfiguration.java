package com.inertia.solutions.claims.mvc.app.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

/**
 * 
 * This class is a basic Spring IOC Container config
 * which does a @Component @Services scan on the base package name,
 * and also allows the AspectJ Style proxy generation.
 *
 */
@Configuration
@EnableMongoRepositories(basePackages="com.inertia.solutions.claims.mvc.domain.repository")
@ComponentScan(basePackages = {"com.inertia.solutions.claims.mvc.domain"})
@PropertySource(value="classpath:database.properties")
public class SpringConfiguration extends AbstractMongoConfiguration  {

	@Autowired
	private Environment env;
	
	@Override
	@Bean
	public MongoClient mongo() throws Exception {
		List<MongoCredential> credsList = new ArrayList<MongoCredential>();
		credsList.add(MongoCredential.createCredential(env.getProperty("mongo.username"), env.getProperty("mongo.database"), 
				env.getProperty("mongo.password").toCharArray()));
		return new MongoClient(new ServerAddress(env.getProperty("mongo.host"), new Integer(env.getProperty("mongo.port"))), credsList);
	}

	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(mongo(), env.getProperty("mongo.database"));
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongoDbFactory());
	}

	@Override
	protected String getDatabaseName() {
		return null;
	}
	
}
