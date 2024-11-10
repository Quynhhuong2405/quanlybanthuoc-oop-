package quanlybanthuoc;

import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachKhachHang {
    private ArrayList<KhachHang> danhSachKhachHang;
    private Scanner sc;

    public DanhSachKhachHang() {
        this.danhSachKhachHang = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }

    public void themKhachHang() {
        System.out.print("Nhap ten khach hang: ");
        String tenKhachHang = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        String soDienThoai = sc.nextLine();
        System.out.print("Nhap ma hoa don: ");
        String maHoaDon = sc.nextLine();
        System.out.print("Nhap ten san pham: ");
        String tenSanPham = sc.nextLine();
        System.out.print("Nhap gia san pham: ");
        double gia = sc.nextDouble();
        System.out.print("Nhap so luong san pham: ");
        int soLuong = sc.nextInt();
        sc.nextLine(); // Xoa bo nho dem

        KhachHang khachHang = new KhachHang(tenKhachHang, soDienThoai, maHoaDon, tenSanPham, gia, soLuong);
        danhSachKhachHang.add(khachHang);
        System.out.println("Them khach hang thanh cong.");
    }

    public void xoaKhachHang() {
        System.out.print("Nhap ma hoa don khach hang can xoa: ");
        String maHoaDon = sc.nextLine();
        boolean daXoa = danhSachKhachHang.removeIf(kh -> kh.getMaHoaDon().equals(maHoaDon));
        if (daXoa) {
            System.out.println("Xoa khach hang thanh cong.");
        } else {
            System.out.println("Khong tim thay khach hang voi ma hoa don: " + maHoaDon);
        }
    }

    public void suaKhachHang() {
        System.out.print("Nhap ma hoa don khach hang can sua: ");
        String maHoaDon = sc.nextLine();
        for (KhachHang kh : danhSachKhachHang) {
            if (kh.getMaHoaDon().equals(maHoaDon)) {
                System.out.print("Nhap ten khach hang moi: ");
                kh.setTenKhachHang(sc.nextLine());
                System.out.print("Nhap so dien thoai moi: ");
                kh.setSoDienThoai(sc.nextLine());
                System.out.print("Nhap ten san pham moi: ");
                kh.setTenSanPham(sc.nextLine());
                System.out.print("Nhap gia san pham moi: ");
                kh.setGia(sc.nextDouble());
                System.out.print("Nhap so luong moi: ");
                kh.setSoLuong(sc.nextInt());
                sc.nextLine(); // Xoa bo nho dem
                System.out.println("Sua thong tin khach hang thanh cong.");
                return;
            }
        }
        System.out.println("Khong tim thay khach hang voi ma hoa don: " + maHoaDon);
    }

    public void timKiemKhachHang() {
        System.out.print("Nhap ma hoa don khach hang can tim: ");
        String maHoaDon = sc.nextLine();
        for (KhachHang kh : danhSachKhachHang) {
            if (kh.getMaHoaDon().equals(maHoaDon)) {
                System.out.println("Thong tin khach hang: " + kh);
                return;
            }
        }
        System.out.println("Khong tim thay khach hang voi ma hoa don: " + maHoaDon);
    }

    public void xuatDanhSachKhachHang() {
        if (danhSachKhachHang.isEmpty()) {
            System.out.println("Danh sach khach hang trong.");
        } else {
            System.out.println("Danh sach khach hang:");
            for (KhachHang kh : danhSachKhachHang) {
                System.out.println(kh);
            }
        }
    }

    public void menu() {
        int choice;
        do {
            System.out.println("\n======BANG LUA CHON======");
            System.out.println("1. Them khach hang");
            System.out.println("2. Xoa khach hang");
            System.out.println("3. Sua thong tin khach hang");
            System.out.println("4. Tim kiem khach hang");
            System.out.println("5. Xuat danh sach");
            System.out.println("6. Thoat");
            System.out.print("Lua chon cua ban la: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> themKhachHang();
                case 2 -> xoaKhachHang();
                case 3 -> suaKhachHang();
                case 4 -> timKiemKhachHang();
                case 5 -> xuatDanhSachKhachHang();
                case 6 -> System.out.println("Thoat chuong trinh");
                default -> System.out.println("Lua chon khong hop le.");
            }
        } while (choice != 6);
    }
}
