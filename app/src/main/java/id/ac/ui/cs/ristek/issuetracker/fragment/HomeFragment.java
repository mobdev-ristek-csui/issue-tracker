package id.ac.ui.cs.ristek.issuetracker.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import id.ac.ui.cs.ristek.issuetracker.MainActivity;
import id.ac.ui.cs.ristek.issuetracker.R;
import id.ac.ui.cs.ristek.issuetracker.adapter.IssueAdapter;
import id.ac.ui.cs.ristek.issuetracker.api.ApiAdapter;
import id.ac.ui.cs.ristek.issuetracker.model.Issue;
import id.ac.ui.cs.ristek.issuetracker.model.IssueListResponse;
import id.ac.ui.cs.ristek.issuetracker.service.IssueService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by faqrulan on 10/7/17.
 */
@EFragment(R.layout.fragment_home)
public class HomeFragment extends Fragment {

    MenuItem searchItem;

    @Bean
    ApiAdapter apiAdapter;
    @ViewById
    RecyclerView rv;

    @AfterViews
    void init() {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Home");
        setHasOptionsMenu(true);
        apiAdapter.service(IssueService.class).getIssues().enqueue(new Callback<IssueListResponse>() {
            @Override
            public void onResponse(Call<IssueListResponse> call, Response<IssueListResponse> response) {
                IssueListResponse issueListResponse = response.body();
                if (response.isSuccessful() && issueListResponse != null) {
                    List<Issue> issues = issueListResponse.issues;
                    IssueAdapter issueAdapter = new IssueAdapter(getContext(), issues);
                    rv.setLayoutManager(new LinearLayoutManager(getContext()));
                    rv.setAdapter(issueAdapter);
                } else {
                    Toast.makeText(getContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<IssueListResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Terjadi kesalahan, periksa koneksi anda", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Click
    public void fab() {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.search_item, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = new SearchView(((MainActivity) getContext()).getSupportActionBar().getThemedContext());
        MenuItemCompat.setShowAsAction(item, MenuItemCompat.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        MenuItemCompat.setActionView(item, searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        searchView.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {

                                          }
                                      }
        );

    }
}
