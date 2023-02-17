import java.sql.SQLException;
import java.util.List;

public class TesterDao {
    public static void main(String[] args) throws SQLException {
    DeviceDao devDao = new DeviceDao();
        List<Device> devices = devDao.getAllDeviceWIthHearthRateAndGps("paolo");
        for (Device device : devices){
            String manufact = device.getDeviceManufacturer().toLowerCase();
            String partNumber = device.getDevicePartNumber();
            String model = device.getDeviceModel().toUpperCase();
            String user = device.getUsername();
            System.out.println(user + " " + model + " " + partNumber + " " + manufact);
    }
    }
}