package com.kodak.selenium.ui;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.kodak.selenium.ui.Exceptions.ObjectNotDefinedException;

public class ObjectRepository {

	private static Document _document;

	public static Element getDocumentRoot() {
		return _document.getRootElement();
	}

	public static void init(String repoFile) throws DocumentException {
		SAXReader reader = new SAXReader();
		_document = reader.read(new File(repoFile));
	}
	
	public static HtmlControlDefinition getDefinition(String id) throws ObjectNotDefinedException {
		String xpath = String.format("//%s", id);
		Element elem = (Element) ObjectRepository.getDocumentRoot().selectSingleNode(xpath);
		if(elem == null){
			throw new Exceptions.ObjectNotDefinedException(id);
		}
		return  new HtmlControlDefinition(elem);
	}	
}
