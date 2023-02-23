package interviewShowcaseAutomation.constants;

public enum EndPoint {
    STORE("/store"),
    ACCOUNT("/account"),
    ADD_TO_CART("/?wc-ajax=add_to_cart"),
    CHECKOUT("/checkout"),
    WEATHER("/comments"),

    DATA("/comments/1"),

    HOME(""),

    USERSLIST("/api/users"),

    SINGLEUSER("/api/users/2"),

    CREATEUSER("/api/users"),

    SEARCH("/search") ;

    public final String url;

    EndPoint(String url) {
        this.url = url;
    }
}
