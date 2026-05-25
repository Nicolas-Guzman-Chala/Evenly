package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.Compra;
import co.edu.uniquindio.poo.evenly.classes.model.Entrada;
import co.edu.uniquindio.poo.evenly.classes.model.Event;
import co.edu.uniquindio.poo.evenly.classes.model.PurchaseTicketPDFPrototype;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;

public class HistoryUserCardController {

    private Compra compra;

    @FXML
    private ImageView imgEvent;

    @FXML
    private Label textDate;

    @FXML
    private Label textHour;

    @FXML
    private Label textNameEvent;

    @FXML
    private Label textTotalCost;

    @FXML
    private Label textVenueAndCity;

    public void setData(Compra compra) {

        this.compra = compra;

        textNameEvent.setText(
                compra.getEventName()
        );

        textDate.setText(
                compra.getEventDate()
        );

        textHour.setText(
                compra.getEventHour()
        );

        textTotalCost.setText(
                "$" + compra.calcularTotal()
        );

        StringBuilder seats = new StringBuilder();

        for(Entrada entrada : compra.getEntradas()) {

            seats.append(
                    entrada.getAsientoAsociado().getCode()
            ).append(" ");
        }

        textVenueAndCity.setText(
                seats.toString()
        );

        cargarImagenEvento();
    }

    private void cargarImagenEvento() {

        try {

            String path =
                    compra.getEventImagePath();

            if(path != null && !path.isEmpty()) {

                File file = new File(path);

                if(file.exists()) {

                    Image image = new Image(
                            file.toURI().toString()
                    );

                    imgEvent.setImage(image);
                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @FXML
    void onChangeHistoryInfo(MouseEvent event) {

        System.out.println("Generando PDF de compra...");

        PurchaseTicketPDFPrototype.generateTicket(compra);
    }
}