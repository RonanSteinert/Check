import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TrainingDAo {
    public TrainingSessionWithData getTraningSessionDataByTrainingId(Integer trainingId) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "snow");
            PreparedStatement ps = connection.prepareStatement("SELECT TS., TSD. FROM TRAINING_SESSION TS FULL JOIN TRAINING_SESSION_DATA TSD ON ID_TRAINING_SESSION = ID_TRAINING_SESSION_DATA");

        }


    }
}
