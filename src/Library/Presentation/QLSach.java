package Library.Presentation;


import Library.Entities.DauSach;
import Library.Entities.Sach;
import Library.Utils.ListDauSach;
import Library.Utils.ListSach;
import Library.Works.DauSachBL;
import Library.Works.PhieuMuonBL;
import Library.Works.SachBL;

import java.util.Scanner;


public class QLSach {

    Scanner scanner = new Scanner(System.in);
    DauSachBL dausachBL = new DauSachBL();
    SachBL sachBL = new SachBL();
    PhieuMuonBL phieuMuonBL = new PhieuMuonBL();
    DauSach dausach = new DauSach();

    public void menu() {
        do {
            System.out.println();
            System.out.println("             QUAN LY SACH");
            System.out.println("-------------------***-------------------");
            System.out.println("|    1. Them sach.                      |");
            System.out.println("|    2. Sua thong tin.                  |");
            System.out.println("|    3. Xoa sach.                       |");
            System.out.println("|    4. Xem danh sach.                  |");
            System.out.println("|    5. Sap xep theo ten.               |");
            System.out.println("|    6. Tim kiem.                       |");
            System.out.println("|    9. Quay lai menu chinh.            |");
            System.out.println("|    0. Thoat chuong trinh.             |");
            System.out.println("-----------------------------------------");
            System.out.print("  Moi chon chuc nang: ");
            int n = Integer.parseInt(scanner.nextLine());
            switch (n) {
                case 1:
                    them();
                    break;
                case 2:
                    sua();
                    break;
                case 3:
                    xoa();
                    break;
                case 4:
                    xemDanhSach();
                    break;
                case 5:
                    sapXepTheoTen();
                    break;
                case 6:
                    timKiem();
                    break;
                case 9:
                    Main.menu();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }

            System.out.println("\n---------------------KET THUC MENU QUAN LY SACH------------------\n");
        } while (true);
    }

    public void them() {
        System.out.println();
        System.out.println("                THEM SACH");
        System.out.println("-------------------***-------------------");
        System.out.println("MOI NHAP CAC THONG TIN:");
        String maDausach, maSach;
        ListDauSach lst = dausachBL.layDanhSach();
        ListDauSach.NodeDauSach nb = lst.getHead();
        do {
            System.out.print("Nhap vao ma dau sach: ");
            maDausach = scanner.nextLine();
        } while (maDausach == "");
        if (dausachBL.kiemTra(maDausach)== true) {
            do {
                System.out.print("Nhap ma sach : ");
                maSach = scanner.nextLine();
                if(sachBL.kiemTra(maSach)==true)
                { System.out.println("Ma sach da ton tai!");}
            } while (sachBL.kiemTra(maSach)== true);
            while(nb != null){
                if(nb.getInfo().getMaDauSach().equalsIgnoreCase(maDausach)){
                    Sach Sach = new Sach(maDausach, maSach, nb.getInfo().getTenSach(), nb.getInfo().getTheLoai(),nb.getInfo().getTacGia(), nb.getInfo().getTrangThai());
                    sachBL.them(Sach);
                } nb = nb.getNext();
            }
        } else {
            System.out.println("khong ton tai ma: " + maDausach);
        }
        System.out.println("\n-----------------------------------------------------------------------------\n");

    }

    public void sua() {
        System.out.println();
        System.out.println("                SUA SACH");
        System.out.println("-------------------***-------------------");
        System.out.println("MOI NHAP VAO CAC THONG TIN:");
        String maDausach,maSach, tenSach, theLoai,tacgia, trangThai;
        ListSach lst = sachBL.layDanhSach();
        ListSach.NodeSach nb = lst.getHead();

        do {
            System.out.print("Nhap vao ma cho sach: ");
            maSach = scanner.nextLine();
        } while (maSach == "");
        if (sachBL.kiemTra(maSach)) {
            do {
                System.out.print("Nhap ten sach : ");
                tenSach = scanner.nextLine();
            } while (tenSach == "");

            do {
                System.out.print("the loai: ");
                theLoai = scanner.nextLine();
            } while (theLoai == "");
            do {
                System.out.print("Tac gia: ");
                tacgia = scanner.nextLine();
            } while (tacgia == "");

            do {
                System.out.print("trang thai: ");
                trangThai = scanner.nextLine();
            } while (trangThai == "");
            Sach Sach = new Sach(maSach, tenSach, theLoai,tacgia, trangThai);
            sachBL.sua(Sach);
        } else {
            System.out.println("Da ton tai ma: " + maSach);
        }
        System.out.println("\n-----------------------------------------------------------------------------\n");

    }
    public void xoa() {
        System.out.println();
        System.out.println("        XOA THONG TIN DAU SACH");
        System.out.println("-------------------***-------------------");
        System.out.println("Nhap vao ma dau sach can xoa: ");
        String maSach = scanner.nextLine();
        if (sachBL.kiemTra(maSach)) {
            sachBL.xoa(maSach);
            System.out.println("Xoa thanh cong dau sach co ma: " + maSach);
        } else {
            System.out.println("Khong ton tai dau sach co ma: " + maSach);
        }

        System.out.println("\n-----------------------------------------------------------------------------\n");
    }

