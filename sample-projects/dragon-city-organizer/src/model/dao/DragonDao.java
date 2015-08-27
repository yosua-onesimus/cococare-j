package model.dao;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.parseInt;
import static cococare.common.CCLogic.isNotNull;
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
    public List<Dragon> getListUnlimitedBy(HabitatType habitatType, Boolean hasHabitat) {
        hql.start().
                where(":habitatType IN (habitatType1, habitatType2, habitatType3, habitatType4)");
        parameters.start().
                set("habitatType", habitatType);
        if (isNotNull(hasHabitat)) {
            hql.where(hasHabitat ? "habitat IS NOT NULL" : "habitat IS NULL");
            if (!hasHabitat) {
                hql.orderBy("revenues DESC");
            }
        }
        return getListUnlimitedBy(hql.value(), parameters.value());
    }

    public long countBy(Habitat habitat) {
        return countByField("habitat", habitat, false);
    }

    public int sumRevenuesTotalBy(Habitat habitat) {
        hql.start().
                select("SUM(revenuesTotal)").
                where("habitat = :habitat");
        parameters.start().
                set("habitat", habitat);
        return parseInt(getBy(hql.value(), parameters.value()));
    }
//</editor-fold>
}