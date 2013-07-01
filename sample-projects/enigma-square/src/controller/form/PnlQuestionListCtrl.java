package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCMessage;
import cococare.framework.swing.CFSwingCtrl;
import model.mdl.EnigmaSquareMain;
import model.obj.Question;
//</editor-fold>

public class PnlQuestionListCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return Question.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    public void doUpdateTable() {
        tblEntity.setList(EnigmaSquareMain.questions);
    }

    @Override
    protected boolean _doDeleteEntity() {
        return EnigmaSquareMain.questions.remove((Question) tblEntity.getSelectedItem());
    }

    @Override
    protected void _doExport() {
        CCMessage.showSaved(EnigmaSquareMain.saveQuestions());
    }
}