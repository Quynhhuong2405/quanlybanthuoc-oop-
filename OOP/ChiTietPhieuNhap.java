
import java.util.Scanner;

public class ChiTietPhieuNhap {

private String maSP;
private int soluong;
private double dongia;
private double thanhtien;
    
public ChiTietPhieuNhap() {}
    
public ChiTietPhieuNhap(String maSP, int soluong, double dongia, double thanhtien) {
        this.maSP = maSP;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
    }
    
    public ChiTietPhieuNhap(ChiTietPhieuNhap ctpn){
        this.maSP = ctpn.maSP;
        this.soluong = ctpn.soluong;
        this.dongia = ctpn.dongia;
        this.thanhtien = ctpn.thanhtien;
    }

    public String getMasp() {
        return maSP;
    }

    public void setMasp(String maSP) {
        this.maSP = maSP;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }
    
   public void nhap(DanhSachSanPham dssp, String ma)    {
        Scanner sc = new Scanner(System.in);
        dssp.xuatDanhSach();
        do {
            dssp.xuatDanhSach();
            System.out.print("Nhap vao ma san pham: ");
            maSP = sc.nextLine();
		    if(!dssp.timKiem_MaSP(maSP)) {
            System.out.println("\nKhong tim thay ma san pham ban vua nhap.");
            }
	    }while(!dssp.timKiem_MaSP(maSP));	
 
        System.out.print("Nhap so luong: ");
        soluong = sc.nextInt();
        
        System.out.print("Nhap don gia: ");
        dongia = sc.nextFloat();
        //dssp.capNhat_SP_DG_PhieuNhap(maSP, soluong, dongia);        
        thanhtien = soluong * dongia;
    }
    public void xuat(){
        System.out.format(" %12s | %10s | %10s | %15s ||\n",maSP, soluong, dongia, thanhtien); 
    }
}

/*
 * public void xuatDanhSach() {
        System.out.println("\t\t\t\t\t\t======DANH SÁCH SẢN PHẨM ======");
        System.out.println("=========================================================================================" +
		"=========================================================");
        System.out.format("|| %4s |%8s | %12s | %23s | %20s | %8s | %12s | %12s | %15s ||\n",
		 "STT", "MÃ SP", "TÊN SẢN PHẨM", "LOẠI SP", "SỐ LƯỢNG", "ĐƠN GIÁ ","THƯƠNG HIỆU", "ĐẾ", "CỠ");
        try {
            for (int i = 0; i < n; i++) {
                System.out.format("|| %4s |", (i + 1));
                sp[i].xuat();
            }
        } catch (NullPointerException npe) {}
        System.out.println("==========================================================================================" +
		"========================================================");
    }
 */

 /*
  * public boolean timKiem_MaSP(String masanpham) {
		for(int i = 0; i < n; i++) {
			if(sp[i].getMasp().indexOf(masanpham) != -1) {
				return true;
			}
		}
		return false;
	}
  */

  /*
   *         //CẬP NHẬT SỐ LƯỢNG VÀ ĐƠN GIÁ SAU KHI NHẬP PHIẾU NHẬP
    public void capNhat_SP_DG_PhieuNhap(String maSP,int soLuong,double dongia){
        for(int i = 0; i < n; i++){
            if(sp[i].getMasp().equals(maSP)){
                int slMoi = sp[i].getSl() + soLuong;
                sp[i].setSl(slMoi);
                sp[i].setGia(dongia);
            } 
        }
    }
   */
  //all in danhsachsanpham

