package id.ac.ui.cs.ristek.issuetracker.preferences;


import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.sharedpreferences.Pref;

/**
 * Created by faqrulan on 10/7/17.
 */
@EBean(scope = EBean.Scope.Singleton)
public class UserData {

    @Pref
    public UserPref_ userPref;

    public String getNPM(){
        return userPref.npm().get();
    }

    public void setNPM(String NPM){
        userPref.edit().npm().put(NPM).apply();
    }

}
