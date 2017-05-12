package com.kodak.study.Study;

import java.io.IOException;

import org.apache.poi.POITextExtractor;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFComment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.xmlbeans.XmlException;

public class DocxUtil {

	public DocxUtil() {
		// TODO Auto-generated constructor stub
	}

	public void read(String filePath) throws XmlException, OpenXML4JException, IOException{
		org.apache.poi.xwpf.extractor.XWPFWordExtractor docx = new XWPFWordExtractor(POIXMLDocument.openPackage(filePath)); 
		//提取.docx正文文本 
		String text = docx.getText();
		System.out.println(text);
		//提取.docx批注 
//		org.apache.poi.xwpf.usermodel.XWPFComment[] comments = docx.getDocument()).getComments(); 
//		for(XWPFComment comment:comments){ 
//		comment.getId();//提取批注Id 
//		comment.getAuthor();//提取批注修改人 
//		comment.getText();//提取批注内容 
	}
}
