package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.EventSummaryDTO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.util.List;

public class AdminReportPDFPrototype {

    public static void generateReport(List<EventSummaryDTO> data) {

        try (PDDocument document = new PDDocument()) {

            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream content = new PDPageContentStream(document, page);

            // ===== TITLE =====
            content.beginText();
            content.setFont(PDType1Font.HELVETICA_BOLD, 20);
            content.newLineAtOffset(50, 750);
            content.showText("EVENLY - ADMIN REPORT");
            content.endText();

            // ===== HEADER =====
            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 12);
            content.newLineAtOffset(50, 720);
            content.showText("Event Sales Summary Report");
            content.endText();

            float y = 680;

            // ===== TABLE HEADER =====
            content.beginText();
            content.setFont(PDType1Font.HELVETICA_BOLD, 10);
            content.newLineAtOffset(50, y);
            content.showText("EVENT | CITY | TICKETS | REVENUE");
            content.endText();

            y -= 20;

            // ===== DATA =====
            for (EventSummaryDTO dto : data) {

                content.beginText();
                content.setFont(PDType1Font.HELVETICA, 10);
                content.newLineAtOffset(50, y);

                String line = dto.getEventName() + " | "
                        + dto.getCity() + " | "
                        + dto.getTicketsSold() + " | $"
                        + dto.getRevenue();

                content.showText(line);
                content.endText();

                y -= 15;

                // salto de página si se llena
                if (y < 50) {
                    content.close();
                    page = new PDPage();
                    document.addPage(page);
                    content = new PDPageContentStream(document, page);
                    y = 750;
                }
            }

            content.close();

            // ===== SAVE =====
            String path = System.getProperty("user.home") + "/Downloads/evenly-admin-report.pdf";
            document.save(new File(path));

            System.out.println("PDF guardado en: " + path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}