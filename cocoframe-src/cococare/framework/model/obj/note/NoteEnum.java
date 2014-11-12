package cococare.framework.model.obj.note;

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class NoteEnum {

    public enum ReferenceType {

        ATTACHMENT("Attachment"), LINK("Link"), SHORTCUT("Shortcut");
        private String string;

        private ReferenceType(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }
}