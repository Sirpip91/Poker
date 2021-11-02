
/*
 * Bradley Allen
 * COSC 1174
 * Octoboer 28 2021
 * Homework 4 Poker_1
 * 
 * This program will deal 5 cards that will be shown to the user.
 * The user can then press a button that will deal another 5 cards
 * With each deal there will never be the same card dealt.
 * 
 *
 */

//packages
package application;
//Imports
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


//Poker Class that has all of the methods and also contains Main
public class Poker extends Application {
	
	//array of cards and an array of picked cards , this is what keeps track of duplicates
	   Image[] cards;
	    int[] picked = new int[5];
	    int pick = 0;

	    //make the image = to the card  The images are named such that they can be connected with integers.//
	    private void setCards() {
	        cards = new Image[52];
	        int cardNum = 1;
	        for (int i = 0; i < cards.length; i++) {
	            Image card = new Image("file:Cards/" + cardNum + ".png");
	            cards[i] = card;

	            cardNum++;
	        }
	    }//end of setCards
	
	
	    //start method that is needed with JavaFX
	   @Override
	    public void start(Stage primaryStage) throws Exception {
	        setCards();
	        //declaring each JavaFX box that will contain the child that it is holding
	        VBox vbox = new VBox();
	        HBox cardBox = new HBox();
	        HBox buttonBar = new HBox();
	        vbox.setFillWidth(true);
	        
	        //Setting card1 with the random image card array
	        ImageView card1 = new ImageView(cards[randomCard()]);
	      //this is for the view settings of each card
	        card1.setPreserveRatio(true);
	        card1.setFitHeight(300);
	        
	        //Setting card2 with the random image card array
	        ImageView card2 = new ImageView(cards[randomCard()]);
	      //this is for the view settings of each card
	        card2.setPreserveRatio(true);
	        card2.setFitHeight(300);

	        //Setting card3 with the random image card array
	        ImageView card3 = new ImageView(cards[randomCard()]);
	        //this is for the view settings of each card
	        card3.setPreserveRatio(true);
	        card3.setFitHeight(300);
	        
	        //Setting card4 with the random image card array
	        ImageView card4 = new ImageView(cards[randomCard()]);
	      //this is for the view settings of each card
	        card4.setPreserveRatio(true);
	        card4.setFitHeight(300);
	        
	        //Setting card5 with the random image card array
	        ImageView card5 = new ImageView(cards[randomCard()]);
	      //this is for the view settings of each card
	        card5.setPreserveRatio(true);
	        card5.setFitHeight(300);
	        
	        // Makes a refresh button that will deal another set of cards. (Halloween Themed) 
	        Button refreshButton = new Button("Deal if you Dare");
	        refreshButton.setOnAction(e -> {
	        	//method that will refresh the cards
	            refreshCards(vbox);
	        });
	        //adds the button to the bar
	        buttonBar.getChildren().add(refreshButton);
	        //centers the button
	        buttonBar.setAlignment(Pos.CENTER);
	        
	        //adds all of the cards to the children of the cardbox
	        cardBox.getChildren().addAll(card1, card2, card3, card4, card5);
	        vbox.getChildren().add(cardBox);
	        vbox.getChildren().add(buttonBar);
	        //creats a new scene that holds the vbox
	        Scene scene = new Scene(vbox);
	        //information that will show the Scene
	        primaryStage.setTitle(getClass().getName());
	        primaryStage.setScene(scene);
	        primaryStage.show();

	    }

	   	//The refreshCards method that will refresh each of the cards.
	    private void refreshCards(VBox vBox) {
	    	//set the pick to 0
	        pick = 0;
	        // hav a new Horizontal box that will be new cards
	        HBox nuCardBox = new HBox();
	        //Creates another Set card1 with the random image card array
	        ImageView c1 = new ImageView(cards[randomCard()]);
	      //this is for the view settings of each card
	        c1.setPreserveRatio(true);
	        c1.setFitHeight(300);
	        
	        //Creates another Set card2 with the random image card array
	        ImageView c2 = new ImageView(cards[randomCard()]);
	      //this is for the view settings of each card
	        c2.setPreserveRatio(true);
	        c2.setFitHeight(300);

	        //Creates another Set card3 with the random image card array
	        ImageView c3 = new ImageView(cards[randomCard()]);
	      //this is for the view settings of each card
	        c3.setPreserveRatio(true);
	        c3.setFitHeight(300);
	        
	        //Creates another Set card4 with the random image card array
	        ImageView c4 = new ImageView(cards[randomCard()]);
	      //this is for the view settings of each card
	        c4.setPreserveRatio(true);
	        c4.setFitHeight(300);
	        
	        //Creates another Set card5 with the random image card array
	        ImageView c5 = new ImageView(cards[randomCard()]);
	      //this is for the view settings of each card
	        c5.setPreserveRatio(true);
	        c5.setFitHeight(300);
	        
	        // adds all the new set of cards to the newcardbox
	        nuCardBox.getChildren().addAll(c1, c2, c3, c4, c5);
	        vBox.getChildren().set(0, nuCardBox);
	        

	    }
	    // This is the random card method
	    int randomCard() {
	    	//chooses a random card *52 to set the limit
	        int ran = -1;
	        do {
	            ran = (int) (Math.random() * 52);
	            //while the random numbers are == to the array index pick add it to the picked array
	        } while (ran == picked[0] || ran == picked[1] || ran == picked[2] || ran == picked[3] || ran == picked[4]);
	        
	        picked[pick++] = ran;
	        //return the random int
	        return ran;
	    }

	}//end of class
