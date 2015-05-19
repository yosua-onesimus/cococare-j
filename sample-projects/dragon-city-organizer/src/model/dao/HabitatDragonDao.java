package model.dao;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.parseInt;
import java.util.List;
import model.mdl.DragonCityOrganizerDao;
import model.obj.Dragon;
import model.obj.Habitat;
import model.obj.HabitatDragon;
//</editor-fold>

public class HabitatDragonDao extends DragonCityOrganizerDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return HabitatDragon.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public List<Dragon> getDragonsUnlimited() {
        hql.start().
                select("dragon");
        parameters.start();
        return getListUnlimitedBy(hql.value(), parameters.value());
    }

    public int sumRevenuesTotal(Habitat habitat) {
        hql.start().
                alias("hd").
                select("SUM(hd.dragon.revenuesTotal)").
                where("hd.habitat = :habitat");
        parameters.start().
                set("habitat", habitat);
        return parseInt(getBy(hql.value(), parameters.value()));
    }
//</editor-fold>
}