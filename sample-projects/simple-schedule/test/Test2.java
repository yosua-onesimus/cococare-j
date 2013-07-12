
import cococare.common.CCFormat;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        Person person = new Person();
        person.name = "Yosua";
        Schedule schedule = new Schedule();
        schedule.person = person;
        schedule.dateBegin = CCFormat.getDate("201304011200", "yyyyMMddHHmm");
        schedule.dateEnd = CCFormat.getNextHour(schedule.dateBegin);
        List<Schedule> schedules = new ArrayList();
        schedules.add(schedule);

        Schedule schedule2 = new Schedule();
        schedule2.person = person;
        schedule2.dateBegin = CCFormat.getDate("201304081000", "yyyyMMddHHmm");
        schedule2.dateEnd = CCFormat.getNextHour(schedule2.dateBegin);
        schedules.add(schedule2);

        Schedule schedule3 = new Schedule();
        schedule3.person = person;
        schedule3.dateBegin = CCFormat.getDate("201304021130", "yyyyMMddHHmm");
        schedule3.dateEnd = CCFormat.getNextMinute(schedule3.dateBegin, 30);

        for (Schedule s : schedules) {
            int i;
            System.out.println(s.dateBegin);
            System.out.println(i = CCFormat.getDayOfWeek(s.dateBegin));
            System.out.println(CCFormat.getDayName(i));
            if (!schedule3.dateEnd.after(s.dateBegin) || !schedule3.dateBegin.before(s.dateEnd)) {
            } else {
                System.out.println("fail");
            }
        }
    }
}

enum Repetition {

    ONCE, WEEKLY, RANGE;
}

class Person {

    String name;
}

class Schedule {

    Repetition repetition;
    Date dateBegin;
    Date dateEnd;
    Time timeBegin;
    Time timeEnd;
    String description;
    Person person;
}