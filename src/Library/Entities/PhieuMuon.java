package Library.Entities;

public class PhieuMuon {
    private String maNguoiMuon,maSach, madausach;
    private String ngayMuon;

    public PhieuMuon() {
        this.maNguoiMuon= "";
        this.madausach = "";
        this.maSach = "";
        this.ngayMuon = "";
    }

    public PhieuMuon(PhieuMuon phieuMuon) {
        this.maNguoiMuon = phieuMuon.getmaNguoiMuon();
        this.maSach = phieuMuon.getMaSach();
        this.madausach = phieuMuon.getMadausach();
        this.ngayMuon = phieuMuon.getNgayMuon();
    }

    public PhieuMuon(String maNguoiMuon, String maSach,String madausach, String ngayMuon) {
        this.maNguoiMuon = maNguoiMuon;
        this.maSach = maSach;
        this.madausach = madausach;
        this.ngayMuon = ngayMuon;
    }


    public void hienThi() {

        System.out.printf("%-25s | %-10s |%-10s | %-20s|\n",
                getmaNguoiMuon(),
                getMaSach(),
                getMadausach(),
                getNgayMuon());
    }

    @Override
    public String toString() {
        return getmaNguoiMuon()+ "#" +
                getMaSach()+ "#" +
                getMadausach()+"#"+
                getNgayMuon();
    }
    public void capNhat(PhieuMuon phieuMuon) {
        this.maNguoiMuon = phieuMuon.getmaNguoiMuon();
        this.maSach = phieuMuon.getMaSach();
        this.madausach = phieuMuon.getMadausach();
        this.ngayMuon = phieuMuon.getNgayMuon();
    }

    public void capNhat(String maNguoiMuon,String maSach, String madausach,String ngayMuon) {
        this.maNguoiMuon = maNguoiMuon;
        this.maSach = maSach;
        this.madausach = madausach;
        this.ngayMuon = ngayMuon;
    }

    public String getmaNguoiMuon() {
        return maNguoiMuon;
    }

    public void setmaNguoiMuon(String phieuMuon) {
        this.maNguoiMuon = maNguoiMuon;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }
    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getMadausach() {
        return madausach;
    }

    public void setMadausach(String madausach) {
        this.madausach = madausach;
    }



}
