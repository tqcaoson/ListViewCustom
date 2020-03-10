package com.example.customlistview;

public class MusicModel {
    private int idAnh;
    private String tenBaiHat, tenCaSi, thoiGian;

    public MusicModel(int idAnh, String tenBaiHat, String tenCaSi, String thoiGian) {
        this.idAnh = idAnh;
        this.tenBaiHat = tenBaiHat;
        this.tenCaSi = tenCaSi;
        this.thoiGian = thoiGian;
    }

    public int getIdAnh() {
        return idAnh;
    }

    public void setIdAnh(int idAnh) {
        this.idAnh = idAnh;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getTenCaSi() {
        return tenCaSi;
    }

    public void setTenCaSi(String tenCaSi) {
        this.tenCaSi = tenCaSi;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }
}
