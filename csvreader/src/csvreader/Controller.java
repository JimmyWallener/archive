package csvreader;




import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import csvreader.model.DataModel;
import csvreader.utils.FileManager;
import javafx.scene.control.cell.TextFieldTableCell;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable {



    @FXML private TableColumn<DataModel,String> orderDate;
    @FXML private TableColumn<DataModel,String> region;
    @FXML private TableColumn<DataModel,String> rep1;
    @FXML private TableColumn<DataModel,String> rep2;
    @FXML private TableColumn<DataModel,String> item;
    @FXML private TableColumn<DataModel,String> units;
    @FXML private TableColumn<DataModel,String> unitCost;
    @FXML private TableColumn<DataModel,String> total;
    @FXML private TableView<DataModel> table;
    @FXML private TextField orderDateTextField;
    @FXML private TextField regionTextField;
    @FXML private TextField rep1TextField;
    @FXML private TextField rep2TextField;
    @FXML private TextField itemTextField;
    @FXML private TextField unitsTextField;
    @FXML private TextField unitCostTextField;
    @FXML private TextField totalTextField;


    private ObservableList<DataModel> dm = FXCollections.observableArrayList();
    private final FileManager fm = new FileManager();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setTableData();
        getData();


    }

    // Populate Table Data
    private void setTableData(){

        orderDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        region.setCellValueFactory(new PropertyValueFactory<>("region"));
        rep1.setCellValueFactory(new PropertyValueFactory<>("rep1"));
        rep2.setCellValueFactory(new PropertyValueFactory<>("rep2"));
        item.setCellValueFactory(new PropertyValueFactory<>("item"));
        units.setCellValueFactory(new PropertyValueFactory<>("units"));
        unitCost.setCellValueFactory(new PropertyValueFactory<>("unitCost"));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));

        editTableData();
    }

    // Makes Cells Editable and saves new Value to Object
    private void editTableData(){
        orderDate.setCellFactory(TextFieldTableCell.forTableColumn());
        orderDate.setOnEditCommit(td -> td.getTableView().getItems().get(td.getTablePosition().getRow()).setOrderDate(td.getNewValue()));

        region.setCellFactory(TextFieldTableCell.forTableColumn());
        region.setOnEditCommit(td -> td.getTableView().getItems().get(td.getTablePosition().getRow()).setRegion(td.getNewValue()));

        rep1.setCellFactory(TextFieldTableCell.forTableColumn());
        rep1.setOnEditCommit(td -> td.getTableView().getItems().get(td.getTablePosition().getRow()).setRep1(td.getNewValue()));

        rep2.setCellFactory(TextFieldTableCell.forTableColumn());
        rep2.setOnEditCommit(td -> td.getTableView().getItems().get(td.getTablePosition().getRow()).setRep2(td.getNewValue()));

        item.setCellFactory(TextFieldTableCell.forTableColumn());
        item.setOnEditCommit(td -> td.getTableView().getItems().get(td.getTablePosition().getRow()).setItem(td.getNewValue()));

        units.setCellFactory(TextFieldTableCell.forTableColumn());
        units.setOnEditCommit(td -> td.getTableView().getItems().get(td.getTablePosition().getRow()).setUnits(td.getNewValue()));

        unitCost.setCellFactory(TextFieldTableCell.forTableColumn());
        unitCost.setOnEditCommit(td -> td.getTableView().getItems().get(td.getTablePosition().getRow()).setUnitCost(td.getNewValue()));

        total.setCellFactory(TextFieldTableCell.forTableColumn());
        total.setOnEditCommit(td -> td.getTableView().getItems().get(td.getTablePosition().getRow()).setTotal(td.getNewValue()));



    }
    // Gets TextField Value and creates a new record to be added
    public void addToRecord(){
        DataModel addData = new DataModel(orderDateTextField.getText(),regionTextField.getText(),rep1TextField.getText(),
                rep2TextField.getText(),itemTextField.getText(),unitsTextField.getText(),unitCostTextField.getText(),totalTextField.getText());
        dm.add(addData);
    }

    // Resets the Text Fields
    public void resetField() {

        orderDateTextField.clear();
        regionTextField.clear();
        rep1TextField.clear();
        rep2TextField.clear();
        itemTextField.clear();
        unitsTextField.clear();
        unitCostTextField.clear();
        totalTextField.clear();
    }


    // Not so good looking code for populating Observable List with Model.
    public void getData() {

        ArrayList<String[]> csvData = fm.csvParser();

        csvData.stream().skip(1).forEach(items -> {
            String date = items[0];
            String region = items[1];
            String rep1 = items[2];
            String rep2 = items[3];
            String item = items[4];
            String units = items[5];
            String unitCost = items[6];
            String total = items[7];
            dm.add(new DataModel(date,region,rep1,rep2,item,units,unitCost,total));

        });
        // Sends Observable List Data to Table View.
        table.setItems(dm);

    }
    public void saveChanges() {
       List<DataModel> fileSave = table.getItems();
       fm.writeDataToCsv(fileSave);


    }

}

