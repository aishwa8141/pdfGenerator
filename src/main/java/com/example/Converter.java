package com.example;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.licensekey.LicenseKey;


import java.io.File;
import java.io.IOException;


public class Converter {

    private static void pdfConverter() {
        LicenseKey.loadLicenseFile("src/main/resources/itextkey1574056292536_0.xml");
        File htmlSource = new File("src/main/resources/certificate/language.html");
        File pdfDest = new File("output.pdf");
        try {
            ConverterProperties converterProperties = new ConverterProperties();
            DefaultFontProvider defaultFontProvider = new DefaultFontProvider(true, false, false);
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