package interviewShowcaseAutomation.pojoPayloadSerialization.usersAPI;

import interviewShowcaseAutomation.context.TestContext;

public class CreateUser {
    public CreateUser(TestContext context) {
        this.name = setName(context.userDetails.getName());
        this.job = setJob(context.userDetails.getJob());
    }
        private String name;
        private String job;

    public String getName() {
        return name;
    }

    private String setName(String name) {
        return name;
    }

    public String getJob() {
        return job;
    }

    private String setJob(String job) {
        return job;
    }
}
