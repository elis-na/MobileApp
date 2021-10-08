package umn.ac.id;

import android.widget.ImageView;

import java.io.Serializable;

public class SumberLagu implements Serializable {
    private String judul;
    private String penyanyi;

    public SumberLagu (String judul, String penyanyi){
        this.judul = judul;
        this.penyanyi = penyanyi;

    }

    public String getJudul() { return this.judul; }
    public String getPenyanyi() { return this.penyanyi; }


    public void setJudul(String judul){ this.judul = judul; }
    public void setPenyanyi(String penyanyi) {
        this.penyanyi = penyanyi;
    }


    public String toString() { return this.getJudul() + " => "
            + this.getPenyanyi(); }

}
