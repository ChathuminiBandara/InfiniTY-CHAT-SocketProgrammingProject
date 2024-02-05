package lk.ijse.chatapplication;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.chatapplication.Model.UserModel;
import lk.ijse.chatapplication.dto.UserDto;

import java.io.IOException;
import java.sql.SQLException;

public class AddNewUserFormController extends Application {
    public TextField txtUsername;
    static String username;
    public TextField password;

    private UserModel userModel = new UserModel();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/NewUser.fxml"))));
        stage.show();

        new Thread(()->{
            ServerFormContoller serverFormContoller = new ServerFormContoller();
            try {
                serverFormContoller.Server();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public void btnAddOnAction(ActionEvent actionEvent) throws IOException {
        if(txtUsername==null || password == null) {
            new Alert(Alert.AlertType.ERROR, "User Name Reqired !").show();
        }else {
            username = txtUsername.getText();
            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/ClientForm.fxml"))));
            stage.setTitle(txtUsername.getText() + "'s Chat");
            savepassword();
            stage.show();
            txtUsername.clear();
            password.clear();
        }

    }

    public void savepassword(){
         String pw = password.getText();
         String username1 = txtUsername.getText();

        var dto = new UserDto(pw,username1);

        try {
            boolean isSaved = userModel.saveUser(dto);

            if (isSaved) {
               // new Alert(Alert.AlertType.CONFIRMATION, "User saved!").show();

            }
        } catch (SQLException e) {
           //new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}
