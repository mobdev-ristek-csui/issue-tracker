package id.ac.ui.cs.ristek.issuetracker;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;

public class NewIssueActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private EditText mTopikMasalah;
    private EditText mKategori;
    private EditText mKeteranganPengaduan;
    private CheckBox mAnonim;
    private Button mCreate;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };


    RequestBody topikMasalah = RequestBody.create(MediaType.parse("text/plain"), mTopikMasalah.getText().toString());
    RequestBody kategori = RequestBody.create(MediaType.parse("text/plain"), mKategori.getText().toString());
    RequestBody keteranganPengaduan = RequestBody.create(MediaType.parse("text/plain"), mKeteranganPengaduan.getText().toString());
    RequestBody anonim = RequestBody.create(MediaType.parse("text/plain"), mAnonim.isActivated());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_issue);

        mTextMessage = (TextView) findViewById(R.id.message);
        mTopikMasalah = (EditText) findViewById(R.id.topik_masalah);
        mKategori = (EditText) findViewById(R.id.kategori);
        mKeteranganPengaduan = (EditText) findViewById(R.id.keterangan_pengaduan);
        mAnonim = (CheckBox) findViewById(R.id.anonim);
        mCreate = (Button) findViewById(R.id.create);

        mCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }



}
