package Library.Works;


import Library.DataAccess.NguoiMuonDA;
import Library.Entities.NguoiMuon;
import Library.Utils.ListNguoiMuon;


public class NguoiMuonBL {

    NguoiMuonDA nguoiMuonDA = new NguoiMuonDA();

    public ListNguoiMuon layDanhSach() {
        return nguoiMuonDA.layDanhSach();
    }

    public void them(NguoiMuon nguoiMuon) {
        nguoiMuonDA.ghiNguoiMuon(nguoiMuon);
    }

    public void sua(NguoiMuon nguoiMuon) {
        ListNguoiMuon lst = nguoiMuonDA.layDanhSach();
        ListNguoiMuon.NodeNguoiMuon nb = lst.getHead();
        while (nb != null) {
            if (nb.getInfo().getmaNguoiMuon().equalsIgnoreCase(nguoiMuon.getmaNguoiMuon())) {
                nb.getInfo().capNhat(nguoiMuon);
            }
            nb = nb.getNext();
        }
        nguoiMuonDA.ghiDanhSach(lst);
    }

    public void xoa(String maNguoiMuon) {
        ListNguoiMuon lst = nguoiMuonDA.layDanhSach();
        ListNguoiMuon.NodeNguoiMuon nb = lst.getHead();
        while (nb != null) {
            if (nb.getInfo().getmaNguoiMuon().equalsIgnoreCase(maNguoiMuon)) {
                lst.removeNode(nb);
            }
            nb = nb.getNext();
        }
        nguoiMuonDA.ghiDanhSach(lst);
    }

    public boolean kiemTra(String maNguoiMuon) {
        ListNguoiMuon lst = nguoiMuonDA.layDanhSach();
        ListNguoiMuon.NodeNguoiMuon nb = lst.getHead();
        while (nb != null) {
            if (nb.getInfo().getmaNguoiMuon().equalsIgnoreCase(maNguoiMuon)) return true;
            nb = nb.getNext();
        }
        return false;
    }

    public ListNguoiMuon timTen(String tenNguoiMuon) {
        ListNguoiMuon kq = new ListNguoiMuon();
        ListNguoiMuon lst = nguoiMuonDA.layDanhSach();
        ListNguoiMuon.NodeNguoiMuon nb = lst.getHead();
        while (nb != null) {
            if (nb.getInfo().getTenNguoiMuon().contains(tenNguoiMuon))
                kq.insertTail(nb.getInfo());
            nb = nb.getNext();
        }
        return kq;
    }

    public ListNguoiMuon timDiaChi(String diaChi) {
        ListNguoiMuon kq = new ListNguoiMuon();
        ListNguoiMuon lst = nguoiMuonDA.layDanhSach();
        ListNguoiMuon.NodeNguoiMuon nb = lst.getHead();
        while (nb != null) {
            if (nb.getInfo().getDiaChi().contains(diaChi))
                kq.insertTail(nb.getInfo());
            nb = nb.getNext();
        }
        return kq;
    }


    public int tongNguoiMuon() {
        int dem = 0;
        ListNguoiMuon.NodeNguoiMuon nb = nguoiMuonDA.layDanhSach().getHead();
        while (nb != null) {
            dem++;
            nb = nb.getNext();
        }
        return dem;
    }


}

