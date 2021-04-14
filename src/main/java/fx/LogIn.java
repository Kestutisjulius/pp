package fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LogIn {



    @FXML
    private Button button;
    @FXML
    private Label wrongLogInLabel;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;

    public void userLogIn(ActionEvent event) throws IOException {
        checkLogin();
    }
    private void checkLogin() throws IOException {
        FxMain main = new FxMain();
        if (userName.getText().equals("J1x") && password.getText().equals("123")) {
            wrongLogInLabel.setText("Success!");
            main.changeScene("afterLogin.fxml");
        }
        else if (userName.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogInLabel.setText("Please enter your data.");
        }
        else {
            wrongLogInLabel.setText("Wrong username or password");
        }
    }
}
