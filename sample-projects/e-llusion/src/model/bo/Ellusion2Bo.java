package model.bo;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFormat;
import java.util.Date;
//</editor-fold>

public class Ellusion2Bo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private static Integer[][] aryDefault = new Integer[][]{
        {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}
    };
//</editor-fold>

    public static Integer[][] getTodayMatrix() {
        Integer[][] aryToday = new Integer[4][4];
        Date today = new Date();
        int month = CCFormat.getMonth(today) + 1;
        int day = CCFormat.getDay(today);
        int mdTotal = (month * 100) + day - 34;
        int mdTotal_4 = (mdTotal / 4);
        int mdMod = mdTotal % 4;
        for (int index1 = 3; index1 >= 0; index1--) {
            for (int index2 = 0; index2 < 4; index2++) {
                aryToday[index1][index2] =
                        aryDefault[index1][index2] + (mdTotal_4)
                        + (mdMod > 0 ? 1 : 0);
            }
            if (mdMod > 0) {
                mdMod--;
            }
        }
        return aryToday;
    }

    public static void main(String[] args) {
        Integer[][] ises = getTodayMatrix();
        for (Integer[] is : ises) {
            for (Integer i : is) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }
}