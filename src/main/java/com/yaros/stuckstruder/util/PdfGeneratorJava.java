package com.yaros.stuckstruder.util;

import java.io.IOException;
import java.util.List;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.yaros.stuckstruder.model.PublicacionEntity;
import jakarta.servlet.http.HttpServletResponse;

public class PdfGeneratorJava {
    public void generate(List <PublicacionEntity> publicacionEntityList, HttpServletResponse response) throws DocumentException, IOException {
        // Creating the Object of Document
        Document document = new Document(PageSize.A4);
        // Getting instance of PdfWriter
        PdfWriter.getInstance(document, response.getOutputStream());
        // Opening the created document to change it
        document.open();
        // Creating font
        // Setting font style and size
        Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTiltle.setSize(20);
        // Creating paragraph
        Paragraph paragraph1 = new Paragraph("Lista de Publicaciones", fontTiltle);
        // Aligning the paragraph in the document
        paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
        // Adding the created paragraph in the document
        document.add(paragraph1);
        // Creating a table of the 4 columns
        PdfPTable table = new PdfPTable(4);
        // Setting width of the table, its columns and spacing
        table.setWidthPercentage(100f);
        table.setWidths(new int[] {3,3,3,3});
        table.setSpacingBefore(5);
        // Create Table Cells for the table header
        PdfPCell cell = new PdfPCell();
        // Setting the background color and padding of the table cell
        cell.setBackgroundColor(CMYKColor.BLUE);
        cell.setPadding(5);
        // Creating font
        // Setting font style and size
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.WHITE);
        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Titulo", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Descripcion", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Autor", font));
        table.addCell(cell);
        for (PublicacionEntity publicacion: publicacionEntityList) {
            if(publicacion.getFkPregunta() == null){
                table.addCell("");
                table.addCell("");
                table.addCell("");
            }
            else{
                table.addCell(String.valueOf(publicacion.getId()));
                table.addCell(publicacion.getFkPregunta().getNombre());
                table.addCell(publicacion.getFkPregunta().getDescripcion());
            }
            if(publicacion.getFkModelo() == null){
                table.addCell("");
            }else{
                table.addCell(publicacion.getFkModelo().getNombre());
            }
        }
        // Adding the created table to the document
        document.add(table);
        // Closing the document
        document.close();
    }
}