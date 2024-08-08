package com.iisi.jobrunr;

import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.scheduling.cron.Cron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()

public class JobRunController {
    @Autowired
    private JobScheduler jobScheduler;
    @Autowired
    private RunnerService runnerService;

    @RequestMapping(value = {"/runJob"}, produces = "application/json;charset=UTF-8")
    public String runJob() {
        jobScheduler.enqueue(() -> runnerService.execute("Test Simple Job"));
        return "Job is running";
    }
    @RequestMapping(value = {"/runRepJob"}, produces = "application/json;charset=UTF-8")
    public String runRepJob(){
        jobScheduler
                .scheduleRecurrently(Cron.minutely(),
                        () -> runnerService.execute("Test recurring scheduled job"));
        return "RepJob is running";
    }
}