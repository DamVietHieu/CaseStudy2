package Library.Entities;

public class DauSach{

    private String maDauSach, tenSach,theLoai,tacGia,soluong, trangThai;

    public DauSach() {
        this.maDauSach = "";
        this.tenSach = "";
        this.theLoai = "";
        this.tacGia = "";
        this.trangThai = "";
        this.soluong = "";
    }

    public DauSach(DauSach Dausach) {
        this.maDauSach = Dausach.getMaDauSach();
        this.tenSach = Dausach.getTenSach();
        this.theLoai = Dausach.getTheLoai();
        this.tacGia = Dausach.getTacGia();
        this.soluong = Dausach.getSoluong();
        this.trangThai = Dausach.getTrangThai();
    }

    public DauSach(String maDauSach, String tenSach, String theLoai, String tacGia,String soluong, String trangThai) {
        this.maDauSach =  maDauSach;
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.tacGia = tacGia;
        this.soluong = soluong;
        this.trangThai = trangThai;
    }

    public void hienThi() {

        System.out.printf("%-15s | %-25s | %-30s | %-15s | %-15s | %-20s |\n",
                getMaDauSach(),
                getTenSach(),
                getTheLoai(),
                getTacGia(),
                getSoluong(),
                getTrangThai());
    }

    @Override
    public String toString() {
        return getMaDauSach() + "#"
                + getTenSach() + "#"
                + getTheLoai() + "#"
                + getTacGia() + "#"
                + getSoluong()+"#"
                + getTrangThai();
    }

    public void capNhat(DauSach Dausach) {
//        this.maNhanVien = nhanVien.getMaNhanVien();
        this.tenSach = Dausach.getTenSach();
        this.theLoai = Dausach.getTheLoai();
        this.tacGia = Dausach.getTacGia();
        this.soluong = Dausach.getSoluong();
        this.trangThai = Dausach.getTrangThai();
    }

    public void capNhat(String maDauSach, String tenSach, String theLoai, String tacGia,String soluong, String trangThai) {
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.tacGia = tacGia;
        this.soluong = soluong;
        this.trangThai = trangThai;
    }

    public String getMaDauSach() {
        return  maDauSach;
    }

    public void setMaDauSach(String  maSach) {
        this. maDauSach =  maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void settheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }
    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

}