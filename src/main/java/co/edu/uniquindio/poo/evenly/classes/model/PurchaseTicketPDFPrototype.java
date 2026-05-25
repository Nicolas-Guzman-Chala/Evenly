package co.edu.uniquindio.poo.evenly.classes.model;

import co.edu.uniquindio.poo.evenly.classes.model.Compra;
import co.edu.uniquindio.poo.evenly.classes.model.Entrada;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;

public class PurchaseTicketPDFPrototype {

    public static void generateTicket(Compra compra) {

        try (PDDocument document = new PDDocument()) {

            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream content =
                    new PDPageContentStream(document, page);

            // ================= HEADER =================
            content.beginText();
            content.setFont(PDType1Font.HELVETICA_BOLD, 20);
            content.newLineAtOffset(50, 750);
            content.showText("EVENLY - PURCHASE TICKET");
            content.endText();

            // ================= EVENT INFO =================
            drawText(content, "Event: " + compra.getEventName(), 700);
            drawText(content, "Date: " + compra.getEventDate(), 680);
            drawText(content, "Hour: " + compra.getEventHour(), 660);

            // ================= SEATS =================
            StringBuilder seats = new StringBuilder();
            for (Entrada e : compra.getEntradas()) {
                seats.append(e.getAsientoAsociado().getCode()).append(" ");
            }

            drawText(content, "Seats: " + seats, 630);

            // ================= TOTAL =================
            drawText(content, "Total Paid: $" + compra.calcularTotal(), 600);

            // ================= FOOTER =================
            drawText(content, "Thank you for your purchase!", 550);

            content.close();

            String fileName =
                    "ticket_" + compra.getIdCompra() + ".pdf";

            document.save(fileName);

            System.out.println("PDF generated: " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void drawText(PDPageContentStream content,
                                 String text,
                                 int y) throws IOException {

        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(50, y);
        content.showText(text);
        content.endText();
    }
}