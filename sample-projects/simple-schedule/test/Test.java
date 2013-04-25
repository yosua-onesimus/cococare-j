
import cococare.common.CCConfig;
import cococare.common.CCFormat;
import cococare.database.CCDatabaseConfig;
import cococare.database.CCHibernate;
import java.util.Date;
import java.util.List;
import model.dao.sch.SchScheduleDao;
import model.mdl.sch.ScheduleModule;
import model.obj.sch.SchPerson;
import model.obj.sch.SchSchedule;

public class Test {

    public static void main(String[] args) {
        CCConfig.MSG_SHOW_LOG_INFO = true;
        CCConfig.MSG_SHOW_LOG_SEVERE = true;
        /**
         * select min(timebegin) from schedule where person and 7-days-range
         * -----> x0 select max(timeend) from schedule where person and
         * 7-days-range -----> x1 select * from schedule where timebegin>x0 and
         * timeend<x1
         *
         */
        CCHibernate hibernate = new CCHibernate();
        ScheduleModule.INSTANCE.init(hibernate);
        hibernate.addDatabaseConfig(new CCDatabaseConfig().withPassword("1234").withDatabase("test"));
        SchPerson person = (SchPerson) hibernate.get(SchPerson.class, 1l);
        Date dateBegin = CCFormat.getDate("20130411", "yyyyMMdd");
        Date dateEnd = CCFormat.getDate("20130411", "yyyyMMdd");
        SchScheduleDao scheduleDao = new SchScheduleDao();
        SchSchedule tr = scheduleDao.getTimeRange(person, dateBegin, dateEnd);
        System.out.println(tr.getTimeBegin() + " -> " + tr.getTimeEnd());
        Date date = CCFormat.getMinMinuteSecondMilli(tr.getTimeBegin());
        while (date.before(CCFormat.getMaxMinuteSecondMilli(tr.getTimeEnd()))) {
            System.out.println(date + " -> " + CCFormat.getMaxMinuteSecondMilli(date));
            List<SchSchedule> schedules = scheduleDao.getSchedules(person, dateBegin, dateEnd, date, CCFormat.getMaxMinuteSecondMilli(date));
            if (!schedules.isEmpty()) {
                for (SchSchedule schedule : schedules) {
                    System.out.println("---------");
                    System.out.println(schedule.getDateBegin() + " -> " + schedule.getDateEnd() + " : " + schedule.getDescription());
                    System.out.println(schedule.getTimeBegin() + " -> " + schedule.getTimeEnd() + " : " + schedule.getDescription());
                    System.out.println("---------");
                }
            }
            date = CCFormat.getNextHour(date);
        }
    }
}