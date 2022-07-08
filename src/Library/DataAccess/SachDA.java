package Library.DataAccess;


import Library.Entities.Sach;
import Library.Utils.ListSach;


import java.io.*;



public class SachDA {
    private static final String fileName = "Sach.txt";


    public ListSach layDanhSach() {
        ListSach lst = new ListSach();
        Sach sach;
        String[] tmp;
        String line = null;

        try {

            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                tmp = line.split("#"); // # la ky tu phan tach giua cac truong trong file
                sach = new Sach(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5]);
                lst.insertTail(sach);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Khong the mo file hoac file khong ton tai " + fileName);
        } catch (IOException ex) {
            System.err.println("Khong the doc file " + fileName);
        }
        return lst;
    }

    // Ghi danh sách thông tin  vào tệp.
    public void ghiDanhSach(ListSach lst) {
        ListSach.NodeSach nb = lst.getHead();

        try {

            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            while (nb != null) {
                bufferedWriter.write(nb.getInfo().toString());
                bufferedWriter.newLine();
                nb = nb.getNext();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException ex) {
            System.err.println("Khong the ghi vao file " + fileName);
        }
    }


    //Ghi thêm thông tin vào cuối tệp.
    public void ghiSach(Sach sach) {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(fileName, true));
            pw.println(sach.toString());
            pw.close();
        } catch (IOException e) {
            System.err.println("Khong the ghi vao tep " + fileName);
        }
    }
}
