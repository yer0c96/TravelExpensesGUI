package lab7;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TravelExpenses extends Application{

	private int days;
	private double totalAllowable, totalSpent, amountOwed, amountSaved;
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle("Travel Expenses");
		Label numDaysLbl = new Label("Number of days on the trip:");
		Label airfareLbl = new Label("Amount of airfare:");
		Label carRentalLbl = new Label("Car rental fees:");
		Label milesDrivenLbl = new Label("Mile driven (with private vehicle):");
		Label parkingFeesLbl = new Label("Parking fees:");
		Label taxiChargesLbl = new Label("Taxi charges:");
		Label conferenceFeesLbl = new Label("Conference or seminar fees:");
		Label lodgingChargesLbl = new Label("Lodging charges:");
		Label totalExpensesLbl = new Label(String.format("Total expenses: $%,.2f", totalSpent));
		Label totalAllowableLbl = new Label(String.format("Total amount covered: $%,.2f", totalAllowable));
		Label amountOwedLbl = new Label(String.format("Amount owed: $%,.2f", amountOwed));
		Label amountSavedLbl = new Label(String.format("Total saved: $%,.2f", amountSaved));
		
		TextField numDaysTf = new TextField("0");
		TextField airfareTf = new TextField("0");
		TextField carRentalTf = new TextField("0");
		TextField milesDrivenTf = new TextField("0");
		TextField parkingFeesTf = new TextField("0");
		TextField taxiChargesTf = new TextField("0");
		TextField conferenceFeesTf = new TextField("0");
		TextField lodgingChargesTf = new TextField("0");
		
		Button submit = new Button("Submit");
		
		HBox row1 = new HBox(30, numDaysLbl, numDaysTf);
		HBox row2 = new HBox(30, airfareLbl, airfareTf);
		HBox row3 = new HBox(30, carRentalLbl, carRentalTf);
		HBox row4 = new HBox(30, milesDrivenLbl, milesDrivenTf);
		HBox row5 = new HBox(30, parkingFeesLbl, parkingFeesTf);
		HBox row6 = new HBox(30, taxiChargesLbl, taxiChargesTf);
		HBox row7 = new HBox(30, conferenceFeesLbl, conferenceFeesTf);
		HBox row8 = new HBox(30, lodgingChargesLbl, lodgingChargesTf);
		HBox row9 = new HBox(submit);
		HBox resultRow1 = new HBox(100, totalExpensesLbl, totalAllowableLbl);
		HBox resultRow2 = new HBox(100, amountOwedLbl, amountSavedLbl);
		row9.setAlignment(Pos.CENTER);
		
		VBox root = new VBox(30, row1, row2, row3, row4, row5, row6, row7, row8, row9, resultRow1, resultRow2);
		Scene scene = new Scene(root, 500, 700);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		submit.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent arg0) 
			{
				double miles = Double.parseDouble(milesDrivenTf.getText());
				double milesRefundfund = miles * .42;
				days = Integer.parseInt(numDaysTf.getText());
				totalAllowable = (double)((double)47 + 20.00 + 40.00 + 195) * days + milesRefundfund;
				totalSpent = Double.parseDouble(airfareTf.getText()) + Double.parseDouble(carRentalTf.getText()) + Double.parseDouble(parkingFeesTf.getText()) + 
					Double.parseDouble(taxiChargesTf.getText()) + Double.parseDouble(conferenceFeesTf.getText()) + Double.parseDouble(lodgingChargesTf.getText());
				amountOwed = totalSpent - totalAllowable;
				if(amountOwed < 0)
				{
					amountOwed = 0;
				}
				amountSaved = totalAllowable - totalSpent;
				if(amountSaved < 0)
				{
					amountSaved = 0;
				}
				totalExpensesLbl.setText(String.format("Total expenses: $%,.2f", totalSpent));
				totalAllowableLbl.setText(String.format("Total amount covered: $%,.2f", totalAllowable));
				amountOwedLbl.setText(String.format("Amount owed: $%,.2f", amountOwed));
				amountSavedLbl.setText(String.format("Total saved: $%,.2f", amountSaved));
			}
		});
	}

}
