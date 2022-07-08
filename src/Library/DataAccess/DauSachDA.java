package Library.DataAccess;

import java.io.*;


import Library.Entities.DauSach;
import Library.Utils.ListDauSach;


public class DauSachDA {
    private static final String fileName = "DauSach.txt";


    public ListDauSach layDanhSach() {
        ListDauSach lst = new ListDauSach();
        DauSach dauSach;
        String[] tmp;
        String line = null;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                tmp = line.split("#"); // # la ky tu phan tach giua cac truong trong file
                dauSach = new DauSach(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5]);

                lst.insertTail(dauSach);
            }
            fileReader.close();
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Khong the mo file hoac file khong ton tai " + fileName);
        } catch (IOException ex) {
            System.err.println("Khong the doc file " + fileName);
        }
        return lst;
    }

    // Ghi danh sách thông tin vào tệp.
    public void ghiDanhSach(ListDauSach lst) {
        ListDauSach.NodeDauSach nb = lst.getHead();

        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
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

    public void ghiDauSach(DauSach dauSach) {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(fileName, true));
            pw.println(dauSach.toString());
            pw.close();
        } catch (IOException e) {
            System.err.println("Khong the ghi vao tep " + fileName);
        }
    }
}


