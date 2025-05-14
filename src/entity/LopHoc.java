package entity;

import java.util.Objects;

public class LopHoc {
    private String maLop;
    private String tenLop;
    private GiaoVien giaoVien;
    private int siso;

    public LopHoc(String maLop, String tenLop, GiaoVien giaoVien, int siso) {

        this.maLop = maLop;
        this.tenLop = tenLop;
        this.giaoVien = giaoVien;
        this.siso = siso;
    }
    
    public LopHoc(String maLop) {
    	super();
    	this.maLop = maLop;
    }
    
    public LopHoc(GiaoVien giaoVien) {
    	super();
    	this.giaoVien = giaoVien;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    } 

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public GiaoVien getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(GiaoVien giaoVien) {
        this.giaoVien = giaoVien;
    }

    public int getSiso() {
        return siso;
    }

    public void setSiso(int siso) {
        this.siso = siso;
    }

    @Override
    public String toString() {
        return "LopHoc [maLop=" + maLop + ", tenLop=" + tenLop + ", maGiaoVien=" + giaoVien + ", siso=" + siso + "]";
    }

    @Override 
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result +((maLop==null)? 0 : maLop.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LopHoc other = (LopHoc) obj;
        if(maLop == null) {
        	if(other.maLop != null)
        		return false;
        } else if(!maLop.equals(other.maLop))
        	return false;
        return true;
    }
}
