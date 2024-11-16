package quanlybanthuoc;

import java.util.ArrayList;

import java.util.List;

class KhachHang {
    private String tenKhachHang;
    private String soDienThoai;
    private String maHoaDon;
    private String tenSanPham;
    private double gia;
    private int soLuong;
    private double tongTien;

    // Danh sách tĩnh lưu trữ tất cả khách hàng
    private static List<KhachHang> danhSachKhachHang = new ArrayList<>();

    public KhachHang(String tenKhachHang, String soDienThoai, String maHoaDon, String tenSanPham, double gia, int soLuong) {
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.maHoaDon = maHoaDon;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.soLuong = soLuong;
        this.tongTien = gia * soLuong;
    }

    // Phương thức tĩnh để thêm khách hàng vào danh sách
    public static void themKhachHang(KhachHang khachHang) {
        danhSachKhachHang.add(khachHang);
    }

    // Phương thức tĩnh để hiển thị danh sách khách hàng
    public static void hienThiDanhSachKhachHang() {
        if (danhSachKhachHang.isEmpty()) {
            System.out.println("Danh sách khách hàng trống.");
        } else {
            for (KhachHang kh : danhSachKhachHang) {
                System.out.println(kh);
            }
        }
    }

    // Getters and Setters
    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public void setGia(double gia) {
        this.gia = gia;
        this.tongTien = this.gia * this.soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
        this.tongTien = this.gia * this.soLuong;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "tenKhachHang='" + tenKhachHang + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", maHoaDon='" + maHoaDon + '\'' +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", gia=" + gia +
                ", soLuong=" + soLuong +
                ", tongTien=" + tongTien +
                '}';
    }
}
