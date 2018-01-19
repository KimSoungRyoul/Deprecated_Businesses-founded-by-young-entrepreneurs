package com.server.pdf;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chapter;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class BookPdfView2 extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String fileName = createFileName();
        setFileNameToResponse(request, response, fileName);

        Chapter chapter = new Chapter(new Paragraph("this is english"), 1);
        chapter.add(new Paragraph("이건 메세지입니다."));
        document.add(chapter);
    }

    private void setFileNameToResponse(HttpServletRequest request, HttpServletResponse response, String fileName) {
        String userAgent = request.getHeader("User-Agent");
        if (userAgent.indexOf("MSIE 5.5") >= 0) {
            response.setContentType("doesn/matter");
            response.setHeader("Content-Disposition", "filename=\"" + fileName + "\"");
        } else {
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        }
    }

    private String createFileName() {
        SimpleDateFormat fileFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return new StringBuilder("설문조사").append("-").append(fileFormat.format(new Date())).append(".pdf").toString();
    }
}