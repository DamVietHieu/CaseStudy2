package CaseModule2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);


            public void menu() {
                do {
                    System.out.println();

                    System.out.println("        CHUONG TRINH QUAN LY SAN PHAM");
                    System.out.println("-------------------***-------------------");
                    System.out.println("|   1. Xem danh sach.                   |");
                    System.out.println("|   2. Them san pham moi.               |");
                    System.out.println("|   3. Update san pham.                 |");
                    System.out.println("|   4. Xoa san pham.                    |");
                    System.out.println("|   5. Sap xep theo ten.                |");
                    System.out.println("|   6. Tim san pham co gia dat nhat     |");
                    System.out.println("|   7. Quay lai menu chinh              |");
                    System.out.println("|   0. Thoat chuong trinh.              |");
                    System.out.println("-----------------------------------------");
                    System.out.print("  Moi chon chuc nang: ");
                    int n = Integer.parseInt(scanner.nextLine());

                    switch (n) {
                        case 1:
                            Show();
                            break;
                        case 2:
                            them();
                            break;

                        case 3:
                            sua();
                            break;
                        case 4:
                            xoa();
                            break;

                        case 5:
                            sapxepTheoTen();
                            break;

                        case 6:
                            timsanpham();
                            break;
                        case 7:
                            Main.menu();
                            break;

                        case 0:
                            System.exit(0);
                            break;
                    }
                    System.out.println("\n---------------------------------KET THU MENU QUAN LY SAN PHAM----------------\n");

                } while (true);

            }



        }
}
