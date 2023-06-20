package com.csm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.csm.dto.PriceSlab;
import com.csm.model.PriceDtl;
import com.csm.service.PriceDtlService;

@Controller
public class MyController {

	@Autowired
	PriceDtlService priceServ;

	@GetMapping("/getForm")
	public String getForm(Model model) {

		List<PriceDtl> priceDtls = priceServ.getAllList();
		model.addAttribute("priceSlabs", priceDtls);

		return "SilverJw";
	}

	@PostMapping("/save")
	public String processForm(@RequestParam("rate") Double silverRate,
			@RequestParam("jwExc") MultipartFile file, Model model) {
		try {
			// Read the Excel file
			Workbook workbook = new XSSFWorkbook(file.getInputStream());
			Sheet sheet = workbook.getSheetAt(0);

			// Parse the data from the Excel file
			List<PriceSlab> priceSlabs = new ArrayList<>();
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (row.getRowNum() == 0) {
					// Skip the header row
					continue;
				}
				PriceSlab priceSlab = new PriceSlab();

				priceSlab.setProductId((int) row.getCell(0).getNumericCellValue());
				priceSlab.setMakingChargesPerGram(row.getCell(1).getNumericCellValue());
				priceSlab.setGstPercent(row.getCell(2).getNumericCellValue());
				priceSlab.setDiscountOnMakingCharges(row.getCell(3).getNumericCellValue());
				priceSlab.setTodaySilverRate(silverRate);
				priceSlabs.add(priceSlab);
			}
			
			
			List<PriceDtl> priceDtls = new ArrayList<>();
			priceDtls = priceSlabs.stream().map(priceServ::convertPriceSlabToPriceDtl).collect(Collectors.toList());
			// Close the workbook
			workbook.close();
			System.out.println(priceDtls);
			List<PriceDtl> priceDtlsAll = priceServ.saveAllPriceDtls(priceDtls);
			// Add the data to the model
			System.out.println(priceDtlsAll);
			// model.addAttribute("priceSlabs", priceDtlsAll);

			return "redirect:/getForm";
		} catch (IOException ex) {
			// Handle the exception
			ex.printStackTrace();
			return "redirect:/";
		}
	}

}
