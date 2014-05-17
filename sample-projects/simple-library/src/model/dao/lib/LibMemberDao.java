package model.dao.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import model.mdl.lib.LibraryDao;
import model.obj.lib.LibMember;
//</editor-fold>

public class LibMemberDao extends LibraryDao {

    @Override
    protected Class getEntity() {
        return LibMember.class;
    }
}