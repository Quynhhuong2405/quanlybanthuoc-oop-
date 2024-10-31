import java.util.Scanner;

public class PhieuNhap {
    Scanner sc = new Scanner(System.in);
    
    private int slCTPN;
    private ChiTietPhieuNhap ctpn[];
    
    private String maNV, maNCC, hoNV, tenNV, tenNCC;
    private double tongtien;

    //Constructors
    public PhieuNhap() {
        tongtien = 0;
    }

    public PhieuNhap(String maNV,String hoNV, String tenNV, String maNCC, String tenNCC, double tongtien, int slCTPN, ChiTietPhieuNhap[] ctpn){
        this.slCTPN = slCTPN;
        this.ctpn = ctpn;
        this.maNV = maNV;
        this.maNCC = maNCC;
        this.tenNV = tenNV;
        this.hoNV = hoNV;
        this.tenNCC = tenNCC;
        this.tongtien = tongtien;
    }

    public PhieuNhap(PhieuNhap pn) {
        this.slCTPN = pn.slCTPN;
        this.ctpn = pn.ctpn;
        this.maNV = pn.maNV;
        this.hoNV = pn.hoNV;
        this.tenNV = pn.tenNV;
        this.maNCC = pn.maNCC;
        this.tenNCC = pn.tenNCC;
        this.tongtien = pn.tongtien;
    }
    
    //GET

    public double gettongtien() {
        return tongtien;
    }
    public int getslCTPN() {
        return slCTPN;
    }

    public ChiTietPhieuNhap[] getCTPN() {
        return ctpn;
    }

    public String getmaNV() {
        return maNV;
    }

    public String gethoNV() {
        return hoNV;
    }

    public String gettenNV() {
        return tenNV;
    }

    public String getmaNCC() {
        return maNCC;
    }
    
    public String gettenNCC() {
        return tenNCC;
    }
    
    //SET
    public void settongtien(double tongtien) {
        this.tongtien = tongtien;
    }   
    
    public void setslCTPN(int slCTPN) {
        this.slCTPN = slCTPN;
    }

    public void setChiTietPhieuNhap(ChiTietPhieuNhap[] ctpn) {
        this.ctpn = ctpn;
    }

    public void setmaNV(String maNV) {
        this.maNV = maNV;
    }

    public void sethoNV(String hoNV) {
        this.hoNV = hoNV;
    }

    public void settenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setmaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public void settenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }
        
    //Nhap xuat chi tiet phieu nhap
    public void nhap(DanhSachSanPham dssp, DanhSachNhanVien dsnv, DanhSachNhaCungCap dsncc) {
        do {
            dsnv.xuatDanhSachNV();
            System.out.print("Nhap ma nhan vien phu trach: ");
            maNV = sc.nextLine();
            if(dsnv.xetTonTai(maNV)) {
                hoNV = dsnv.truyenDuLieu_NV_Ho(maNV);
                tenNV = dsnv.truyenDuLieu_NV_Ten(maNV);
            }
            else{
                System.out.println("\nMa nhan vien khong co trong danh sach.");
                System.out.println();
            }
	    } while(dsnv.xetTonTai(maNV) != true);
        
        do {
            dsncc.xuatDanhSach();
            System.out.print("\nNhap ma nha cung cap: ");
            maNCC = sc.nextLine();
            if(dsncc.xetTonTai(maNCC)){
                tenNCC = dsncc.truyenDuLieu_NCC(maNCC);
            }
            else{
                System.out.print("Khong tim thay nha cung cap.");
                System.out.println();                    
            }
        } while(!dsncc.xetTonTai(maNCC));    

            System.out.print("Nhap so luong chi tiet phieu nhap :");
            slCTPN  = sc.nextInt();
            ctpn = new ChiTietPhieuNhap[slCTPN];
            for(int i = 0; i < slCTPN; i++){
                ctpn[i] = new ChiTietPhieuNhap();
                ctpn[i].nhap(dssp); 
            }
            tinhtongtien();
    }
    
   public void tinhtongtien(){
            for(int i = 0; i < slCTPN; i++)
                tongtien += ctpn[i].getThanhtien();
        }
	
    public void xuat() {
        System.out.println("Ma nhan vien phu trach: " + maNV);
        System.out.println("Ho va ten nhan vien phu trach: " + hoNV + " " + tenNV);
        System.out.println("Ma nha cung cap: " + maNCC);
        System.out.println("Ten nha cung cap: " + tenNCC);
        
        System.out.println("Thong tin chi tiet phieu nhap:");
        System.out.format("|| %12s | %10s | %10s | %15s ||\n",  "MA SAN PHAM", "SO LUONG", "DON GIA", "THANH TIEN");
        for (int j = 0; j < slCTPN; j++) {
            System.out.format("|| %4s |", (j + 1));
            if (ctpn[j] != null) {
                ctpn[j].xuat();
            }
        }
    }
}

/*
 * public void xuatDanhSachNV() {
		
		System.out.println("\t\t\t\t\t\t=======DANH SÁCH NHÂN VIÊN=======");
		System.out.println("================================================================================================================================");
		System.out.format("|| %4s | %8s |%25s| %5s | %12s | %13s | %12s | %13s ||\n", "STT", "MÃ NV","HỌ VÀ TÊN CỦA NHÂN VIÊN", "GIỚI", "NGÀY SINH", "SĐT", "CHỨC VỤ", "LƯƠNG");
                try {
			for (int i = 0; i < n; i++) {                                                         
                                System.out.format("|| %4s |", (i + 1));
                                if(nv[i] != null)
                                    nv[i].xuat();                          
                        }
		}catch(NullPointerException npe) {			
		}
		 System.out.println("================================================================================================================================");
	}
 */

 /*
  * public boolean xetTonTai(String maNV){
            for(int i = 0; i < n; i++){
                if(nv[i].getmaNV().equals(maNV))
                    return true;
            }
            return false;
        }
  */

/*
 * public String truyenDuLieu_NV_Ho(String maNV) {
		for(int i = 0; i < n; i++) {
			if(nv[i].getmaNV().equals(maNV)) {
				return nv[i].ho;
			}
		}
		return null;
	}
 */

 /*
  *  public String truyenDuLieu_NV_Ten(String maNV) {
		for(int i = 0; i < n; i++) {
			if(nv[i].getmaNV().equals(maNV)) {
				return nv[i].ten;
			}
		}
		return null;
	}
  */

 //all in class danhsachnhanvien

 /*
  * public boolean xetTonTai(String manhacungcap) {
		for(int i = 0; i < n; i++) {
			if(ncc[i].getMancc().indexOf(manhacungcap) != -1){
				return true;
			}
		}
		return false;
	}
  */

  /*public String truyenDuLieu_NCC(String manhacungcap) {
		for(int i = 0; i < n; i++) {
			if(ncc[i].getMancc().indexOf(manhacungcap) != -1) {
				return ncc[i].getTenncc();
			}
		}
		return null;
	} */

  // in class DanhSachNhaCungCap

  
