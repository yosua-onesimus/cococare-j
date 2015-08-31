package cococare.framework.model.obj.wf;

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class WfEnum {

    public enum ActivityPointType {

        START_POINT("Start Point"),
        PLAIN_POINT("Plain Point"),
        MERGE_POINT("Merge Point"),
        FINAL_POINT("Final Point");
        private String string;

        private ActivityPointType(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }

    public enum TransitionRouteType {

        MANUAL("Manual"),//
        POOLING("Pooling"),//WfActivity.userRole
        RANDOM("Random"),//WfActivity.userRole
        WEIGHTAGE("Weightage"),//WfActivity.userRole and WfActivity.weight
        ROUND_ROBIN("Round Robin"),//WfActivity.userRole
        TO_LAST_USER("To Last User");//WfWorkflowHistory.user
        private String string;

        private TransitionRouteType(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }

    public enum WorkflowStatus {

        AVAILABLE("Available"),
        WAITING("Waiting"),//waiting for the merging
        PROCESSING("Processing"),//waiting for the asynchronous
        COMPLETED("Completed");
        private String string;

        private WorkflowStatus(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }
}