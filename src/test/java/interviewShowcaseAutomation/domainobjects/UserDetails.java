package interviewShowcaseAutomation.domainobjects;

public class UserDetails {

    public UserDetails(String name, String job) {
        this.name = name;
        this.job = job;
    }
    private String name;
    private String job;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
