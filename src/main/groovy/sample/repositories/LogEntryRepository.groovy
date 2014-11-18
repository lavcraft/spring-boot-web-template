package sample.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository
import sample.domain.LogEntry

//import sample.configs.LogEntry

/**
 * @author tolkv
 * @version 18/11/14
 */
@RepositoryRestResource(path = 'logs',collectionResourceRel='logs')
@Repository
public interface LogEntryRepository extends MongoRepository<LogEntry,Long> {
    List<LogEntry> findBySeverity(@Param('name') Integer severity)
}
