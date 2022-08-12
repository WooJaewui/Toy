import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.spi.JobFactory;


/**
 * Quartz
 * 1. 스케쥴 등록
 * 2. 쿼츠 실행
 *
 * @author GLIB
 */
public class ScheduleCreater {

    private final Scheduler scheduler;

    public ScheduleCreater(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    /**
     * createSchedule()
     * 스케쥴을 등록하는 메소드
     * @param clazz - Job을 상속받은 클래스 (execute 메서드를 통해 수행할 로직을 작성)
     * @param cronExpression - 크론 표현식
     *
     * ## 크론 표현식은 테스트 후 사용하기 ##
     * 크론 표현식 테스트 사이트 : http://www.cronmaker.com/;jsessionid=node01z4h1qwayvv81c4eivd8b67pf349328.node0?0
     */
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

    /**
     * startSchedule()
     * Quartz 스케쥴러를 실행하는 메서드.
     *
     * createSchedule 메서드를 통해 Job 등록 후 실행.
     */
    public void startSchedule() {
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

}
