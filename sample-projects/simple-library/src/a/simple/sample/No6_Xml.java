package a.simple.sample;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static a.simple.sample.No0_Static.initConfig;
import static a.simple.sample.No0_Static.newMember;
import static cococare.common.CCClass.getAssociativeArray;
import static cococare.common.CCMessage.println;
import cococare.datafile.CCDom;
import static cococare.datafile.CCFile.getFileSystArchFile;
import java.util.ArrayList;
import java.util.List;
import model.obj.lib.LibMember;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class No6_Xml {

    public static void main(String[] args) {
        initConfig();

        //write member to xml
        List<LibMember> members = new ArrayList();
        members.add(newMember("001", "Yosua Onesimus", "06/06/1984"));
        members.add(newMember("002", "Sari Heriati", "17/03/1984"));
        CCDom domWrite = new CCDom();
        domWrite.writeList("root", LibMember.class, members);
        domWrite.transform(getFileSystArchFile("member.xml"));

        //read member from xml
        CCDom domRead = new CCDom();
        domRead.read(getFileSystArchFile("member.xml"));
        members = domRead.readList(LibMember.class);
        for (LibMember member : members) {
            println(getAssociativeArray(member, null));
        }
        /**
         * output: code:001;fullName:Yosua Onesimus;suspend:false;
         * code:002;fullName:Sari Heriati;suspend:false;
         */
    }
}