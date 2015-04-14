package com.inertia.solutions.claims.mvc.app.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

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
@ComponentScan(basePackages = {"com.inertia.solutions.claims.mvc.app", "com.inertia.solutions.claims.mvc.domain"}, 
	excludeFilters = { @Filter( type=FilterType.ANNOTATION, value=Configuration.class ) })
public class SpringConfiguration extends AbstractMongoConfiguration {


	@Override
	@Bean
	public MongoClient mongo() throws Exception {
		List<MongoCredential> credsList = new ArrayList<MongoCredential>();
		credsList.add(MongoCredential.createCredential("sysAcct", "claims", "myPassword1".toCharArray()));
		return new MongoClient(new ServerAddress("inertia-0.inertia-inc.1272.mongodbdns.com", 27000), credsList);
	}

	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(mongo(), "claims");
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
