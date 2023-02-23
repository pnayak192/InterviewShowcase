package interviewShowcaseAutomation.pojoResponseDeserialization.usersAPI;

import interviewShowcaseAutomation.pojoResponseDeserialization.usersAPI.getUsersListPojoClasses.Data;
import interviewShowcaseAutomation.pojoResponseDeserialization.usersAPI.getUsersListPojoClasses.Support;

public class GetSingleUser {

    private Data data;
    private Support support;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}
