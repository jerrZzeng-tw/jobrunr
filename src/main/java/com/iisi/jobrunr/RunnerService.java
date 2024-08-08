package com.iisi.jobrunr;

import org.jobrunr.jobs.annotations.Job;
import org.springframework.stereotype.Service;

@Service
public class RunnerService {
    @Job(name = "Simple job")
    public void execute() {
        execute("Hello Simple job");
    }

    @Job(name = "The parametrized job")
    public void execute(String input) {
        System.out.println("The parameterized job with input :" + input);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Error while executing job");
        } finally {
            System.out.println("job has finished...");
        }
    }
}