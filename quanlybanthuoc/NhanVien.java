package quanlybanthuoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NhanVien {
    private String manv;
    private String ho;
    private String ten;
    private String gioiTinh;
    private String ngaySinh;
    private String sdt;
    private String chucVu;
    private double luong;

    // Danh sách tĩnh để lưu trữ nhân viên
    private static List<NhanVien> danhSachNhanVien = new ArrayList<>();

    // Constructor không tham số
    public NhanVien() {}

    // Constructor có tham số
    public NhanVien(String manv, String ho, String ten, String gioiTinh, String ngaySinh, String sdt, String chucVu, double luong) {
        this.manv = manv;
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.chucVu = chucVu;
        this.luong = luong;
    }

    // Getters và Setters
    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    // Phương thức tạo mã tự động cho nhân viên
    public void taoMaTuDong() {
        this.manv = "NV" + (int)(Math.random() * 10000);
    }

    // Phương thức nhập thông tin nhân viên
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho nhan vien: ");
        this.ho = sc.nextLine();
        System.out.print("Nhap ten nhan vien: ");
        this.ten = sc.nextLine();
        System.out.print("Nhap gioi tinh: ");
        this.gioiTinh = sc.nextLine();
        System.out.print("Nhap ngay sinh: ");
        this.ngaySinh = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        this.sdt = sc.nextLine();
        System.out.print("Nhap chuc vu: ");
        this.chucVu = sc.nextLine();
        System.out.print("Nhap luong: ");
        this.luong = sc.nextDouble();
        this.taoMaTuDong();
    }

    // Phương thức xuất thông tin nhân viên
    public void xuat() {
        System.out.format(" %8s |%25s %-15s| %5s | %12s | %13s | %12s | %,13.0f |\n", 
                manv, ho, ten, gioiTinh, ngaySinh, sdt, chucVu, luong);
    }

    // Thêm nhân viên vào danh sách
    public static void themNhanVien(NhanVien nv) {
        danhSachNhanVien.add(nv);
    }

    // Hiển thị toàn bộ danh sách nhân viên
    public static void hienThiDanhSachNhanVien() {
        if (danhSachNhanVien.isEmpty()) {
            System.out.println("Danh sach nhan vien trong!");
        } else {
            System.out.println("Danh sach nhan vien:");
            System.out.format(" %8s |%25s %-15s| %5s | %12s | %13s | %12s | %s\n", 
                    "Ma NV", "Ho", "Ten", "GT", "Ngay sinh", "SDT", "Chuc vu", "Luong");
            System.out.println("---------------------------------------------------------------------------------------------------");
            for (NhanVien nv : danhSachNhanVien) {
                nv.xuat();
            }
        }
    }
}
