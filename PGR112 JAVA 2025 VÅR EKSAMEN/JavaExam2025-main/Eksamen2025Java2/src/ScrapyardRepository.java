import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ScrapyardRepository {
    private final Connection con; //Disse klassene har final Connection

    public ScrapyardRepository(Connection con) {
        this.con = con;
    }

    private static final String query = SqlQueries.INSERT_SCRAPYARD_VALUES;

    public void insertScrapyardValuesToDB(List<Scrapyard> scrapyardList) throws SQLException {
        PreparedStatement stmt = con.prepareStatement(query);
        for (Scrapyard s : scrapyardList) {
            stmt.setInt(1, s.scrapyardID());
            stmt.setString(2, s.name());
            stmt.setString(3, s.address());
            stmt.setString(4,s.phoneNumber());
            stmt.addBatch();
        }
        stmt.executeBatch();
    }

}
