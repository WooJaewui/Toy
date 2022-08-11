import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.spi.JobFactory;

public class ScheduleCreater {

    private final Scheduler scheduler;

    public ScheduleCreater(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void createSchedule(Class<? extends Job> clazz, String cronExpression) {

        try {

            JobDetail jobDetail = JobBuilder
                    .newJob(clazz)
                    .withIdentity(clazz.getName(), "groupName")
                    .build();

            Trigger trigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity(clazz.getName(), "groupName")
                    .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                    .build();

            scheduler.scheduleJob(jobDetail, trigger);

        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }

    }

    public void startSchedule() {
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

}
