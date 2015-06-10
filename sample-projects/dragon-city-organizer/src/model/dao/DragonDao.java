package model.dao;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.parseInt;
import java.util.List;
import model.mdl.DragonCityOrganizerDao;
import model.obj.Dragon;
import model.obj.Habitat;
import model.obj.HabitatType;
//</editor-fold>

public class DragonDao extends DragonCityOrganizerDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return Dragon.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public List<Dragon> getListUnlimitedBy(HabitatType habitatType) {
        hql.start().
                where(":habitatType IN (habitatType1, habitatType2, habitatType3)");
        parameters.start().
                set("habitatType", habitatType);
        return getListUnlimitedBy(hql.value(), parameters.value());
    }

    public int sumRevenuesTotal(Habitat habitat) {
        hql.start().
                select("SUM(revenuesTotal)").
                where("habitat = :habitat");
        parameters.start().
                set("habitat", habitat);
        return parseInt(getBy(hql.value(), parameters.value()));
    }
//</editor-fold>
}