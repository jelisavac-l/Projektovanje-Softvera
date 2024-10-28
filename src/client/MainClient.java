package client;

import client.ui.Login;
import com.formdev.flatlaf.FlatLightLaf;

public class MainClient {
    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Login().setVisible(true);
    }
}
