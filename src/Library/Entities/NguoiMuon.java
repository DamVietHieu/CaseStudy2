package Library.Entities;

public class NguoiMuon {

    private String maNguoiMuon, tenNguoiMuon,  diaChi, soDienThoai, email;
    public NguoiMuon() {
        this.maNguoiMuon = "";
        this.tenNguoiMuon = "";
        this.diaChi = "";
        this.soDienThoai = "";
        this.email = "";

    }

    public NguoiMuon(NguoiMuon phieuMuon) {
        this.maNguoiMuon = phieuMuon.getmaNguoiMuon();
        this.tenNguoiMuon = phieuMuon.getTenNguoiMuon();
        this.diaChi = phieuMuon.getDiaChi();
        this.soDienThoai = phieuMuon.getSoDienThoai();
        this.email = phieuMuon.getEmail();

    }

    public NguoiMuon(String maNguoiMuon,  String tenNguoiMuon, String diaChi, String soDienThoai, String email) {
        this.maNguoiMuon = maNguoiMuon;
        this.tenNguoiMuon = tenNguoiMuon;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;

    }

    public void hienThi() {

        System.out.printf("%-15s | %-20S | %-25s | %-30s | %-25s |\n",
                getmaNguoiMuon(),
                getTenNguoiMuon(),
                getDiaChi(),
                getSoDienThoai(),
                getEmail());

    }

    @Override
    public String toString() {
        return getmaNguoiMuon()+ "#"
                + getTenNguoiMuon()+ "#"
                + getDiaChi()+ "#"
                + getSoDienThoai()+ "#"
                + getEmail()+ "#";


    }

    public void capNhat(NguoiMuon phieuMuon) {
        this.maNguoiMuon = phieuMuon.getmaNguoiMuon();
        this.tenNguoiMuon = phieuMuon.getTenNguoiMuon();
        this.diaChi = phieuMuon.getDiaChi();
        this.soDienThoai = phieuMuon.getSoDienThoai();
        this.email = phieuMuon.getEmail();

    }
    public void capnhat(String maNguoiMuon,String tenNguoiMuon,  String diaChi, String soDienThoai, String email) {

        this.tenNguoiMuon = tenNguoiMuon;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;

    }

    public String getmaNguoiMuon() {
        return maNguoiMuon;
    }

    public void setmaNguoiMuon(String maNguoiMuon) {
        this.maNguoiMuon = maNguoiMuon;
    }
    public String getTenNguoiMuon() {
        return tenNguoiMuon;
    }

    public void setTenNguoiMuon(String tenNguoiMuon) {
        this.tenNguoiMuon = tenNguoiMuon;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
