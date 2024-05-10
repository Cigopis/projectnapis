package Component;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.util.Arrays;
import java.util.List;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.util.StringConverter;


public class lineChart extends Application {

    private TableView<XYChart.Data<String, Number>> tableView = new TableView<>();
   private ObservableList<XYChart.Data<String, Number>> dataList = FXCollections.observableArrayList(
        new XYChart.Data<>("January", 0),
        new XYChart.Data<>("February", 0),
        new XYChart.Data<>("March", 0),
        new XYChart.Data<>("April", 0),
        new XYChart.Data<>("May", 0),
        new XYChart.Data<>("June", 0),
        new XYChart.Data<>("July", 0),
        new XYChart.Data<>("August", 0),
        new XYChart.Data<>("September", 0),
        new XYChart.Data<>("October", 0),
        new XYChart.Data<>("November", 0),
        new XYChart.Data<>("December", 0));


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Line Chart");

        Group root = new Group();

        tableView.setEditable(true);

        Callback<TableColumn<XYChart.Data<String, Number>, Number>, TableCell<XYChart.Data<String, Number>, Number>> cellFactory
                = new Callback<TableColumn<XYChart.Data<String, Number>, Number>, TableCell<XYChart.Data<String, Number>, Number>>() {
            @Override
            public TableCell call(TableColumn p) {
                return new EditingCell();
            }
        };

        TableColumn<XYChart.Data<String, Number>, String> columnMonth = new TableColumn<>("Month");
        columnMonth.setCellValueFactory(cellData -> cellData.getValue().XValueProperty());

        TableColumn<XYChart.Data<String, Number>, Number> columnValue = new TableColumn<>("Value");
        columnValue.setCellValueFactory(cellData -> cellData.getValue().YValueProperty());
        columnValue.setCellFactory(cellFactory);

        columnValue.setOnEditCommit((TableColumn.CellEditEvent<XYChart.Data<String, Number>, Number> t) -> {
            t.getRowValue().setYValue(t.getNewValue());
        });

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month");
        yAxis.setLabel("Value");

        final LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("LineChart");
        XYChart.Series<String, Number> series = new XYChart.Series<>(dataList);
        series.setName("XYChart.Series");
        lineChart.getData().add(series);

        tableView.setItems(dataList);
        tableView.getColumns().addAll(columnMonth, columnValue);

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.getChildren().addAll(tableView, lineChart);

        root.getChildren().add(hBox);

        primaryStage.setScene(new Scene(root, 670, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class EditingCell extends TableCell<XYChart.Data<String, Number>, Number> {

    private TextField textField;

    public EditingCell() {
    }

    @Override
    public void startEdit() {
        super.startEdit();

        if (textField == null) {
            createTextField();
        }

        setGraphic(textField);
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        textField.selectAll();
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();

        setText(String.valueOf(getItem()));
        setContentDisplay(ContentDisplay.TEXT_ONLY);
    }

    @Override
    public void updateItem(Number item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            if (isEditing()) {
                if (textField != null) {
                    textField.setText(getString());
                }
                setGraphic(textField);
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            } else {
                setText(getString());
                setContentDisplay(ContentDisplay.TEXT_ONLY);
            }
        }
    }

    private void createTextField() {
        textField = new TextField(getString());
        textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
        textField.setOnKeyPressed((KeyEvent t) -> {
            if (t.getCode() == KeyCode.ENTER) {
                commitEdit(Double.parseDouble(textField.getText()));
            } else if (t.getCode() == KeyCode.ESCAPE) {
                cancelEdit();
            }
        });
    }

    private String getString() {
        return getItem() == null ? "" : getItem().toString();
    }
}
