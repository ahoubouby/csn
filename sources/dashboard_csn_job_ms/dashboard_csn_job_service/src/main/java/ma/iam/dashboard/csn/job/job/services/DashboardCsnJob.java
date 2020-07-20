package ma.iam.dashboard.csn.job.job.services;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author K.ELBAGUARI
 *
 */
@Component
public class DashboardCsnJob implements Job {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JobService jobService;

    public void execute(JobExecutionContext context) throws JobExecutionException {

        logger.info("Job ** {} ** fired @ {}", context.getJobDetail().getKey().getName(), context.getFireTime());
        // System.out.println("Job ** {} ** fired @ {}");
        jobService.executeJob();
        logger.info("Next job scheduled @ {}", context.getNextFireTime());
        // System.out.println("Next job scheduled @ {}" + context.getNextFireTime());
    }
}
