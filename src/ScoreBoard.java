
import Game.GameController;
import Game.Player;
import Game.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.nio.file.Paths;
import java.util.ArrayList;


	


public class ScoreBoard{


    private Scene scene;
    private ArrayList<Player> players = new ArrayList<>();
    private MediaPlayer mediaPlayer;
    ScoreBoard(Stage stage)
    {


        Media sound = new Media(Paths.get("ScoreBoard.mp3").toUri().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });
        mediaPlayer.play();


        Image bgImage = new Image("file:resources/ScoreBoard.gif");


        ImageView bgIv = new ImageView(bgImage);
        bgIv.setPreserveRatio(false);
        bgIv.setFitWidth(1220);
        bgIv.setFitHeight(820);

        Ellipse ellipse = new Ellipse();
        ellipse.setRadiusX(100);
        ellipse.setRadiusY(51);
        ellipse.setLayoutX(611);
        ellipse.setLayoutY(65);
        ellipse.setFill(Color.GREY);

        Label label = new Label("Welcome to Score Board!");
        label.setPrefHeight(63);
        label.setPrefWidth(175);
        label.setLayoutX(527);
        label.setLayoutY(34);
        label.setTextFill(Color.WHITE);

        TableView scoreBoardTable = new TableView();
        scoreBoardTable.setLayoutX(168);
        scoreBoardTable.setLayoutY(134);
        scoreBoardTable.setPrefWidth(885);
        scoreBoardTable.setPrefHeight(506);
        scoreBoardTable.setOpacity(0.75);

        Circle circle = new Circle(50);
        Button exitBtn = new Button("MainMenu");
        exitBtn.setPrefWidth(112);
        exitBtn.setPrefHeight(50);
        exitBtn.setLayoutX(1053);
        exitBtn.setLayoutY(731);
        exitBtn.setOpacity(1);
        exitBtn.setShape(circle);
        exitBtn.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
        exitBtn.setTextFill(Paint.valueOf("White"));

        exitBtn.setOnAction(e->{
            GuiMainMenu mainMenu = new GuiMainMenu(stage);
            stage.setScene(mainMenu.getScene());
            mediaPlayer.stop();
        });


        //TABLE SETTING
        //Player player = new Player("Mahmoud", 250, "Classic Hard");

        ObservableList<Player> playerObservableList = FXCollections.observableArrayList();
        GameController gameController = GameController.getInstance();
        players = gameController.listPlayers();
        if(!players.isEmpty())
        {
            for (int i = 0; i < players.size(); i++) {
                playerObservableList.add(players.get(i));
            }
        }
        //playerObservableList.add(player);

        //THIS SHOULD BE LINKING TO LOAD ...
        //ArrayList<Game.Player> playersList = player.getPlayerList();


        TableColumn<Player, String> playerNameColumn = new TableColumn<>("Name");
        playerNameColumn.setCellValueFactory(new PropertyValueFactory<>("playerName"));

        TableColumn<Player, Integer> playerScoreColumn = new TableColumn<>("Score");
        playerScoreColumn.setCellValueFactory(new PropertyValueFactory<>("playerScore"));

        TableColumn<Player, String> difficultyColumn = new TableColumn<>("Difficulty");
        difficultyColumn.setCellValueFactory(new PropertyValueFactory<>("difficulty"));


        playerNameColumn.setPrefWidth(295);
        playerScoreColumn.setPrefWidth(295);
        difficultyColumn.setPrefWidth(295);

        scoreBoardTable.getColumns().addAll(playerNameColumn, playerScoreColumn, difficultyColumn);
        scoreBoardTable.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        scoreBoardTable.setItems(playerObservableList);


        //-------------------

        Pane pane = new Pane();
        Image cursor1 = new Image("file:cursor.gif");
        ImageCursor cursor = new ImageCursor(cursor1);
        pane.setCursor(cursor);
        scene = new Scene(pane, 1200, 800);

        pane.getChildren().addAll(bgIv, ellipse, label, scoreBoardTable, exitBtn);

    }

    public Scene getScene() {
        return scene;
    }



}



