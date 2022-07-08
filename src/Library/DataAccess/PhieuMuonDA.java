package Library.DataAccess;


import Library.Entities.PhieuMuon;
import Library.Utils.ListPhieuMuon;


import java.io.*;


public class PhieuMuonDA {

    private static final String fileName = "PhieuMuon.txt";

    public ListPhieuMuon layDanhSach() {
        ListPhieuMuon lst = new ListPhieuMuon();
        PhieuMuon phieuMuon;
        String[] tmp;
        String line = null;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                tmp = line.split("#"); // # la ky tu phan tach giua cac truong trong file
                phieuMuon = new PhieuMuon(tmp[0], tmp[1], tmp[2], tmp[3]);
                lst.insertTail(phieuMuon);
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Khong the mo file hoac file khong ton tai " + fileName);
        } catch (IOException ex) {
            System.err.println("Khong the doc file " + fileName);
        }
        return lst;
    }

    // Ghi danh sách thông tin  vào tệp.
    public void ghiDanhSach(ListPhieuMuon lst) {
        ListPhieuMuon.NodePhieuMuon nb = lst.getHead();
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            while (nb != null) {
                bufferedWriter.write(nb.getInfo().toString());
                bufferedWriter.newLine();
                nb = nb.getNext();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException ex) {
            System.err.println("Khong the ghi vao file " + fileName);
        }
    }

    //Ghi thêm thông tin vào cuối tệp.
    public void ghiPhieuMuon(PhieuMuon phieuMuon) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream(fileName, true));
            pw.println(phieuMuon.toString());
            pw.close();
        } catch (IOException e) {
            System.err.println("Khong the ghi vao tep " + fileName);
        }
    }
}