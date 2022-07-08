package Library.Works;


import Library.DataAccess.PhieuMuonDA;
import Library.Entities.PhieuMuon;
import Library.Utils.ListPhieuMuon;



public class PhieuMuonBL {

    PhieuMuonDA phieuMuonDA = new PhieuMuonDA();

    public ListPhieuMuon layDanhSach() {
        return phieuMuonDA.layDanhSach();
    }

    public void them(PhieuMuon phieuMuon) {
        phieuMuonDA.ghiPhieuMuon(phieuMuon);
    }

    public void sua(PhieuMuon phieuMuon) {
        ListPhieuMuon lst = phieuMuonDA.layDanhSach();
        ListPhieuMuon.NodePhieuMuon nb = lst.getHead();
        while (nb != null) {
            if (nb.getInfo().getmaNguoiMuon().equalsIgnoreCase(phieuMuon.getmaNguoiMuon())
                    && nb.getInfo().getmaNguoiMuon().equalsIgnoreCase(phieuMuon.getmaNguoiMuon())) {
                nb.getInfo().capNhat(phieuMuon);
            }
            nb = nb.getNext();
        }
        phieuMuonDA.ghiDanhSach(lst);
    }

    public void xoa(String maNguoiMuon) {
        ListPhieuMuon lst = phieuMuonDA.layDanhSach();
        ListPhieuMuon.NodePhieuMuon nb = lst.getHead();
        while (nb != null) {
            if (nb.getInfo().getmaNguoiMuon().equalsIgnoreCase(maNguoiMuon)) {
                lst.removeNode(nb);
            }
            nb = nb.getNext();
        }
        phieuMuonDA.ghiDanhSach(lst);
    }

    public boolean kiemTra(String maNguoiMuon) {
        ListPhieuMuon lst = phieuMuonDA.layDanhSach();
        ListPhieuMuon.NodePhieuMuon nb = lst.getHead();
        while (nb != null) {
            if (nb.getInfo().getmaNguoiMuon().equalsIgnoreCase(maNguoiMuon)) return true;
            nb = nb.getNext();
        }
        return false;
    }
    public ListPhieuMuon timNgay(String ngayMuon) {
        ListPhieuMuon kq = new ListPhieuMuon();
        ListPhieuMuon lst = phieuMuonDA.layDanhSach();
        ListPhieuMuon.NodePhieuMuon nb = lst.getHead();
        while (nb != null) {
            if (nb.getInfo().getNgayMuon().contains(ngayMuon))
                kq.insertTail(nb.getInfo());
            nb = nb.getNext();
        }
        return kq;
    }
    public int tongPhieuMuon() {
        int dem = 0;
        ListPhieuMuon.NodePhieuMuon nb = phieuMuonDA.layDanhSach().getHead();
        while (nb != null) {
            dem++;
            nb = nb.getNext();
        }
        return dem;
    }

    public ListPhieuMuon timSoLuong(String soLuong) {
        return null;
    }
}

