package com.poc.FinancialManager.Utility;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.poc.FinancialManager.model.ExpenditureModel;
import com.poc.FinancialManager.model.FInancialModel;
import com.poc.FinancialManager.model.IncomeModel;
import com.sun.scenario.effect.ImageData;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;


public class PdfPrinter {

    public void pdfConverterForModel(FInancialModel fInancialModel) throws DocumentException, IOException, URISyntaxException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("/Users/sworuppatra/IdeaProjects/financial-manager-app/src/main/java/com/poc/FinancialManager/pdfFiles/FinancialModel_"+fInancialModel.getUserId()+".pdf"));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime now = LocalDateTime.now();

        document.open();

        Font fontHeading = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.RED);
        Chunk chunk = new Chunk("Welcome to Finacial Manager Model Generator:", fontHeading);
        document.add(chunk);

        document.add(new Paragraph("\n"));
        Font fontContent = FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.BLACK);
        chunk=new Chunk("UserId: "+fInancialModel.getUserId()+"                  Date:"+now,fontContent);
        document.add(chunk);
        document.add(new Paragraph("\n"));

        document.add(new Paragraph("\n"));
        Font fontContentUnderLine = FontFactory.getFont(FontFactory.COURIER, 12, Font.UNDERLINE);
        chunk=new Chunk("INCOME TABLE",fontContentUnderLine);
        document.add(chunk);
        document.add(new Paragraph("\n"));

        //Income Model PDF generator
        PdfPTable table = new PdfPTable(7);
        addTableHeaderIncomeTable(table);
        addCustomRowsIncomeTable(table,fInancialModel.getIncomeModel());
        document.add(table);


        document.add(new Paragraph("\n"));
        chunk=new Chunk("EXPENDITURE TABLE",fontContentUnderLine);
        document.add(chunk);
        document.add(new Paragraph("\n"));

        PdfPTable tableExpense = new PdfPTable(10);
        addTableHeaderExpenditureTable(tableExpense);
        addCustomRowsExpenditureTable(tableExpense,fInancialModel.getExpenditureModel());
        document.add(tableExpense);

        document.add(new Paragraph("\n"));
        Font fontContentBold = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD);
        chunk=new Chunk("NET SAVINGS: "+fInancialModel.getSavingsModel().getSavings(),fontContentBold);
        document.add(chunk);
        document.add(new Paragraph("\n"));
        chunk=new Chunk("FINANCIAL MODEL CHART FOR USERID: "+fInancialModel.getUserId(),fontContentBold);
        document.add(chunk);
        document.add(new Paragraph("\n"));


        try {
            // Creating image by file name
            String filename = "/Users/sworuppatra/IdeaProjects/financial-manager-app/src/main/java/com/poc/FinancialManager/pdfFiles/FinancialModelChart_"+fInancialModel.getUserId()+".png";

            File file=new File(filename);

            Image image = Image.getInstance(filename);

            int indentation=0;

            float scaler = ((document.getPageSize().getWidth() - document.leftMargin()
                    - document.rightMargin() - indentation) / image.getWidth()) * 60;

            image.scalePercent(scaler);
            document.add(image);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

    private void addTableHeaderExpenditureTable(PdfPTable table) {

        Stream.of("UserId","Transc_Date","Rent","Food","Shopping","Household","vehicle","Commute","Loans","NetExpense")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });

    }

    private void addCustomRowsExpenditureTable(PdfPTable table, List<ExpenditureModel> expenditureModels) {
        expenditureModels.forEach(expenditureModel1 ->{
            table.addCell(expenditureModel1.getUserId());
            table.addCell(String.valueOf(expenditureModel1.getExpenseDate()));
            table.addCell(String.valueOf(expenditureModel1.getRent()));
            table.addCell(String.valueOf(expenditureModel1.getFood()));
            table.addCell(String.valueOf(expenditureModel1.getShopping()));
            table.addCell(String.valueOf(expenditureModel1.getHousehold()));
            table.addCell(String.valueOf(expenditureModel1.getVehicle()));
            table.addCell(String.valueOf(expenditureModel1.getCommunication()));
            table.addCell(String.valueOf(expenditureModel1.getLoans()));
            table.addCell(String.valueOf(expenditureModel1.getTotalExpense()));
        } );

    }

    private static void addTableHeaderIncomeTable(PdfPTable table) {
        Stream.of("UserId","Transc_Date","Salary","Bonus","Deduction","Others","NetIncome")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(1);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    private static void addCustomRowsIncomeTable(PdfPTable table, List<IncomeModel> incomeModel) {
       incomeModel.forEach(incomeModel1 ->{
           table.addCell(incomeModel1.getUserId());
           table.addCell(String.valueOf(incomeModel1.getIncomeDate()));
           table.addCell(String.valueOf(incomeModel1.getSalary()));
           table.addCell(String.valueOf(incomeModel1.getBonus()));
           table.addCell(String.valueOf(incomeModel1.getDeduction()));
           table.addCell(String.valueOf(incomeModel1.getOthers()));
           table.addCell(String.valueOf(incomeModel1.getTotalIncome()));
       } );
    }


}
