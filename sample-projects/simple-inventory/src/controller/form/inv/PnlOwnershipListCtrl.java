package controller.form.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.getBoolean;
import static cococare.common.CCLogic.isNotNull;
import static cococare.common.CCLogic.isNull;
import cococare.database.CCHibernateFilter;
import cococare.framework.swing.CFSwingCtrl;
import java.util.List;
import model.bo.inv.InvRecalculationBo;
import model.obj.inv.InvOwnership;
//</editor-fold>

public class PnlOwnershipListCtrl extends CFSwingCtrl {

    private InvRecalculationBo recalculationBo;

    @Override
    protected Class _getEntity() {
        return InvOwnership.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
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
    protected void _initTable() {
        super._initTable();
        if (isNotNull(parameter.get("employee"))) {
            tblEntity.setHqlFilters(new CCHibernateFilter() {
                @Override
                public String getFieldName() {
                    return "employee";
                }

                @Override
                public Object getFieldValue() {
                    return parameter.get("employee");
                }
            });
        }
    }

    @Override
    protected void _doShowScreen() {
        if (isNull(parameter.get("employee"))) {
            super._doShowScreen();
        }
    }

    @Override
    protected boolean _doDeleteEntity() {
        if (getBoolean(parameter.get("employee_newEntity"))) {
            return ((List) parameter.get("ownerships")).remove(_getSelectedItem());
        } else {
            InvOwnership ownership = (InvOwnership) _getSelectedItem();
            return super._doDeleteEntity() && tblEntity.saveOrUpdate(recalculationBo.recalcInventory(ownership.getInventory()));
        }
    }

    @Override
    public void doUpdateTable() {
        if (getBoolean(parameter.get("employee_newEntity"))) {
            tblEntity.setList((List) parameter.get("ownerships"));
        } else {
            super.doUpdateTable();
        }
    }
}