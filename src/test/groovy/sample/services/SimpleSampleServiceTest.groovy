package sample.services

import sample.services.api.SampleService
import spock.lang.Specification

/**
 * @author tolkv
 * @version 16/11/14
 */
class SimpleSampleServiceTest extends Specification {
    def "show info should return correct implemented interfaces"() {
        given:
        def srv=new SimpleSampleService()
        when:
        def info = srv.showInfo()
        then:
        info == [SampleService.class,GroovyObject.class]
    }
}
