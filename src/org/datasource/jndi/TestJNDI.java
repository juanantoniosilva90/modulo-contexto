package org.datasource.jndi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import oracle.net.aso.e;

public class TestJNDI {

	public static void main(String[] args) {
		
		try {
			//CCONEXION DE JNDI A ORACLE
			InitialContext context= new InitialContext();	
			DataSource dataSource = (DataSource) context.lookup("jdbc/Oracle");
			Connection conectionConnection = dataSource.getConnection();
			
			
			
			
			//QUERIE
			
			
			String sql = "SELECT * FROM S_REGION";
			PrepareStatement psPrepareStatement = Connection.prepareStatement(sql);
			ResultSet rSet = ps.executeQuery();
			while(rSet.next()) {
				System.out.println(rSet.getInt("id")+","+rSet.getString("name"));
			}
			
		}catch (Exception e) {
			System.out.println("Exception"+e.getMessage());
		}

	}

}
