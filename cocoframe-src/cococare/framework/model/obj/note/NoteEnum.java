package cococare.framework.model.obj.note;

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class NoteEnum {

    public enum ObjectiveStatus {

        TO_DO("To Do"), DOING("Doing"), DONE("Done");
        private String string;

        private ObjectiveStatus(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }

    public enum TrackerType {

        NOTES("Notes"), NEW_FEATURE("New Feature"), ENHANCING("Enhancing"), ERROR_REPORT("Error Report"), ERROR_FIXING("Error Fixing");
        private String string;

        private TrackerType(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }
}