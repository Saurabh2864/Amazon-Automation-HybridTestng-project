

package utilities;


import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import org.testng.ITestContext;
import org.testng.ITestResult;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PDFReportGenerator {

    public void generatePDFReport(ITestContext context) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String pdfPath = System.getProperty("user.dir") + "/PDF-Report/Amazon Automation testing report" + timeStamp + ".pdf";

        // Create a new PDF writer
        PdfWriter writer = new PdfWriter(pdfPath);
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);

        // Add a title to the PDF document
        document.add(new Paragraph("Amazon Website Automation Testing Report"));
        document.add(new Paragraph("Date: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
        document.add(new Paragraph("Execution Start Time: " + context.getStartDate()));
       document.add(new Paragraph("Execution End Date: " + context.getEndDate()));
       document.add(new Paragraph("Passed TestCases: " + context.getPassedTests()));
       document.add(new Paragraph("Failed TestCases: " + context.getFailedTests()));
       document.add(new Paragraph("Skipped TestCases: " + context.getSkippedTests()));




        // Add summary information
        document.add(new Paragraph("Total Passed: " + context.getPassedTests().size()));
        document.add(new Paragraph("Total Failed: " + context.getFailedTests().size()));
        document.add(new Paragraph("Total Skipped: " + context.getSkippedTests().size()));
     //  document.add(new Paragraph("Get Host: " + context.getStartDate()));
      // document.add(new Paragraph("Test Suite Name: " + context.getEndDate()));


        // Add details of passed tests
        document.add(new Paragraph("\nPassed Test Cases:"));
        for (ITestResult result : context.getPassedTests().getAllResults()) {
            document.add(new Paragraph(result.getName() + " - Passed"));
        }

        // Add details of failed tests
        document.add(new Paragraph("\nFailed Test Cases:"));
        for (ITestResult result : context.getFailedTests().getAllResults()) {
            document.add(new Paragraph(result.getName() + " - Failed: " + result.getThrowable().getMessage()));
        }

        // Add details of skipped tests
        document.add(new Paragraph("\nSkipped Test Cases:"));
        for (ITestResult result : context.getSkippedTests().getAllResults()) {
            document.add(new Paragraph(result.getName() + " - Skipped"+result.getThrowable().getMessage()));

            document.add(new Paragraph("Execution End Time: " + context.getEndDate()));

        }

        // Close the document
        document.close();
    }
}













/*
package utilities;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.testng.ITestResult;

import java.io.FileOutputStream;
import java.util.List;

public class PDFReportGenerator {
    private Document document;
    private String fileName;

    public PDFReportGenerator(String fileName) {
        this.fileName = fileName;
        this.document = new Document();
    }

    public void createPDF(List<ITestResult> testResults) {
        try {
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();
            addContent(testResults);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addContent(List<ITestResult> testResults) throws DocumentException {
        Paragraph title = new Paragraph("Test Execution Report", FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD));
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        document.add(Chunk.NEWLINE);

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.addCell("Test Name");
        table.addCell("Status");
        table.addCell("Duration (ms)");
        table.addCell("Exception");

        for (ITestResult result : testResults) {
            table.addCell(result.getName());
            table.addCell(getStatus(result.getStatus()));
            table.addCell(String.valueOf(result.getEndMillis() - result.getStartMillis()));
            table.addCell(result.getThrowable() != null ? result.getThrowable().getMessage() : "");
        }

        document.add(table);
    }

    private String getStatus(int status) {
        switch (status) {
            case ITestResult.SUCCESS:
                return "PASS";
            case ITestResult.FAILURE:
                return "FAIL";
            case ITestResult.SKIP:
                return "SKIP";
            default:
                return "UNDEFINED";
        }
    }
}

*/































