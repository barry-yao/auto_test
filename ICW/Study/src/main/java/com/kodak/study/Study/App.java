package com.kodak.study.Study;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.xmlbeans.XmlException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception, Exception, IOException
    {
    	DocxUtil dUtil = new DocxUtil();
    	dUtil.read("D:\\docs\\refer.docx");
        System.out.println( "Hello World!!!!!!" );
    }
}
