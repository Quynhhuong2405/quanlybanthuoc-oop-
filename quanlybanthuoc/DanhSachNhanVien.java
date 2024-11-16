package quanlybanthuoc;

import java.util.Arrays;
import java.util.Scanner;

public class DanhSachNhanVien {
    private static NhanVien[] nv = new NhanVien[0]; // Danh sách nhân viên tĩnh
    private static int n = 0; // Số lượng nhân viên hiện tại

    // Phương thức tĩnh nhập danh sách nhân viên
    public static void nhapDanhSachNV() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao so luong nhan vien: ");
        int soLuong = sc.nextInt();
        sc.nextLine();
        nv = Arrays.copyOf(nv, n + soLuong);
        for (int i = n; i < n + soLuong; i++) {
            nv[i] = new NhanVien();
            System.out.print("\n\t\t\t\t\t\tNHAN VIEN THU " + (i + 1 - n) + "\n");
            nv[i].taoMaTuDong();
            nv[i].nhap();
        }
        n += soLuong;
    }

    // Phương thức tĩnh xuất danh sách nhân viên
    public static void xuatDanhSachNV() {
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

    // Phương thức tĩnh thêm nhân viên
    public static void them() {
        Scanner sc = new Scanner(System.in);
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

    // Phương thức tĩnh xóa nhân viên
    public static void xoa(String manv) {
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

    // Phương thức tĩnh sửa thông tin nhân viên
    public static void sua() {
        Scanner sc = new Scanner(System.in);
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

    // Phương thức tĩnh thao tác chính
    public static void thaoTac() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n======BANG LUA CHON======");
            System.out.println("1. Them nhan vien");
            System.out.println("2. Xoa nhan vien");
            System.out.println("3. Sua thong tin nhan vien");
            System.out.println("4. Xuat danh sach");
            System.out.println("5. Thoat");
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
                case 4 -> xuatDanhSachNV();
                case 5 -> System.out.println("Thoat chuong trinh");
                default -> System.out.println("Lua chon khong hop le.");
            }
        } while (choice != 5);
    }
}