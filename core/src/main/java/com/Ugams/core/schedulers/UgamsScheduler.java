package com.Ugams.core.schedulers;


import com.Ugams.core.config.SchedulerConfiguration;

import com.Ugams.core.services.DemoService;
import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;


import org.osgi.service.component.annotations.*;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




@Component(immediate = true, service = UgamsScheduler.class)
@Designate(ocd = SchedulerConfiguration.class)
public class UgamsScheduler implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(UgamsScheduler.class);
    private int schedulerId;
    @Reference
    private Scheduler scheduler;
    @Reference
    DemoService Date;
    @Activate
    protected void activate(SchedulerConfiguration config) {
        schedulerId = config.schedulerName().hashCode();
        addScheduler(config);
    }

    @Deactivate
    protected void deactivate(SchedulerConfiguration config) {
        removeScheduler();
    }

    private void removeScheduler() {
        scheduler.unschedule(String.valueOf(schedulerId));
    }

    private void addScheduler(SchedulerConfiguration config) {
        ScheduleOptions scheduleOptions = scheduler.EXPR(config.cronExpression());
        scheduleOptions.name(String.valueOf(schedulerId));
        scheduleOptions.canRunConcurrently(true);
        scheduler.schedule(this, scheduleOptions);
        LOG.info("\n ---------Scheduler added----------");

    }
    @Override
    public void run() {
        LOG.info("\n ====> RUN METHOD  ");
        Date.addProperty();
    }
}