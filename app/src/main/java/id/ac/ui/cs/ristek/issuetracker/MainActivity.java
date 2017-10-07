package id.ac.ui.cs.ristek.issuetracker;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.bottom_bar_main)
    BottomBar bottomBar;

    @AfterViews
    void init(){
        Toast.makeText(MainActivity.this,"Anda ada di dalam Main Activity", Toast.LENGTH_SHORT).show();
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_home) {
                    // The tab with id R.id.tab_favorites was selected,
                    // change your content accordingly.
                }else if(tabId == R.id.tab_my_issues){

                }else if(tabId == R.id.tab_profile){

                }
            }
        });
    }

}
