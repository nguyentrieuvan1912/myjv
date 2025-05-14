package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.Database;
import entity.GiaoVien;
import entity.LopHoc;

public class LopHoc_dao {
	ArrayList<entity.LopHoc> dslop;
	LopHoc lh;
	public LopHoc_dao() {
		dslop = new ArrayList<LopHoc>();
		
	}
	
	
	public ArrayList<entity.LopHoc> docTuBang(){
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "select * from LopHoc JOIN GiaoVien ON LopHoc.maGiaoVien = GiaoVien.maGiaoVien";
			Statement statement =con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
		
			while (rs.next()) { 
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String gvString = rs.getString(6);
				int siso = rs.getInt(4);
				LopHoc s = new LopHoc(ma, ten, new GiaoVien(gvString), siso);
				dslop.add(s);
			}
			
			
			
			
		} catch (SQLException e) {
		e.printStackTrace();
		}
		
		return dslop;
	}

	public ArrayList<LopHoc> getLopTheoMaLop(String malop){
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null; 
		try {
			String sql = "select * from LopHoc where maLop = ?";
			stmt = con.prepareStatement(sql); 
			stmt.setString(1,malop);
			
			ResultSet rs = stmt.executeQuery();
			 
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String gv = rs.getString(3); 
				int siso = rs.getInt(4);
				LopHoc s = new LopHoc(malop, ten, new GiaoVien(gv), siso);
				dslop.add(s);
				
			}
			 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dslop;
	}
	
	public boolean create(LopHoc lh) {
	    Connection con = Database.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    int n = 0;
	    try {
	        // Đảm bảo câu lệnh có đủ tham số cho 4 cột
	        String sql = "INSERT INTO LopHoc VALUES (?, ?, ?, ?)";
	        stmt = con.prepareStatement(sql);
	        
	        // Set giá trị cho các tham số
	        stmt.setString(1, lh.getMaLop());  // maLop
	        stmt.setString(2, lh.getTenLop()); // tenLop
	        stmt.setString(3, lh.getGiaoVien().getMaGv()); // maGiaoVien
	        stmt.setInt(4, lh.getSiso()); // siSo

	        // Thực thi câu lệnh
	        n = stmt.executeUpdate(); 

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return n > 0;  // Trả về true nếu cập nhật thành công
	}

	
	
	public boolean update(LopHoc lh) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n =0;
		
		try {
			stmt = con.prepareStatement("update LopHoc set tenLop = ?, maGiaoVien = ?, siso = ? where malop = ?");
			stmt.setString(1, lh.getTenLop());
			stmt.setString(2, lh.getGiaoVien().getMaGv());
			stmt.setInt(3, lh.getSiso());
			stmt.setString(4, lh.getMaLop());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
		e.printStackTrace();
		}   
		
	return n > 0;	 
	}
	public boolean delete(String malop) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n =0;
		try {
		stmt = con.prepareStatement("delete from LopHoc where malop = ?");
		stmt.setString(1, malop);
		n = stmt.executeUpdate();
		
		
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
		 
	}
}
