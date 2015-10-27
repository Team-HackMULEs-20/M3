package gameConfig;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class StoreController implements Initializable {

    @FXML
    private Button buyEnergyButton, sellFoodButton,
            buyOreButton, buyCrysButton, sellEnergyButton,
            sellCrysButton, buyMuleButton, sellMuleButton,
            backButton, sellOreButton;
    @FXML
    private ComboBox muleChoice;

    @FXML
    private Label muleQuantityLabel, muleCostLabel, foodCostLabel,
            energyCostLabel, smithoreCostLabel, crystiteCostLabel,
            foodQuantityLabel, energyQuantityLabel, smithoreQuantityLabel,
            crystiteQuantityLabel;

    private Store store;
    public static Mule potentialMule;

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resourceBundle) {
        this.store = new Store();
       // System.out.println(store);
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

    public void updateStoreLabels() {
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

    @FXML
    public void updateMuleCostLabel(ActionEvent e) {
        System.out.println("update mule cost button clicked");
        if (e.getSource() == muleChoice) {
            String choice = muleChoice.getSelectionModel().getSelectedItem().toString();
            choice = choice.toUpperCase().substring(0, choice.indexOf(" "));
            Mule.Type type = Mule.Type.valueOf(choice);
            potentialMule = new Mule(type);
            muleCostLabel.setText(String.valueOf(potentialMule.getCost()));
        }
    }

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

    @FXML
    public void buyMuleButtonClicked(ActionEvent event) {
        Player p = Turns.getTurn();
        p.muleBuyEnable = true;
        Stage stage = (Stage) muleChoice.getScene().getWindow();
        stage.close();
        store.buySellMule(true, p);
        this.updateStoreLabels();
        GameController.infoBar.updateInfoBar(); //Todo
    }

    @FXML
    public void sellMuleButtonClicked(ActionEvent event) {
        Player p = Turns.getTurn();
        //GameController.infoBar.updateInfoBar(); //Todo
    }

    @FXML
    public void buyFoodButtonClicked(ActionEvent e) {
        Player p = Turns.getTurn();
        store.buySellFood(true, p);
        this.updateStoreLabels();
        GameController.infoBar.updateInfoBar();
    }

    @FXML
    public void sellFoodButtonClicked(ActionEvent e) {
        Player p = Turns.getTurn();
        store.buySellFood(false, p);
        this.updateStoreLabels();
        GameController.infoBar.updateInfoBar();
    }

    @FXML
    public void buyEnergyButtonClicked(ActionEvent e) {
        Player p = Turns.getTurn();
        store.buySellEnergy(true, p);
        this.updateStoreLabels();
        GameController.infoBar.updateInfoBar();
    }

    @FXML
    public void sellEnergyButtonClicked(ActionEvent e) {
        Player p = Turns.getTurn();
        store.buySellEnergy(false, p);
        this.updateStoreLabels();
        GameController.infoBar.updateInfoBar();
    }

    @FXML
    public void buyOreButtonClicked(ActionEvent e) {
        Player p = Turns.getTurn();
        store.buySellSmithore(true, p);
        this.updateStoreLabels();
        GameController.infoBar.updateInfoBar();
    }

    @FXML
    public void sellOreButtonClicked(ActionEvent e) {
        Player p = Turns.getTurn();
        store.buySellSmithore(false, p);
        this.updateStoreLabels();
        GameController.infoBar.updateInfoBar();
    }

    @FXML
    public void buyCrysButtonClicked(ActionEvent e) {
        Player p = Turns.getTurn();
        store.buySellChrystite(true, p);
        this.updateStoreLabels();
        GameController.infoBar.updateInfoBar();
    }

    @FXML
    public void sellCrysButtonClicked(ActionEvent e) {
        Player p = Turns.getTurn();
        store.buySellChrystite(false, p);
        this.updateStoreLabels();
        GameController.infoBar.updateInfoBar();
    }

}
