/*
 * ============================================================================
 * GNU Lesser General Public License
 * ============================================================================
 *
 * JasperReports - Free Java report-generating library.
 * Copyright (C) 2001-2009 JasperSoft Corporation http://www.jaspersoft.com
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 * 
 * JasperSoft Corporation
 * 539 Bryant Street, Suite 100
 * San Francisco, CA 94107
 * http://www.jaspersoft.com
 */
package net.sf.jasperreports.engine.xml;

import net.sf.jasperreports.engine.design.JRDesignParameter;

import org.xml.sax.Attributes;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id$
 */
public class JRParameterFactory extends JRBaseFactory
{
	/**
	 *
	 */
	public Object createObject(Attributes atts)
	{
		JRDesignParameter parameter = new JRDesignParameter();
		
		setParameterAttributes(parameter, atts);

		return parameter;
	}


	protected void setParameterAttributes(JRDesignParameter parameter, Attributes atts)
	{
		parameter.setName(atts.getValue(JRXmlConstants.ATTRIBUTE_name));
		
		if (atts.getValue(JRXmlConstants.ATTRIBUTE_class) != null)
		{
			parameter.setValueClassName(atts.getValue(JRXmlConstants.ATTRIBUTE_class));
		}
		
		String nestedType = atts.getValue(JRXmlConstants.ATTRIBUTE_nestedType);
		if (nestedType != null)
		{
			parameter.setNestedTypeName(nestedType);
		}

		String isForPrompting = atts.getValue(JRXmlConstants.ATTRIBUTE_isForPrompting);
		if (isForPrompting != null && isForPrompting.length() > 0)
		{
			parameter.setForPrompting(Boolean.valueOf(isForPrompting).booleanValue());
		}
	}
	

}
