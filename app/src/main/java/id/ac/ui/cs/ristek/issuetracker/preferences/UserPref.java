package id.ac.ui.cs.ristek.issuetracker.preferences;

import org.androidannotations.annotations.sharedpreferences.DefaultString;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Created by faqrulan on 10/7/17.
 */
@SharedPref(value=SharedPref.Scope.UNIQUE)
public interface UserPref {

    @DefaultString("123")
    String npm();

}
