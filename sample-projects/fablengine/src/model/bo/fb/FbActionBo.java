package model.bo.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCLogic.isEmpty;
import cococare.database.CCHibernateBo;
import java.util.List;
import model.obj.fb.FbActionAttribute;
//</editor-fold>

public class FbActionBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public synchronized String getAttributes(List<FbActionAttribute> actionAttributes) {
        String attributes = "";
        for (FbActionAttribute actionAttribute : actionAttributes) {
            attributes += (isEmpty(attributes) ? "" : ", ") + actionAttribute.getAttribute().getName();
        }
        return attributes;
    }
//</editor-fold>
}