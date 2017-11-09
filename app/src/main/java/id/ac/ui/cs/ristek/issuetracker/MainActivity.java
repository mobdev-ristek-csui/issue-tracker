package id.ac.ui.cs.ristek.issuetracker;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import id.ac.ui.cs.ristek.issuetracker.api.ApiAdapter;
import id.ac.ui.cs.ristek.issuetracker.fragment.HomeFragment;
import id.ac.ui.cs.ristek.issuetracker.fragment.HomeFragment_;
import id.ac.ui.cs.ristek.issuetracker.fragment.MyIssuesFragment;
import id.ac.ui.cs.ristek.issuetracker.fragment.MyIssuesFragment_;
import id.ac.ui.cs.ristek.issuetracker.fragment.ProfileFragment;
import id.ac.ui.cs.ristek.issuetracker.fragment.ProfileFragment_;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @Bean
    ApiAdapter api;
    @ViewById(R.id.bottom_bar_main)
    BottomBar bottomBar;
    HomeFragment homeFragment;
    MyIssuesFragment myIssuesFragment;
    ProfileFragment profileFragment;
    Fragment currentFragment;
    FragmentTransaction ft;

    @AfterViews
    void init(){
        initFragment();
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                ft = getSupportFragmentManager().beginTransaction();
                if (tabId == R.id.tab_home) {
                    currentFragment = homeFragment;
                }else if(tabId == R.id.tab_my_issues){
                    currentFragment = myIssuesFragment;
                }else if(tabId == R.id.tab_profile){
                    currentFragment = profileFragment;
                }
                ft.replace(R.id.layout_main_content_container, currentFragment);
                ft.commit();
            }
        });
    }

    void initFragment(){
        homeFragment = HomeFragment_.builder().build();
        myIssuesFragment = MyIssuesFragment_.builder().build();
        profileFragment = ProfileFragment_.builder().build();
    }

}
