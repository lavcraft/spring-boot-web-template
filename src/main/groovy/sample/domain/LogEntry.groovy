package sample.domain

import groovy.transform.Canonical
import groovy.transform.builder.Builder
import groovy.transform.builder.SimpleStrategy
import org.springframework.data.annotation.Id

/**
 * @author tolkv
 * @version 18/11/14
 */
@Builder(builderStrategy=SimpleStrategy, prefix="")
@Canonical
public class LogEntry {
    @Id
    Long id

    def severity
    def data
}
