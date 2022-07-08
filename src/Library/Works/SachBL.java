package Library.Works;


import Library.DataAccess.DauSachDA;
import Library.DataAccess.SachDA;
import Library.Entities.Sach;
import Library.Utils.ListSach;



public class SachBL {

    Library.DataAccess.SachDA SachDA = new SachDA();
    DauSachDA DausachDA = new DauSachDA();

    public ListSach layDanhSach() {
        return SachDA.layDanhSach();
    }
    public void them(Sach Sach) {
        SachDA.ghiSach(Sach);
    }

    public void sua(Sach Sach) {
        ListSach lst = SachDA.layDanhSach();
        ListSach.NodeSach nb = lst.getHead();
        while (nb != null) {
            if (nb.getInfo().getMasach().equalsIgnoreCase(Sach.getMasach())) {
                nb.getInfo().capNhat(Sach);
            }
            nb = nb.getNext();
        }
        SachDA.ghiDanhSach(lst);
    }

    public void xoa(String maSach) {
        ListSach lst = SachDA.layDanhSach();
        ListSach.NodeSach nb = lst.getHead();
        while (nb != null) {
            if (nb.getInfo().getMasach().equalsIgnoreCase(maSach)) {
                lst.removeNode(nb);
            }
            nb = nb.getNext();
        }
        SachDA.ghiDanhSach(lst);
    }

    public boolean kiemTra(String maSach) {
        ListSach lst = SachDA.layDanhSach();
        ListSach.NodeSach nb = lst.getHead();
        while (nb != null) {
            if (nb.getInfo().getMasach().equalsIgnoreCase(maSach)) return true;
            nb = nb.getNext();
        }
        return false;
    }

    public ListSach timTen(String tenSach) {
        ListSach kq = new ListSach();
        ListSach lst = SachDA.layDanhSach();
        ListSach.NodeSach nb = lst.getHead();
        while (nb != null) {
            if (nb.getInfo().getTenSach().contains(tenSach))
                kq.insertTail(nb.getInfo());
            nb = nb.getNext();
        }
        return kq;
    }
    public ListSach.NodeSach timMa(String maSach) {
        ListSach lst = SachDA.layDanhSach();
        ListSach.NodeSach nb = lst.getHead();
        while (nb != null) {
            if (nb.getInfo().getMasach().equalsIgnoreCase(maSach)) return nb;
            nb = nb.getNext();
        }
        return null;
    }
    public ListSach timGanMa(String maSach) {
        ListSach kq = new ListSach();
        ListSach lst = SachDA.layDanhSach();
        ListSach.NodeSach nb = lst.getHead();
        while (nb != null) {
            if (nb.getInfo().getMasach().contains(maSach))
                kq.insertTail(nb.getInfo());
            nb = nb.getNext();
        }
        return kq;
    }
    public int tongSach() {
        int dem = 0;
        ListSach.NodeSach nb = SachDA.layDanhSach().getHead();
        while (nb != null) {
            dem++;
            nb = nb.getNext();
        }
        return dem;
    }
    public int tongSachCon(){
        int dem=0;
        ListSach.NodeSach nb = SachDA.layDanhSach().getHead();
        while(nb!=null){
            if (nb.getInfo().getTinhTrang().equalsIgnoreCase("con"))
                dem++;
            nb=nb.getNext();
        }
        return dem;
    }

}
