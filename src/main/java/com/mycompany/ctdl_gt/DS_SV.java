package com.mycompany.ctdl_gt;

/**
 *
 * @author allec
 */
public class DS_SV {

    // Lớp SinhVien đại diện cho thông tin của sinh viên
    class SinhVien {
        String ten;
        int tuoi;
        SinhVien next;

        SinhVien(String ten, int tuoi) {
            this.ten = ten;
            this.tuoi = tuoi;
            this.next = null;
        }
    }

    private SinhVien head;

    // Hàm khởi tạo, khởi tạo danh sách trống
    public DS_SV() {
        this.head = null;
    }

    // Thêm sinh viên vào đầu danh sách
    public void addToHead(String ten, int tuoi) {
        SinhVien newSV = new SinhVien(ten, tuoi);
        newSV.next = head;
        head = newSV;
    }

    // Thêm sinh viên vào cuối danh sách
    public void addToTail(String ten, int tuoi) {
        SinhVien newSV = new SinhVien(ten, tuoi);
        if (head == null) {
            head = newSV;
            return;
        }
        SinhVien temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newSV;
    }

    // Tìm kiếm sinh viên theo tên
    public SinhVien search(String ten) {
        SinhVien temp = head;
        while (temp != null) {
            if (temp.ten.equals(ten)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Sắp xếp danh sách theo thứ tự tên (sử dụng bubble sort)
    public void sortByName() {
        if (head == null || head.next == null) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            SinhVien temp = head;
            while (temp.next != null) {
                if (temp.ten.compareTo(temp.next.ten) > 0) {
                    // Hoán đổi thông tin sinh viên
                    String tmpTen = temp.ten;
                    int tmpTuoi = temp.tuoi;
                    temp.ten = temp.next.ten;
                    temp.tuoi = temp.next.tuoi;
                    temp.next.ten = tmpTen;
                    temp.next.tuoi = tmpTuoi;
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
    }

    // Tìm sinh viên có tuổi lớn nhất
    public SinhVien findMaxAge() {
        if (head == null) return null;
        SinhVien maxSV = head;
        SinhVien temp = head.next;
        while (temp != null) {
            if (temp.tuoi > maxSV.tuoi) {
                maxSV = temp;
            }
            temp = temp.next;
        }
        return maxSV;
    }

    // Tìm sinh viên có tuổi nhỏ nhất
    public SinhVien findMinAge() {
        if (head == null) return null;
        SinhVien minSV = head;
        SinhVien temp = head.next;
        while (temp != null) {
            if (temp.tuoi < minSV.tuoi) {
                minSV = temp;
            }
            temp = temp.next;
        }
        return minSV;
    }

    // Duyệt và in thông tin sinh viên
    public void traverse() {
        SinhVien temp = head;
        while (temp != null) {
            System.out.println("Ten: " + temp.ten + ", Tuoi: " + temp.tuoi);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        DS_SV svList = new DS_SV();

        // Thêm sinh viên vào đầu danh sách
        svList.addToHead("Nguyen Van A", 20);
        svList.addToHead("Le Thi B", 22);
        
        // Thêm sinh viên vào cuối danh sách
        svList.addToTail("Tran Van C", 19);
        svList.addToTail("Pham Thi D", 21);

        // In danh sách sinh viên
        System.out.println("Danh sach sinh vien:");
        svList.traverse();

        // Tìm kiếm sinh viên theo tên
        SinhVien sv = svList.search("Le Thi B");
        if (sv != null) {
            System.out.println("Tim thay sinh vien: Ten: " + sv.ten + ", Tuoi: " + sv.tuoi);
        } else {
            System.out.println("Khong tim thay sinh vien co ten nay");
        }

        // Sắp xếp danh sách theo tên
        svList.sortByName();
        System.out.println("Danh sach sinh vien sau khi sap xep:");
        svList.traverse();

        // Tìm sinh viên có tuổi lớn nhất
        SinhVien maxAgeSV = svList.findMaxAge();
        if (maxAgeSV != null) {
            System.out.println("Sinh vien co tuoi lon nhat: Ten: " + maxAgeSV.ten + ", Tuoi: " + maxAgeSV.tuoi);
        }

        // Tìm sinh viên có tuổi nhỏ nhất
        SinhVien minAgeSV = svList.findMinAge();
        if (minAgeSV != null) {
            System.out.println("Sinh vien co tuoi nho nhat: Ten: " + minAgeSV.ten + ", Tuoi: " + minAgeSV.tuoi);
        }
    }
}
