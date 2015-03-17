package model.bo;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFormat;
import java.util.Date;
import java.util.Random;
import static model.bo.Ellusion1Bo.isNewItem;
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

    public static Object[][] horizontalShuffle(Object[][] aryObject0) {
        //step 1. init new index array with some value
        int size0 = aryObject0.length;
        int[] newIndex = new int[size0];
        for (int index = 0; index < size0; index++) {
            newIndex[index] = size0;
        }
        //step 2. generate new index
        int size1 = 0;
        Random random = new Random();
        while (size1 < size0) {
            int i = random.nextInt(size0);
            if (isNewItem(newIndex, i)) {
                newIndex[size1++] = i;
            }
        }
        //step 3. shuffle
        Object[][] aryObject1 = new Object[size0][aryObject0[0].length];
        for (int index1 = 0; index1 < size0; index1++) {
            for (int index2 = 0; index2 < aryObject0[0].length; index2++) {
                aryObject1[index1][index2] = aryObject0[newIndex[index1]][index2];
            }
        }
        return aryObject1;
    }

    public static Object[][] verticalShuffle(Object[][] aryObject0) {
        //step 1. init new index array with some value
        int size0 = aryObject0.length;
        int[] newIndex = new int[size0];
        for (int index = 0; index < size0; index++) {
            newIndex[index] = size0;
        }
        //step 2. generate new index
        int size1 = 0;
        Random random = new Random();
        while (size1 < size0) {
            int i = random.nextInt(size0);
            if (isNewItem(newIndex, i)) {
                newIndex[size1++] = i;
            }
        }
        //step 3. shuffle
        Object[][] aryObject1 = new Object[size0][aryObject0[0].length];
        for (int index1 = 0; index1 < size0; index1++) {
            for (int index2 = 0; index2 < aryObject0[0].length; index2++) {
                aryObject1[index1][index2] = aryObject0[index1][newIndex[index2]];
            }
        }
        return aryObject1;
    }

    public static void main(String[] args) {
        Integer[][] ises = getTodayMatrix();
        for (Integer[] is : ises) {
            for (Integer i : is) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
        System.out.println("-");
        Object[][] oses = horizontalShuffle(verticalShuffle(ises));
        for (Object[] os : oses) {
            for (Object o : os) {
                System.out.print(o + " ");
            }
            System.out.println("");
        }
    }
}