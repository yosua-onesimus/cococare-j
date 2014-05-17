package a.simple.sample;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static a.simple.sample.No0_Static.initConfig;
import static a.simple.sample.No0_Static.newMember;
import static cococare.common.CCClass.getAssociativeArray;
import static cococare.common.CCMessage.println;
import static cococare.datafile.CCFile.getFileSystArchFile;
import cococare.datafile.jxl.CCExcel;
import java.util.ArrayList;
import java.util.List;
import model.obj.lib.LibMember;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class No7_Xls {

    public static void main(String[] args) {
        initConfig();

        //write member to xls
        List<LibMember> members = new ArrayList();
        members.add(newMember("001", "Yosua Onesimus", "06/06/1984"));
        members.add(newMember("002", "Sari Heriati", "17/03/1984"));
        CCExcel excelWrite = new CCExcel();
        excelWrite.newWorkbook();
        excelWrite.newSheet("member");
        excelWrite.initEntity(LibMember.class, true);
        excelWrite.writeRowEntityHeader();
        excelWrite.writeRowEntity(members);
        excelWrite.saveAndCloseWorkbook(getFileSystArchFile("member.xls"));

        //read member from xls
        CCExcel excelRead = new CCExcel();
        excelRead.openWorkbook(getFileSystArchFile("member.xls"));
        excelRead.getSheet("member");
        excelRead.initEntity(LibMember.class, true);
        members = excelRead.readRowEntity(1, excelRead.getRowCount() - 1);
        for (LibMember member : members) {
            println(getAssociativeArray(member, null));
        }
        /**
         * output: code:001;fullName:Yosua Onesimus;suspend:false;
         * code:002;fullName:Sari Heriati;suspend:false;
         */
    }
}