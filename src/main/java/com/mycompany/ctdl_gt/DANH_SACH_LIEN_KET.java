package com.mycompany.ctdl_gt;

/**
 *
 * @author allec
 */
public class DANH_SACH_LIEN_KET {
    // Lớp Node đại diện cho một nút trong danh sách liên kết đơn
    class Node {
        int data; // Giá trị của nút
        Node next; // Con trỏ tới nút tiếp theo

        Node(int data) {
            this.data = data; // Khởi tạo giá trị của nút
            this.next = null; // Khởi tạo con trỏ tới nút tiếp theo là null
        }
    }

    private Node head; // Con trỏ tới đầu danh sách

    // Hàm khởi tạo, khởi tạo danh sách trống
    public DANH_SACH_LIEN_KET() {
        this.head = null;
    }

    // Thêm một nút với giá trị x vào đầu danh sách
    public void addToHead(int x) {
        Node newNode = new Node(x); // Tạo nút mới với giá trị x
        newNode.next = head; // Con trỏ của nút mới trỏ tới nút đầu hiện tại
        head = newNode; // Đặt nút mới là đầu danh sách
    }

    // Thêm một nút với giá trị x vào cuối danh sách
    public void addToTail(int x) {
        Node newNode = new Node(x); // Tạo nút mới với giá trị x
        if (head == null) {
            head = newNode; // Nếu danh sách trống, đặt nút mới là đầu danh sách
            return;
        }
        Node temp = head; // Bắt đầu từ nút đầu tiên
        while (temp.next != null) {
            temp = temp.next; // Duyệt tới nút cuối cùng
        }
        temp.next = newNode; // Thêm nút mới vào cuối danh sách
    }

    // Thêm một nút với giá trị x vào sau nút p
    public void addAfter(Node p, int x) {
        if (p == null) return;
        Node newNode = new Node(x); // Tạo nút mới với giá trị x
        newNode.next = p.next; // Con trỏ của nút mới trỏ tới nút sau nút p
        p.next = newNode; // Con trỏ của nút p trỏ tới nút mới
    }

    // Duyệt và in giá trị của các nút từ đầu đến cuối danh sách
    public void traverse() {
        Node temp = head; // Bắt đầu từ nút đầu tiên
        while (temp != null) {
            System.out.print(temp.data + " "); // In giá trị của nút hiện tại
            temp = temp.next; // Chuyển tới nút tiếp theo
        }
        System.out.println(); // Xuống dòng sau khi duyệt hết danh sách
    }

    // Xóa nút đầu tiên và trả về giá trị của nó
    public int deleteFromHead() {
        if (head == null) return -1; // Danh sách trống, trả về -1
        int value = head.data; // Lưu giá trị của nút đầu
        head = head.next; // Đặt đầu danh sách là nút tiếp theo
        return value; // Trả về giá trị của nút đã xóa
    }

    // Xóa nút cuối cùng và trả về giá trị của nó
    public int deleteFromTail() {
        if (head == null) return -1; // Danh sách trống, trả về -1
        if (head.next == null) {
            int value = head.data; // Lưu giá trị của nút đầu
            head = null; // Đặt danh sách là trống
            return value; // Trả về giá trị của nút đã xóa
        }
        Node temp = head; // Bắt đầu từ nút đầu tiên
        while (temp.next.next != null) {
            temp = temp.next; // Duyệt tới nút trước nút cuối cùng
        }
        int value = temp.next.data; // Lưu giá trị của nút cuối
        temp.next = null; // Xóa nút cuối
        return value; // Trả về giá trị của nút đã xóa
    }

    // Xóa nút sau nút p và trả về giá trị của nó
    public int deleteAfter(Node p) {
        if (p == null || p.next == null) return -1; // Nếu p là null hoặc p không có nút tiếp theo, trả về -1
        int value = p.next.data; // Lưu giá trị của nút sau p
        p.next = p.next.next; // Bỏ qua nút sau p
        return value; // Trả về giá trị của nút đã xóa
    }

    // Xóa nút đầu tiên có giá trị bằng x
    public void dele(int x) {
        if (head == null) return; // Danh sách trống, không làm gì
        if (head.data == x) {
            head = head.next; // Nếu nút đầu có giá trị x, xóa nút đầu
            return;
        }
        Node temp = head; // Bắt đầu từ nút đầu tiên
        while (temp.next != null && temp.next.data != x) {
            temp = temp.next; // Duyệt tới nút có giá trị x
        }
        if (temp.next != null) {
            temp.next = temp.next.next; // Xóa nút có giá trị x
        }
    }

