package id.ac.ui.cs.ristek.issuetracker.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.ristek.issuetracker.R;
import id.ac.ui.cs.ristek.issuetracker.adapter.IssueAdapter;
import id.ac.ui.cs.ristek.issuetracker.model.IssuePlaceHolder;

/**
 * Created by faqrulan on 10/7/17.
 */
@EFragment(R.layout.fragment_my_issues)
public class MyIssuesFragment extends Fragment {

    @ViewById
    RecyclerView rv;

    @AfterViews
    void init() {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("My Issues");
        final List<IssuePlaceHolder> issues = new ArrayList<>();

        issues.add(new IssuePlaceHolder("Kantin terlalu ramai", "Vincent", "Setiap semester ganjil, kantin menjadi terlalu penuh", 10, 20));
        issues.add(new IssuePlaceHolder("Kantin makanannya ayam semua", "Cesa", "jenis makanan di kantin kurang bervariasi", 12, 15));
        issues.add(new IssuePlaceHolder("MobDev keseringan minta makanan", "Jowin", "setiap kali internal class, selalu ada request makanan lol", 3, 2));

//        IssueAdapter issueAdapter = new IssueAdapter(getContext(), issues);

        rv.setLayoutManager(new LinearLayoutManager(getContext()));
//        rv.setAdapter(issueAdapter);
    }
}

