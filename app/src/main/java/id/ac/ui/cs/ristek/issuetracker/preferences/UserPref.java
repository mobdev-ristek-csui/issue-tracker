package id.ac.ui.cs.ristek.issuetracker.preferences;

/**
 * Created by faqrulan on 10/7/17.
 */

public class UserPref {

    private static UserPref instance;
    public String npm = "1506688891";

    public static UserPref instance() {
        if (instance == null) {
            instance = new UserPref();
        }
        return instance;
    }

}