    // Tìm kiếm và trả về nút đầu tiên có giá trị x
    public Node search(int x) {
        Node temp = head; // Bắt đầu từ nút đầu tiên
        while (temp != null) {
            if (temp.data == x) return temp; // Trả về nút có giá trị x
            temp = temp.next; // Chuyển tới nút tiếp theo
        }
        return null; // Không tìm thấy nút có giá trị x, trả về null
    }

    // Tìm và trả về giá trị lớn nhất trong danh sách
    public int max() {
        if (head == null) return -1; // Danh sách trống, trả về -1
        int max = head.data; // Khởi tạo giá trị lớn nhất là giá trị của nút đầu
        Node temp = head.next; // Bắt đầu từ nút thứ hai
        while (temp != null) {
            if (temp.data > max) max = temp.data; // Cập nhật giá trị lớn nhất
            temp = temp.next; // Chuyển tới nút tiếp theo
        }
        return max; // Trả về giá trị lớn nhất
    }

    // Tìm và trả về giá trị nhỏ nhất trong danh sách
    public int min() {
        if (head == null) return -1; // Danh sách trống, trả về -1
        int min = head.data; // Khởi tạo giá trị nhỏ nhất là giá trị của nút đầu
        Node temp = head.next; // Bắt đầu từ nút thứ hai
        while (temp != null) {
            if (temp.data < min) min = temp.data; // Cập nhật giá trị nhỏ nhất
            temp = temp.next; // Chuyển tới nút tiếp theo
        }
        return min; // Trả về giá trị nhỏ nhất
    }

    // Tính và trả về tổng giá trị của tất cả các nút trong danh sách
    public int sum() {
        int sum = 0; // Khởi tạo tổng giá trị là 0
        Node temp = head; // Bắt đầu từ nút đầu tiên
        while (temp != null) {
            sum += temp.data; // Cộng giá trị của nút hiện tại vào tổng
            temp = temp.next; // Chuyển tới nút tiếp theo
        }
        return sum; // Trả về tổng giá trị
    }

    // Tính và trả về giá trị trung bình của tất cả các nút trong danh sách
    public int avg() {
        if (head == null) return 0; // Danh sách trống, trả về 0
        int sum = 0, count = 0; // Khởi tạo tổng và số lượng nút
        Node temp = head; // Bắt đầu từ nút đầu tiên
        while (temp != null) {
            sum += temp.data; // Cộng giá trị của nút hiện tại vào tổng
            count++; // Tăng số lượng nút
            temp = temp.next; // Chuyển tới nút tiếp theo
        }
        return sum / count; // Tính và trả về giá trị trung bình
    }

    public static void main(String[] args) {
        // Tạo đối tượng danh sách liên kết đơn
        DANH_SACH_LIEN_KET dslk = new DANH_SACH_LIEN_KET();

        // Thêm các nút vào đầu và cuối danh sách
        dslk.addToHead(3);
        dslk.addToHead(2);
        dslk.addToTail(4);
        dslk.traverse(); // In danh sách: 2 3 4

        // Tìm nút có giá trị 3 và thêm nút mới với giá trị 5 sau nút đó
        Node node = dslk.search(3);
        dslk.addAfter(node, 5);
        dslk.traverse(); // In danh sách: 2 3 5 4

        // Xóa nút đầu tiên và in danh sách
        System.out.println(dslk.deleteFromHead()); // In giá trị nút đầu tiên đã xóa: 2
        dslk.traverse(); // In danh sách: 3 5 4

        // Xóa nút cuối cùng và in danh sách
        System.out.println(dslk.deleteFromTail()); // In giá trị nút cuối cùng đã xóa: 4
        dslk.traverse(); // In danh sách: 3 5

        // Thêm các nút vào cuối danh sách
        dslk.addToTail(7);
        dslk.addToTail(9);
        dslk.traverse(); // In danh sách: 3 5 7 9

        // Xóa nút sau nút có giá trị 3 và in danh sách
        System.out.println(dslk.deleteAfter(node)); // In giá trị nút đã xóa: 5
        dslk.traverse(); // In danh sách: 3 7 9

        // Xóa nút có giá trị 7 và in danh sách
        dslk.dele(7);
        dslk.traverse(); // In danh sách: 3 9

        // Tìm và in giá trị lớn nhất, nhỏ nhất, tổng và trung bình của các nút
        System.out.println(dslk.max()); // In giá trị lớn nhất: 9
        System.out.println(dslk.min()); // In giá trị nhỏ nhất: 3
        System.out.println(dslk.sum()); // In tổng giá trị: 12
        System.out.println(dslk.avg()); // In giá trị trung bình: 6
    }
}
