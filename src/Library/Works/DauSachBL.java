package Library.Works;



import Library.DataAccess.DauSachDA;
import Library.Entities.DauSach;
import Library.Utils.ListDauSach;



public class DauSachBL {

    DauSachDA dausachDA = new DauSachDA();

    public ListDauSach layDanhSach() {
        return dausachDA.layDanhSach();
    }

    public void them(DauSach Dausach) {
        dausachDA.ghiDauSach(Dausach);
    }

    public void sua(DauSach dausach) {
        ListDauSach lst = dausachDA.layDanhSach();
        ListDauSach.NodeDauSach nb = lst.getHead();
        while (nb != null) {
            if (nb.getInfo().getMaDauSach().equalsIgnoreCase(dausach.getMaDauSach())) {
                nb.getInfo().capNhat(dausach);
            }
            nb = nb.getNext();
        }
        dausachDA.ghiDanhSach(lst);
    }

    public void xoa(String maDauSach) {
        ListDauSach lst = dausachDA.layDanhSach();
        ListDauSach.NodeDauSach nb = lst.getHead();
        while (nb != null) {
            if (nb.getInfo().getMaDauSach().equalsIgnoreCase(maDauSach)) {
                lst.removeNode(nb);
            }
            nb = nb.getNext();
        }
        dausachDA.ghiDanhSach(lst);
    }

    public boolean kiemTra(String maDauSach) {
        ListDauSach lst = dausachDA.layDanhSach();
        ListDauSach.NodeDauSach nb = lst.getHead();
        while (nb != null) {
            if (nb.getInfo().getMaDauSach().equalsIgnoreCase(maDauSach)) return true;
            nb = nb.getNext();
        }
        return false;
    }

    public ListDauSach.NodeDauSach timMa(String maDauSach) {
        ListDauSach lst = dausachDA.layDanhSach();
        ListDauSach.NodeDauSach nb = lst.getHead();
        while (nb != null) {
            if (nb.getInfo().getMaDauSach().equalsIgnoreCase(maDauSach)) return nb;
            nb = nb.getNext();
        }
        return null;
    }
    public ListDauSach timGanMa(String maDauSach) {
        ListDauSach kq = new ListDauSach();
        ListDauSach lst = dausachDA.layDanhSach();
        ListDauSach.NodeDauSach nb = lst.getHead();
        while (nb != null) {
            if (nb.getInfo().getMaDauSach().contains(maDauSach))
                kq.insertTail(nb.getInfo());
            nb = nb.getNext();
        }
        return kq;
    }

    public ListDauSach timTen(String tenSach) {
        ListDauSach kq = new ListDauSach();
        ListDauSach lst = dausachDA.layDanhSach();
        ListDauSach.NodeDauSach nb = lst.getHead();
        while (nb != null) {
            if (nb.getInfo().getTenSach().contains(tenSach))
                kq.insertTail(nb.getInfo());
            nb = nb.getNext();
        }
        return kq;
    }

    public int tongSach() {
        int dem = 0;
        ListDauSach.NodeDauSach nb = dausachDA.layDanhSach().getHead();
        while (nb != null) {
            dem++;
            nb = nb.getNext();
        }
        return dem;
    }
    public int tongSachCon(){
        int dem=0;
        ListDauSach.NodeDauSach nb = dausachDA.layDanhSach().getHead();
        while(nb!=null){
            if (nb.getInfo().getTrangThai().equalsIgnoreCase("con"))
                dem++;
            nb=nb.getNext();
        }
        return dem;
    }

}