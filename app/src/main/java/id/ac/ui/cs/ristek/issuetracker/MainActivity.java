package id.ac.ui.cs.ristek.issuetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.ristek.issuetracker.adapter.IssueAdapter;
import id.ac.ui.cs.ristek.issuetracker.model.Issue;
import id.ac.ui.cs.ristek.issuetracker.model.IssuePlaceHolder;

public class MainActivity extends AppCompatActivity {
    RecyclerView RV  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RV = (RecyclerView) findViewById(R.id.rv);
        final List<IssuePlaceHolder> issues = new ArrayList<>();

        issues.add(new IssuePlaceHolder("Kantin terlalu ramai", "Vincent", "Setiap semester ganjil, kantin menjadi terlalu penuh", 10, 20));
        issues.add(new IssuePlaceHolder("Kantin makanannya ayam semua", "Cesa", "jenis makanan di kantin kurang bervariasi", 12, 15));
        issues.add(new IssuePlaceHolder("MobDev keseringan minta makanan", "Jowin", "setiap kali internal class, selalu ada request makanan lol", 3, 2));

        IssueAdapter issueAdapter = new IssueAdapter(this, issues);

        RV.setLayoutManager(new LinearLayoutManager(this));
        RV.setAdapter(issueAdapter);

    }
}
