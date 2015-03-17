package model.bo;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFormat;
import java.util.Random;
//</editor-fold>

public class Ellusion1Bo {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    private static String toBinaryString(int i) {
        return Integer.toBinaryString(i);
    }

    private static String toBinaryString(int i, int length) {
        return CCFormat.pack(toBinaryString(i), "0", length);
    }

    protected static boolean isNewItem(int[] aryInt, int newInt) {
        for (int i : aryInt) {
            if (i == newInt) {
                return false;
            }
        }
        return true;
    }
//</editor-fold>

    public static String[] getBinaryGroup(int maxNumber) {
        //step 1. mengelompokkan bilangan berdasarkan susunan binary-nya
        int binaryStringLength = toBinaryString(maxNumber).length();
        String[][] aryString = new String[binaryStringLength][maxNumber];
        for (int number = 1; number <= maxNumber; number++) {
            char[] aryChar = toBinaryString(number, binaryStringLength).toCharArray();
            for (int index = 0; index < binaryStringLength; index++) {
                aryString[index][number - 1] =
                        String.valueOf(aryChar[binaryStringLength - 1 - index]).equalsIgnoreCase("1")
                        ? String.valueOf(number)
                        : "";
            }
        }
        //step 2. merapikan array agar lebih mudah dibaca
        String[] aryString2 = new String[binaryStringLength];
        for (int index = 0; index < binaryStringLength; index++) {
            String string2 = "";
            for (String string : aryString[index]) {
                if (!string.isEmpty()) {
                    string2 += (string2.isEmpty() ? "" : ", ") + string;
                }
            }
            aryString2[index] = string2;
        }
        return aryString2;
    }

    public static Object[] shuffle(Object[] aryObject0) {
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
        Object[] aryObject1 = new Object[size0];
        for (int index = 0; index < size0; index++) {
            aryObject1[index] = aryObject0[newIndex[index]];
        }
        return aryObject1;
    }

    public static void main(String[] args) {
        String[] ses = getBinaryGroup(10);
        for (String string : ses) {
            System.out.println(string);
        }
        System.out.println("-");
        Object[] os = shuffle(ses);
        for (Object o : os) {
            System.out.println(o);
        }
    }
}