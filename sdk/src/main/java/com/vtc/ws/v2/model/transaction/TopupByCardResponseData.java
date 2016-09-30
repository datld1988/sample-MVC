/**
 * TopupByCardResponseData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.model.transaction;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.vtc.ws.v2.model.ResponseData;

public class TopupByCardResponseData  extends ResponseData  implements java.io.Serializable {
    private java.lang.Integer accountID;

    private java.lang.String accountName;

    private java.lang.Integer balance;

    private java.lang.Integer cardAmount;

    private java.lang.Long transactionID;

    private java.lang.Integer vcoinTopup;

    public TopupByCardResponseData() {
    }

    public TopupByCardResponseData(
           java.lang.String description,
           java.lang.String extend,
           java.lang.Integer responseCode,
           java.lang.Integer accountID,
           java.lang.String accountName,
           java.lang.Integer balance,
           java.lang.Integer cardAmount,
           java.lang.Long transactionID,
           java.lang.Integer vcoinTopup) {
        super(
            description,
            extend,
            responseCode);
        this.accountID = accountID;
        this.accountName = accountName;
        this.balance = balance;
        this.cardAmount = cardAmount;
        this.transactionID = transactionID;
        this.vcoinTopup = vcoinTopup;
    }


    /**
     * Gets the accountID value for this TopupByCardResponseData.
     * 
     * @return accountID
     */
    public java.lang.Integer getAccountID() {
        return accountID;
    }


    /**
     * Sets the accountID value for this TopupByCardResponseData.
     * 
     * @param accountID
     */
    public void setAccountID(java.lang.Integer accountID) {
        this.accountID = accountID;
    }


    /**
     * Gets the accountName value for this TopupByCardResponseData.
     * 
     * @return accountName
     */
    public java.lang.String getAccountName() {
        return accountName;
    }


    /**
     * Sets the accountName value for this TopupByCardResponseData.
     * 
     * @param accountName
     */
    public void setAccountName(java.lang.String accountName) {
        this.accountName = accountName;
    }


    /**
     * Gets the balance value for this TopupByCardResponseData.
     * 
     * @return balance
     */
    public java.lang.Integer getBalance() {
        return balance;
    }


    /**
     * Sets the balance value for this TopupByCardResponseData.
     * 
     * @param balance
     */
    public void setBalance(java.lang.Integer balance) {
        this.balance = balance;
    }


    /**
     * Gets the cardAmount value for this TopupByCardResponseData.
     * 
     * @return cardAmount
     */
    public java.lang.Integer getCardAmount() {
        return cardAmount;
    }


    /**
     * Sets the cardAmount value for this TopupByCardResponseData.
     * 
     * @param cardAmount
     */
    public void setCardAmount(java.lang.Integer cardAmount) {
        this.cardAmount = cardAmount;
    }


    /**
     * Gets the transactionID value for this TopupByCardResponseData.
     * 
     * @return transactionID
     */
    public java.lang.Long getTransactionID() {
        return transactionID;
    }


    /**
     * Sets the transactionID value for this TopupByCardResponseData.
     * 
     * @param transactionID
     */
    public void setTransactionID(java.lang.Long transactionID) {
        this.transactionID = transactionID;
    }


    /**
     * Gets the vcoinTopup value for this TopupByCardResponseData.
     * 
     * @return vcoinTopup
     */
    public java.lang.Integer getVcoinTopup() {
        return vcoinTopup;
    }


    /**
     * Sets the vcoinTopup value for this TopupByCardResponseData.
     * 
     * @param vcoinTopup
     */
    public void setVcoinTopup(java.lang.Integer vcoinTopup) {
        this.vcoinTopup = vcoinTopup;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TopupByCardResponseData)) return false;
        TopupByCardResponseData other = (TopupByCardResponseData) obj;
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
            ((this.cardAmount==null && other.getCardAmount()==null) || 
             (this.cardAmount!=null &&
              this.cardAmount.equals(other.getCardAmount()))) &&
            ((this.transactionID==null && other.getTransactionID()==null) || 
             (this.transactionID!=null &&
              this.transactionID.equals(other.getTransactionID()))) &&
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
        if (getCardAmount() != null) {
            _hashCode += getCardAmount().hashCode();
        }
        if (getTransactionID() != null) {
            _hashCode += getTransactionID().hashCode();
        }
        if (getVcoinTopup() != null) {
            _hashCode += getVcoinTopup().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TopupByCardResponseData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "TopupByCardResponseData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "AccountID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "AccountName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("balance");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "Balance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "CardAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "TransactionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vcoinTopup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "VcoinTopup"));
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

    public String toString() {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			return ow.writeValueAsString(this);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
