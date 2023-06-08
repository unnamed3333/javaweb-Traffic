package ticket.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import core.bean.Ticket;
import ticket.dao.TicketDao;	

public class TicketDaoImpl implements TicketDao {

	@Override
	public List<Ticket> selectByMemId(Integer memId, Integer status) {
		final String sql = "select t.* from ticket t \r\n" + "left join Vehicle v on t.VehicleNo = v.VehicleNo\r\n"
				+ "left join relatedperson r on  r.ID = v.RelatedPersonID\r\n"
				+ "where (v.RelatedPersonID is not null or t.MemID is not null)\r\n"
				+ "and (t.MemID = ? or r.MemID = ?) and (t.Status = ?);";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, memId);
			pstmt.setInt(2, memId);
			pstmt.setInt(3, status);
			try (ResultSet rs = pstmt.executeQuery()) {
				List<Ticket> list = new ArrayList<>();
				while (rs.next()) {
					Ticket ticket = new Ticket();
					ticket.setTicketNo(rs.getString("ticketNo"));
					ticket.setMemID(rs.getInt("memID"));
					ticket.setDriver(rs.getString("driver"));
					ticket.setPhoneNo(rs.getString("phoneNo"));
					ticket.setVehicleNo(rs.getString("vehicleNo"));
					ticket.setVehicleType(rs.getString("vehicleType"));
					ticket.setViolationsTime(rs.getTimestamp("violationsTime"));
					ticket.setViolationsAddress(rs.getString("violationsAddress"));
					ticket.setViolations(rs.getString("violations"));
					ticket.setReportingRegulations(rs.getString("reportingRegulations"));
					ticket.setAmount(rs.getInt("amount"));
					ticket.setPaymentDueDate(rs.getTimestamp("paymentDueDate"));
					ticket.setPolice(rs.getString("police"));
					ticket.setUnit(rs.getString("unit"));
					ticket.setStatus(rs.getInt("status"));
					ticket.setPaymentTime(rs.getTimestamp("paymentTime"));
					ticket.setAppendix(selectAllAppendix(rs.getString("ticketNo")));
					list.add(ticket);
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Ticket> selectByMemIdHistory(Integer memId) {
		final String sql = "select t.* from ticket t \r\n" + "left join Vehicle v on t.VehicleNo = v.VehicleNo\r\n"
				+ "left join relatedperson r on  r.ID = v.RelatedPersonID\r\n"
				+ "where (v.RelatedPersonID is not null or t.MemID is not null)\r\n"
				+ "and (t.MemID = ? or r.MemID = ?) and (t.Status = 1 or t.Status = 3);";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, memId);
			pstmt.setInt(2, memId);
			try (ResultSet rs = pstmt.executeQuery()) {
				List<Ticket> list = new ArrayList<>();
				while (rs.next()) {
					Ticket ticket = new Ticket();
					ticket.setTicketNo(rs.getString("ticketNo"));
					ticket.setMemID(rs.getInt("memID"));
					ticket.setDriver(rs.getString("driver"));
					ticket.setPhoneNo(rs.getString("phoneNo"));
					ticket.setVehicleNo(rs.getString("vehicleNo"));
					ticket.setVehicleType(rs.getString("vehicleType"));
					ticket.setViolationsTime(rs.getTimestamp("violationsTime"));
					ticket.setViolationsAddress(rs.getString("violationsAddress"));
					ticket.setViolations(rs.getString("violations"));
					ticket.setReportingRegulations(rs.getString("reportingRegulations"));
					ticket.setAmount(rs.getInt("amount"));
					ticket.setPaymentDueDate(rs.getTimestamp("paymentDueDate"));
					ticket.setPolice(rs.getString("police"));
					ticket.setUnit(rs.getString("unit"));
					ticket.setStatus(rs.getInt("status"));
					ticket.setPaymentTime(rs.getTimestamp("paymentTime"));
					ticket.setAppendix(selectAllAppendix(rs.getString("ticketNo")));
					list.add(ticket);
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<byte[]> selectAllAppendix(String ticketNo) {
		final String sql = "select * from Appendix where ticketNo = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, ticketNo);
			try (ResultSet rs = pstmt.executeQuery()) {
				List<byte[]> result = new ArrayList<>();
				if (rs.next()) {
					result.add(rs.getBytes("Appendix"));
					return result;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
