package org.jlrdigital.rv.test.rvseleniumtest.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Created by mahughes
 * This class is designed to read the questions from an Excel Spreadsheet, to enable testing of the user interface against the 
 * correct list of questions
 */
public class ReadQuestions {
	
	public static final String PATH = "src/main/resources/PpapChecklist.xlsm";
	public static final String COMPLETE_SUMMARY = "Complete Summary";
	
	public static XSSFWorkbook setupReader() {
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		
		//This takes the path to the spreadsheet and uses it to create a workbook object.
		try {
			fis = new FileInputStream(PATH);
			workbook = new XSSFWorkbook(fis);
			workbook.setMissingCellPolicy(Row.CREATE_NULL_AS_BLANK); //If any cells are blank, this treats them as cells with "" in them. Without it an empty cell would be treated as the end of the row
		} catch (IOException e) {
			e.printStackTrace();
		}
		return workbook;
	}
	
	/*
	 * This method takes a sheetname (from the process step number) and then pulls out all the cells in that page into a 2D array of strings, to model a table, 
	 * which we will then be able to interrogate in our tests with String comparisons
	 */
	public static String[][] getQuestionsFromProcessStep(String sheetName, XSSFWorkbook workbook) {
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		//This will enable us to get the results of formulae, rather than the formulae as strings
		FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
		
		int numRows = sheet.getLastRowNum() + 1;
		int numCols = sheet.getRow(0).getLastCellNum();
		
		String[][] sheetData = new String[numRows][numCols];
		
		//Iterate through each cell in the table, evaluate it and put it into the 2D array
		for(int i = 0; i < numRows; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < numCols; j++) {
				Cell cell = row.getCell(j);
				String value = cellToString(cell, evaluator);
				sheetData[i][j] = value;
			}
		}
		System.out.println("processing complete");
		return sheetData;
	}
	/*
	 * This will be used when information is needed from the summary sheet, which is formatted slightly different to the others. 
	 */
public static String[][] getQuestionsFromSummary(XSSFWorkbook workbook) {
		
		//create an object of the summary sheet
		XSSFSheet sheet = workbook.getSheet(COMPLETE_SUMMARY);
		
		//This will enable us to get the results of formulae, rather than the formulae as strings
		FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
		
		int numRows = sheet.getLastRowNum() + 1;
		int numCols = sheet.getRow(0).getLastCellNum();
		
		String[][] sheetData = new String[numRows][numCols];
		
		for(int i = 0; i < numRows; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < numCols; j++) {
				Cell cell = row.getCell(j);
				String value = cellToString(cell, evaluator);
				sheetData[i][j] = value;
			}
		}
		System.out.println("processing complete");
		return sheetData;
	}
	
	//This makes sure the format of each cell is a string so that it can be compared and evaluated by the tests
	public static String cellToString(Cell cell, FormulaEvaluator evaluator) {
        int type = cell.getCellType();
        String result;
         
        //Formulas can't be evaluated, so throw an Exception if one is encountered.
        if (type == Cell.CELL_TYPE_FORMULA) {
            //throw new RuntimeException("Cannot process a formula. Please change field to result of formula. Cell: " + cell.getRowIndex() + " " + cell.getColumnIndex());
        	CellValue cellValue = evaluator.evaluate(cell);
        	result = cellValue.formatAsString();
        }
        //If blanks are ever able to be evaluated by Apache POI, set them to empty string
        else if (type ==Cell.CELL_TYPE_BLANK) {
            result = " ";
        }
        //Convert cell contents to String
        else {
            result = String.valueOf(cell);
        }
        return result;
	}
	
	//Search within the array that has been generated for the String we need to find.
	public static boolean searchSheet(String[][] array, String toFind) {
		boolean found = false;
		outerloop:
		for (int i = 0; i < array.length; i++) {
		    for (int j = 0; j < array[1].length; j++) {
		        if (array[i][j].contains(toFind)) {
		            found = true;
		            break outerloop;
		    } else {
		    	found = false;
		    }
		    }
		}
		return found;
	}
	
	/*On the QuestionSet page, filter out all rows that we aren't looking for, then look through the one we're on for the String we are expecting.
	 * e.g for qSet1, in the loop, check the first cell in a row for the question set number, only if it is found search for the string in that row.
	 */

	public static boolean searchRows(String[][] data, String setNo, String question) {
		boolean found = false;
		String[][] xlsData = data;
		outerloop:
		for(int i = 0; i < xlsData.length; i++) {
			if(xlsData[i][0].equals(setNo)) {
				for(int j = 0; j < xlsData[1].length; j++) {
					if(xlsData[i][j].contains(question)) {
						found = true;
						break outerloop;
					}
				}
			}
		}
		return found;
	}
}
