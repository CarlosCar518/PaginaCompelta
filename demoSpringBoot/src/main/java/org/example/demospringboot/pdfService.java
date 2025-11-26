package org.example.demospringboot;

import Model.Accesorio;
import Model.Mascota;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import java.util.List;

public class pdfService {
    public pdfService() {
    }

    public byte[] createPdf(Mascota mascotaFinal, List<Accesorio> accesorios){

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        com.lowagie.text.Document pdf = new com.lowagie.text.Document();
        com.lowagie.text.pdf.PdfWriter.getInstance(pdf, out);

        pdf.open();

        // Define fonts
        com.lowagie.text.Font titleFont = new com.lowagie.text.Font(
                com.lowagie.text.Font.HELVETICA, 24, com.lowagie.text.Font.BOLD,
                new java.awt.Color(51, 51, 51)
        );
        com.lowagie.text.Font headingFont = new com.lowagie.text.Font(
                com.lowagie.text.Font.HELVETICA, 12, com.lowagie.text.Font.BOLD,
                new java.awt.Color(80, 80, 80)
        );
        com.lowagie.text.Font normalFont = new com.lowagie.text.Font(
                com.lowagie.text.Font.HELVETICA, 10, com.lowagie.text.Font.NORMAL,
                new java.awt.Color(100, 100, 100)
        );
        com.lowagie.text.Font boldFont = new com.lowagie.text.Font(
                com.lowagie.text.Font.HELVETICA, 10, com.lowagie.text.Font.BOLD,
                new java.awt.Color(51, 51, 51)
        );
        com.lowagie.text.Font footerFont = new com.lowagie.text.Font(
                com.lowagie.text.Font.HELVETICA, 9, com.lowagie.text.Font.ITALIC,
                new java.awt.Color(120, 120, 120)
        );

        // Title
        com.lowagie.text.Paragraph title = new com.lowagie.text.Paragraph("RECIBO DE ADOPCIÓN", titleFont);
        title.setAlignment(com.lowagie.text.Element.ALIGN_CENTER);
        title.setSpacingAfter(30);
        pdf.add(title);

        // Pet section
        com.lowagie.text.Paragraph petHeading = new com.lowagie.text.Paragraph("Mascota Adoptada", headingFont);
        petHeading.setSpacingBefore(10);
        petHeading.setSpacingAfter(8);
        pdf.add(petHeading);

        com.lowagie.text.Paragraph petInfo = new com.lowagie.text.Paragraph(
                mascotaFinal.getNombre() + "  •  " + mascotaFinal.getTipo(),
                normalFont
        );
        petInfo.setSpacingAfter(20);
        pdf.add(petInfo);

        // Accessories section
        if (!accesorios.isEmpty()) {
            com.lowagie.text.Paragraph accHeading = new com.lowagie.text.Paragraph("Accesorios", headingFont);
            accHeading.setSpacingBefore(10);
            accHeading.setSpacingAfter(10);
            pdf.add(accHeading);

            // Create table for accessories
            com.lowagie.text.pdf.PdfPTable table = new com.lowagie.text.pdf.PdfPTable(3);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{3f, 1f, 1.5f});
            table.setSpacingAfter(15);

            // Table header
            com.lowagie.text.pdf.PdfPCell headerCell1 = new com.lowagie.text.pdf.PdfPCell(
                    new com.lowagie.text.Phrase("Artículo", headingFont)
            );
            headerCell1.setBorder(com.lowagie.text.Rectangle.BOTTOM);
            headerCell1.setBorderWidthBottom(1.5f);
            headerCell1.setBorderColor(new java.awt.Color(200, 200, 200));
            headerCell1.setPadding(8);
            headerCell1.setPaddingBottom(10);
            table.addCell(headerCell1);

            com.lowagie.text.pdf.PdfPCell headerCell2 = new com.lowagie.text.pdf.PdfPCell(
                    new com.lowagie.text.Phrase("Cant.", headingFont)
            );
            headerCell2.setBorder(com.lowagie.text.Rectangle.BOTTOM);
            headerCell2.setBorderWidthBottom(1.5f);
            headerCell2.setBorderColor(new java.awt.Color(200, 200, 200));
            headerCell2.setPadding(8);
            headerCell2.setPaddingBottom(10);
            headerCell2.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_CENTER);
            table.addCell(headerCell2);

            com.lowagie.text.pdf.PdfPCell headerCell3 = new com.lowagie.text.pdf.PdfPCell(
                    new com.lowagie.text.Phrase("Precio", headingFont)
            );
            headerCell3.setBorder(com.lowagie.text.Rectangle.BOTTOM);
            headerCell3.setBorderWidthBottom(1.5f);
            headerCell3.setBorderColor(new java.awt.Color(200, 200, 200));
            headerCell3.setPadding(8);
            headerCell3.setPaddingBottom(10);
            headerCell3.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_RIGHT);
            table.addCell(headerCell3);

            // Table rows
            int totalAccesorios = 0;
            for (Accesorio a : accesorios) {
                int subtotal = a.getPrecioUnitario() * a.getCantidad();
                totalAccesorios += subtotal;

                com.lowagie.text.pdf.PdfPCell nameCell = new com.lowagie.text.pdf.PdfPCell(
                        new com.lowagie.text.Phrase(a.getNombre(), normalFont)
                );
                nameCell.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
                nameCell.setPadding(8);
                table.addCell(nameCell);

                com.lowagie.text.pdf.PdfPCell qtyCell = new com.lowagie.text.pdf.PdfPCell(
                        new com.lowagie.text.Phrase(String.valueOf(a.getCantidad()), normalFont)
                );
                qtyCell.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
                qtyCell.setPadding(8);
                qtyCell.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_CENTER);
                table.addCell(qtyCell);

                com.lowagie.text.pdf.PdfPCell priceCell = new com.lowagie.text.pdf.PdfPCell(
                        new com.lowagie.text.Phrase("$" + subtotal, normalFont)
                );
                priceCell.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
                priceCell.setPadding(8);
                priceCell.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_RIGHT);
                table.addCell(priceCell);
            }

            pdf.add(table);

            // Total
            com.lowagie.text.Paragraph totalPara = new com.lowagie.text.Paragraph(
                    "Total: $" + totalAccesorios,
                    boldFont
            );
            totalPara.setAlignment(com.lowagie.text.Element.ALIGN_RIGHT);
            totalPara.setSpacingBefore(5);
            totalPara.setSpacingAfter(30);
            pdf.add(totalPara);
        }

        // Footer
        com.lowagie.text.Paragraph footer = new com.lowagie.text.Paragraph(
                "Gracias por adoptar y cuidar de una mascota",
                footerFont
        );
        footer.setAlignment(com.lowagie.text.Element.ALIGN_CENTER);
        footer.setSpacingBefore(20);
        pdf.add(footer);

        pdf.close();

        // Convertir PDF a bytes
        return out.toByteArray();
    }
}
