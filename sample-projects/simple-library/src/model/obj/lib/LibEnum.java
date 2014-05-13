package model.obj.lib;

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class LibEnum {

    public enum Gender {

        MALE("Male"), FEMALE("Female");
        private String string;

        private Gender(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }

    public static void main(String[] args) {
        System.out.println(Gender.class);//--> class model.obj.lib.LibEnum$Gender
    }
}