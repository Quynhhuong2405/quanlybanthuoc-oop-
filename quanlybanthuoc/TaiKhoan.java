package quanlybanthuoc;

import java.util.ArrayList;

public class TaiKhoan {
    private String tenDangNhap;
    private String matKhau;
    private String vaiTro;

    // Danh sách tĩnh để quản lý tất cả các tài khoản
    private static ArrayList<TaiKhoan> danhSachTaiKhoan = new ArrayList<>();

    // Constructor
    public TaiKhoan(String tenDangNhap, String matKhau, String vaiTro) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    // Getters và Setters
    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    // Phương thức kiểm tra đăng nhập
    public boolean kiemTraDangNhap(String tenDangNhap, String matKhau) {
        return this.tenDangNhap.equals(tenDangNhap) && this.matKhau.equals(matKhau);
    }

    // Phương thức thêm tài khoản vào danh sách tĩnh
    public static void themTaiKhoan(TaiKhoan tk) {
        danhSachTaiKhoan.add(tk);
    }

    // Phương thức tìm tài khoản dựa trên tên đăng nhập
    public static TaiKhoan timTaiKhoan(String tenDangNhap) {
        for (TaiKhoan tk : danhSachTaiKhoan) {
            if (tk.getTenDangNhap().equals(tenDangNhap)) {
                return tk;
            }
        }
        return null; // Không tìm thấy
    }

    // Phương thức xóa tài khoản khỏi danh sách
    public static boolean xoaTaiKhoan(String tenDangNhap) {
        TaiKhoan tk = timTaiKhoan(tenDangNhap);
        if (tk != null) {
            danhSachTaiKhoan.remove(tk);
            return true;
        }
        return false; // Không tìm thấy
    }

    // Phương thức in danh sách tài khoản
    public static void hienThiDanhSach() {
        System.out.println("--- Danh sách tài khoản ---");
        for (TaiKhoan tk : danhSachTaiKhoan) {
            System.out.printf("Tên: %s, Vai trò: %s\n", tk.getTenDangNhap(), tk.getVaiTro());
        }
    }
}
