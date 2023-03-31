import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {
  private Button btKilometerstoMeters = new Button("Kilometers to Meters");
  private Button btFeettoInches = new Button("Feet to Inches");
  private Button btFahrenheittoCelsius = new Button("Fahrenheit to Celsius");
  private Button btMeterstoYards = new Button("Meters to Yards");
  private Button btKCelsiustoFahrenheit = new Button("Celsius to Fahrenheit");
  private TextField tfQuery = new TextField();
  private TextField tfConvertedQuery = new TextField();
  private Button btConvert = new Button("Convert");
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create UI
    GridPane gridPane = new GridPane();
    gridPane.setHgap(10);
    gridPane.setVgap(10);
    gridPane.add(btKilometerstoMeters, 1, 0);
    gridPane.add(btFeettoInches, 1, 1);
    gridPane.add(btFahrenheittoCelsius, 1, 2);
    gridPane.add(btMeterstoYards, 1, 3);
    gridPane.add(btKCelsiustoFahrenheit, 1, 4);
    gridPane.add(new Label("Query"), 0, 5);
    gridPane.add(tfQuery, 1, 5);
    gridPane.add(new Label("Converted Query"), 0, 6);
    gridPane.add(tfConvertedQuery, 1, 6);
    gridPane.add(btConvert, 1, 7);

    // Set properties for UI
    gridPane.setAlignment(Pos.CENTER);
    GridPane.setHalignment(btKilometerstoMeters, HPos.RIGHT);
    GridPane.setHalignment(btFeettoInches, HPos.RIGHT);
    GridPane.setHalignment(btFahrenheittoCelsius, HPos.RIGHT);
    GridPane.setHalignment(btMeterstoYards, HPos.RIGHT);
    GridPane.setHalignment(btKCelsiustoFahrenheit, HPos.RIGHT);
    GridPane.setHalignment(btConvert, HPos.RIGHT);
    tfQuery.setEditable(false);
    tfConvertedQuery.setEditable(false);

    // Process events
    btKilometerstoMeters.setOnAction(e -> convertKilometers());
    btFeettoInches.setOnAction(e -> convertFeet());
    btFahrenheittoCelsius.setOnAction(e -> convertFahrenheit());
    btMeterstoYards.setOnAction(e -> convertMeters());
    btKCelsiustoFahrenheit.setOnAction(e -> convertCelsius());

    // Create a scene and place it in the stage
    Scene scene = new Scene(gridPane, 600, 450);
    primaryStage.setTitle("Metric Converter"); // Set title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
  
  private void convertKilometers() {
    tfQuery.setEditable(true);

    btConvert.setOnAction(e -> {
        int meters = Integer.parseInt(tfQuery.getText()) * 1000;
        tfConvertedQuery.setText(String.format("%d meters", meters));
    });
  }

  private void convertFeet() {
    tfQuery.setEditable(true);
    tfQuery.setText(String.format(""));
    tfConvertedQuery.setText(String.format(""));

    btConvert.setOnAction(e -> {
        int inches = Integer.parseInt(tfQuery.getText()) * 12;
        tfConvertedQuery.setText(String.format("%d inches", inches));
    });
  }

  private void convertFahrenheit() {
    tfQuery.setEditable(true);
    tfQuery.setText(String.format(""));
    tfConvertedQuery.setText(String.format(""));

    btConvert.setOnAction(e -> {
        double celsius = (Double.parseDouble(tfQuery.getText()) - 32) / 1.8;
        tfConvertedQuery.setText(String.format("%.2f degrees Celsius", celsius));
    });
  }

  private void convertMeters() {
    tfQuery.setEditable(true);
    tfQuery.setText(String.format(""));
    tfConvertedQuery.setText(String.format(""));

    btConvert.setOnAction(e -> {
        int yards = Integer.parseInt(tfQuery.getText()) * 1760;
        tfConvertedQuery.setText(String.format("%d yards", yards));
    });
  }

  private void convertCelsius() {
    tfQuery.setEditable(true);
    tfQuery.setText(String.format(""));
    tfConvertedQuery.setText(String.format(""));

    btConvert.setOnAction(e -> {
        double fahrenheit = (Double.parseDouble(tfQuery.getText()) * 1.8) + 32;
        tfConvertedQuery.setText(String.format("%.2f degrees Fahrenheit", fahrenheit));
    });
  }

  
  
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}