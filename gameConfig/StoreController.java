package gameConfig;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class StoreController implements Initializable {

    @FXML
    public Button buyEnergyButton;
    @FXML
    public Button sellFoodButton;
    @FXML
    public Button buyOreButton;
    @FXML
    public Button buyCrysButton;
    @FXML
    public Button sellEnergyButton;
    @FXML
    public Button sellCrysButton;
    @FXML
    public Button buyMuleButton;
    @FXML
    public Button sellMuleButton;
    @FXML
    private Button backButton;
    @FXML
    public Button sellOreButton;
    @FXML
    private ComboBox muleChoice;

    @FXML
    private Label muleQuantityLabel, muleCostLabel, foodCostLabel,
            energyCostLabel, smithoreCostLabel, crystiteCostLabel,
            foodQuantityLabel, energyQuantityLabel, smithoreQuantityLabel,
            crystiteQuantityLabel;

    public static Store store;
    public static Mule potentialMule;
    public static boolean buy;

    /**
     *
     * @param fxmlFileLocation the fxml file where the file is located
     * @param resourceBundle group of resources
     */
    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resourceBundle) {
        if (Controller.loaded) {
            store = (Store) Controller.loadData.get(2);
        } else {
            store = new Store();
        }
        muleQuantityLabel.setText(String.valueOf(store.getMuleQuantity()));
        muleCostLabel.setText(String.valueOf(store.getMuleCost()));
        foodCostLabel.setText(String.valueOf(store.getFoodCost()));
        foodQuantityLabel.setText(String.valueOf(store.getFoodQuantity()));
        energyCostLabel.setText(String.valueOf(store.getEnergyCost()));
        energyQuantityLabel.setText(String.valueOf(store.getEnergyQuantity()));
        crystiteCostLabel.setText(String.valueOf(store.getCrysCost()));
        crystiteQuantityLabel.setText(String.valueOf(store.getCrysQuantity()));
        smithoreCostLabel.setText(String.valueOf(store.getSmithCost()));
        smithoreQuantityLabel.setText(String.valueOf(store.getSmithQuantity()));
    }

    private void updateStoreLabels() {
        muleQuantityLabel.setText(String.valueOf(store.getMuleQuantity()));
        muleCostLabel.setText(String.valueOf(store.getMuleCost()));
        foodCostLabel.setText(String.valueOf(store.getFoodCost()));
        foodQuantityLabel.setText(String.valueOf(store.getFoodQuantity()));
        energyCostLabel.setText(String.valueOf(store.getEnergyCost()));
        energyQuantityLabel.setText(String.valueOf(store.getEnergyQuantity()));
        crystiteCostLabel.setText(String.valueOf(store.getCrysCost()));
        crystiteQuantityLabel.setText(String.valueOf(store.getCrysQuantity()));
        smithoreCostLabel.setText(String.valueOf(store.getSmithCost()));
        smithoreQuantityLabel.setText(String.valueOf(store.getSmithQuantity()));
    }

    /**
     *
     * @param e the actionevent to check button source
     */
    @FXML
    public void updateMuleCostLabel(ActionEvent e) {
        if (e.getSource() == muleChoice) {
            String choice = muleChoice.getSelectionModel().getSelectedItem().toString();
            choice = choice.toUpperCase().substring(0, choice.indexOf(" "));
            Mule.Type type = Mule.Type.valueOf(choice);
            potentialMule = new Mule(type);
            muleCostLabel.setText(String.valueOf(potentialMule.getCost()));
        }
    }

    /**
     *
     * @param e the actionevent to check button source
     */
    @FXML
    public void backButtonClicked(ActionEvent e) {
        Stage newStage = new Stage();
        if (e.getSource() == backButton) {
            newStage.setScene(GameController.townScene);
            newStage.setTitle("Town");
            newStage.show();
        }
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    /**
     *
     * @param event the actionevent to check button source
     */
    @FXML
    public void buyMuleButtonClicked(ActionEvent event) {
        Stage stage = (Stage) muleChoice.getScene().getWindow();
        stage.close();
        //GameController.landButton.setDisable(false);
        this.messageBox();
        this.updateStoreLabels();
        buy  = true;
    }

    /**
     *
     * @param event actionevent to check button source
     */
    @FXML
    public void sellMuleButtonClicked(ActionEvent event) {
        Stage stage = (Stage) muleChoice.getScene().getWindow();
        stage.close();
        //GameController.landButton.setDisable(false);
        this.messageBox();
        this.updateStoreLabels();
        buy = false;
    }

    private void messageBox() {
        Stage stage = new Stage();
        stage.setTitle("Buying/Selling a Mule");
        GridPane grid = new GridPane();
        Label label = new Label("Please select one of your land plots to emplace/sell mule.");
        label.setFont(new Font("American Typewriter", 15));
        Button errorButton = new Button("Ok");
        errorButton.setFont(new Font("American Typewriter", 17));
        errorButton.setOnAction((ActionEvent e) -> stage.close());
        grid.add(label, 0, 0);
        grid.add(errorButton, 1, 1);
        Scene errorScene = new Scene(grid);
        stage.setScene(errorScene);
        stage.show();
        stage.toFront();
    }

    /**
     *
     * @param e the actionevent to check button source
     */
    @FXML
    public void buyFoodButtonClicked(ActionEvent e) {
        Player p = Turns.getTurn();
        store.buySellFood(true, p);
        this.updateStoreLabels();
        GameController.infoBar.updateInfoBar();
    }
    /**
     *
     * @param e the actionevent to check button source
     */
    @FXML
    public void sellFoodButtonClicked(ActionEvent e) {
        Player p = Turns.getTurn();
        store.buySellFood(false, p);
        this.updateStoreLabels();
        GameController.infoBar.updateInfoBar();
    }
    /**
     *
     * @param e the actionevent to check button source
     */
    @FXML
    public void buyEnergyButtonClicked(ActionEvent e) {
        Player p = Turns.getTurn();
        store.buySellEnergy(true, p);
        this.updateStoreLabels();
        GameController.infoBar.updateInfoBar();
    }
    /**
     *
     * @param e the actionevent to check button source
     */
    @FXML
    public void sellEnergyButtonClicked(ActionEvent e) {
        Player p = Turns.getTurn();
        store.buySellEnergy(false, p);
        this.updateStoreLabels();
        GameController.infoBar.updateInfoBar();
    }
    /**
     *
     * @param e the actionevent to check button source
     */
    @FXML
    public void buyOreButtonClicked(ActionEvent e) {
        Player p = Turns.getTurn();
        store.buySellSmithore(true, p);
        this.updateStoreLabels();
        GameController.infoBar.updateInfoBar();
    }
    /**
     *
     * @param e the actionevent to check button source
     */
    @FXML
    public void sellOreButtonClicked(ActionEvent e) {
        Player p = Turns.getTurn();
        store.buySellSmithore(false, p);
        this.updateStoreLabels();
        GameController.infoBar.updateInfoBar();
    }
    /**
     *
     * @param e the actionevent to check button source
     */
    @FXML
    public void buyCrysButtonClicked(ActionEvent e) {
        Player p = Turns.getTurn();
        store.buySellChrystite(true, p);
        this.updateStoreLabels();
        GameController.infoBar.updateInfoBar();
    }
    /**
     *
     * @param e the actionevent to check button source
     */
    @FXML
    public void sellCrysButtonClicked(ActionEvent e) {
        Player p = Turns.getTurn();
        store.buySellChrystite(false, p);
        this.updateStoreLabels();
        GameController.infoBar.updateInfoBar();
    }

}
