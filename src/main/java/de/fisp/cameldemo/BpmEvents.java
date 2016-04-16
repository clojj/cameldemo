package de.fisp.cameldemo;

import org.camunda.bpm.engine.cdi.BusinessProcessEvent;
import org.camunda.bpm.engine.cdi.annotation.event.CreateTask;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Observes;

@Startup
@Singleton
public class BpmEvents {

    @PostConstruct
    public void init() {
        System.out.println("init");
    }

    public void onTaskEvent(@Observes @CreateTask("UserTask_1") BusinessProcessEvent businessProcessEvent) {
        System.out.println("CreateTask: " + businessProcessEvent);
    }
}
