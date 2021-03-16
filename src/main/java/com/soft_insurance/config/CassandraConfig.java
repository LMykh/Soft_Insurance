package com.soft_insurance.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "com.soft_insurance.repository")
public class CassandraConfig extends AbstractCassandraConfiguration {

    public static final String KEYSPACE = "insurancedb";

    @Override
    protected String getKeyspaceName() {
        return KEYSPACE ;
    }
}
