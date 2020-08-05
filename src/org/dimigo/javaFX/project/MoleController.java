package org.dimigo.javaFX.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

public class MoleController implements Initializable {
    @FXML ComboBox<String> inputBox;
    @FXML TextField textBox;
    @FXML Button previousButton;
    @FXML Button nextButtton;

    public static String stemp;
    static double dtemp;

    // 콤보박스 초기화
    public void initialize (URL location, ResourceBundle resources) {
        inputBox.getItems().addAll("산 수용액", "염기 수용액");
    }

    // 다음버튼 누르면 실행됨
    public void handleEnterAction (ActionEvent event) {
        try {
            dtemp = Double.parseDouble(textBox.getText()); // 몰농도 입력한거를 가져옴
            normalAction(); // 정상적으로 가져왔으면 실행됨
        } catch (InvocationTargetException ite) { // 이거 뭔오류인지 모르겠는데 에러뜰때 떠서 처리해줌
            System.out.println("InvocationTartgetException On");
            return;
        } catch (NumberFormatException nfe) { // 이상한값 넣으면 발생하는 오류
            System.out.println("정확한 값을 입력해주세요.");
            return;
        } catch (Exception e) { // 그 외
            System.out.println("원인을 알 수 없는 오류입니다.");
            return;
        }
    }

    public void normalAction() throws Exception {
        stemp = inputBox.getValue(); // 박스에서 값을 가져옴

        if (stemp == null) {
            System.out.println("입력된 값이 없습니다. 산 수용액을 입력합니다.");
            stemp = "산 수용액";
        }

        // 산수용액이면 염기 몰농도에 입력한 값을 넣고, 염기면 반대로
        switch (stemp) {
            case "산 수용액":
                inputBasicM();
                Value.setAcidOrBasic("산");
                break;

            case "염기 수용액":
                inputAcidM();
                Value.setAcidOrBasic("염기");
                break;

            default:
                System.out.println("오류");
                break;
        }
        System.out.println("산 몰농도 : " + Value.getM1() + " 염기 몰농도 : " + Value.getM2());

        // 씬전환
        Stage stage = (Stage) nextButtton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/dimigo/javaFX/project/result.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void inputBasicM() {
        Value.setM2(dtemp);
    }

    public static void inputAcidM() {
        Value.setM1(dtemp);
    }

    // 씬전환
    public void handlePreviousAction (ActionEvent event) throws Exception {
        Stage stage = (Stage) previousButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/dimigo/javaFX/project/application.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
