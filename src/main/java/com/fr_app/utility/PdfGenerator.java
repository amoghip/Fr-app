package com.fr_app.utility;

import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.fr_app.entity.Reservation;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
@Component
public class PdfGenerator {
	 
    public void generateItinerary (Reservation reservation,String filePath  )
    		 {
    	try {
			Document document=new Document();
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();
			document.add(generateTable(reservation));
			document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


	private PdfPTable generateTable(Reservation reservation) {
    	
        PdfPTable table = new PdfPTable(2);//2 colomns

        PdfPCell cell = new PdfPCell(new Phrase("passenger details"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(2);
        table.addCell(cell);

        table.addCell("passenger name");
        table.addCell(reservation.getPassenger().getFirstName());

        table.addCell("emailid");
        table.addCell(reservation.getPassenger().getEmail());
        table.addCell("phone number");
        table.addCell(reservation.getPassenger().getPhone());

        
        
        PdfPCell cell2 = new PdfPCell(new Phrase("  flight details"));
        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2.setColspan(2);
        table.addCell(cell2);
        
        table.addCell("operating airlines");
        table.addCell( reservation.getFlight().getOperatingAirlines());//using flight obj address callling op airlines
        table.addCell("departure date");
        table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());
        table.addCell("departure city");
        table.addCell(reservation.getFlight().getDepartureCity());

		return table;
	}

 
    
}
    
    
    
    
    
    
    