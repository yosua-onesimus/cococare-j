package model.obj;

public class Enum {

    public enum AutoAnswer {

        FALSE("False"), TRUE("True");
        private String string;

        private AutoAnswer(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }

    public enum GameMode {

        ONE_LOSSER("1 tertinggal"), ONE_WINNER("1 juara"), TEN_TURN("10 giliran"), TEN_MINUTE("10 menit");
        private String string;

        private GameMode(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }

    public enum QuestionOrder {

        SEQUENCE("Berurutan"), RANDOM("Acak");
        private String string;

        private QuestionOrder(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }
}