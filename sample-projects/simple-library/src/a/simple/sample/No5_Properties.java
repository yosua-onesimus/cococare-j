package a.simple.sample;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static a.simple.sample.No0_Static.initConfig;
import static a.simple.sample.No0_Static.newMember;
import static cococare.common.CCClass.getAssociativeArray;
import static cococare.common.CCMessage.println;
import static cococare.datafile.CCFile.getFileSystArchFile;
import cococare.datafile.CCProperties;
import model.obj.lib.LibMember;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class No5_Properties {

    public static void main(String[] args) {
        initConfig();

        //write member to properties
        LibMember member = newMember("001", "Yosua Onesimus", "06/06/1984");
        CCProperties propertiesWrite = new CCProperties();
        propertiesWrite.setValue(member, false);
        propertiesWrite.storeExtern(getFileSystArchFile("member.prop"));

        //read member from properties
        CCProperties propertiesRead = new CCProperties();
        propertiesRead.loadExtern(getFileSystArchFile("member.prop"));
        member = (LibMember) propertiesRead.getValue(LibMember.class, false);
        println(getAssociativeArray(member, null));
        /**
         * output: code:001;fullName:Yosua Onesimus;suspend:false;
         */
    }
}