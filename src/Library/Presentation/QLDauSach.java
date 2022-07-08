package Library.Presentation;


import Library.Entities.DauSach;
import Library.Utils.ListDauSach;
import Library.Utils.ListSach;
import Library.Works.DauSachBL;
import Library.Works.SachBL;

import java.util.Scanner;


public class QLDauSach {

    Scanner scanner = new Scanner(System.in);
    SachBL sachBL = new SachBL();
    DauSachBL dausachBL = new DauSachBL();

    public void menu() {
        do {
            System.out.println();

            System.out.println("             QUAN LY DAU SACH");
            System.out.println("-------------------***-------------------");
            System.out.println("|   1. Them dau sach.                   |");
            System.out.println("|   2. Sua thong tin.                   |");
            System.out.println("|   3. Xoa dau sach.                    |");
            System.out.println("|   4. Xem danh sach.                   |");
            System.out.println("|   5. Sap xep theo ten.                |");
            System.out.println("|   6. Tim kiem.                        |");
            System.out.println("|   9. Quay lai menu chinh.             |");
            System.out.println("|   0. Thoat chuong trinh.              |");
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

            System.out.println("\n---------------------KET THUC MENU QUAN LY DAU SACH ------------------\n");
        } while (true);
    }

    public void them() {
        System.out.println();
        System.out.println("THEM SACH");
        System.out.println("MOI NHAP VAO CAC THONG TIN:");

        String maDauSach, tenSach,theLoai,tacGia,soluong, trangThai;

        do {
            System.out.print("Nhap vao ma cho sach: ");
            maDauSach = scanner.nextLine();
        } while (maDauSach == "");
        if (!dausachBL.kiemTra(maDauSach)) {
            do {
                System.out.print("Nhap ten sach: ");
                tenSach = scanner.nextLine();
            } while (tenSach == "");

            do {
                System.out.print("Nhap the loai: ");
                theLoai = scanner.nextLine();
            } while (theLoai == "");

            do {
                System.out.print("Nhap ten tac gia: ");
                tacGia = scanner.nextLine();
            } while (tacGia == "");
            do {
                System.out.print("Nhap so luong sach: ");
                soluong = scanner.nextLine();
            } while (soluong == "");

            do {
                System.out.print("Nhap trang thai : ");

                trangThai = scanner.nextLine();
            } while (trangThai == "");

            DauSach Dausach = new DauSach( maDauSach, tenSach,theLoai,tacGia,soluong, trangThai);
            dausachBL.them(Dausach);
        } else {
            System.out.println(
                    "Da ton tai nhan vien co ma: " + maDauSach);
        }
        System.out.println("\n-----------------------------------------------------------------------------\n");

    }

    public void sua() {
        System.out.println();
        System.out.println("SUA SACH");
        System.out.println("MOI NHAP CAC THONG TIN:");

        String maDauSach, tenSach,theLoai,tacGia, soluong, trangThai;

        do {
            System.out.print("Nhap vao ma sach can sua: ");
            maDauSach = scanner.nextLine();
        } while (maDauSach == "");
        if (sachBL.kiemTra(maDauSach)) {
            do {
                System.out.print("Nhap ten sach: ");
                tenSach = scanner.nextLine();
            } while (tenSach == "");

            do {
                System.out.print("Nhap the loai: ");
                theLoai = scanner.nextLine();
            } while (theLoai == "");

            do {
                System.out.print("Nhap ten tac gia: ");
                tacGia = scanner.nextLine();
            } while (tacGia == "");
            do {
                System.out.print("Nhap so luong: ");
                soluong = scanner.nextLine();
            } while (soluong == "");

            do {
                System.out.print("Nhap trang thai : ");

                trangThai = scanner.nextLine();
            } while (trangThai == "");

            DauSach sach = new DauSach( maDauSach, tenSach,theLoai,tacGia, soluong, trangThai);
            dausachBL.sua(sach);
        } else {
            System.out.println(
                    "Da ton tai sach co ma: " + maDauSach);
        }
        System.out.println("\n-----------------------------------------------------------------------------\n");

    }

    public void xoa() {
        System.out.println();
        System.out.println("XOA THONG TIN SACH ");
        System.out.println("Nhap vao ma sach can xoa: ");
        String maDauSach = scanner.nextLine();
        if (dausachBL.kiemTra(maDauSach)) {
            dausachBL.xoa(maDauSach);
            System.out.println("Xoa thanh cong sach co ma: " + maDauSach);
        } else {
            System.out.println("Khong ton tai sach co ma: " + maDauSach);
        }

        System.out.println("\n-----------------------------------------------------------------------------\n");
    }

