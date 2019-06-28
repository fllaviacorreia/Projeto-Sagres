//package modelo;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import  com.itextpdf.text.Document ;
//import  com.itextpdf.text.DocumentException ;
//import  com.itextpdf.text.Paragraph ;
//import  com.itextpdf.text.pdf.PdfWriter ;
//
//import  java.awt. * ;
//import  java.io.File ;
//import  java.io.FileNotFoundException ;
//import  java.io.FileOutputStream ;
//import  java.io.IOException ;
//
//public class Relatorios {
//
//	public Relatorios() {
//		 Document document = new Document();
//         try {
//             
//             PdfWriter.getInstance(document, new FileOutputStream("C:\\PDF_DevMedia.pdf"));
//             document.open();
//             
//             // adicionando um parágrafo no documento
//             document.add(new Paragraph("Gerando PDF - Java"));
//   }
//         catch(DocumentException de) {
//             System.err.println(de.getMessage());
//         }
//         catch(IOException ioe) {
//             System.err.println(ioe.getMessage());
//         }
//         document.close();
//	}
//
//}
