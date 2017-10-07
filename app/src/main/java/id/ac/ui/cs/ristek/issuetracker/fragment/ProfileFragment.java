package id.ac.ui.cs.ristek.issuetracker.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import id.ac.ui.cs.ristek.issuetracker.R;

/**
 * Created by faqrulan on 10/7/17.
 */
@EFragment(R.layout.fragment_profile)
public class ProfileFragment  extends Fragment {

    @AfterViews
    void init(){
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Profile");
    }

}
