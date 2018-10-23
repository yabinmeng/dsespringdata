package com.ymeng;

import java.util.UUID;

import com.datastax.driver.core.ProtocolVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.data.cassandra.core.query.Query;

import com.datastax.driver.dse.DseCluster;
import com.datastax.driver.dse.DseSession;

public class MyDseSpringTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyDseSpringTest.class);

    protected static Person newPerson(String name, int age) {
        return newPerson(UUID.randomUUID().toString(), name, age);
    }

    protected static Person newPerson(String id, String name, int age) {
        return new Person(id, name, age);
    }

    public static void main(String[] args) {

        DseCluster cluster = DseCluster.builder()
            .addContactPoints("35.239.224.37")
            //.withProtocolVersion(ProtocolVersion.V4)
            .build();
        DseSession session = cluster.connect("testks");

        CassandraOperations template = new CassandraTemplate(session);

        Person jonDoe = template.insert(newPerson("Jon Doe", 40));

        System.out.println(jonDoe);

        LOGGER.info(template.selectOne(Query.query(Criteria.where("id").is(jonDoe.getId())), Person.class).getId());

        //template.truncate(Person.class);
        session.close();
        cluster.close();
    }
}