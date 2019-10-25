package com.example;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;

import java.io.*;


public class Converter {

    private static void pdfConverter() {
        File htmlSource = new File("src/main/resources/certificate/index.html");
        File pdfDest = new File("output.pdf");
        try { ConverterProperties converterProperties = new ConverterProperties();
            DefaultFontProvider defaultFontProvider = new DefaultFontProvider(false, true, true);
            defaultFontProvider.addDirectory("src/main/resources/fonts");
            converterProperties.setFontProvider(defaultFontProvider);
            HtmlConverter.convertToPdf(htmlSource, pdfDest, converterProperties);
        } catch (IOException e) {
        }
    }


    public static void main(String[] args) {
        pdfConverter();
    }
}