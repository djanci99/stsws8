package com.mirhenge.jyl.pds.view;

import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mirhenge.jyl.calendar.help.CalendarUtil;
import com.mirhenge.jyl.pds.model.JYLPds;
import com.mirhenge.jyl.spfp.model.SpfpDiary;

/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * @author www.codejava.net
 *
 */
public class PDFBuilder2 extends AbstractITextPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc,
			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		// get data model which is passed by the Spring container
		JYLPds pds = (JYLPds)model.get("pdsPDF");
		//경로
		String fontpath 
		=request.getServletContext().getRealPath("/font");
		String path 
		=request.getServletContext().getRealPath("/upload");
		System.out.println("-------------------");
		System.out.println(path);
		Image img=null;
		if(pds.getFilename().contains("png") || pds.getFilename().contains("PNG")
				|| pds.getFilename().contains("jpg")) {
			img=Image.getInstance(path+"/"+pds.getFilename());			
		}else {
			
		}
		doc.add(new Paragraph(pds.getTitle()+" 내용 "));
		
		PdfPTable table = new PdfPTable(2);//4ĭ
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] {1.0f, 5.0f});
		table.setSpacingBefore(10);
		// define font for table header row
		BaseFont fs=BaseFont.createFont(fontpath+"/H2MJRE.TTF", 
				BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		//Font font = FontFactory.getFont(FontFactory.HELVETICA);
		Font font = new Font(fs);
		Font font2 = new Font(fs);
		font.setColor(BaseColor.WHITE);
		font2.setColor(BaseColor.BLACK);
		// define table header cell
		PdfPCell cell = new PdfPCell();
		PdfPCell cell2 = new PdfPCell();
		PdfPCell cell3 = null;
		if(img!=null){
			cell3 = new PdfPCell(img, true);
			//그림배경
			cell3.setBackgroundColor(BaseColor.WHITE);
			cell3.setPadding(4);
		}
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(4);
		cell2.setBackgroundColor(BaseColor.WHITE);
		cell2.setPadding(4);
		
		// write table header 작성자
		cell.setPhrase(new Phrase("작성자", font));
		table.addCell(cell);
		cell2.setPhrase(new Phrase(pds.getId(), font2));
		table.addCell(cell2);
		// write table header 개발자 참여
		cell.setPhrase(new Phrase("제목", font));
		table.addCell(cell);
		cell2.setPhrase(new Phrase(pds.getTitle(), font2));
		table.addCell(cell2);
		
		cell.setPhrase(new Phrase("등록일", font));
		table.addCell(cell);
		cell2.setPhrase(new Phrase(pds.getRegdate()+"", font2));
		table.addCell(cell2);
		
		cell.setPhrase(new Phrase("제목", font));
		table.addCell(cell);
		cell2.setPhrase(new Phrase(pds.getTitle(), font2));
		table.addCell(cell2);
		
		cell.setPhrase(new Phrase("사진", font));
		table.addCell(cell);
		if(cell3!=null) {
			table.addCell(cell3);
		}else {
			cell2.setPhrase(new Phrase("사진없음", font2));
			table.addCell(cell2);
		}
		
		cell.setPhrase(new Phrase("내용", font));
		table.addCell(cell);
		cell2.setPhrase(new Phrase(pds.getContent(), font2));
		table.addCell(cell2);
		
		doc.add(table);
		String fileName = URLEncoder.encode((pds.getTitle().trim()),"utf-8") + ".pdf";
		response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
	}

}