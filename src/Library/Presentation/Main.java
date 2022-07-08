package Library.Presentation;


import Library.Works.DauSachBL;
import Library.Works.NguoiMuonBL;
import Library.Works.PhieuMuonBL;
import Library.Works.SachBL;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {

        QLNguoiMuon qlNguoiMuon = new QLNguoiMuon();
        QLSach qlSach = new QLSach();
        QLPhieuMuon qlPhieuMuon = new QLPhieuMuon();
        QLDauSach qLDauSach = new QLDauSach();


        do {

            System.out.println();
            System.out.println("    CHUONG TRINH QUAN LY THU VIEN");
            System.out.println("-------------------***------------------");
            System.out.println("|   1. Quan ly dau sach.               |");
            System.out.println("|   2. Quan Ly Sach .                  |");
            System.out.println("|   3. Quan ly Phieu muon.             |");
            System.out.println("|   4. Quan ly nguoi muon.             |");
            System.out.println("|   5. Tim Kiem.                       |");
            System.out.println("|   6. Thong Ke.                       |");
            System.out.println("|   0. Thoat chuong trinh.             |");
            System.out.println("----------------------------------------");
            System.out.print("Moi chon chuc nang: ");
            int n = Integer.parseInt(scanner.nextLine());
            switch (n) {
                case 1:
                    qLDauSach.menu();
                    break;
                case 2:
                    qlSach.menu();
                    break;
                case 3:
                    qlPhieuMuon.menu();
                    break;
                case 4:
                    qlNguoiMuon.menu();
                    break;
                case 5:
                    menuTimKiem();
                    break;
                case 6:
                    thongKe();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }

            System.out.println("\n---------------------KET THUC MENU CHINH------------------\n");
        } while (true);
    }

    public static void menuTimKiem() {
        QLNguoiMuon qLNguoiMuon = new QLNguoiMuon();
        QLSach qlSach = new    QLSach();
        QLPhieuMuon qLPhieuMuon = new QLPhieuMuon();
        QLDauSach qLDauSach =new QLDauSach();

        do {
            System.out.println();
            System.out.println("                TIM KIEM");
            System.out.println("-------------------***-------------------");
            System.out.println("|   1. Tim kiem dau sach.               |");
            System.out.println("|   2. Tim kiem sach.                   |");
            System.out.println("|   3. Tim kiem phieu muon.             |");
            System.out.println("|   4. Tim kiem nguoi muon.             |");
            System.out.println("|   9. Quay lai menu chinh.             |");
            System.out.println("|   0. Thoat khoi chuong trinh          |");
            System.out.println("-----------------------------------------");
            System.out.print("      Moi chon chuc nang: ");
            int n = Integer.parseInt(scanner.nextLine());
            switch (n) {
                case 1:

                    qLDauSach.timKiem();
                    break;
                case 2:
                    qlSach.timKiem();
                    break;
                case 3:
                    qLPhieuMuon.timKiem();
                    break;
                case 4:
                    qLNguoiMuon.timKiem();
                case 9:
                    menu();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }

            System.out.println("\n---------------------KET THUC MENU CHINH------------------\n");
        } while (true);
    }

    public static void thongKe() {
        System.out.println();
        System.out.println("               THONG KE HE THONG");
        System.out.println("---------------------***---------------------");
        SachBL sachBL = new SachBL();
        int tongSach = sachBL.tongSach();
        int tongSachCon = sachBL.tongSachCon();
        NguoiMuonBL nguoiMuonBL = new NguoiMuonBL();
        int tongNguoiMuon = nguoiMuonBL.tongNguoiMuon();
        PhieuMuonBL phieuMuonBL = new PhieuMuonBL();
        int tongPhieuMuon = phieuMuonBL.tongPhieuMuon();
        DauSachBL dauSachBL = new DauSachBL();
        int tongDauSach = dauSachBL.tongSach();
        System.out.println("|       Tong nguoi muon: " + tongNguoiMuon+"                   |");
        System.out.println("|       Tong phieu muon: " + tongPhieuMuon+"                   |");
        System.out.println("|       Tong dau sach: "+ tongDauSach+"                     |");
        System.out.println("|       Tong  sach: "+ tongSach+"                        |");
        System.out.println("|       Tong  sach con : "+ tongSachCon+"                    |");
        System.out.println("|       Tong dau sach con: "+tongDauSach+"                 |");
        System.out.println("---------------------------------------------");
        System.out.println("\n---------------------KET THUC THONG KE------------------\n");
    }
}

