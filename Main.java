import java.io.File;

public class Main extends Application {

  private TextField directoryPathField;
  private TextField searchField;
  private TextArea resultArea;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("File Browser and Search");

    directoryPathField = new TextField();
    directoryPathField.setPromptText("Enter directory path");

    searchField = new TextField();
    searchField.setPromptText("Enter search phrase");

    resultArea = new TextArea();
    resultArea.setPrefHeight(400);

    Button searchButton = new Button("Search");
    Button browseButton = new Button("Browse");
    browseButton.setOnAction(e -> browseDirectory());

    HBox hBox = new HBox(10, directoryPathField, browseButton);
    VBox vBox = new VBox(10, hBox, searchField, searchButton, resultArea);

    Scene scene = new Scene(vBox, 600, 200);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void browseDirectory() {
    DirectoryChooser directoryChooser = new DirectoryChooser();
    File selectedDirectory = directoryChooser.showDialog(null);
    if (selectedDirectory != null) {
      directoryPathField.setText(selectedDirectory.getAbsolutePath());
    }
  }
}