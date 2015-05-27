package model.obj.fb;

public class FbEnum {

    public enum ActionType {

        COMMAND("Command"), CONDITION("Condition"), SKILL("Skill");
        private String string;

        private ActionType(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }
}