    public void xemDanhSach() {
        System.out.println();
        System.out.println(" DANH SACH ");
        ListSach lst = sachBL.layDanhSach();
        ListSach.NodeSach nb = lst.getHead();
        lst.sapXepTheoTen();
        System.out.printf("%-10s | %-30s | %-30S | %-15s | %-15s |%-20s|\n\n",
                "Ma dau sach",
                "Ma sach ",
                "Ten sach",
                "The loai",
                "Tac gia",
                "Tinh trang");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        while (nb != null) {
            nb.getInfo().hienThi();
            nb = nb.getNext();
        }

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
    }

    public void sapXepTheoTen() {
        System.out.println();
        System.out.println("DANH SACH DAU SACH");
        ListSach lst = sachBL.layDanhSach();
        lst.sapXepTheoTen();
        ListSach.NodeSach nb = lst.getHead();
        System.out.printf("%-10s | %-30s | %-30S | %-15s | %-15s |%-20s|\n",
                "Ma dau sach",
                "Ma sach ",
                "Ten sach",
                "The loai",
                "Tac gia",
                "Tinh trang");
        while (nb != null) {
            nb.getInfo().hienThi();
            nb = nb.getNext();
        }

        System.out.println("\n-----------------------------------------------------------------------------\n");
    }

    public void timKiem() {
        do {
            System.out.println();
            System.out.println("            TIM KIEM SACH");
            System.out.println("-------------------***-------------------");
            System.out.println("|   1. Tim theo ma sach gan dung.   |");
            System.out.println("|   2. Tim theo ma sach.            |");
            System.out.println("|   3. Tim theo ten sach.           |");
            System.out.println("|   9. Quay lai menu quan ly .               |");
            System.out.println("|   0. Thoat chuong trinh.              |");
            System.out.println("-----------------------------------------");
            System.out.print("  Moi chon chuc nang: ");
            int n = Integer.parseInt(scanner.nextLine());
            switch (n) {
                case 1:
                    timGanMa();
                    break;
                case 2:
                    timMa();
                    break;
                case 3:
                    timTen();
                    break;
                case 9:
                    menu();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }

            System.out.println("\n--------------------KET THUC MENU TIM KIEM SACH-------------------\n");
        } while (true);
    }


    public void timMa() {
        System.out.println();
        System.out.println("            TIM KIEM THEO MA");
        System.out.println("-------------------***-------------------");
        System.out.print("Nhap vao ma can tim kiem: ");
        String maSach = scanner.nextLine();
        ListSach.NodeSach nb = sachBL.timMa(maSach);

        System.out.println();
        if (nb != null) {
            System.out.printf("%-10s | %-30s | %-30S | %-15s | %-15s |%-20s|\n",
                    "Ma dau sach",
                    "Ma sach ",
                    "Ten sach",
                    "The loai",
                    "Tac gia",
                    "Tinh trang");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
            nb.getInfo().hienThi();
        }
        else {
            System.out.println("Khong co ket qua phu hop.");
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------\n");

    }
    public void timGanMa() {
        System.out.println();
        System.out.println("        TIM KIEM GAN DUNG THEO MA");
        System.out.println("-------------------***-------------------");
        System.out.print("Nhap vao ky tu can tim  kiem: ");
        String maSach = scanner.nextLine();
        ListSach lst = sachBL.timGanMa(maSach);
        ListSach.NodeSach nb = lst.getHead();

        System.out.println();
        if (nb != null) {
            System.out.printf("%-10s | %-30s | %-30S | %-15s | %-15s |%-20s|\n",
                    "Ma dau sach",
                    "Ma sach ",
                    "Ten sach",
                    "The loai",
                    "Tac gia",
                    "Tinh trang");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
            while (nb != null) {
                nb.getInfo().hienThi();
                nb = nb.getNext();
            }
        } else {
            System.out.println("Khong co ket qua phu hop.");
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------\n");

    }
    public void timTen() {
        System.out.println();
        System.out.println("            TIM KIEM THEO TEN");
        System.out.println("-------------------***-------------------");
        System.out.print("Nhap vao ten can tim kiem: ");
        String tenSach = scanner.nextLine();
        ListSach lst = sachBL.timTen(tenSach);
        ListSach.NodeSach nb = lst.getHead();

        System.out.println();
        if (nb != null) {
            System.out.printf("%-10s | %-30s | %-30S | %-15s | %-15s |%-20s|\n",
                    "Ma dau sach",
                    "Ma sach ",
                    "Ten sach",
                    "The loai",
                    "Tac gia",
                    "Tinh trang");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
            while (nb != null) {
                nb.getInfo().hienThi();
                nb = nb.getNext();
            }
        } else {
            System.out.println("Khong co ket qua phu hop.");
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------\n");

    }

}
