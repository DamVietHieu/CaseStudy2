package Library.Presentation;



import Library.Entities.NguoiMuon;
import Library.Utils.ListNguoiMuon;
import Library.Works.NguoiMuonBL;
import Library.Works.PhieuMuonBL;
import Library.Works.SachBL;

import java.util.Scanner;


public class QLNguoiMuon {

    Scanner scanner = new Scanner(System.in);
    NguoiMuonBL nguoiMuonBL = new NguoiMuonBL();
    SachBL sachBL = new SachBL();
    PhieuMuonBL phieuMuonBL = new PhieuMuonBL();

    public void menu() {
        do {
            System.out.println();
            System.out.println("            QUAN LY NGUOI MUON");
            System.out.println("-------------------***-------------------");
            System.out.println("|   1. Them nguoi muon.                 |");
            System.out.println("|   2. Sua thong tin.                   |");
            System.out.println("|   3. Xoa nguoi muon.                  |");
            System.out.println("|   4. Xem danh sach.                   |");
            System.out.println("|   5. Sap xep theo ten.                |");
            System.out.println("|   6. Tim kiem.                        |");
            System.out.println("|   9. Quay lai menu chinh.             |");
            System.out.println("|   0. Thoat chuong trinh.              |");
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

            System.out.println("\n---------------------KET THUC MENU QUAN LY NGUOI MUON------------------\n");
        } while (true);
    }

    public void them() {
        System.out.println();
        System.out.println("            THEM NGUOI MUON");
        System.out.println("-------------------***-------------------");
        System.out.println("MOI NHAP VAO CAC THONG TIN:");
        String maNguoiMuon, tenNguoiMuon, diaChi, soDienThoai, email;
        do {
            System.out.print("Nhap vao ma cho nguoi muon: ");
            maNguoiMuon = scanner.nextLine();
        } while (maNguoiMuon == "");
        if (!nguoiMuonBL.kiemTra(maNguoiMuon)) {
            do {
                System.out.print("Nhap ten : ");
                tenNguoiMuon = scanner.nextLine();
            } while (tenNguoiMuon == "");
            do {
                System.out.print("email: ");
                email = scanner.nextLine();
            } while (email == "");
            do {
                System.out.print("Nhap dia chi: ");

                diaChi = scanner.nextLine();
            } while (diaChi == "");

            do {
                System.out.print("Nhap SDT: ");
                soDienThoai = scanner.nextLine();
            } while (soDienThoai == "");
            NguoiMuon nguoiMuon = new NguoiMuon(maNguoiMuon, tenNguoiMuon, diaChi, soDienThoai, email);
            nguoiMuonBL.them(nguoiMuon);
        } else {
            System.out.println("Da ton tai ma: " + maNguoiMuon);

        }
        System.out.println("\n-----------------------------------------------------------------------------\n");

    }

    public void sua() {
        System.out.println();
        System.out.println("        SUA THONG TIN NGUOI MUON ");
        System.out.println("-------------------***-------------------");
        String maNguoiMuon, tenNguoiMuon, diaChi, soDienThoai, email;

        do {
            System.out.print("Nhap vao ma nguoi muon: ");
            maNguoiMuon = scanner.nextLine();
        } while (maNguoiMuon == "");

        if (nguoiMuonBL.kiemTra(maNguoiMuon)) {
            System.out.println("NHAP VAO THONG TIN CAP NHAT CHO NGUOI MUON : " + maNguoiMuon);
            do {
                System.out.print("Nhap ten nguoi muon: ");
                tenNguoiMuon = scanner.nextLine();
            } while (tenNguoiMuon == "");
            do {
                System.out.print("Nhap dia chi: ");
                diaChi = scanner.nextLine();
            } while (diaChi == "");
            do {
                System.out.print("Nhap SDT: ");

                soDienThoai = scanner.nextLine();
            } while (soDienThoai == "");

            do {
                System.out.print("Nhap email: ");
                email = scanner.nextLine();
            } while (email == "");


            NguoiMuon nguoiMuon = new NguoiMuon(maNguoiMuon, tenNguoiMuon, diaChi, soDienThoai, email);
            nguoiMuonBL.sua(nguoiMuon);

        } else {
            System.out.println("Khong ton tai ma: " + maNguoiMuon);
        }

        System.out.println("\n-----------------------------------------------------------------------------\n");
    }

