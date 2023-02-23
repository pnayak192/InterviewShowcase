package interviewShowcaseAutomation.customtype;

import interviewShowcaseAutomation.domainobjects.BillingDetails;
import interviewShowcaseAutomation.domainobjects.UserDetails;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CustomDataTableType {

    @DataTableType
    public BillingDetails billingDetailsEntry(Map<String, String> entry){
        return new BillingDetails(entry.get("firstname"),
                entry.get("lastname"),
                entry.get("address_line1"),
                entry.get("city"),
                entry.get("state"),
                entry.get("zip"),
                entry.get("email"));
    }

    @DataTableType
    public UserDetails userDetails(Map<String, String> entry){
        return new UserDetails(entry.get("name"),
                entry.get("job"));
    }
}
