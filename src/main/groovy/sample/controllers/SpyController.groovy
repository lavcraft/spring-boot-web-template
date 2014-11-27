package sample.controllers

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessageSendingOperations
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import sample.domain.LogEntry
import sample.repositories.LogEntryRepository

import javax.servlet.http.HttpServletRequest

/**
 * @author tolkv
 * @version 18/11/14
 */
@Controller
@Slf4j
class SpyController {

    @Autowired
    public SimpMessageSendingOperations msgTemplate;

    @Autowired
    public LogEntryRepository repository

    @RequestMapping(value = 'spy', method = [
            RequestMethod.GET,
            RequestMethod.POST,
            RequestMethod.OPTIONS,
            RequestMethod.DELETE
    ])
    public @ResponseBody
    String spy(@RequestBody String body, HttpServletRequest request) {
        log.info 'i am spy'
        def result = new StringBuilder()
        request.headerNames.each {
            log.info "$it : ${request.getHeader(it)}"
            result << "$it : $it : ${request.getHeader(it)}"
        }

        result << body
        log.info 'i am body'
        msgTemplate.convertAndS('/logs/all', result.toString())
        repository.save(new LogEntry().severity(1).data(result))
        return result.toString()
    }

    @RequestMapping(value = 'all', method = [
            RequestMethod.GET
    ])
    public @ResponseBody
    String all() {
        def all = repository.findAll()
        return all.collect {
            it.data
        }.join('<br/>')
    }

    @MessageMapping("/logs")
    @SendTo("/logs/all")
    public String greeting(String message) throws Exception {
        Thread.sleep(100);
        return "| $message |"
    }
}
