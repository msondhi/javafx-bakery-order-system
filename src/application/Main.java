 package application;
	
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class Main extends Application {
	 private TableView<FoodItem> table = new TableView<FoodItem>();
	 private final ObservableList<FoodItem> itemList =
            FXCollections.observableArrayList();
	 
	public void start(Stage primaryStage) {	
		
		      Scene scene = new Scene(new Group(),500,500);
		       
		      TextField txtfld1 = new TextField();
		      TextField txtfld2 = new TextField();
		      GridPane grid = new GridPane();
		      grid.setVgap(10);
		      grid.setHgap(10);
		      grid.setPadding(new Insets(20,20,20,20));
		      
		      grid.add(new Label("Username"),0,0);
		      grid.add(txtfld1,1,0);
		      grid.add(new Label("Password"),0,1);
		      grid.add(txtfld2,1,1);
		     
		      Button signButton = new Button("Sign in");
		      grid.add(signButton,0,2);
		      signButton.setOnAction(e -> {
		    	  try {
					salesorder();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		      });
		      Group root = (Group) scene.getRoot();
		       root.getChildren().add(grid);
		       grid.setStyle("-fx-background-color: DAE6F3;");
		        primaryStage.setTitle("login Page");
		        primaryStage.setScene(scene);
		        primaryStage.show();
		    }
		
	

	
//****************************************************************************************
	private void salesorder() throws IOException{
		Stage stage = new Stage();

	 
	
	
	// System.out.println(itemList);
	 final TextField addproductName = new TextField();
	 final TextField addQuantity = new TextField();
	 final TextField addPrice = new TextField();
	 final Label labelTotal = new Label();
	 final Label labelHST = new Label();
	 TextField textfield1 = new TextField();// textfield of cashier id
	 TextField textfield2 = new TextField();  // textfield bill id
	 Button buttonDebit = new Button();// //buttonDebit 
	 Button buttonCash = new Button("Cash");
	 Button buttonCredit = new Button();
	 //String[] itemDetails;
	@SuppressWarnings("unchecked")
	//@Override
	
		HBox MainHbox= new HBox();
		VBox vbox1 = new VBox();
		
		VBox vbox2 =new VBox();
		HBox hbox1 = new HBox();
		
		Label label1 = new Label("Cashier id");
		
		hbox1.getChildren().addAll(label1,textfield1);
		
		HBox hbox2 = new HBox();
		Label label2 = new Label("Bill Number");
		//TextField textfield2 = new TextField();
		textfield2.setText(String.valueOf(Instant.now().toEpochMilli())); // update value of bill number on project startup, 
		
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
	 
	        TableColumn<FoodItem, String> productCol = new TableColumn<FoodItem, String>(" Product Name");
	        //to associate the itemList with the table columns
	        productCol.setCellValueFactory(
	                new PropertyValueFactory<FoodItem, String>("productName"));
	       		//Editing Data in the Table
	        /**
	         * Use the setCellFactory method to reimplement the table cell as a text field with the help of the TextFieldTableCell class. 
	         * The setOnEditCommit method processes editing and assigns the updated value to the corresponding table cell.
	         */
	        productCol.setCellFactory(TextFieldTableCell.forTableColumn());
	        productCol.setOnEditCommit(
	        	    new EventHandler<CellEditEvent<FoodItem, String>>() {
	        	        @Override
	        	        public void handle(CellEditEvent<FoodItem, String> t) {
	        	            ((FoodItem) t.getTableView().getItems().get(
	        	                t.getTablePosition().getRow())
	        	                ).setProductName(t.getNewValue());
	        	        }
	        	    }
	        	);

	        // second column Quantity of a table
	        TableColumn<FoodItem, Integer> quantityCol = new TableColumn<FoodItem, Integer>("Quantity");
	        quantityCol.setCellValueFactory(
	                new PropertyValueFactory<FoodItem, Integer>("quantity"));
	      //quantityCol.setCellFactory(TextFieldTableCell.forTableColumn());
	        quantityCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
	        quantityCol.setOnEditCommit(
	        	    new EventHandler<CellEditEvent<FoodItem, Integer>>() {
	        	        @Override
	        	        public void handle(CellEditEvent<FoodItem, Integer> t) {
	        	            ((FoodItem)t.getTableView().getItems().get(
	        	                t.getTablePosition().getRow())
	        	                ).setQuantity(t.getNewValue());
	        	        }
	        	    }
	        	);

	        
	        
	        TableColumn<FoodItem, Double> priceCol = new TableColumn<FoodItem, Double>("price");
	        priceCol.setCellValueFactory(
	                new PropertyValueFactory<FoodItem, Double>("price"));
	        priceCol.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
	        quantityCol.setOnEditCommit(
	        	    new EventHandler<CellEditEvent<FoodItem, Integer>>() {
	        	        @Override
	        	        public void handle(CellEditEvent<FoodItem, Integer> t) {
	        	            ((FoodItem) t.getTableView().getItems().get(
	        	                t.getTablePosition().getRow())
	        	                ).setQuantity(t.getNewValue());
	        	            table.refresh();
	        	            System.out.println("here");
	        	            labelHST.setText("HST: $" + String.format("%.2f", calculateHST()));
	        		        labelTotal.setText("Total Price: $" + String.format("%.2f", calculateTotal()));
	        	        }
	        	    }
	        	);
	        
	        //table.setItems(itemList);
	        table.getColumns().addAll(productCol, quantityCol, priceCol);
	        
	        addproductName.setPromptText("Name");
	        addQuantity.setPromptText("Quantity");
	        addPrice.setPromptText("Price");
	      
	       
	
	        VBox vbox3 = new VBox();
	        vbox3.setSpacing(5);
	        vbox3.setPadding(new Insets(10,10,10,10));
	        vbox3.getChildren().addAll(label, table);
	        
	        HBox hbox3 = new HBox();
	       
	        hbox3.setSpacing(15);
	        Button deleteButton = new Button("Delete");
	        Button newbillButton = new Button(" newbill");
	        hbox3.setPadding(new Insets(10,10,10,10));
	        deleteButton.setPrefSize(100, 20);
	        newbillButton.setPrefSize(100, 20);
	        //deletebutton 
	        hbox3.getChildren().addAll(deleteButton,newbillButton);
	        
	        deleteButton.setOnAction(e -> {
	        	//Fooditem
	        	//deleteButton.setOnAction(e -> itemList.remove(selectedIndex.get()));
	        	FoodItem selectedItem = table.getSelectionModel().getSelectedItem();
	        	table.getItems().remove(selectedItem);
	        	labelHST.setText("HST: $" + String.format("%.2f", calculateHST()));
		        labelTotal.setText("Total Price: $" + String.format("%.2f", calculateTotal()));
	        });
	        
	        newbillButton.setOnAction(e -> newBill());
	        
	       
	        // label for displaying total bill and calculation
	        VBox hboxTotal = new VBox();
	        hboxTotal.setPadding(new Insets(10,10,10,10));
	        hboxTotal.setSpacing(10);
	        labelHST.setText("HST: $" + String.format("%.2f", calculateHST()));
	      
	        labelTotal.setText("Total Price: $" + String.format("%.2f", calculateTotal()));
	        labelTotal.setFont(new Font("Arial", 20));
	        labelTotal.setAlignment(Pos.BASELINE_RIGHT);
	        hboxTotal.getChildren().addAll(labelHST, labelTotal);
	        
	        
	        //pushing all hbox and vbox in vbox1
	        vbox1.getChildren().addAll(vbox2,vbox3,hbox3, hboxTotal);
	        VBox vbox1A = new VBox(); 
	        FlowPane itemPane = new FlowPane();
	        itemPane.setPadding(new Insets(20,20,20,20));
	        itemPane.setVgap(8);
	        itemPane.setHgap(34);
	       itemPane.setStyle("-fx-background-color: DAE6F3;");
	        InputStreamReader isr = new InputStreamReader(getClass().getResourceAsStream("database/data.csv"));
	        BufferedReader br = new BufferedReader(isr);
	        
	        String st;
	        while ((st = br.readLine()) != null) {
	        	System.out.println(st);
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
			            	//System.out.println(((Button)e.getSource()).getProperties().get("item"));
			            	try {
								readFromFile(((Button)e.getSource()).getProperties().get("item").toString());
								labelHST.setText("HST: $" + String.format("%.2f", calculateHST()));
								labelTotal.setText("Total Price: " + String.format("%.2f", calculateTotal()));
							} catch (URISyntaxException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			            }	
			        });
			      vbox4.getChildren().addAll(imageview1,buttonAdd1);
			      itemPane.getChildren().addAll(vbox4);
	          } else {
	        	  System.out.println(itemDetails);
	          }
	        }
	        
	        
	        HBox hbox  = new HBox();
	        hbox.setPadding(new Insets(15, 12, 15, 12));
	        hbox.setSpacing(30);
	        hbox.setStyle("-fx-background-color: #336699;");

	        
	        buttonCredit.setText("Credit");
	        buttonCredit.setPrefSize(100, 20);
	        buttonCredit.setOnAction(e -> {
	        	showAlertOnButton(); 
	        	 newBill();
	        });
	        
	        buttonDebit.setText("Debit");
	        buttonDebit.setPrefSize(100, 20);
	        buttonDebit.setOnAction(e -> {
	         showAlertOnButton();
	        try {
				saveBillData("debit");
			} catch (ClassNotFoundException | URISyntaxException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	         newBill();
	        
	        });
	     
	        
	        buttonCash .setText("Cash");
	        buttonCash.setPrefSize(100, 20);
	        buttonCash.setOnAction(e ->{ 
	        	showAlertOnButton();
	        	 newBill();
	        		
	        		
	        });
	        
	        hbox.getChildren().addAll(buttonCredit, buttonDebit,buttonCash);
	        vbox1A.setSpacing(25);
	        vbox1A.getChildren().addAll(itemPane,hbox);

	        
	        MainHbox.getChildren().addAll(vbox1, vbox1A);
	        Scene scene = new Scene (MainHbox,800,800);
	       /// Stage.setTitle("Bakery Ordering System");
	        stage.setScene(scene);
	        stage.show();
	} 
	
	        
	     
	        
	       
	
			
	private void newBill() {
		table.getItems().clear();
	}

	//eventHandler
	
	 private void readFromFile(String itemtype) throws URISyntaxException, IOException {
	        URI databaseUri = getClass().getResource("database\\data.csv").toURI();
     	File databaseFile = new File(databaseUri);
     	 try {
             BufferedReader br = new BufferedReader(new FileReader(databaseFile));
             String line;
             String[] array;

             while ((line = br.readLine()) != null){
            	 //why we created array
                 array = line.split(",");
                 if(array[0].equalsIgnoreCase(itemtype))
                	 table.getItems().add(new FoodItem(array[0], array[2], "1"));
                	//System.out.println (table.getItems().add(new FoodItem(array[0], array[2], "1")));
                 
             }

             br.close();

         }catch (Exception ex){
             ex.printStackTrace();
         }
     }
	 
	 private Double calculateTotal() {
		 Double total = 0.00d;
		 for (FoodItem item : table.getItems()) {
	            total = total + (item.getPrice()*item.getQuantity());
	        }
		 return total + calculateHST();
	 }
	 private Double calculateHST() {
		 Double total = 0.00d;
		 for (FoodItem item : table.getItems()) {
	            total = total + (item.getPrice()*item.getQuantity());
	        }
		 return total*0.13;
	 }
	 
	 //
	 private void showAlertOnButton() {
		 Alert alert = new Alert(AlertType.CONFIRMATION);
		 alert.setTitle("Payment Method ");
		 alert.setHeaderText(null);
		 alert.setContentText("Payment has made successful");
		 alert.showAndWait();
		 
}
	 private void saveBillData(String paymentMethod) throws URISyntaxException, IOException, ClassNotFoundException {
		 Bill2 bill = new Bill2();
		 bill.setBillDate(new Date());
		 bill.setBillNumber(Instant.now().toEpochMilli());
		 bill.setPaymentMethod(paymentMethod);
		 bill.setFoodItems(itemList.toArray());
		 bill.setTotal(calculateTotal());
		 bill.setHst(calculateHST());
		// bill.setCashierId(Integer.parseInt(textfield1.getText()));
		//
//		 System.out.println(bill);
		 URI databaseUrl = getClass().getResource("database\\billData.dat").toURI();
		 FileOutputStream fout = null;
		 ObjectOutputStream oos = null;
		 FileInputStream fInS = null;
		 ObjectInputStream dIns = null;
		// System.out.println(databaseUrl.getPath());
		 
		 boolean cont = true;
		 ArrayList<Bill2> objectsList = new ArrayList<Bill2>();
		 try {
			 // reading current entries from file
			 fInS = new FileInputStream(databaseUrl.getPath());
			 try {
				 dIns  = new ObjectInputStream(fInS);
				 objectsList = (ArrayList<Bill2>)dIns.readObject();
			 } catch(EOFException e) {
				 e.printStackTrace();
			 }
			 
			 objectsList.add(bill);
			 fout = new FileOutputStream(databaseUrl.getPath(), true);
			 oos = new ObjectOutputStream(fout);
			 oos.writeObject(objectsList);
			 System.out.println("Done");
		 } catch (Exception ex) {
			ex.printStackTrace();
		 } finally {
			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fInS != null) {
				try {
					fInS.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		 
//		 try {
//			 fInS = new FileInputStream(databaseUrl.getPath());
//			 dIns  = new ObjectInputStream(fInS);
//			 while(fInS.available()!=0) {
//				 Bill2 b = (Bill2) dIns.readObject();
//			 }
//		 } catch (Exception ex) {
//			ex.printStackTrace();
//		 } finally {
//			
//		}
	 }		
			

	 
	private void setEditable(boolean b) {
		// TODO Auto-generated method stub
		
	}

	


	public static void main(String[] args) {
		
		launch(args);
	}
}
