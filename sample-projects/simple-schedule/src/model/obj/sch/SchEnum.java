package model.obj.sch;

public class SchEnum {

    public enum Repetition {

        ONCE("Once"), WEEKLY("Weekly");
        private String string;

        private Repetition(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }
}