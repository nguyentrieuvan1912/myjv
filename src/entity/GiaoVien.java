package entity;

import java.util.Objects;

public class GiaoVien {
    private String maGv;
    private String tenGv;

    public GiaoVien(String magv) {
    	super();
    	this.maGv = magv;
    }
    public GiaoVien(String maGv, String tenGv) {
    	super();
        this.maGv = maGv;
        this.tenGv = tenGv;
    }

    public String getMaGv() {
        return maGv;
    }

    public void setMaGv(String maGv) {
        this.maGv = maGv;
    }

    public String getTenGv() {
        return tenGv;
    }

    public void setTenGv(String tenGv) {
        this.tenGv = tenGv;
    }

    @Override
    public String toString() {
        return maGv;
    }

	

}
