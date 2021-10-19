package hu.uni.miskolc.recyclerviewpelda.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Dolgozo implements Serializable {
    @SerializedName(value = "id")
    int dolgozoId;

    String keresztNev;

    String vezetekNev;

    int fizetes;

    public Dolgozo() {
    }

    public int getDolgozoId() {
        return dolgozoId;
    }

    public void setDolgozoId(int dolgozoId) {
        this.dolgozoId = dolgozoId;
    }

    public String getKeresztNev() {
        return keresztNev;
    }

    public void setKeresztNev(String keresztNev) {
        this.keresztNev = keresztNev;
    }

    public String getVezetekNev() {
        return vezetekNev;
    }

    public void setVezetekNev(String vezetekNev) {
        this.vezetekNev = vezetekNev;
    }

    public int getFizetes() {
        return fizetes;
    }

    public void setFizetes(int fizetes) {
        this.fizetes = fizetes;
    }

    @Override
    public String toString() {
        return "Dolgozo{" +
                "dolgozoId=" + dolgozoId +
                ", keresztNev='" + keresztNev + '\'' +
                ", vezetekNev='" + vezetekNev + '\'' +
                ", fizetes=" + fizetes +
                '}';
    }
}
