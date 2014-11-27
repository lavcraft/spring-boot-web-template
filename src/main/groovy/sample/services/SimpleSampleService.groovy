package sample.services

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component
import sample.services.api.SampleService

/**
 * @author tolkv
 * @version 16/11/14
 */
@Slf4j
@Component
class SimpleSampleService implements SampleService {

    def convertMessage(msg){
        return msg as Map
    }

    @Override
    def showInfo() {
        return this.class.getInterfaces()
    }

}
