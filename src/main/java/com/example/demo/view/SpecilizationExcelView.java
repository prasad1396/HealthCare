package com.example.demo.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.example.demo.entity.Specialization;

//import antlr.collections.List;

public class SpecilizationExcelView  extends AbstractXlsView{
	
	@Override
	protected void buildExcelDocument (Map<String, Object> model, Workbook workbook,HttpServletRequest request,HttpServletResponse response ) throws Exception{
		
		
		List<Specialization> list = (List<Specialization>) model.get("list");
		System.out.println(" list ::" + list );
		
		
		Sheet sheet = workbook.createSheet("Specialization");
		System.out.println(" sheet::" + sheet  );
		setHead(sheet);
		
	}
	
	
	//Here first creating row object ,after based on the row object here creating cell ,and setting data to cell based on the  index
	
	private void setHead(Sheet sheet) {
		Row row  = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");  
		row.createCell(1).setCellValue("CODE");
		row.createCell(2).setCellValue("NAME");
		row.createCell(3).setCellValue("NOTE");
	}

}
