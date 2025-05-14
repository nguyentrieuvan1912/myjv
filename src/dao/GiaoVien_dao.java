package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.Database;
import entity.GiaoVien;

public class GiaoVien_dao {
List<entity.GiaoVien> dsgv;

public GiaoVien_dao() {
	dsgv = new ArrayList<entity.GiaoVien>();
	
}

public List<entity.GiaoVien> docTuBang(){
	try {
		Connection con  = Database.getInstance().getConnection();
		String sql = "Select * from GiaoVien";
		Statement statement = con.createStatement();
		
		ResultSet rs =  statement.executeQuery(sql);
		
		while(rs.next()) { 
			String ma = rs.getString("maGiaoVien");
			String ten = rs.getString(2); 
			
			GiaoVien s = new GiaoVien(ma, ten);
			
			dsgv.add(s);
			
		} 
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return dsgv;
}







}
