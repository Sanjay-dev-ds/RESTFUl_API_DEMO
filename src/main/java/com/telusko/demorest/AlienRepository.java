package com.telusko.demorest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlienRepository {

	private Connection con;

	public AlienRepository() {
		this.con = new AlienDb().getConnection();
	}

	public List<Alien> getAliens() {
		List<Alien> aliens = new ArrayList<>();
		String sql = "select * from alien";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Alien a = new Alien();
				a.setId(rs.getInt(1));
				a.setPoints(rs.getInt(2));
				a.setName(rs.getString(3));

				aliens.add(a);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return aliens;

	}

	public Alien getAlien(int id) {
		String sql = "select * from alien where id =" + id;
		Alien a = new Alien();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {

				a.setId(rs.getInt(1));
				a.setPoints(rs.getInt(2));
				a.setName(rs.getString(3));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return a;
	}

	public void create(Alien a) {
		String sql = "insert into alien values (?,?,?)";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, a.getId());
			st.setInt(2, a.getPoints());
			st.setString(3, a.getName());

			st.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void update(Alien a) {
		String sql = "update alien set name = ? , points = ? where id = ?";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, a.getName());
			st.setInt(2, a.getPoints());
			st.setInt(3, a.getId());
			st.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public void delete(Alien a) {
		String sql = "delete from alien where id = ? ";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, a.getId());
			st.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
