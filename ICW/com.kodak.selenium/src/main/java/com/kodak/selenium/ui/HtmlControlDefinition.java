package com.kodak.selenium.ui;

import org.openqa.selenium.By;

import com.kodak.selenium.ui.Exceptions.ObjectDefinitionError;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Element;

public class HtmlControlDefinition {

	private Logger _Logger = Logger.getLogger(HtmlControlDefinition.class.getSimpleName());
	private String _byType;
	private String _byValue;
	private String _id;
	private String _type;

	private By _by = null;
	protected Map<String, HtmlControlDefinition> _subDefinitions = new HashMap<String, HtmlControlDefinition>();
	protected Map<String, String> _attributes = new HashMap<String, String>();

	public String attribute(String name){
		return this._attributes.get(name);
	}
	
	public HtmlControlDefinition child(String name){
		return this._subDefinitions.get(name);
	}
	
	public HtmlControlDefinition(Element elem) {
		_type = elem.attributeValue("type");
		String byString = elem.attributeValue("by");
		_id = elem.getName();
		if (byString == null) {
			_by = new By.ById(elem.getName());

		} else {
			int firstEqu = byString.indexOf("=");
			_byType = byString.substring(0, firstEqu);
			_byValue = byString.substring(firstEqu + 1);
		}

		for (Object attrObj : elem.attributes()) {
			Attribute attr = (Attribute) attrObj;
			_attributes.put(attr.getName(), attr.getValue());
		}

		for (Object c : elem.elements()) {
			Element e= (Element) c;
			_subDefinitions.put(e.getName(), new HtmlControlDefinition(e));
		}
	}

	public HtmlControlDefinition setParam(String param) {
		_byValue = String.format(_byValue, param);
		return this;
	}

	public By getBy() throws ObjectDefinitionError {
		if (_by == null) {
			if (_byValue.contains("%s")) {
				throw new Exceptions.ObjectDefinitionError(_id, _byType, _byValue);
			}
			try {
				Method method = By.class.getMethod(_byType, String.class);
				_by = (By) method.invoke(null, _byValue);
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
				Exceptions.ObjectDefinitionError err = new Exceptions.ObjectDefinitionError(_id, _byType, _byValue);
				this._Logger.error(err.getMessage(), e);
				throw err;
			}
		}
		return _by;
	}

	public String getType() {
		return _type;
	}

	@Override
	public String toString() {
		return String.format("id:%s, byType:%s, byValue:%s", _id, _byType, _byValue) + _type == null ? ""
				: ",type=" + _type;
	}

}
