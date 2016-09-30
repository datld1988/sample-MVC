/**
 * CheckCardOrderResponseData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.model.transaction;

import com.vtc.ws.v2.model.ResponseData;

public class CheckCardOrderResponseData  extends ResponseData  implements java.io.Serializable {
    private java.lang.String accountName;

    private java.lang.Integer cardValue;

    private java.util.Calendar dateUse;

    public CheckCardOrderResponseData() {
    }

    public CheckCardOrderResponseData(
           java.lang.String description,
           java.lang.String extend,
           java.lang.Integer responseCode,
           java.lang.String accountName,
           java.lang.Integer cardValue,
           java.util.Calendar dateUse) {
        super(
            description,
            extend,
            responseCode);
        this.accountName = accountName;
        this.cardValue = cardValue;
        this.dateUse = dateUse;
    }


    /**
     * Gets the accountName value for this CheckCardOrderResponseData.
     * 
     * @return accountName
     */
    public java.lang.String getAccountName() {
        return accountName;
    }


    /**
     * Sets the accountName value for this CheckCardOrderResponseData.
     * 
     * @param accountName
     */
    public void setAccountName(java.lang.String accountName) {
        this.accountName = accountName;
    }


    /**
     * Gets the cardValue value for this CheckCardOrderResponseData.
     * 
     * @return cardValue
     */
    public java.lang.Integer getCardValue() {
        return cardValue;
    }


    /**
     * Sets the cardValue value for this CheckCardOrderResponseData.
     * 
     * @param cardValue
     */
    public void setCardValue(java.lang.Integer cardValue) {
        this.cardValue = cardValue;
    }


    /**
     * Gets the dateUse value for this CheckCardOrderResponseData.
     * 
     * @return dateUse
     */
    public java.util.Calendar getDateUse() {
        return dateUse;
    }


    /**
     * Sets the dateUse value for this CheckCardOrderResponseData.
     * 
     * @param dateUse
     */
    public void setDateUse(java.util.Calendar dateUse) {
        this.dateUse = dateUse;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CheckCardOrderResponseData)) return false;
        CheckCardOrderResponseData other = (CheckCardOrderResponseData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.accountName==null && other.getAccountName()==null) || 
             (this.accountName!=null &&
              this.accountName.equals(other.getAccountName()))) &&
            ((this.cardValue==null && other.getCardValue()==null) || 
             (this.cardValue!=null &&
              this.cardValue.equals(other.getCardValue()))) &&
            ((this.dateUse==null && other.getDateUse()==null) || 
             (this.dateUse!=null &&
              this.dateUse.equals(other.getDateUse())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getAccountName() != null) {
            _hashCode += getAccountName().hashCode();
        }
        if (getCardValue() != null) {
            _hashCode += getCardValue().hashCode();
        }
        if (getDateUse() != null) {
            _hashCode += getDateUse().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CheckCardOrderResponseData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "CheckCardOrderResponseData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "AccountName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "CardValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateUse");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "DateUse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
