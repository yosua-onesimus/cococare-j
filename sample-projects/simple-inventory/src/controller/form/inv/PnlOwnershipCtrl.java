package controller.form.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.getBoolean;
import static cococare.common.CCLogic.isNotNull;
import cococare.framework.swing.CFSwingCtrl;
import java.util.List;
import model.bo.inv.InvRecalculationBo;
import model.obj.inv.InvEmployee;
import model.obj.inv.InvOwnership;
//</editor-fold>

public class PnlOwnershipCtrl extends CFSwingCtrl {

    private InvRecalculationBo recalculationBo;

    @Override
    protected Class _getEntity() {
        return InvOwnership.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initObject() {
        super._initObject();
        if (newEntity && getBoolean(parameter.get("employee_newEntity"))) {
            newEntity = !((List) parameter.get("ownerships")).contains(objEntity);
        }
    }

    @Override
    protected String _getSysRef(Object objEntity) {
        if (getBoolean(parameter.get("employee_newEntity"))) {
            return objEntity.toString();
        } else {
            return super._getSysRef(objEntity);
        }
    }

    @Override
    protected void _initObjEntity() {
        super._initObjEntity();
        if (isNotNull(parameter.get("employee"))) {
            ((InvOwnership) objEntity).setEmployee((InvEmployee) parameter.get("employee"));
        }
    }

    @Override
    protected boolean _doSaveEntity() {
        if (getBoolean(parameter.get("employee_newEntity"))) {
            List list = (List) parameter.get("ownerships");
            return list.contains(objEntity) ? true : list.add(objEntity);
        } else {
            InvOwnership ownership = (InvOwnership) objEntity;
            return super._doSaveEntity() && edtEntity.saveOrUpdate(recalculationBo.recalcInventory(ownership.getInventory()));
        }
    }
}