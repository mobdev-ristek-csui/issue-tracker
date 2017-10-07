package id.ac.ui.cs.ristek.issuetracker;

import com.squareup.okhttp.RequestBody;

import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Sang Agung Raditya P on 10/7/2017.
 */

public interface NewSubmissionService {
    @Multipart
    @POST("XXXX")
    Call<NewIssueFormData> newIssue(@Part("topik") RequestBody topikMasalah,
                                    @Part("kategori") RequestBody kategori,
                                    @Part("keterangan_pengaduan") RequestBody keteranganPengaduan,
                                    @Part("anonim") RequestBody anonim);
}
