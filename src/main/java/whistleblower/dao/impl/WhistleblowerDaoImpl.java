package whistleblower.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import whistleblower.dao.WhistleblowerDao;
import whistleblower.model.Whistleblower;


public class WhistleblowerDaoImpl implements WhistleblowerDao{

	@Override
	public int insert(Whistleblower whistleblower) {
		final String sql = "INSERT INTO whistleblowerform (MemID, Violations, ViolationsDate, ViolationsTime, ViolationsAddress, VehicleType, VehicleNo) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?);";
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)
		) {
			pstmt.setInt(1, whistleblower.getMemID());
			pstmt.setString(2, whistleblower.getViolations());
			pstmt.setString(3, whistleblower.getViolationsDate());
			pstmt.setString(4, whistleblower.getViolationsTime());
			pstmt.setString(5, whistleblower.getViolationsAddress());
			pstmt.setString(6, whistleblower.getVehicleType());
			pstmt.setString(7, whistleblower.getVehicleNo());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int update(Whistleblower whistleblower) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Whistleblower> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Whistleblower selectByID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
