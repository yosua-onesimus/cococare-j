package model.obj.bljr;

public class Enum {

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

    public enum BloodType {

        UNKNOWN("~"), A("A"), B("B"), AB("AB"), O("O");
        private String string;

        private BloodType(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }
}