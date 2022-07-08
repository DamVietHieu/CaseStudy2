package Library.DataAccess;

import java.io.*;



import Library.Entities.NguoiMuon;
import Library.Utils.ListNguoiMuon;





public class NguoiMuonDA {
    private static final String fileName = "NguoiMuon.txt";


    public ListNguoiMuon layDanhSach() {
        ListNguoiMuon lst = new ListNguoiMuon();
        NguoiMuon nguoiMuon;
        String[] tmp;
        String line = null;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                tmp = line.split("#"); // # la ky tu phan tach giua cac truong trong file
                nguoiMuon = new NguoiMuon(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4]);
                lst.insertTail(nguoiMuon);
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
    public void ghiDanhSach(ListNguoiMuon lst) {
        ListNguoiMuon.NodeNguoiMuon nb = lst.getHead();

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

    public void ghiNguoiMuon(NguoiMuon nguoiMuon) {
    }
}
