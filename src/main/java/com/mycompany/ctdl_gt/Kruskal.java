package com.mycompany.ctdl_gt;

import java.util.Arrays;
import java.util.Comparator;

// Lớp đại diện cho một cạnh trong đồ thị
class Canh {
    int dinhDau, dinhCuoi, trongSo;

    public Canh(int dinhDau, int dinhCuoi, int trongSo) {
        this.dinhDau = dinhDau;
        this.dinhCuoi = dinhCuoi;
        this.trongSo = trongSo;
    }
}

// Lớp đại diện cho một đồ thị với số đỉnh và cạnh
class DoThi {
    int soDinh, soCanh;
    Canh[] cacCanh;

    public DoThi(int soDinh, int soCanh) {
        this.soDinh = soDinh;
        this.soCanh = soCanh;
        cacCanh = new Canh[soCanh];
    }
}

// Lớp triển khai thuật toán Kruskal
class KruskalMST {
    int[] parent, rank;

    // Hàm khởi tạo với số lượng đỉnh n
    public KruskalMST(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Hàm tìm đỉnh đại diện của tập hợp chứa đỉnh u
    int timDinhDaiDien(int u) {
        if (u != parent[u]) {
            parent[u] = timDinhDaiDien(parent[u]);
        }
        return parent[u];
    }

    // Hàm hợp nhất hai tập hợp chứa đỉnh u và v
    void hopNhat(int u, int v) {
        int rootU = timDinhDaiDien(u);
        int rootV = timDinhDaiDien(v);

        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }

    // Hàm tìm cây khung nhỏ nhất
    void kruskalMST(DoThi doThi) {
        Arrays.sort(doThi.cacCanh, Comparator.comparingInt(canh -> canh.trongSo));
        Canh[] mst = new Canh[doThi.soDinh - 1];
        int e = 0;

        for (Canh canh : doThi.cacCanh) {
            if (e == doThi.soDinh - 1) break;

            int u = timDinhDaiDien(canh.dinhDau);
            int v = timDinhDaiDien(canh.dinhCuoi);

            if (u != v) {
                mst[e++] = canh;
                hopNhat(u, v);
            }
        }

        System.out.println("Các cạnh trong Cây Khung Nhỏ Nhất:");
        for (int i = 0; i < e; i++) {
            System.out.println(mst[i].dinhDau + " - " + mst[i].dinhCuoi + ": " + mst[i].trongSo);
        }
    }

    public static void main(String[] args) {
        int V = 6; // Số lượng đỉnh
        int E = 10; // Số lượng cạnh
        DoThi doThi = new DoThi(V, E);

        doThi.cacCanh[0] = new Canh(0, 1, 16);
        doThi.cacCanh[1] = new Canh(0, 2, 3);
        doThi.cacCanh[2] = new Canh(0, 3, 12);
        doThi.cacCanh[3] = new Canh(1, 2, 12);
        doThi.cacCanh[4] = new Canh(1, 4, 7);
        doThi.cacCanh[5] = new Canh(2, 3, 13);
        doThi.cacCanh[6] = new Canh(2, 4, 16);
        doThi.cacCanh[7] = new Canh(2, 5, 10);
        doThi.cacCanh[8] = new Canh(3, 5, 5);
        doThi.cacCanh[9] = new Canh(4, 5, 16);

        KruskalMST mst = new KruskalMST(V);
        mst.kruskalMST(doThi);
    }
}
