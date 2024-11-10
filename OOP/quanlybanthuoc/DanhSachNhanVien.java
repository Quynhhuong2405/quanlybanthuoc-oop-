package quanlybanthuoc;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class DanhSachNhanVien implements ThaoTac {
    private NhanVien[] nv;
    private int n;
    private Scanner sc = new Scanner(System.in);

    public DanhSachNhanVien() {
        this.nv = new NhanVien[0];
        this.n = 0;
    }

    public void nhapDanhSachNV() {
        System.out.print("Nhap vao so luong nhan vien: ");
        n = sc.nextInt();
        sc.nextLine(); 
        nv = new NhanVien[n];
        for (int i = 0; i < n; i++) {
            nv[i] = new NhanVien();
            System.out.print("\n\t\t\t\t\t\tNHAN VIEN THU " + (i + 1) + "\n");
            nv[i].taoMaTuDong();
            nv[i].nhap();
        }
    }

    public void xuatDanhSachNV() {
        System.out.println("\t\t\t\t\t\t=======DANH SACH NHAN VIEN=======");
        System.out.println("================================================================================================================================");
        System.out.format("|| %4s | %8s |%25s| %5s | %12s | %13s | %12s | %13s ||\n", "STT", "MA NV", "HO VA TEN CUA NHAN VIEN", "GIOI", "NGAY SINH", "SDT", "CHUC VU", "LUONG");

        for (int i = 0; i < n; i++) {
            if (nv[i] != null) {
                System.out.format("|| %4s |", (i + 1));
                nv[i].xuat();
            }
        }
        System.out.println("================================================================================================================================");
    }

    public void them() {
        System.out.print("Nhap so luong nhan vien muon them: ");
        int sl = sc.nextInt();
        sc.nextLine();
        nv = Arrays.copyOf(nv, n + sl);
        for (int i = n; i < n + sl; i++) {
            nv[i] = new NhanVien();
            System.out.print("\n\t\t\t\t\t\tNHAN VIEN THU " + (i + 1) + "\n");
            nv[i].taoMaTuDong();
            nv[i].nhap();
        }
        n += sl;
    }

    public void xoa(String manv) {
        boolean found = false;
        int i = 0;
        for (; i < n; i++) {
            if (nv[i].getManv().equals(manv)) {
                found = true;
                break;
            }
        }
        if (found) {
            for (int j = i; j < n - 1; j++) {
                nv[j] = nv[j + 1];
            }
            nv[--n] = null; 
            System.out.println("\nDa xoa thanh cong du lieu");
        } else {
            System.err.println("\nKhong tim thay nhan vien can tim");
        }
    }

    public void sua() {
        System.out.print("Nhap ma nhan vien muon sua: ");
        String maSua = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (nv[i].getManv().equals(maSua)) {
                System.out.println("Thong tin nhan vien truoc khi sua:");
                nv[i].xuat();
                nv[i].nhap();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay nhan vien voi ma: " + maSua);
        }
    }

    // Các phương thức tìm kiếm, ghi file, đọc file và menu sẽ không đổi

    public void thaoTac() {
        int choice;
        do {
            System.out.println("\n======BANG LUA CHON======");
            System.out.println("1. Them nhan vien");
            System.out.println("2. Xoa nhan vien");
            System.out.println("3. Sua thong tin nhan vien");
            System.out.println("4. Tim kiem nhan vien");
            System.out.println("5. Xuat danh sach");
            System.out.println("6. Thoat");
            System.out.print("Lua chon cua ban la: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> them();
                case 2 -> {
                    System.out.print("Nhap ma nhan vien can xoa: ");
                    xoa(sc.nextLine());
                }
                case 3 -> sua();
                case 4 -> {
                    System.out.print("Nhap ma nhan vien can tim: ");
                    timKiem_MaNhanVien(sc.nextLine());
                }
                case 5 -> xuatDanhSachNV();
                case 6 -> System.out.println("Thoat chuong trinh");
                default -> System.out.println("Lua chon khong hop le.");
            }
        } while (choice != 6);
    }
}
