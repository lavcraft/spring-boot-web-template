package sample

import com.mongodb.Mongo
import com.mongodb.WriteConcern
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

/**
 * Created by tolkv on 11/27/2014.
 */
@EnableMongoRepositories
@Configuration
class MongoConfig extends AbstractMongoConfiguration {
    @Override
    protected String getDatabaseName() {
        return 'spring-boot-web-examle'
    }

    @Override
    Mongo mongo() throws Exception {
        Mongo mongo = new Mongo()
        mongo.setWriteConcern(WriteConcern.SAFE)
        return mongo
    }
}
