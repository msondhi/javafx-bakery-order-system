package application;
	
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class Main extends Application {
	private TableView<FoodItem> table = new TableView<FoodItem>();
	
	
	 private final ObservableList<FoodItem> itemList =
	            FXCollections.observableArrayList();
	 final TextField addproductName = new TextField();
	 final TextField addQuantity = new TextField();
	 final TextField addPrice = new TextField();
	 String[] itemDetails;
	@Override
	public void start(Stage primaryStage) throws IOException, URISyntaxException {
		HBox MainHbox= new HBox();
		VBox vbox1 = new VBox();
		
		VBox vbox2 =new VBox();
		HBox hbox1 = new HBox();
		
		Label label1 = new Label("Emp Name");
		TextField textfield1 = new TextField();
		hbox1.getChildren().addAll(label1,textfield1);
		
		HBox hbox2 = new HBox();
		Label label2 = new Label("id Number");
		TextField textfield2 = new TextField();
		hbox2.getChildren().addAll(label2,textfield2);
		//small VBox1 to insert hbox1,hbox2 then insert in vbox1;
		vbox2.getChildren().addAll(hbox1,hbox2);
		
		vbox2.setSpacing(10);
		vbox2.setPadding(new Insets(10,10,10,10));
		hbox1.setSpacing(5);
		hbox2.setSpacing(5);
		
			final Label label = new Label("Order Detail");
	        label.setFont(new Font("Arial", 20));
	 
	        table.setEditable(true);
	 
	        TableColumn productCol = new TableColumn(" Product Name");
	        productCol.setCellValueFactory(
	                new PropertyValueFactory<FoodItem, String>("productName"));
	        TableColumn quantityCol = new TableColumn("Quantity");
	        quantityCol.setCellValueFactory(
	                new PropertyValueFactory<FoodItem, String>("quantity"));
	        
	        TableColumn priceCol = new TableColumn("price");
	        priceCol.setCellValueFactory(
	                new PropertyValueFactory<FoodItem, String>("price"));
	        table.getColumns().addAll(productCol, quantityCol, priceCol);
	        
	        addproductName.setPromptText("product Name");
	        addQuantity.setPromptText("Quantity");
	        addPrice.setPromptText("Price");
	      
	       
	
	        VBox vbox3 = new VBox();
	        vbox3.setSpacing(5);
	        vbox3.setPadding(new Insets(10,10,10,10));
	        vbox3.getChildren().addAll(label, table);
	        
	        HBox hbox3 = new HBox();
	       
	        hbox3.setSpacing(5);
	        vbox1.getChildren().addAll(vbox2,vbox3,hbox3);
	        
	      /*  FlowPane itemPane = new FlowPane();
	        itemPane.setPadding(new Insets(10,10,10,10));
	        InputStreamReader isr = new InputStreamReader(getClass().getResourceAsStream("database/data.csv"));
	        BufferedReader br = new BufferedReader(isr);
	        
	        String st;
	        while ((st = br.readLine()) != null) {
	          String[] itemDetails = st.split(",");
	          InputStream fin = getClass().getResourceAsStream("images/"+itemDetails[1]);
	          if(fin != null) {
		          VBox vbox4 = new VBox();
			      Image image1 = new Image(fin);
			      ImageView imageview1 = new ImageView(image1);
			      imageview1.setFitHeight(100);
			      imageview1.setFitWidth(100);
			      vbox4.setSpacing(10);
			      
			      
			      Button buttonAdd1 = new Button("Add ($"+itemDetails[2]+")");
			      buttonAdd1.getProperties().put("item", itemDetails[0]);
			      buttonAdd1.setOnAction(new EventHandler<ActionEvent>() {
			            public void handle(ActionEvent e) { 
			            	System.out.println(((Button)e.getSource()).getProperties().get("item"));
			            }	
			        });
			      
			      
			      
			      vbox4.getChildren().addAll(imageview1,buttonAdd1);
			      itemPane.getChildren().addAll(vbox4);
	          } else {
	        	  System.out.println(itemDetails);
	          }
	        }*/
	
        VBox vbox4 = new VBox();
	        Image image1 = new Image(getClass().getResourceAsStream("images/biscuits.jpg"));
	        ImageView imageview1 = new ImageView(image1);
	        imageview1.setFitHeight(100);
	        imageview1.setFitWidth(100);
	        vbox4.setSpacing(10);
	        Button buttonAdd1 = new Button("Add");
	        vbox4.getChildren().addAll(imageview1,buttonAdd1);
	       
	        VBox vbox5 = new VBox();
       Image image2 = new Image(getClass().getResourceAsStream("images/muffin.jpg"));
	        ImageView imageview2 = new ImageView(image2);
	        imageview2.setFitHeight(100);
	        imageview2.setFitWidth(100); 
        vbox5.setSpacing(10);
	        Button buttonAdd2 = new Button("Add");
	        vbox5.getChildren().addAll(imageview2,buttonAdd2);
	        
	        VBox vbox6 = new VBox();
	        Image image3 = new Image(getClass().getResourceAsStream("images/croosiant_.jpg"));
	        ImageView imageview3 = new ImageView(image3);
	        imageview3.setFitHeight(100);
	        imageview3.setFitWidth(100); 
	        vbox6.setSpacing(10);
	        Button buttonAdd3 = new Button("Add");
	        vbox6.getChildren().addAll(imageview3,buttonAdd3);
	        
        VBox vbox7 = new VBox();
	        Image image4 = new Image(getClass().getResourceAsStream("images/danishPastry.jpg"));
	        ImageView imageview4 = new ImageView(image3);
	        imageview4.setFitHeight(100);
        imageview4.setFitWidth(100);
	        vbox7.setSpacing(10);
        Button buttonAdd4 = new Button("Add");
	        vbox7.getChildren().addAll(imageview4,buttonAdd4);
	        
	        
	        
	        HBox vbox1b = new HBox();
	        vbox1b.getChildren().addAll(vbox4,vbox5,vbox6,vbox7);
	        vbox1b .setSpacing(25);
	        
	        
	       
	        
	        MainHbox.getChildren().addAll(vbox1,vbox1b);
	        Scene scene = new Scene (MainHbox,800,800);
	        primaryStage.setTitle("Bakery Ordering System");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        
	        
	        // retrieving data from file pushing in string
	        
	        URI databaseUri = getClass().getResource("database\\data.csv").toURI();
        	File databaseFile = new File(databaseUri);
        	FileInputStream fin = null;
        	BufferedInputStream bin = null;
        	DataInputStream din = null;
	        try {
	        	fin = new FileInputStream(databaseFile);
	        	bin = new BufferedInputStream(fin);
	        	din = new DataInputStream(bin);

				while (din.available() != 0) {
					System.out.println(din.readUTF());
				}
	        	
	        } catch (EOFException ex){
	        	System.out.println("end of file");
	        } finally {
	        	try {
					fin.close();
					bin.close();
					din.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
	        }
	}
			
	//eventHandler
	
	
	
	
	




	private void setEditable(boolean b) {
		// TODO Auto-generated method stub
		
	}




	public static void main(String[] args) {
		
		launch(args);
	}
}
