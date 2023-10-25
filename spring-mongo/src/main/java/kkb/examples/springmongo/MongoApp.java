package kkb.examples.springmongo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongoApp {

    private static final Logger LOG = LoggerFactory.getLogger(MongoApp.class);

    public static void main(String[] args) {
        LOG.info("Data App started");
        ConfigurableApplicationContext run = SpringApplication.run(MongoApp.class, args);
        run.registerShutdownHook();
    }

}
