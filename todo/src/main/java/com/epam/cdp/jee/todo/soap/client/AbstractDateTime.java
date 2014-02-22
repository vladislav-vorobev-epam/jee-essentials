
package com.epam.cdp.jee.todo.soap.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for abstractDateTime complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="abstractDateTime">
 *   &lt;complexContent>
 *     &lt;extension base="{http://soap.todo.jee.cdp.epam.com/}abstractInstant">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "abstractDateTime")
@XmlSeeAlso({
    BaseDateTime.class
})
public abstract class AbstractDateTime
    extends AbstractInstant
{


}
