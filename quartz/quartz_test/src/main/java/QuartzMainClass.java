import job.JobTest;
import job.JobTest2;
import job.JobTest3;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.spi.JobStore;

public class QuartzMainClass {


    public static void main(String[] args) {

        try {
            ScheduleCreater scheduleCreater = new ScheduleCreater(new StdSchedulerFactory().getScheduler());

            scheduleCreater.createSchedule(JobTest.class, "0/5 * * * * ?");
            scheduleCreater.createSchedule(JobTest2.class, "10 * * * * ?");
            scheduleCreater.createSchedule(JobTest3.class, "15 * * * * ?");

            scheduleCreater.startSchedule();

        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }

    }
}
