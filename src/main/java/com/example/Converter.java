package com.example;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.attach.ITagWorker;
import com.itextpdf.html2pdf.attach.ITagWorkerFactory;
import com.itextpdf.html2pdf.attach.ProcessorContext;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.WriterProperties;
import com.itextpdf.kernel.utils.PdfMerger;
import com.itextpdf.styledxmlparser.node.IElementNode;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import java.io.*;


public class Converter {



    public static void pdfConverter() {
        File htmlSource = new File("src/main/resources/certificate/index.html");
        File pdfDest = new File("output.pdf");
        File method1 = new File("method1.pdf");
        File method2= new File("method2.pdf");

        try {
            ConverterProperties converterProperties = new ConverterProperties();
            PdfWriter pdfWriter = new PdfWriter(method1);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            pdfDocument.setDefaultPageSize(PageSize.A4.rotate());
            System.out.println(pdfDocument.getDefaultPageSize());


            HtmlConverter.convertToPdf(new FileInputStream(htmlSource),
                    pdfDocument, converterProperties);


            HtmlConverter.convertToPdf(htmlSource, pdfDest);

            HtmlConverter.convertToPdf(htmlSource, method2, converterProperties );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void convert() {
        File htmlSource = new File("/Users/aishwarya/workspace/pdf/src/main/resources/certificate_pdf/index.html");

        //Initialize
        File pdfDest = new File("output.pdf");
        ConverterProperties vProperties = new ConverterProperties();

        //Adding the fonts

        try {
            PdfWriter vWriter = new PdfWriter(new FileOutputStream(pdfDest), new WriterProperties().setCompressionLevel(9));
            PdfDocument vPDF = new PdfDocument(vWriter);
            PdfMerger vMerger = new PdfMerger(vPDF);
            //Convert to PDF
            ByteArrayOutputStream vArrByteAOS = new ByteArrayOutputStream();
            PdfDocument vDoc = new PdfDocument(new PdfWriter(vArrByteAOS, new WriterProperties().setCompressionLevel(9)));
            vDoc.setDefaultPageSize(new PageSize(900, 1080));

            HtmlConverter.convertToPdf(new FileInputStream(htmlSource), vDoc, vProperties);
            vDoc = new PdfDocument(new PdfReader(new ByteArrayInputStream(vArrByteAOS.toByteArray())));
            vMerger.merge(vDoc, 1, vDoc.getNumberOfPages());
            vDoc.close();

            vPDF.close();
        } catch (IOException e) {

        }


    }



    public static void main(String[] args) {

        pdfConverter();
//        addImage();
    }

}
