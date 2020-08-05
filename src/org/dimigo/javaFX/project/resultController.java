package org.dimigo.javaFX.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class resultController {
    @FXML TextField acidTextBox;
    @FXML TextField basicTextBox;
    @FXML Label NameField;
    @FXML Label MolField;
    @FXML Button previousButton;
    @FXML Button enterButton;

    static double dtemp1;
    static double dtemp2;
    static double result;

    // 다음버튼 누르면 실행되는거
    public void enterAction (ActionEvent event) {
        try {
            dtemp1 = Double.parseDouble(acidTextBox.getText());
            dtemp2 = Double.parseDouble(basicTextBox.getText()); // 각각의 박스에서 값을 가져오고, 세팅
            Value.setVolume1(dtemp1);
            Value.setVolume2(dtemp2);
            normalAction();

            System.out.println("산 부피 : " + Value.getVolume1() + " 염기 부피 : " + Value.getVolume2());
        } catch (Exception e) {
            System.out.println("정확한 값을 입력해주세요");
            return;
        }
    }

    // 몰농도를 구해서 출력
    public void normalAction () {
        if (Value.getAcidOrBasic().equals("산")) {
            NameField.setText(Value.getName1());
            result = Value.getValue2() * Value.getM2() * Value.getVolume2() / Value.getValue1() / Value.getVolume1();
            MolField.setText(String.format("%.2f", result));
        }

        else if (Value.getAcidOrBasic().equals("염기")) {
            NameField.setText(Value.getName2());
            result = Value.getValue1() * Value.getM1() * Value.getVolume1() / Value.getValue2() / Value.getVolume2();
            MolField.setText(String.format("%.2f", result));
        }

        else {
            System.out.println("오류");
        }
    }

    // 씬전환
    public void handlePreviousAction (ActionEvent event) throws Exception {
        Stage stage = (Stage) previousButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/dimigo/javaFX/project/inputMole.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