    public void xoa() {
        System.out.println();
        System.out.println("         XOA THONG TIN  NGUOI MUON");
        System.out.println("-------------------***-------------------");
        System.out.println("Nhap vao ma nguoi muon can xoa: ");
        String maNguoiMuon = scanner.nextLine();
        if (nguoiMuonBL.kiemTra(maNguoiMuon)) {
            nguoiMuonBL.xoa(maNguoiMuon);
            System.out.println("Xoa thanh cong nguoi muon co ma: " + maNguoiMuon);
        } else {
            System.out.println("Khong ton taa nguoi muon co ma: " + maNguoiMuon);
        }

        System.out.println("\n-----------------------------------------------------------------------------\n");
    }

    public void xemDanhSach() {
        System.out.println();
        System.out.println("DANH SACH");
        ListNguoiMuon lst = nguoiMuonBL.layDanhSach();
        ListNguoiMuon.NodeNguoiMuon nb = lst.getHead();
        lst.sapXepTheoTen();

        System.out.printf("%-15s | %-20S | %-25s | %-30s | %-20s |\n",
                "Ma nguoi Muon ",
                "Ten Nguoi Muon",
                "Dia chi",
                "SĐT",
                "Email");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        while (nb != null) {
            nb.getInfo().hienThi();
            nb = nb.getNext();
        }

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------\n");
    }

    public void sapXepTheoTen() {
        System.out.println();
        System.out.println("DANH SACH NGUOI MUON");
        ListNguoiMuon lst = nguoiMuonBL.layDanhSach();
        lst.sapXepTheoTen();
        ListNguoiMuon.NodeNguoiMuon nb = lst.getHead();

        System.out.printf("%-15s | %-20S | %-25s | %-30s | %-20s |\n",
                "Ma nguoi Muon ",
                "Ten Nguoi Muon",
                "Dia chi",
                "SĐT",
                "Email");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        while (nb != null) {
            nb.getInfo().hienThi();
            nb = nb.getNext();
        }

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------\n");
    }


    public void timKiem() {
        do {
            System.out.println();
            System.out.println("            TIM KIEM NGUOI MUON");
            System.out.println("-------------------***-------------------");
            System.out.println("|   1. Tim theo ten.                    |");
            System.out.println("|   2. Tim theo dia chi.                |");
            System.out.println("|   9. Quay lai menu quan ly thu vien.       |");
            System.out.println("|   0. Thoat chuong trinh.              |");
            System.out.println("-----------------------------------------");
            System.out.print("      Moi chon chuc nang: ");
            int n = Integer.parseInt(scanner.nextLine());
            switch (n) {
                case 1:
                    timTen();
                    break;
                case 2:
                    timDiaChi();
                    break;
                case 9:
                    menu();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }

            System.out.println("\n--------------------KET THUC MENU TIM KIEM NGUOI MUON-------------------\n");
        } while (true);
    }


    public void timTen() {
        System.out.println();
        System.out.println("            TIM KIEM THEO TEN");
        System.out.println("-------------------***-------------------");
        System.out.print("  Nhap vao ten can tim kiem: ");
        String tenNguoiMuon = scanner.nextLine();
        ListNguoiMuon lst = nguoiMuonBL.timTen(tenNguoiMuon);
        ListNguoiMuon.NodeNguoiMuon nb = lst.getHead();

        System.out.println();
        if (nb != null) {
            System.out.printf("%-15s | %-20S | %-25s | %-30s | %-20s |\n",
                    "Ma nguoi Muon ",
                    "Ten Nguoi Muon",
                    "Dia chi",
                    "SDT",
                    "Email");
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
    public void timDiaChi() {
        System.out.println();
        System.out.println("          TIM KIEM THEO DIA CHI");
        System.out.println("-------------------***-------------------");
        System.out.print("Nhap vao dia chi can tim kiem: ");
        String diaChi = scanner.nextLine();
        ListNguoiMuon lst = nguoiMuonBL.timDiaChi(diaChi);
        ListNguoiMuon.NodeNguoiMuon nb = lst.getHead();

        System.out.println();
        if (nb != null) {
            System.out.printf("%-15s | %-20S | %-25s | %-30s | %-20s |\n",
                    "Ma nguoi Muon ",
                    "Ten Nguoi Muon",
                    "Dia chi",
                    "SĐT",
                    "Email");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");

            while (nb != null) {
                nb.getInfo().hienThi();
                nb = nb.getNext();
            }
        } else {
            System.out.println("khong co ket qua phu hop.");
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------\n");

    }

}

