package com.example.ontapsqlite3;

public class QuanLyThuChi {
    private int khoanChi;
    private int khoanThu;

    public QuanLyThuChi() {
    }

    public QuanLyThuChi(int khoanChi, int khoanThu) {
        this.khoanChi = khoanChi;
        this.khoanThu = khoanThu;
    }

    public int getKhoanChi() {
        return khoanChi;
    }

    public void setKhoanChi(int khoanChi) {
        this.khoanChi = khoanChi;
    }

    public int getKhoanThu() {
        return khoanThu;
    }

    public void setKhoanThu(int khoanThu) {
        this.khoanThu = khoanThu;
    }
}
