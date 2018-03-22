package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.awt.*;
import java.sql.Statement;

/**
 * main class for application
 *
 * @author mac
 */
public class Main extends Application {

    @FXML
    private Button btnOK;//button for login
    @FXML
    private TextField textName;//input password
    @FXML
    private TextField textProgram;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));
        primaryStage.setTitle("CMUA Identification System");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

    }

    /**
     * launch the FX
     *
     * @param args
     */
    public static void main(String[] args) {
        //create();
        PlayMusic p = new PlayMusic();
        p.play();
        launch(args);

        //creates();
    }

    /**
     * connect to login user database
     */
    public static void creates() {

        try {
            Connect db = new Connect();
            java.sql.Connection conn = db.Connect();
            Statement st = conn.createStatement();
            //INSERT INTO visitor (visitdate,name,program,gender,reason) VALUES ('2017-10-31','Troy','MISM','male','stapler')
            //insert into students(ID,program,name,age,gender) VALUES (1,'MISM','Nion','22','male')
            st.execute("CREATE TABLE login(username VARCHAR(100),password VARCHAR(100))");

            //System.out.println("suceess");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * connect to student information database
     */
    public static void create() {

        try {
            Connect db = new Connect();
            java.sql.Connection conn = db.Connect();
            Statement st = conn.createStatement();
            //INSERT INTO visitor (visitdate,name,program,gender,reason) VALUES ('2017-10-31','Troy','MISM','male','stapler')
            //insert into students(ID,program,name,age,gender) VALUES (1,'MISM','Nion','22','male')
            st.execute("CREATE TABLE studentInformatt (ID INTEGER NOT NULL,NAME VARCHAR(100),PROGRAM VARCHAR(100), AGE VARCHAR(10), GENDER VARCHAR(10), PRIMARY KEY (ID))");
            st.execute("CREATE TABLE viss (visitdate varchar(30),ids int generated by default as identity,name varchar(30),program varchar(30),gender varchar(30),reason varchar(30),PRIMARY KEY (ids))");
            // create table

            //System.out.println("suceess");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}