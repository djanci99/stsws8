package com.mirhenge.jyl.pds.view;

import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.mirhenge.jyl.mboard.model.JYLMBoard;

@Component
public class ExcelBuilder extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, 
			Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		/*XSSF의 Streaming Version으로 
		 * 메모리를 적게 사용하여 대용량 엑셀 다운로드에 주로 사용되는 방식
		 * 생성자 방식에서의 기본 flush 크기는 100 이며, -1 지정시 무제한이다. 
		 * 쓰기전용이며 읽기는 불가능하다.
		 * 현업에서는 SXSSF를 Out Of Memory방지용으로 잘 사용하고 있다고 합니다.
		 * by.hc
		*/
		
		//엑셀파일로 받아지도록 통신 설정
		
		
		
		// 모델에서 객체 받아오기
		@SuppressWarnings("unchecked")
		//Map<String, Object> excelModel = (Map<String, Object>) model.get("excel");
		List<JYLMBoard> bbss = (List<JYLMBoard>) model.get("bbslist");
		//System.out.println(bbss.size()+"-----------------");
//		//컬럼이름
//		@SuppressWarnings("unchecked")
//		List<String> colName = (List<String>) excelModel.get("colName");
//		logger.info(colName);
//		
//		//로우데이터
//		@SuppressWarnings("unchecked")
//		List<List<String>> rowList = (List<List<String>>) excelModel.get("rowList");
//		logger.info(rowList);
//		
//		String title = (String)excelModel.get("title");
		
		// Sheet 생성
		Sheet sheet = workbook.createSheet("BBS");
		Row row;
		Cell cell;
		int rowIdx = 0;
		int cellIdx = 0;
		
		//title 생성
		row = sheet.createRow(rowIdx++);
		cell = row.createCell(cellIdx++);
		cell.setCellValue("BBS");
		cell.setCellStyle(takeCellStyle(workbook, "title"));
		
		//A1 - F1 의 셀 병합
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
		
		/*
		 * //A1 - F1 의 셀 스타일 설정 for (int i = 0; i<4; i ++) { cell = row.createCell(i);
		 * cell.setCellStyle(takeCellStyle(workbook, "title")); }
		 */
		//한줄 띄우기
		String[] colName= {"번호","아이디","제목","작성일"};
		//col 데이터 생성
		row = sheet.createRow(rowIdx++);
		for (int i = 0; i< colName.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(colName[i]);
			cell.setCellStyle(takeCellStyle(workbook, "title"));
		}
		
		// create data rows
		int rowCount = 1;
		int i=0;
		for (JYLMBoard bbs : bbss) {
			System.out.println(bbs);
			row = sheet.createRow(rowCount++);
			row.createCell(0).setCellValue(bbs.getSeq()+"");
			row.createCell(0).setCellStyle(takeCellStyle(workbook, "data"));
			row.createCell(1).setCellValue(bbs.getId());
			row.createCell(1).setCellStyle(takeCellStyle(workbook, "data"));
			row.createCell(2).setCellValue(bbs.getTitle());
			row.createCell(2).setCellStyle(takeCellStyle(workbook, "data"));
			row.createCell(3).setCellValue(bbs.getWdate()+"");
			row.createCell(3).setCellStyle(takeCellStyle(workbook, "data"));
		}
		response.setContentType("application/vnd.ms-excel");
        String fileName = URLEncoder.encode("bbslist"+(new Date().getTime()),"utf-8") + ".xlsx";
		response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\";");
		//response.setHeader("Content-Transfer-Encoding", "binary");
		// Excel File Output
		//workbook.write(response.getOutputStream());
		//workbook.close();
	}

	
	public static CellStyle takeCellStyle(Workbook xlsxWb, String type) {
		CellStyle cellStyle = xlsxWb.createCellStyle();
		Font font = xlsxWb.createFont();
		
		//중앙 정렬
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		
		//본문 스타일 : 테두리
		cellStyle.setBorderBottom(BorderStyle.MEDIUM);
		cellStyle.setBorderLeft(BorderStyle.MEDIUM);
		cellStyle.setBorderRight(BorderStyle.MEDIUM);
		cellStyle.setBorderTop(BorderStyle.MEDIUM);
		
		if(type.equals("title")) {
			cellStyle.setFillForegroundColor(IndexedColors.LIME.getIndex());
			cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			font.setFontHeightInPoints((short) 11);
			font.setBold(true);
			font.setFontName("함초롬돋움");
			cellStyle.setFont(font);
		} else if(type.equals("data")) {
			font.setFontHeightInPoints((short) 11);
			font.setFontName("함초롬돋움");
			cellStyle.setFont(font);
		}
		
		return cellStyle;
	}

}