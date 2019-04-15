package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.DBConnector;
import com.dao.AddrDAO;

public class AddrDAOImpl implements AddrDAO {

	private static String selectAddrList = "select * from address where ad_num <= 100";
	
	@Override
	public List<Map<String, String>> selectAddrList(Map<String, String> addr) {
		try {
			List<Map<String,String>> addrList = new ArrayList<>();
			PreparedStatement ps = DBConnector.getCon().prepareStatement(selectAddrList);
			//ResultSet rs = ps.executeQuery();
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,String> addrs = new HashMap<>();
				addrs.put("adNum", rs.getString("ad_num"));
				addrs.put("adCode", rs.getString("ad_code"));
				addrs.put("adSido", rs.getString("ad_sido"));
				addrs.put("adGugun", rs.getString("ad_gugun"));
				addrs.put("adDong", rs.getString("ad_dong"));
				addrs.put("adLee", rs.getString("ad_lee"));
				addrs.put("adBunji", rs.getString("ad_bunji"));
				addrs.put("adHo", rs.getString("ad_ho"));
				addrs.put("adRoadCode", rs.getString("ad_roadcode"));
				addrs.put("adIsbase", rs.getString("ad_isbase"));
				addrs.put("adOrgnum", rs.getString("ad_orgnum"));
				addrs.put("adSubnum", rs.getString("ad_subnum"));
				addrs.put("adJinum", rs.getString("ad_jinum"));
				addrList.add(addrs);
			}
			return addrList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, String> selectAddr(Map<String, String> addr) {
		return null;
	}

	@Override
	public int insertAddr(Map<String, String> addr) {
		return 0;
	}

	@Override
	public int deleteAddr(Map<String, String> addr) {
		return 0;
	}

	@Override
	public int updateAddr(Map<String, String> addr) {
		return 0;
	}
	
	public static void main(String[] args) {
		AddrDAO adao = new AddrDAOImpl();
		System.out.println(adao.selectAddrList(null));
	}

}
