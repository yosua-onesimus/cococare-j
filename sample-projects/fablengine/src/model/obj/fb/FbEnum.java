package model.obj.fb;

public class FbEnum {

    public enum AddRemove {

        ADD("+"), REMOVE("-");
        private String string;

        private AddRemove(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }
}