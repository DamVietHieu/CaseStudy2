package Library.Presentation;


import Library.Entities.PhieuMuon;
import Library.Utils.ListPhieuMuon;
import Library.Works.DauSachBL;
import Library.Works.NguoiMuonBL;
import Library.Works.PhieuMuonBL;
import Library.Works.SachBL;

import java.util.Scanner;


public class QLPhieuMuon {

    Scanner scanner = new Scanner(System.in);
    PhieuMuonBL phieuMuonBL = new PhieuMuonBL();
    SachBL sachBL = new SachBL();
    NguoiMuonBL nguoiMuonBL = new NguoiMuonBL();
    DauSachBL dauSachBL = new DauSachBL();

    public void menu() {
        do {
            System.out.println();
            System.out.println("            QUAN LY PHIEU MUON");
            System.out.println("-------------------***-------------------");
            System.out.println("|   1. Them phieu muon.                    |");
            System.out.println("|   2. Sua thong tin.                      |");
            System.out.println("|   3. Xoa phieu muon.                     |");
            System.out.println("|   4. Xem danh sach.                      |");
            System.out.println("|   5. Sap xep theo loai.                  |");
            System.out.println("|   6. Tim kiem.                           |");
            System.out.println("|   9. Quay lai menu chinh.                |");
            System.out.println("|   0. Thoat chuong trinh.                 |");
            System.out.println("-----------------------------------------");
            System.out.print("Moi chon chuc nang: ");
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

            System.out.println("\n---------------------KET THUC MENU QUAN LY PHIEU MUON------------------\n");
        } while (true);
    }

    public void them() {
        System.out.println();
        System.out.println("            THEM PHIEU MUON");
        System.out.println("-------------------***-------------------");
        System.out.println("MOI NHAP VAO CAC THONG TIN:\n");
        String maNguoiMuon, maSach, madausach, ngayMuon;
        do {
            System.out.print("Nhap vao ma cho phieu muon: ");
            maNguoiMuon = scanner.nextLine();
        } while (maNguoiMuon == "");
        if (!phieuMuonBL.kiemTra(maNguoiMuon)) {
            do {
                System.out.print("ngay muon: ");
                ngayMuon = scanner.nextLine();
            } while (ngayMuon == "");

            do {
                System.out.print("Ma sach: ");
                maSach = scanner.nextLine();
            } while (maSach == "" || !sachBL.kiemTra(maSach));
            do {
                System.out.print("Ma dau sach: ");
                madausach = scanner.nextLine();
            } while (madausach == "" || !dauSachBL.kiemTra(madausach));


            PhieuMuon phieuMuon = new PhieuMuon(maNguoiMuon, maSach, madausach, ngayMuon);
            phieuMuonBL.them(phieuMuon);
        } else {
            System.out.println("khong ton tai ma: " + maNguoiMuon);
        }
        System.out.println("\n-----------------------------------------------------------------------------\n");

    }

    public void sua() {
        System.out.println();
        System.out.println("         SUA THONG TIN PHIEU MUON ");
        System.out.println("-------------------***-------------------");
        String maNguoiMuon, ngayMuon, soLuong, maSach, madausach;

        do {
            System.out.print("Nhap vao ma phieu muon: ");
            maNguoiMuon = scanner.nextLine();
        } while (maNguoiMuon == "" || !phieuMuonBL.kiemTra(maNguoiMuon));

        if (phieuMuonBL.kiemTra(maNguoiMuon)) {
            System.out.println("NHAP VAO THONG TIN CAP NHAT CHO PHIEU MUON : " + maNguoiMuon);
            do {
                System.out.print("Nhap ten ngay muon: ");
                ngayMuon = scanner.nextLine();
            } while (ngayMuon == "");

            do {
                System.out.print("Nhap so luong: ");
                soLuong = scanner.nextLine();
            } while (soLuong == "");


            do {
                System.out.print("Nhap ma sach: ");
                maSach = scanner.nextLine();
            } while (maSach == "");
            do {
                System.out.print("Nhap ma dau sach: ");
                madausach = scanner.nextLine();
            } while (madausach == "");


            PhieuMuon phieuMuon = new PhieuMuon(maNguoiMuon, maSach, madausach, ngayMuon);
            phieuMuonBL.sua(phieuMuon);

        } else {
            System.out.println("Khong ton tai ma: " + maNguoiMuon);
        }

        System.out.println("\n-----------------------------------------------------------------------------\n");
    }


