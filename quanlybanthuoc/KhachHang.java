package quanlybanthuoc;

class KhachHang {
    private String tenKhachHang;
    private String soDienThoai;
    private String maHoaDon;
    private String tenSanPham;
    private double gia;
    private int soLuong;
    private double tongTien;

    public KhachHang(String tenKhachHang, String soDienThoai, String maHoaDon, String tenSanPham, double gia, int soLuong) {
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.maHoaDon = maHoaDon;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.soLuong = soLuong;
        this.tongTien = gia * soLuong;
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