/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctdl_gt;

/**
 *
 * @author allec
 */
import java.util.*;

public class Dijkstra {

    // Lớp để đại diện cho một nút trong đồ thị
    static class Node implements Comparable<Node> {
        int dinh;
        int trongSo;

        Node(int dinh, int trongSo) {
            this.dinh = dinh;
            this.trongSo = trongSo;
        }

        @Override
        public int compareTo(Node khac) {
            return Integer.compare(this.trongSo, khac.trongSo);
        }
    }

    // Hàm để cài đặt thuật toán Dijkstra
    public static void dijkstra(Map<Integer, List<Node>> doThi, int dinhBatDau) {
        // Khởi tạo khoảng cách và hàng đợi ưu tiên
        Map<Integer, Integer> khoangCach = new HashMap<>();
        for (int dinh : doThi.keySet()) {
            khoangCach.put(dinh, Integer.MAX_VALUE);
        }
        khoangCach.put(dinhBatDau, 0);

        PriorityQueue<Node> hangDoiUuTien = new PriorityQueue<>();
        hangDoiUuTien.add(new Node(dinhBatDau, 0));

        while (!hangDoiUuTien.isEmpty()) {
            Node hienTai = hangDoiUuTien.poll();
            int dinhHienTai = hienTai.dinh;
            int trongSoHienTai = hienTai.trongSo;

            // Xử lý từng láng giềng của đỉnh hiện tại
            for (Node langGieng : doThi.get(dinhHienTai)) {
                int khoangCachMoi = trongSoHienTai + langGieng.trongSo;

                // Nếu tìm thấy đường đi ngắn hơn đến láng giềng
                if (khoangCachMoi < khoangCach.get(langGieng.dinh)) {
                    khoangCach.put(langGieng.dinh, khoangCachMoi);
                    hangDoiUuTien.add(new Node(langGieng.dinh, khoangCachMoi));
                }
            }
        }

        // In ra đường đi ngắn nhất từ đỉnh bắt đầu đến tất cả các đỉnh khác
        for (Map.Entry<Integer, Integer> entry : khoangCach.entrySet()) {
            System.out.println("Khoảng cách từ đỉnh " + dinhBatDau + " đến đỉnh " + entry.getKey() + " là " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Tạo đồ thị
        Map<Integer, List<Node>> doThi = new HashMap<>();

        // Khởi tạo đồ thị với các cạnh (dựa trên hình ảnh cung cấp)
        doThi.put(1, Arrays.asList(new Node(2, 1), new Node(4, 2)));
        doThi.put(2, Arrays.asList(new Node(1, 1), new Node(3, 5)));
        doThi.put(3, Arrays.asList(new Node(2, 5), new Node(4, 1), new Node(6, 1)));
        doThi.put(4, Arrays.asList(new Node(1, 2), new Node(3, 1), new Node(5, 3)));
        doThi.put(5, Arrays.asList(new Node(4, 3), new Node(6, 10)));
        doThi.put(6, Arrays.asList(new Node(3, 1), new Node(5, 10)));

        // Chạy thuật toán Dijkstra từ đỉnh 1
        dijkstra(doThi, 1);
    }
}
