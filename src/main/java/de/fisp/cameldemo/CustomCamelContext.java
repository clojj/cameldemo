package de.fisp.cameldemo;

import org.apache.camel.impl.DefaultCamelContext;
import org.camunda.bpm.camel.component.CamundaBpmComponent;
import org.camunda.bpm.engine.ProcessEngine;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.logging.Logger;

@ApplicationScoped
public class CustomCamelContext extends DefaultCamelContext {

    private final static Logger log = Logger.getLogger(CustomCamelContext.class.getCanonicalName());

    @Inject
    private ProcessEngine processEngine;

    @Inject
    private MyCamelRouteBuilder routeBuilder;

    @PostConstruct
    public void init() throws Exception {
        log.info("=======================");
        log.info("Initializing Camel");

        CamundaBpmComponent component = new CamundaBpmComponent(processEngine);
        component.setCamelContext(this);
        addComponent("camunda-bpm", component);
        addRoutes(routeBuilder);
        start();

        log.info("Successfully started Camel with components: " + getComponentNames());
        log.info("=======================");
    }

    @PreDestroy
    public void shutDown() throws Exception {
        log.info("=======================");
        log.info("Shutting down Camel");
        stop();
        log.info("=======================");
    }

}
