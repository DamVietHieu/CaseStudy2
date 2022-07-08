package Library.Entities;


public class Sach {

    private String maSach, maDauSach, tenSach, theLoai, tacgia, tinhTrang;

    public Sach() {
        this.maDauSach = "";
        this.maSach = "";
        this.tenSach = "";
        this.theLoai = "";
        this.tacgia = "";
        this.tinhTrang = "";
    }

    public Sach(Sach Sach) {
        this.maDauSach = Sach.getMaDauSach();
        this.maSach = Sach.getMasach();
        this.tenSach = Sach.getTenSach();
        this.theLoai = Sach.getTheLoai();
        this.tacgia = Sach.getTacgia();
        this.tinhTrang = Sach.getTinhTrang();

    }

    public Sach(String maSach, String maDauSach, String tenSach, String theLoai, String tacgia, String tinhTrang) {
        this.maDauSach = maDauSach;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.tacgia = tacgia;
        this.tinhTrang = tinhTrang;
    }

    public Sach(String maSach, String tenSach, String theLoai, String tacgia, String tinhTrang) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.tacgia = tacgia;
        this.tinhTrang = tinhTrang;
    }

    public void hienThi() {
        System.out.printf("%-10s | %-30s | %-30S | %-15s | %-15s |%-20s|\n",
                getMasach(),
                getMaDauSach(),
                getTenSach(),
                getTheLoai(),
                getTacgia(),
                getTinhTrang());
    }

    @Override
    public String toString() {
        return getMasach() + "#"
                + getMaDauSach() + "#"
                + getTenSach() + "#"
                + getTheLoai() + "#"
                + getTacgia() + "#"
                + getTinhTrang();

    }

    public void capNhat(Sach Sach) {
        //this.masach = dauSach.getMaDauSach();
        this.maSach = Sach.getMasach();
        this.tenSach = Sach.getTenSach();
        this.theLoai = Sach.getTheLoai();
        this.tacgia = Sach.getTacgia();
        this.tinhTrang = Sach.getTinhTrang();
    }

    public void capnhat(String maSach, String tenSach, String theLoai, String tacgia, String tinhTrang) {
        //this.maphieumuon = maphieumuon;
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.theLoai = theLoai;
        this.tinhTrang = tinhTrang;

    }

    public String getMaDauSach() {
        return maDauSach;
    }

    public void setMaDauSach(String maDauSach) {
        this.maDauSach = maDauSach;
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

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public String getMasach() {
        return maSach;
    }

    public void setMasach(String maSach) {
        this.maSach = maSach;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }


}
