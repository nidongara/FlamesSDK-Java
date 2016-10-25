package com.nidongara.flamessdk;

import com.nidongara.flamessdk.annotations.ExternalName;
import com.nidongara.flamessdk.annotations.SoapObject;
import com.nidongara.flamessdk.internal.SubscriberList;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;

import com.nidongara.flamessdk.internal.List;


/**
 * 
 * This class takes care of the association between subscriber and the subscription list. 
 * You need to use this class to modify users in a specific list
 * @author amagar
 *
 */
@SoapObject(internalType = SubscriberList.class)
public class ETSubscriberList extends ETSoapObject{
	
	@ExternalName("status")
    protected ETSubscriber.Status status = null;
	@ExternalName("list")
	//@InternalName("list")
    protected ETList list = null;
	@ExternalName("action")
    protected String action = null;
	@ExternalName("subscriber")
    protected ETSubscriber subscriber = null;
	@ExternalName("ID")
    protected String id = null;
	
	 /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberStatus }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberStatus }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberStatus }
     *     
     */
    public ETSubscriber.Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberStatus }
     *     
     */
    public void setStatus(ETSubscriber.Status value) {
        this.status = value;
    }

    /**
     * Gets the value of the list property.
     * 
     * @return
     *     possible object is
     *     {@link List }
     *     
     */
    public ETList getList() {
        return list;
    }

    /**
     * Sets the value of the list property.
     * 
     * @param value
     *     allowed object is
     *     {@link List }
     *     
     */
    public void setList(ETList value) {
        this.list = value;
    }

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAction(String value) {
        this.action = value;
    }

    /**
     * Gets the value of the subscriber property.
     * 
     * @return
     *     possible object is
     *     {@link Subscriber }
     *     
     */
    public ETSubscriber getSubscriber() {
        return subscriber;
    }

    /**
     * Sets the value of the subscriber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Subscriber }
     *     
     */
    public void setSubscriber(ETSubscriber value) {
        this.subscriber = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
