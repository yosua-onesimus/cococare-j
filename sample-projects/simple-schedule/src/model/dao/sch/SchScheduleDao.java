package model.dao.sch;

//<editor-fold defaultstate="collapsed" desc=" import ">
import java.util.Date;
import java.util.List;
import model.mdl.sch.ScheduleDao;
import model.obj.sch.SchPerson;
import model.obj.sch.SchSchedule;
//</editor-fold>

public class SchScheduleDao extends ScheduleDao {

    @Override
    protected Class getEntity() {
        return SchSchedule.class;
    }

    private void _addWherePerson(Hql hql, Parameters parameters, SchPerson person) {
        hql.where("person = :person");
        parameters.set("person", person);
    }

    private void _addWhereDateRange(Hql hql, Parameters parameters, Date dateBegin, Date dateEnd) {
        hql.where("((repetitionIndex = 0 AND (dateBegin <= :dateEnd AND dateEnd >= :dateBegin)) "
                + "OR (repetitionIndex = 1 AND DAYOFWEEK(dateBegin) >= DAYOFWEEK(:dateBegin) AND DAYOFWEEK(dateBegin) <= DAYOFWEEK(:dateEnd)))");
        parameters.set("dateBegin", dateBegin).set("dateEnd", dateEnd);
    }

    private void _addWhereTimeRange(Hql hql, Parameters parameters, Date timeBegin, Date timeEnd) {
        hql.where("(timeBegin <= :timeEnd AND timeEnd > :timeBegin)");
        parameters.set("timeBegin", timeBegin).set("timeEnd", timeEnd);
    }

    public SchSchedule getTimeRange(SchPerson person, Date dateBegin, Date dateEnd) {
        hql.start().
                select("new SchSchedule(MIN(timeBegin), MAX(timeEnd))");
        parameters.start();
        _addWherePerson(hql, parameters, person);
        _addWhereDateRange(hql, parameters, dateBegin, dateEnd);
        return (SchSchedule) getBy(hql.value(), parameters.value());
    }

    public List<SchSchedule> getSchedules(SchPerson person, Date dateBegin, Date dateEnd, Date timeBegin, Date timeEnd) {
        hql.start();
        parameters.start();
        _addWherePerson(hql, parameters, person);
        _addWhereDateRange(hql, parameters, dateBegin, dateEnd);
        _addWhereTimeRange(hql, parameters, timeBegin, timeEnd);
        return getListBy(hql.value(), parameters.value());
    }
}