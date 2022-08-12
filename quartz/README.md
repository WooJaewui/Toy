# Quartz
- Quartz가 어떻게 동작하는지 확인하기 위한 프로젝트.

---
> ### ScheduleCreater.
- createSchedule() : 스케쥴을 등록하는 메소드. 
- startSchedule() :  스케쥴을 실행하는 메소드.

> ### QuartzMainClass.
- ScheduleCreater 인스턴스를 생성하여 스케쥴을 추가하고 실행하는 main 메소드를 가진 클래스.

> ### Job 패키지 클래스.
- Job을 implements하여 execute를 override해서 실행할 메서드를 작성한다.
- ex ) JobTest, JobTest2, JobTest3.

> ### 기타.
- cron 표현식을 실수하게 되면 일정이 제대로 동작하지 않으므로 테스트를 꼭 하고 적용하자.
- cron 테스트 : http://www.cronmaker.com/?0
