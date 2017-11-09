package id.ac.ui.cs.ristek.issuetracker;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.jaredrummler.materialspinner.MaterialSpinner;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import id.ac.ui.cs.ristek.issuetracker.api.ApiAdapter;
import id.ac.ui.cs.ristek.issuetracker.model.Issue;
import id.ac.ui.cs.ristek.issuetracker.service.IssueService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@EActivity(R.layout.activity_create_issue)
public class CreateIssueActivity extends AppCompatActivity implements MaterialSpinner.OnItemSelectedListener {
    public static final String LOADING = "Loading...";
    public static final String DIALOG_TITLE = "Issue Tracker";
    public static final String TITLE = "Buat Issue Baru";
    @ViewById
    MaterialSpinner spinner;
    @ViewById(R.id.title_input)
    EditText titleInput;
    @ViewById(R.id.content_input)
    EditText contentInput;
    @ViewById
    CheckBox anonim;

    @Bean
    ApiAdapter apiAdapter;

    ProgressDialog progressDialog;

    @AfterViews
    void init() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(TITLE);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        spinner.setItems("Akademis", "Administrasi", "Fasilitas", "Keamanan");
        spinner.setOnItemSelectedListener(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(DIALOG_TITLE);
        progressDialog.setMessage(LOADING);
        progressDialog.setCancelable(true);
    }

    @Override
    public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Click
    public void createIssue() {
        progressDialog.show();
        apiAdapter.service(IssueService.class).createIssue(
                spinner.getSelectedIndex() + 1,
                titleInput.getText().toString(),
                contentInput.getText().toString(),
                anonim.isChecked()).enqueue(new Callback<Issue>() {
            @Override
            public void onResponse(Call<Issue> call, Response<Issue> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()) {
                    Toast.makeText(CreateIssueActivity.this, "sukses", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(CreateIssueActivity.this, "gagal", Toast.LENGTH_SHORT).show();
                    Log.d("wahyu", response.message());
                    Log.d("wahyu", response.raw().toString());
                    Log.d("wahyu", response.raw().request().toString());
                }
            }

            @Override
            public void onFailure(Call<Issue> call, Throwable t) {
                Toast.makeText(CreateIssueActivity.this, "gagal", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }
}
