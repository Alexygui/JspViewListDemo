package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Items;
import util.DBHelper;

/**
 * 商品的业务逻辑类
 */
public class ItemsDAO {
	/**
	 * 获得所有的商品信息
	 */
	public ArrayList<Items> getAllItems() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Items> items = new ArrayList<Items>();// 商品的集合
		try {
			connection = DBHelper.getConnection();
			String sqlString = "select id, name, city, price, number, picture from items";
			preparedStatement = connection.prepareStatement(sqlString);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Items item = new Items();
				items.add(item);
				item.setId(resultSet.getInt("id"));
				item.setName(resultSet.getString("name"));
				item.setCity(resultSet.getString("city"));
				item.setPrice(resultSet.getInt("price"));
				item.setNumber(resultSet.getInt("number"));
				item.setPicture(resultSet.getString("picture"));
				;
			}
			// 返回商品集合
			return items;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;// 发生异常的时候仍然要有返回值
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
					resultSet = null;
				}
				if(preparedStatement != null) {
					preparedStatement.close();
					preparedStatement = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
