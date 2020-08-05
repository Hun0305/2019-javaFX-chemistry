package org.dimigo.javaFX.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

// 첫번째 화면에서 가수와 물질 이름을 설정하기 위한 컨츄럴러
public class Controller implements Initializable {
    @FXML ComboBox<String> acidBox;
    @FXML ComboBox<String> basicBox;
    @FXML Button nextButton;
    @FXML Button previousButton;

    String stemp; // String 변수 대체 변수
    double itemp; // double 변수 대체 변수

    @Override
    public void initialize (URL location, ResourceBundle resources) {
        acidBox.getItems().addAll("HCl", "CH3COOH", "H2SO4", "H2CO3", "H3PO4");
        basicBox.getItems().addAll("NaOH", "KOH", "Ca(OH)2", "Ba(OH)2", "Al(OH)3");
    } // ComboBox 초기화

    // '다음' 버튼을 눌렀을 때 실행되는 함수
    public void handleEnterAction (ActionEvent event) throws Exception {
        stemp = acidBox.getValue(); // 첫번째 박스에서 값을 가져옴

        // 설정 안 했으면 자동으로 'HCl' 넣어짐
        if (stemp == null) {
            System.out.println("입력된 값이 없습니다. HCl을 입력합니다.");
            stemp = "HCl";
        }

        // 물질 이름에 따라 가수를 설정함.
        switch(stemp) {
            case "HCl" :
            case "CH3COOH" :
                itemp = 1;
                break;

            case "H2SO4" :
            case "H2CO3" :
                itemp = 2;
                break;

            case "H3PO4" :
                itemp = 3;
                break;

            default:
                System.out.println("오류");
                break;
        }

        // 진짜 설정
        Value.setName1(stemp);
        Value.setValue1(itemp);

        // 이제 염기
        stemp = basicBox.getValue();

        if (stemp == null) {
            System.out.println("입력된 값이 없습니다. NaOH을 입력합니다.");
            stemp = "NaOH";
        }

        switch(stemp) {
            case "NaOH" :
            case "KOH" :
                itemp = 1;
                break;

            case "Ca(OH)2" :
            case "Ba(OH)2" :
                itemp = 2;
                break;

            case "Al(OH)3" :
                itemp = 3;
                break;

            default:
                System.out.println("오류");
                break;
        }

        Value.setName2(stemp);
        Value.setValue2(itemp);

        System.out.println("산 가수 : " + Value.getValue1() + " 염기 가수 : " + Value.getValue2());

        // 다음씬 로딩
        Stage stage = (Stage) nextButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/dimigo/javaFX/project/inputMole.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    // 여기서 '이전' 버튼 누르면 메인화면으로 가게 해주센
}