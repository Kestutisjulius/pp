package fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Afterlogin {

    @FXML
    private Button logout;

    public void userLogOut(ActionEvent event) throws IOException {
        FxMain main = new FxMain();
        main.changeScene("login.fxml");
    }
}