    public void xoa() {
        System.out.println();
        System.out.println("          SUA THONG TIN PHIEU MUON");
        System.out.println("-------------------***-------------------");
        System.out.println("Nhap vao ma phieu muon can xoa: ");
        String maNguoiMuon = scanner.nextLine();
        if (phieuMuonBL.kiemTra(maNguoiMuon)) {
            phieuMuonBL.xoa(maNguoiMuon);
            System.out.println("Xoa thanh cong phieu muon co ma: " + maNguoiMuon);
        } else {
            System.out.println("Khong ton tai phieu muon co ma: " + maNguoiMuon);
        }

        System.out.println("\n-----------------------------------------------------------------------------\n");
    }

    public void xemDanhSach() {
        System.out.println();
        System.out.println("DANH SACH ");
        ListPhieuMuon lst = phieuMuonBL.layDanhSach();
        lst.sapXepTheoTen();
        ListPhieuMuon.NodePhieuMuon nb = lst.getHead();
        System.out.printf("%-25s | %-10s |%-10s | %-10s | %-20s|\n",
                "Ma nguoi muon ",
                "Ma Sach",
                "Ma Dau Sach",
                "So Luong",
                "Ngay muon");
        System.out.println("---------------------------------------------------------------------------------------");

        while (nb != null) {
            nb.getInfo().hienThi();
            nb = nb.getNext();
        }

        System.out.println("---------------------------------------------------------------------------------------\n");
    }

    public void sapXepTheoTen() {
        System.out.println();
        System.out.println("DANH SACH PHIEU MUON");
        ListPhieuMuon lst = phieuMuonBL.layDanhSach();
        lst.sapXepTheoTen();
        ListPhieuMuon.NodePhieuMuon nb = lst.getHead();
        System.out.printf("%-25s | %-10s |%-10s | %-20s|\n",
                "Ma nguoi muon ",
                "Ma sach",
                "Ma dau sach",
                "ngay muon");
        System.out.println("---------------------------------------------------------------------------------------");
        while (nb != null) {
            nb.getInfo().hienThi();
            nb = nb.getNext();
        }

        System.out.println("---------------------------------------------------------------------------------------\n");
    }

    public void timKiem() {
        do {
            System.out.println();
            System.out.println("            TIM KIEM PHIEU MUON");
            System.out.println("-------------------***-------------------");
            System.out.println("|   1. Tim theo ma nguoi muon.          |");
            System.out.println("|   2. Tim theo ngay muon.               |");
            System.out.println("|   9. Quay lai menu quan ly thu vien.       |");
            System.out.println("|   0. Thoat chuong trinh.              |");
            System.out.println("-----------------------------------------");
            System.out.print("      Moi chon chuc nang: ");
            int n = Integer.parseInt(scanner.nextLine());
            switch (n) {
                case 1:
                    timMa();
                    break;
                case 2:
                    timSoLuong();
                    break;
                case 9:
                    menu();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }

            System.out.println("\n--------------------KET THUC MENU TIM KIEM PHIEU MUON-------------------\n");
        } while (true);
    }


    public void timMa() {
        System.out.println();

        System.out.println("        TIM KIEM THEO MA  NGUOI MUON");
        System.out.println("-------------------***-------------------");
        System.out.print("  Nhap vao ma can tim kiem: ");
        String ngayMuon = scanner.nextLine();
        ListPhieuMuon lst = phieuMuonBL.timNgay(ngayMuon);
        ListPhieuMuon.NodePhieuMuon nb = lst.getHead();

        System.out.println();
        if (nb != null) {
            System.out.printf("%-25s | %-10s |%-10s | %-20s|\n",
                    "Ma nguoi muon ",
                    "Ma sach",
                    "Ma dau sach",
                    "ngay muon");
            System.out.println("---------------------------------------------------------------------------------------");
            while (nb != null) {
                nb.getInfo().hienThi();
                nb = nb.getNext();
            }
        } else {
            System.out.println("Khong co ket qua phu hop.");
        }
        System.out.println("---------------------------------------------------------------------------------------\n");

    }

    public void timSoLuong() {
        System.out.println();
        System.out.println("         TIM KIEM THEO SO LUONG");
        System.out.println("-------------------***-------------------");
        System.out.print("  Nhap vao so luong can tim kiem: ");
        String soLuong = scanner.nextLine();
        ListPhieuMuon lst = phieuMuonBL.timSoLuong(soLuong);
        ListPhieuMuon.NodePhieuMuon nb = lst.getHead();

        System.out.println();
        if (nb != null) {
            System.out.printf("%-25s | %-10s |%-10s | %-20s|\n",
                    "Ma nguoi muon ",
                    "Ma sach",
                    "Ma dau sach",
                    "ngay muon");
            System.out.println("---------------------------------------------------------------------------------------");

            while (nb != null) {
                nb.getInfo().hienThi();
                nb = nb.getNext();
            }
        } else {
            System.out.println("Khong co ket qua nao phu hop.");
        }
        System.out.println("---------------------------------------------------------------------------------------\n");

    }

}

