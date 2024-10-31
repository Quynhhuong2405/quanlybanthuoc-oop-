import java.util.Scanner;

public class DangNhap {
    // Khai báo tài khoản mặc định cho admin và nhân viên
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    private static final String EMP_USERNAME = "emp";
    private static final String EMP_PASSWORD = "emp123";
    Scanner sc = new Scanner(System.in);

    // Hàm khởi tạo
    public DangNhap() {
        // Khởi tạo tất cả giá trị bằng rỗng nếu cần thiết
    }

    // Hiển thị menu chọn chức vụ
    public void show() {
        System.out.println("------- Menu chọn chức vụ -------");
        System.out.println("1. Admin (Quản trị viên)");
        System.out.println("2. Nhân viên");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    // Hàm đăng nhập
    public boolean dangNhap() {
        show();
        int choice = sc.nextInt();
        sc.nextLine(); // Đọc ký tự xuống dòng còn lại sau khi nhập số
        System.out.print("Tên đăng nhập: ");
        String username = sc.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String password = sc.nextLine();
        
        boolean check = false;
        switch (choice) {
            case 1:
                if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                    System.out.println("Đăng nhập thành công với vai trò Quản trị viên!");
                    hienThiMenuAdmin();
                    check = true;
                }
                break;
            case 2:
                if (username.equals(EMP_USERNAME) && password.equals(EMP_PASSWORD)) {
                    System.out.println("Đăng nhập thành công với vai trò Nhân viên!");
                    hienThiMenuNhanVien();
                    check = true;
                }
                break;
            default:
                System.out.println("Lựa chọn của bạn không hợp lệ. Vui lòng nhập lại.");
                return false;
        }

        if (!check) {
            System.out.println("Đăng nhập thất bại. Vui lòng kiểm tra thông tin đăng nhập.");
            return false;
        }
        return true;
    }

    // Menu chức năng cho quản trị viên
    public void hienThiMenuAdmin() {
        System.out.println("------ Chức năng dành cho Quản trị viên ------");
        System.out.println("1. Xem thông tin thuốc");
        System.out.println("2. Thêm thuốc mới");
        System.out.println("3. Sửa thông tin thuốc");
        System.out.println("4. Xóa thuốc");
        System.out.println("5. Tìm kiếm thuốc");
        System.out.println("6. Đăng xuất");
        // Thực hiện các chức năng tùy theo lựa chọn
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                // Gọi hàm xem thông tin thuốc
                xemThongTinThuoc();
                break;
            case 2:
                // Gọi hàm thêm thuốc mới
                themThuoc();
                break;
            case 3:
                // Gọi hàm sửa thông tin thuốc
                suaThongTinThuoc();
                break;
            case 4:
                // Gọi hàm xóa thuốc
                xoaThuoc();
                break;
            case 5:
                // Gọi hàm tìm kiếm thuốc
                timKiemThuoc();
                break;
            case 6:
                System.out.println("Đăng xuất thành công!");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    // Menu chức năng cho nhân viên
    public void hienThiMenuNhanVien() {
        System.out.println("------ Chức năng dành cho Nhân viên ------");
        System.out.println("1. Xem thông tin thuốc");
        System.out.println("2. Tìm kiếm thuốc");
        System.out.println("3. Đăng xuất");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                // Gọi hàm xem thông tin thuốc
                xemThongTinThuoc();
                break;
            case 2:
                // Gọi hàm tìm kiếm thuốc
                timKiemThuoc();
                break;
            case 3:
                System.out.println("Đăng xuất thành công!");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    // Các hàm xử lý chức năng
    public void xemThongTinThuoc() {
        System.out.println("Xem thông tin thuốc...");
        // Thực hiện xem thông tin thuốc
    }

    public void themThuoc() {
        System.out.println("Thêm thuốc mới...");
        // Thực hiện thêm thuốc mới
    }

    public void suaThongTinThuoc() {
        System.out.println("Sửa thông tin thuốc...");
        // Thực hiện sửa thông tin thuốc
    }

    public void xoaThuoc() {
        System.out.println("Xóa thuốc...");
        // Thực hiện xóa thuốc
    }

    public void timKiemThuoc() {
        System.out.println("Tìm kiếm thuốc...");
        // Thực hiện tìm kiếm thuốc
    }

    // Hàm main để chạy chương trình
    public static void main(String[] args) {
        DangNhap dn = new DangNhap();
        dn.dangNhap();
    }
}
