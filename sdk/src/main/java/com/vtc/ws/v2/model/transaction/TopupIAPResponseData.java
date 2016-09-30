/**
 * TopupIAPResponseData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.model.transaction;

import com.vtc.ws.v2.model.ResponseData;

public class TopupIAPResponseData  extends ResponseData  implements java.io.Serializable {
    private java.lang.Integer accountID;

    private java.lang.String accountName;

    private java.lang.Integer balance;

    private java.lang.Long deductTransactionID;

    private java.lang.Long topupTransactionID;

    private java.lang.Integer vcoinTopup;

    public TopupIAPResponseData() {
    }

    public TopupIAPResponseData(
           java.lang.String description,
           java.lang.String extend,
           java.lang.Integer responseCode,
           java.lang.Integer accountID,
           java.lang.String accountName,
           java.lang.Integer balance,
           java.lang.Long deductTransactionID,
           java.lang.Long topupTransactionID,
           java.lang.Integer vcoinTopup) {
        super(
            description,
            extend,
            responseCode);
        this.accountID = accountID;
        this.accountName = accountName;
        this.balance = balance;
        this.deductTransactionID = deductTransactionID;
        this.topupTransactionID = topupTransactionID;
        this.vcoinTopup = vcoinTopup;
    }


    /**
     * Gets the accountID value for this TopupIAPResponseData.
     * 
     * @return accountID
     */
    public java.lang.Integer getAccountID() {
        return accountID;
    }


    /**
     * Sets the accountID value for this TopupIAPResponseData.
     * 
     * @param accountID
     */
    public void setAccountID(java.lang.Integer accountID) {
        this.accountID = accountID;
    }


    /**
     * Gets the accountName value for this TopupIAPResponseData.
     * 
     * @return accountName
     */
    public java.lang.String getAccountName() {
        return accountName;
    }


    /**
     * Sets the accountName value for this TopupIAPResponseData.
     * 
     * @param accountName
     */
    public void setAccountName(java.lang.String accountName) {
        this.accountName = accountName;
    }


    /**
     * Gets the balance value for this TopupIAPResponseData.
     * 
     * @return balance
     */
    public java.lang.Integer getBalance() {
        return balance;
    }


    /**
     * Sets the balance value for this TopupIAPResponseData.
     * 
     * @param balance
     */
    public void setBalance(java.lang.Integer balance) {
        this.balance = balance;
    }


    /**
     * Gets the deductTransactionID value for this TopupIAPResponseData.
     * 
     * @return deductTransactionID
     */
    public java.lang.Long getDeductTransactionID() {
        return deductTransactionID;
    }


    /**
     * Sets the deductTransactionID value for this TopupIAPResponseData.
     * 
     * @param deductTransactionID
     */
    public void setDeductTransactionID(java.lang.Long deductTransactionID) {
        this.deductTransactionID = deductTransactionID;
    }


    /**
     * Gets the topupTransactionID value for this TopupIAPResponseData.
     * 
     * @return topupTransactionID
     */
    public java.lang.Long getTopupTransactionID() {
        return topupTransactionID;
    }


    /**
     * Sets the topupTransactionID value for this TopupIAPResponseData.
     * 
     * @param topupTransactionID
     */
    public void setTopupTransactionID(java.lang.Long topupTransactionID) {
        this.topupTransactionID = topupTransactionID;
    }


    /**
     * Gets the vcoinTopup value for this TopupIAPResponseData.
     * 
     * @return vcoinTopup
     */
    public java.lang.Integer getVcoinTopup() {
        return vcoinTopup;
    }


    /**
     * Sets the vcoinTopup value for this TopupIAPResponseData.
     * 
     * @param vcoinTopup
     */
    public void setVcoinTopup(java.lang.Integer vcoinTopup) {
        this.vcoinTopup = vcoinTopup;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TopupIAPResponseData)) return false;
        TopupIAPResponseData other = (TopupIAPResponseData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.accountID==null && other.getAccountID()==null) || 
             (this.accountID!=null &&
              this.accountID.equals(other.getAccountID()))) &&
            ((this.accountName==null && other.getAccountName()==null) || 
             (this.accountName!=null &&
              this.accountName.equals(other.getAccountName()))) &&
            ((this.balance==null && other.getBalance()==null) || 
             (this.balance!=null &&
              this.balance.equals(other.getBalance()))) &&
            ((this.deductTransactionID==null && other.getDeductTransactionID()==null) || 
             (this.deductTransactionID!=null &&
              this.deductTransactionID.equals(other.getDeductTransactionID()))) &&
            ((this.topupTransactionID==null && other.getTopupTransactionID()==null) || 
             (this.topupTransactionID!=null &&
              this.topupTransactionID.equals(other.getTopupTransactionID()))) &&
            ((this.vcoinTopup==null && other.getVcoinTopup()==null) || 
             (this.vcoinTopup!=null &&
              this.vcoinTopup.equals(other.getVcoinTopup())));
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
        if (getAccountID() != null) {
            _hashCode += getAccountID().hashCode();
        }
        if (getAccountName() != null) {
            _hashCode += getAccountName().hashCode();
        }
        if (getBalance() != null) {
            _hashCode += getBalance().hashCode();
        }
        if (getDeductTransactionID() != null) {
            _hashCode += getDeductTransactionID().hashCode();
        }
        if (getTopupTransactionID() != null) {
            _hashCode += getTopupTransactionID().hashCode();
        }
        if (getVcoinTopup() != null) {
            _hashCode += getVcoinTopup().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TopupIAPResponseData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.GameService.Models", "TopupIAPResponseData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.GameService.Models", "AccountID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.GameService.Models", "AccountName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("balance");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.GameService.Models", "Balance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deductTransactionID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.GameService.Models", "DeductTransactionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("topupTransactionID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.GameService.Models", "TopupTransactionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vcoinTopup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.GameService.Models", "VcoinTopup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
