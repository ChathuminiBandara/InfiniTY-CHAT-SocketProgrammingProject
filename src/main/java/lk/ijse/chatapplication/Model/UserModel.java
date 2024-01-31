package lk.ijse.chatapplication.Model;

import lk.ijse.chatapplication.db.DbConnection;
import lk.ijse.chatapplication.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserModel {
    public boolean saveUser(UserDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO users VALUES(?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getUn());
        pstm.setString(2, dto.getPw());


        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }
}
