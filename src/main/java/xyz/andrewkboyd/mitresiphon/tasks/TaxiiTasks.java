package xyz.andrewkboyd.mitresiphon.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 *
 */
@Component
public class TaxiiTasks {
    private static final Logger LOG = LoggerFactory.getLogger(TaxiiTasks.class);

    @Scheduled(fixedRate = 5000)
    public void Fetch(){
        LOG.debug("starting fetch");
        LOG.debug("finished fetch");
    }
}
