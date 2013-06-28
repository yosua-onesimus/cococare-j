package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCMessage;
import cococare.framework.swing.CFSwingCtrl;
import model.mdl.SnakeAndLadderMain;
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
        tblEntity.setList(SnakeAndLadderMain.questions);
    }

    @Override
    protected boolean _doDeleteEntity() {
        return SnakeAndLadderMain.questions.remove((Question) tblEntity.getSelectedItem());
    }

    @Override
    protected void _doExport() {
        CCMessage.showSaved(SnakeAndLadderMain.saveQuestions());
    }
}