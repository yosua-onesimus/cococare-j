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
        ASIDE_POINT("Aside Point"),//mergeable
        MERGE_POINT("Merge Point"),
        SPLIT_POINT("Split Point"),//unmergeable
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
        POOLING("Pooling"),//WfActivity.receiverRole
        RANDOM("Random"),//WfActivity.receiverRole
        WEIGHTAGE("Weightage"),//WfActivity.receiverRole and WfActivity.weight
        ROUND_ROBIN("Round Robin"),//WfActivity.receiverRole
        RETURN_TO_LAST_USER("Return to Last User");//WfWorkflowHistory.user
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