import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeviceDao {
    Device dev = null;
    ResultSet rs =null;

    List<Device> list = new ArrayList<>();
    public List<Device> getAllDeviceWIthHearthRateAndGps(String username) throws SQLException {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "snow");
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM device WHERE DEVICE_HAS_GPS != ? and DEVICE_HAS_HEARTRATE != ? and USERNAME = ?");
            ps.setInt(1, 0);
            ps.setInt(2, 0);
            ps.setString(3, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                dev = new Device(rs.getString("DEVICE_PART_NUMBER"),
                        rs.getString("DEVICE_MANUFACTURER"),
                        rs.getString("DEVICE_MODEL"),
                        rs.getShort("DEVICE_HAS_GPS"),
                        rs.getShort("DEVICE_HAS_HEARTRATE"),
                        rs.getString("USERNAME"));
                list.add(dev);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            rs.close();
        }
        return list;
    }
}
