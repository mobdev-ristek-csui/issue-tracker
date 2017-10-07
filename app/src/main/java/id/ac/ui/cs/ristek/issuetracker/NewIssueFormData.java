package id.ac.ui.cs.ristek.issuetracker;

/**
 * Created by Sang Agung Raditya P on 10/7/2017.
 */

public class NewIssueFormData {

    public String topikMasalah;
    public String kategori;
    public String keteranganPengaduan;
    public boolean isAnonymous;

    public NewIssueFormData(String topikMasalah, String kategori, String keteranganPengaduan, boolean isAnonymous){
        this.topikMasalah = topikMasalah;
        this.kategori = kategori;
        this.keteranganPengaduan = keteranganPengaduan;
        this.isAnonymous = isAnonymous;
    }
}
