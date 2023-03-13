package org.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/* EJEMPLO: CREAR INYECCION DE DEPENDENCIAS POR MEDIO DE 
 * ANOTACION @Authorized, CREAR UNA CONEXION A BASE DE DATOS
 * EMPLEANDO UN DATASOURCE (FUENTE U ORIGEN DE DATOS
 * 
 * 
 * ORACLE <---- Spring <----   DAO IMPL
 * TABLE      Datasource         CLASS
 *                           @Authorized
 * 
 * 
 * @@Component CONVIERTE LA CLASE EN UN BEAN <bean id = "daoImpl">
 * 
 * 
 */


@Component
public class DaoImpl {
	
	@Autowired
	private DataSource dataSource;

	
	
	//GET AND SET DATASOURCE
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	} 
	
	
	//QUERIE
	
	
	public void selectS_Region() {
		Connection connection = null; 
		try {
			//establece conexion con oracle
			
			connection = dataSource.getConnection();
			//CREA CONSULTA
			String sql = "SELECT * FROM S_REGION"; 
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet resultSet = pStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("id")+","+resultSet.getString("name"));
			}
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
			// TODO: handle exception
		}
	}
	
	
	
	
	
	
	

}