    public void xemDanhSach() {
        System.out.println();
        System.out.println("DANH SÁCH ");
        ListDauSach lst = dausachBL.layDanhSach();
        lst.sapXepTheoTen();
        ListDauSach.NodeDauSach nb = lst.getHead();
        System.out.printf("%-15s | %-25s | %-30s | %-15s | %-15s | %-20s |\n",
                "Ma Dau Sach ",
                "Ten Sach",
                "The Loai",
                "Tac Gia",
                "So luong",
                "Trang Thai");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        while (nb != null) {

            nb.getInfo().hienThi();
            nb = nb.getNext();
        }

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------\n");
    }

    public void sapXepTheoTen() {
        System.out.println();
        System.out.println("DANH SACH NHAN VIEN");
        ListDauSach lst = dausachBL.layDanhSach();
        lst.sapXepTheoTen();
        ListDauSach.NodeDauSach nb = lst.getHead();
        System.out.printf("%-15s | %-25s | %-30s | %-15s | %-15s | %-20s |\n",
                "Ma Dau Sach ",
                "Ten Sach",
                "The Loai",
                "Tac Gia",
                "So luong",
                "Trang Thai");
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
//            System.out.println("---------------------------------------\n");
            System.out.println("              TIM KIEM DAU SACH");
            System.out.println("-------------------***-------------------");
            System.out.println("|   1. Tim theo ma dau sach.            |");
            System.out.println("|   2. Tim theo ten sach.               |");
            System.out.println("|   3. Tim gan dung theo ma dau sach.   |");
            System.out.println("|   9. Quay lai menu ql sach.           |");
            System.out.println("|   0. Thoat chuong trinh.              |");
            System.out.println("-----------------------------------------");
            System.out.print("  Mời chọn chức năng: ");
            int n = Integer.parseInt(scanner.nextLine());
            switch (n) {
                case 1:
                    timMa();
                    break;
                case 2:
                    timTen();
                    break;
                case 3:
                    timGanMa();
                    break;
                case 9:
                    menu();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }

            System.out.println("\n--------------------KET THUC MENU TIM KIEM DAU SACH-------------------\n");
        } while (true);
    }

    public void timMa() {
        System.out.println();
        System.out.println("TIM KIEM THEO MA DAU SACH");
        System.out.print("Nhap vao ma dau sach can tim kiem: ");
        String maDauSach = scanner.nextLine();
        ListSach.NodeSach nb = sachBL.timMa(maDauSach);

        System.out.println();
        if (nb != null) {
            System.out.printf("%-15s | %-25s | %-30s | %-15s | %-15s | %-20s |\n",
                    "Ma Dau Sach ",
                    "Ten Sach",
                    "The Loai",
                    "Tac Gia",
                    "So luong",
                    "Trang Thai");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
            nb.getInfo().hienThi();
        } else {
            System.out.println("khon co ket qua phu hop.");
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------\n");
    }
    public void timGanMa() {
        System.out.println();
        System.out.println("TIM KIEM GAN DUNG THEO MA DAU SACH");
        System.out.print("Nhap vao ma dau sach can tim kiem: ");
        String maDauSach = scanner.nextLine();
        ListDauSach lst = dausachBL.timGanMa(maDauSach);
        ListDauSach.NodeDauSach nb = lst.getHead();

        System.out.println();
        if (nb != null) {
            System.out.printf("%-15s | %-25s | %-30s | %-15s | %-15s | %-20s |\n",
                    "Ma Dau Sach ",
                    "Ten Sach",
                    "The Loai",
                    "Tac Gia",
                    "So luong",
                    "Trang Thai");
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
        System.out.println("TIM KIEM THEO TEN SACH ");
        System.out.print("Nhap vao ten sach tim kiem: ");
        String tenSach = scanner.nextLine();
        ListDauSach lst = dausachBL.timTen(tenSach);
        ListDauSach.NodeDauSach nb = lst.getHead();

        System.out.println();
        if (nb != null) {
            System.out.printf("%-15s | %-25s | %-30s | %-15s | %-15s | %-20s |\n",
                    "Ma Dau Sach ",
                    "Ten Sach",
                    "The Loai",
                    "Tac Gia",
                    "So Luong",
                    "Trang Thai");

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

