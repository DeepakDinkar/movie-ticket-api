package com.bookMyMovie.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.client.MongoClient;

public class MongoDBConfig extends AbstractMongoClientConfiguration {

	@Value("${spring.data.mongodb.host}")
	private String host;
	@Value("${spring.data.mongodb.database}")
	private String database;

	@Override
	public MongoClient mongoClient() {
		return mongoClient();
	}

	@Override
	protected String getDatabaseName() {
		return database;
	}

	public GridFsTemplate gridFsTemplate() throws Exception {
		return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
	}
}
