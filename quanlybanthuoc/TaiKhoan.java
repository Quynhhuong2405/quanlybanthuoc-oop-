package quanlybanthuoc;

public class TaiKhoan {
    private String tenDangNhap;
    private String matKhau;
    private String vaiTro;

    public TaiKhoan(String tenDangNhap, String matKhau, String vaiTro) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean kiemTraDangNhap(String tenDangNhap, String matKhau) {
        return this.tenDangNhap.equals(tenDangNhap) && this.matKhau.equals(matKhau);
    }
}
