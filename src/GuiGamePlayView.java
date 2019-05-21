import Game.GameController;
import Game.Player;

import GameModes.EasyDiff;
import SliceableObjects.ISliceableObject;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.sound.midi.Sequence;
import java.nio.file.Paths;
import java.util.*;


public class GuiGamePlayView {

    private Scene scene;
    private Pane pane = new Pane();
    private AnimationTimer timer;
    //THIS IS ONLY FOR TRIAL SCORE LOOK
    //private int score = 0;
    private GameController gameController = GameController.getInstance();
    private boolean runFlag = true;
    long startTime = System.currentTimeMillis();
    long old = 0;
    int secs = 0, mins = 0;
    private ArrayList<Player> players = new ArrayList<>();
    private RemoteControl rem =new RemoteControl();
	private Command comm= new FileCommand();

	private Button resetBtn;
    private Button pauseBtn;
    private Circle circle;
    private MediaPlayer mediaPlayer;
    private AudioClip slashClip;
    GuiGamePlayView(Stage stage) {
        //BISHO: KNOW PROBS  FRUITS CUT NEEDS NEW IMAGES , TIMER IS SLIGHTLY TOO FAST AND NOT IN SYNC WITH ANIMATION TIMER
        ////////////////////////////////////////////////////
        //-------
        Image image = new Image("file:background.jpg");
        ImageView ivBackGround = new ImageView(image);
        ivBackGround.setMouseTransparent(true);
        ivBackGround.setPreserveRatio(false);
        ivBackGround.setFocusTraversable(false);
        ivBackGround.setFitWidth(1220);
        ivBackGround.setFitHeight(820);
        //-------
        Label scoreLabel = new Label("Current Score:  " + gameController.getScore());
        scoreLabel.setFont(Font.font("Verdana", 20));
        scoreLabel.setTextFill(Color.GOLDENROD);
        scoreLabel.setPrefHeight(49);
        scoreLabel.setPrefWidth(300);
        scoreLabel.setLayoutX(500);
        scoreLabel.setLayoutY(40);
        //------
        Label livesLabel = new Label("LIVES:  " + gameController.getLives()); //bisho: new live counter
        livesLabel.setFont(Font.font("", 22));
        livesLabel.setTextFill(Color.RED);
        livesLabel.setPrefHeight(49);
        livesLabel.setPrefWidth(200);
        livesLabel.setLayoutX(900);
        livesLabel.setLayoutY(40);
        if (gameController.getLives() < 0) {
            livesLabel.setVisible(false);
        }
        //------
        Label timeplayedLabel = new Label("time elapsed:       "); //bisho: new timer played for all modes
        timeplayedLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 17));
        timeplayedLabel.setTextFill(Color.GOLDENROD);
        timeplayedLabel.setPrefHeight(49);
        timeplayedLabel.setPrefWidth(400);
        timeplayedLabel.setLayoutX(500);
        timeplayedLabel.setLayoutY(70);
         //---------
        Label bestLabel = new Label("Highest score:  " + gameController.getBest()); //bisho: for best score lbl
        bestLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        bestLabel.setTextFill(Color.GOLDENROD);
        bestLabel.setPrefHeight(49);
        bestLabel.setPrefWidth(400);
        bestLabel.setLayoutX(500);
        bestLabel.setLayoutY(90);
        //------
        Label timerLabel = new Label("TIME LEFT:  " + gameController.getTime()); //bisho: new timer for arcade
        timerLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 22));
        timerLabel.setTextFill(Color.YELLOW);
        timerLabel.setPrefHeight(49);
        timerLabel.setPrefWidth(200);
        timerLabel.setLayoutX(900);
        timerLabel.setLayoutY(40);
        if (gameController.getTime() < 0) {
            timerLabel.setVisible(false);
        }
        //-------
        Rectangle rec = new Rectangle(300, 120);
        rec.setMouseTransparent(true);
        rec.setFill(Color.DARKRED);
        rec.setLayoutX(450);
        rec.setLayoutY(20);
        rec.setOpacity(0.5);
        //-------
        Ellipse ellipse1 = new Ellipse(80, 30);
        ellipse1.setFill(Color.YELLOW);
        ellipse1.setLayoutX(940);
        ellipse1.setLayoutY(64);
        ellipse1.setOpacity(0.5);
        if (gameController.getLives() < 0) {
            ellipse1.setVisible(false);
        }
        //------
        Ellipse ellipse2 = new Ellipse(120, 30);
        ellipse2.setFill(Color.GREEN);
        ellipse2.setLayoutX(985);
        ellipse2.setLayoutY(64);
        ellipse2.setOpacity(0.5);
        if (gameController.getTime() < 0) {
            ellipse2.setVisible(false);
        }
        //-------


        circle = new Circle(50);
        pauseBtn = new Button("PAUSE");
        pauseBtn.setPrefWidth(90);
        pauseBtn.setPrefHeight(50);
        pauseBtn.setLayoutX(40);
        pauseBtn.setLayoutY(50);
        pauseBtn.setOpacity(0.75);
        pauseBtn.setShape(circle);
        pauseBtn.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
        pauseBtn.setTextFill(Paint.valueOf("White"));
        Button contBtn = new Button("CONTINUE");
        contBtn.setPrefWidth(134);
        contBtn.setPrefHeight(80);
        contBtn.setLayoutX(533);
        contBtn.setLayoutY(200);
        contBtn.setShape(circle);
        contBtn.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
        contBtn.setTextFill(Paint.valueOf("White"));


        resetBtn = new Button("RESET");
        resetBtn.setPrefWidth(134);
        resetBtn.setPrefHeight(80);
        resetBtn.setLayoutX(533);
        resetBtn.setLayoutY(350);
        resetBtn.setShape(circle);
        resetBtn.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
        resetBtn.setTextFill(Paint.valueOf("White"));

      /*  Button saveBtn = new Button("SAVE");
        saveBtn.setPrefWidth(134);
        saveBtn.setPrefHeight(80);
        saveBtn.setLayoutX(533);
        saveBtn.setLayoutY(500);
        saveBtn.setShape(circle);
        saveBtn.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
        saveBtn.setTextFill(Paint.valueOf("White"));*/
        //----------
        Button returntomainBtn = new Button("RETURN TO MAIN MENU");
        returntomainBtn.setPrefWidth(200);
        returntomainBtn.setPrefHeight(80);
        returntomainBtn.setLayoutX(500);
        returntomainBtn.setLayoutY(500);
        returntomainBtn.setShape(circle);
        returntomainBtn.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
        returntomainBtn.setTextFill(Paint.valueOf("White"));




        resetBtn.setOnAction(e -> {
        	mediaPlayer.stop(); //bisho: added to stop gameover sound on reset
            gameController.resetGame();
            GuiGamePlayView guiGameplayView = new GuiGamePlayView(stage);
            stage.setScene(guiGameplayView.getScene());
            stage.centerOnScreen();
        });
        /*saveBtn.setOnAction(e -> {
            // cancelled
        });*/
        returntomainBtn.setOnAction(e -> {
            backToMainMenu(stage);
        });


        

        Image cursor1 = new Image("file:cursor.gif");

        ImageCursor cursor = new ImageCursor(cursor1);

        pane.setCursor(cursor);
        scene = new Scene(pane, 1200, 800);

        ArrayList<ISliceableObject> myObjects = new ArrayList<>();
        ArrayList<ISliceableObject> objectsToRemove = new ArrayList<>();
        ArrayList<ISliceableObject> objectsToSlice = new ArrayList<>();
        HashMap<ImageView, ISliceableObject> objectsOnScreen = new HashMap<>();

        pane.getChildren().addAll(ivBackGround, rec, scoreLabel, livesLabel,bestLabel, ellipse1, ellipse2, pauseBtn, timerLabel, timeplayedLabel);

        Media sound = new Media(Paths.get("pomGameplay.mp3").toUri().toString());
        mediaPlayer = new MediaPlayer(sound);

        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });
        mediaPlayer.play();



        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                //bisho: new timer plz dont mess around with it too much ^_^

                long timepassed = System.currentTimeMillis() - startTime;
                long secondspassed = timepassed / 1000;

                // System.out.println(secondspassed);
                if (secondspassed > old) {
                    gameController.timeEdit(-secondspassed + old);
                    // gameController.setTime(gameController.getTime()-secondspassed+old);
                    old = secondspassed;
                }
                timerLabel.setText("TIME LEFT: " + (int) (gameController.getTime()));
                secs = (int) secondspassed % 60;
                mins = (int) secondspassed / 60;
                timeplayedLabel.setText("time elapsed:  " + mins + " : " + secs);


                if (myObjects.size() < 1) {
                    List<ISliceableObject> newMyObjects = gameController.createGameObject(1);
                    myObjects.addAll(newMyObjects);

                    for (ISliceableObject object : myObjects) {
                        objectsOnScreen.put(object.getImageView(), object);
                        object.getImageView().setOnMouseMoved(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (objectsOnScreen.get(event.getTarget()).isSliced() == false && runFlag == true) {
                                    objectsToSlice.add(objectsOnScreen.get(event.getTarget()));
                                }
                            }
                        });
                        pane.getChildren().add(object.getImageView());
                    }
                }
                gameController.updateObjectsLocations(myObjects, objectsToRemove);


                slice(objectsToSlice);
                objectsToSlice.clear();
                myObjects.removeAll(objectsToRemove);
                moveOffScreen(objectsToRemove);
                objectsToRemove.clear();
                if(gameController.getScore()>gameController.getBest())//bisho: real time highest score
                	bestLabel.setText("Highest score:  " + gameController.getScore());
                scoreLabel.setText("Current Score: " + gameController.getScore());
                livesLabel.setText("LIVES: " + gameController.getLives());
                if (gameController.checkGameOver()) {// bisho: gameover check (bool return) and alert box if true
                    endGame(stage);
                }
                ///////////////////////////////////////////////////////////////////////////////

            }
        };
        timer.start();


        pauseBtn.setOnAction(e->{
        	returntomainBtn.setVisible(true);
        	   pane.getChildren().addAll(contBtn,resetBtn,returntomainBtn);
               pauseBtn.setVisible(false);
               runFlag=false;
        	timer.stop();
        });        
     
        contBtn.setOnAction(e->{
        	returntomainBtn.setVisible(false);
            pane.getChildren().removeAll(contBtn,resetBtn,returntomainBtn);
               pauseBtn.setVisible(true);
               runFlag=true;
        timer.start();
        }); 
 }













    public void endGame(Stage stage) {

        pauseBtn.setVisible(false);
        timer.stop();
        mediaPlayer.stop();

        Media sound = new Media(Paths.get("GameOver.mp3").toUri().toString());
        mediaPlayer = new MediaPlayer(sound);

        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });
        mediaPlayer.play();

        TextField textField = new TextField();
        textField.setPromptText("Name");
        textField.setFont(Font.font("Verdana", 25));
        textField.setPrefWidth(334);
        textField.setPrefHeight(75);
        textField.setLayoutX(570);
        textField.setLayoutY(170);

        Label nameLabel = new Label("Write Your name Here:");
        nameLabel.setTextFill(Color.WHITE);
        nameLabel.setLayoutX(287);
        nameLabel.setLayoutY(101);
        nameLabel.setPrefWidth(291);
        nameLabel.setPrefHeight(200);
        nameLabel.setFont(Font.font("Verdana",22));

        Button saveBtn = new Button("Save Name");
        saveBtn.setPrefWidth(134);
        saveBtn.setPrefHeight(80);
        saveBtn.setLayoutX(533);
        saveBtn.setLayoutY(264);
        saveBtn.setOpacity(1);
        saveBtn.setShape(circle);
        saveBtn.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
        saveBtn.setTextFill(Paint.valueOf("White"));
        //resetBtn.setVisible(true);

        Image gameOver = new Image("file:GameOver.gif");
        ImageView ivGameOver = new ImageView(gameOver);
        ivGameOver.setMouseTransparent(true);
        ivGameOver.setPreserveRatio(false);
        ivGameOver.setFocusTraversable(false);
        ivGameOver.setFitWidth(807);
        ivGameOver.setFitHeight(448);
        ivGameOver.setLayoutX(211);
        ivGameOver.setLayoutY(250);

        Label label = new Label("Your score is    "+gameController.getScore() + "!!\n" + "Press HOME key To MainMenu....\n\tReset BackSpace key To play Again...\n\t\tEnter to show Score Board...");
        label.setTextFill(Color.WHITESMOKE);
        label.setLayoutX(600);
        label.setLayoutY(400);
        label.setPrefWidth(700);
        label.setPrefHeight(400);
        label.setFont(Font.font("Agency FB",28));

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.15), label);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.1);
        fadeTransition.setCycleCount(Timeline.INDEFINITE);
        fadeTransition.setAutoReverse(true);
        fadeTransition.play();
        

        scene.setOnKeyPressed(e->{
            if (e.getCode() == KeyCode.HOME) {
                GuiMainMenu guiMainMenu = new GuiMainMenu(stage);
                stage.setScene(guiMainMenu.getScene());
                mediaPlayer.stop();
            }
            if (e.getCode() == KeyCode.BACK_SPACE) {
                gameController.resetGame();
                GuiGamePlayView guiGameplayView = new GuiGamePlayView(stage);
                stage.setScene(guiGameplayView.getScene());
                stage.centerOnScreen();
                mediaPlayer.stop();
            }
            if (e.getCode() == KeyCode.ENTER) {
                ScoreBoard scoreBoard = new ScoreBoard(stage);
                stage.setScene(scoreBoard.getScene());
                mediaPlayer.stop();
            }
        });

        saveBtn.setOnAction(e->{
            if(textField.getText().equalsIgnoreCase("") && gameController.isSaveName() == false)
            {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setHeaderText("No name added are you sure ?");
                alert.setContentText("Please add a name in textField");
                alert.setTitle("Null Name ERROR");
                alert.show();
            }
            else if (gameController.isSaveName() == false){
                Player player = new Player(textField.getText(), gameController.getScore(), gameController.difficulty());
                players.add(player);
                gameController.addPlayers(player);
                gameController.setSaveName(true);
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setContentText("Save is done successfully");
                alert.setHeaderText("Save Complete");
                alert.setTitle("SAVE NAME");
                alert.show();
                textField.setEditable(false);

                rem.setCommand(comm);// bisho: comand design pattern
                rem.activateButton();// bisho: saves

                ScoreBoard s = new ScoreBoard(stage);
                stage.setScene(s.getScene());
                mediaPlayer.stop();

            }
        });

        pane.getChildren().addAll( nameLabel, textField, saveBtn, ivGameOver, label, resetBtn);


    }


  
    public void moveOffScreen(List<ISliceableObject> objectsToRemove) {//bisho: for when objects fall off screen
        gameController.throwOffScreen(objectsToRemove);
    }



    public void slice(List<ISliceableObject> objectsToSlice) {

        gameController.sliceObjects(objectsToSlice);

        for (ISliceableObject object : objectsToSlice
        ) {
            object.getImageView().setImage(object.getMyImage()[1]);
        }
    }


    public Scene getScene() {
        return scene;
    }


    public void backToMainMenu(Stage stage) {
        mediaPlayer.stop();
        GuiMainMenu g = new GuiMainMenu(stage);
        stage.setScene(g.getScene());
        stage.centerOnScreen();
    }

}
