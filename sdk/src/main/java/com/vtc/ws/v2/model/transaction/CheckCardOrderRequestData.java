/**
 * CheckCardOrderRequestData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.model.transaction;

import com.vtc.ws.v2.model.RequestData;

public class CheckCardOrderRequestData  extends RequestData  implements java.io.Serializable {
    private java.lang.String cardCode;

    private java.lang.String cardSeri;

    private java.lang.Integer cardType;

    private java.lang.Integer createdUserID;

    private java.lang.String createdUserName;

    private java.lang.Long orderID;

    public CheckCardOrderRequestData() {
    }

    public CheckCardOrderRequestData(
           java.lang.String sign,
           java.lang.String cardCode,
           java.lang.String cardSeri,
           java.lang.Integer cardType,
           java.lang.Integer createdUserID,
           java.lang.String createdUserName,
           java.lang.Long orderID) {
        super(
            sign);
        this.cardCode = cardCode;
        this.cardSeri = cardSeri;
        this.cardType = cardType;
        this.createdUserID = createdUserID;
        this.createdUserName = createdUserName;
        this.orderID = orderID;
    }


    /**
     * Gets the cardCode value for this CheckCardOrderRequestData.
     * 
     * @return cardCode
     */
    public java.lang.String getCardCode() {
        return cardCode;
    }


    /**
     * Sets the cardCode value for this CheckCardOrderRequestData.
     * 
     * @param cardCode
     */
    public void setCardCode(java.lang.String cardCode) {
        this.cardCode = cardCode;
    }


    /**
     * Gets the cardSeri value for this CheckCardOrderRequestData.
     * 
     * @return cardSeri
     */
    public java.lang.String getCardSeri() {
        return cardSeri;
    }


    /**
     * Sets the cardSeri value for this CheckCardOrderRequestData.
     * 
     * @param cardSeri
     */
    public void setCardSeri(java.lang.String cardSeri) {
        this.cardSeri = cardSeri;
    }


    /**
     * Gets the cardType value for this CheckCardOrderRequestData.
     * 
     * @return cardType
     */
    public java.lang.Integer getCardType() {
        return cardType;
    }


    /**
     * Sets the cardType value for this CheckCardOrderRequestData.
     * 
     * @param cardType
     */
    public void setCardType(java.lang.Integer cardType) {
        this.cardType = cardType;
    }


    /**
     * Gets the createdUserID value for this CheckCardOrderRequestData.
     * 
     * @return createdUserID
     */
    public java.lang.Integer getCreatedUserID() {
        return createdUserID;
    }


    /**
     * Sets the createdUserID value for this CheckCardOrderRequestData.
     * 
     * @param createdUserID
     */
    public void setCreatedUserID(java.lang.Integer createdUserID) {
        this.createdUserID = createdUserID;
    }


    /**
     * Gets the createdUserName value for this CheckCardOrderRequestData.
     * 
     * @return createdUserName
     */
    public java.lang.String getCreatedUserName() {
        return createdUserName;
    }


    /**
     * Sets the createdUserName value for this CheckCardOrderRequestData.
     * 
     * @param createdUserName
     */
    public void setCreatedUserName(java.lang.String createdUserName) {
        this.createdUserName = createdUserName;
    }


    /**
     * Gets the orderID value for this CheckCardOrderRequestData.
     * 
     * @return orderID
     */
    public java.lang.Long getOrderID() {
        return orderID;
    }


    /**
     * Sets the orderID value for this CheckCardOrderRequestData.
     * 
     * @param orderID
     */
    public void setOrderID(java.lang.Long orderID) {
        this.orderID = orderID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CheckCardOrderRequestData)) return false;
        CheckCardOrderRequestData other = (CheckCardOrderRequestData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cardCode==null && other.getCardCode()==null) || 
             (this.cardCode!=null &&
              this.cardCode.equals(other.getCardCode()))) &&
            ((this.cardSeri==null && other.getCardSeri()==null) || 
             (this.cardSeri!=null &&
              this.cardSeri.equals(other.getCardSeri()))) &&
            ((this.cardType==null && other.getCardType()==null) || 
             (this.cardType!=null &&
              this.cardType.equals(other.getCardType()))) &&
            ((this.createdUserID==null && other.getCreatedUserID()==null) || 
             (this.createdUserID!=null &&
              this.createdUserID.equals(other.getCreatedUserID()))) &&
            ((this.createdUserName==null && other.getCreatedUserName()==null) || 
             (this.createdUserName!=null &&
              this.createdUserName.equals(other.getCreatedUserName()))) &&
            ((this.orderID==null && other.getOrderID()==null) || 
             (this.orderID!=null &&
              this.orderID.equals(other.getOrderID())));
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
        if (getCardCode() != null) {
            _hashCode += getCardCode().hashCode();
        }
        if (getCardSeri() != null) {
            _hashCode += getCardSeri().hashCode();
        }
        if (getCardType() != null) {
            _hashCode += getCardType().hashCode();
        }
        if (getCreatedUserID() != null) {
            _hashCode += getCreatedUserID().hashCode();
        }
        if (getCreatedUserName() != null) {
            _hashCode += getCreatedUserName().hashCode();
        }
        if (getOrderID() != null) {
            _hashCode += getOrderID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CheckCardOrderRequestData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "CheckCardOrderRequestData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "CardCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardSeri");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "CardSeri"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "CardType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createdUserID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "CreatedUserID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createdUserName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "CreatedUserName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "OrderID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
