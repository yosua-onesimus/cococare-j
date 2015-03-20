package a.simple.sample;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static a.simple.sample.No0_Static.initConfig;
import static a.simple.sample.No0_Static.initHibernate;
import static cococare.common.CCFormat.getLong;
import static cococare.common.CCFormat.pack;
import static cococare.common.CCLogic.isNull;
import static cococare.common.CCMessage.*;
import java.util.List;
import model.dao.lib.LibMemberDao;
import model.obj.lib.LibMember;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class No1_ConsoleSample {

    private LibMemberDao memberDao;

    public No1_ConsoleSample() {
        initConfig();
        initHibernate();
        memberDao = new LibMemberDao();
    }

    public void showMenu() {
        String menu;
        while (true) {
            println(pack("", "-", 45));
            println("1. Show Member List");
            println("2. Add Member");
            println("3. Edit Member");
            println("4. Delete Member");
            println("X. Exit");
            println("Your choice: ");
            menu = readln().toUpperCase();
            if ("1".equals(menu)) {
                _showMenu1();
            } else if ("2".equals(menu)) {
                _showMenu2();
            } else if ("3".equals(menu)) {
                _showMenu3();
            } else if ("4".equals(menu)) {
                _showMenu4();
            } else if ("X".equals(menu)) {
                System.exit(0);
            }
        }
    }

    private void _showMenu1() {
        println(pack("", "-", 45));
        println(pack("Id|", " ", 5)
                + pack("Code|", " ", 20)
                + pack("Name|", " ", 20));
        println(pack("", "-", 45));
        List<LibMember> members = memberDao.getList();
        for (LibMember member : members) {
            println(pack(member.getId() + ".|", " ", 5)
                    + pack(member.getCode() + "|", " ", 20)
                    + pack(member.getFullName() + "|", " ", 20));
        }
    }

    private void _showMenu2() {
        println(pack("", "-", 45));
        LibMember member = (LibMember) memberDao.initSequence(new LibMember());
        println("Code: " + member.getCode());
        println("Name: ");
        member.setFullName(readln());
        if (memberDao.saveOrUpdate(member)) {
            println("Member has been saved successfully");
            println("Member.getId(): " + member.getId());
        } else {
            println(getErrorMessage(), true);
        }
    }

    private void _showMenu3() {
        LibMember member = null;
        while (isNull(member)) {
            println(pack("", "-", 45));
            println("Enter Member Id: ");
            member = (LibMember) memberDao.getById(getLong(readln()));
        }
        println("Code: " + member.getCode());
        println("Name: ");
        member.setFullName(readln());
        if (memberDao.saveOrUpdate(member)) {
            println("Member has been saved successfully");
            println("Member.getId(): " + member.getId());
        } else {
            println(getErrorMessage(), true);
        }
    }

    private void _showMenu4() {
        LibMember member = null;
        while (isNull(member)) {
            println(pack("", "-", 45));
            println("Enter Member Id: ");
            member = (LibMember) memberDao.getById(getLong(readln()));
        }
        if (memberDao.delete(member)) {
            println("Member has been deleted successfully");
        } else {
            println(getErrorMessage(), true);
        }
    }

    public static void main(String[] args) {
        new No1_ConsoleSample().showMenu();
    }
}