/**
 * BalanceResponseData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.model.info;

import com.vtc.ws.v2.model.ResponseData;

public class BalanceResponseData  extends ResponseData  implements java.io.Serializable {
    private java.lang.Integer accountID;

    private java.lang.String accountName;

    private java.lang.Integer vcoin;

    private java.lang.Integer vcoinFreeze;

    private java.lang.Integer vcoinGame;

    public BalanceResponseData() {
    }

    public BalanceResponseData(
           java.lang.String description,
           java.lang.String extend,
           java.lang.Integer responseCode,
           java.lang.Integer accountID,
           java.lang.String accountName,
           java.lang.Integer vcoin,
           java.lang.Integer vcoinFreeze,
           java.lang.Integer vcoinGame) {
        super(
            description,
            extend,
            responseCode);
        this.accountID = accountID;
        this.accountName = accountName;
        this.vcoin = vcoin;
        this.vcoinFreeze = vcoinFreeze;
        this.vcoinGame = vcoinGame;
    }


    /**
     * Gets the accountID value for this BalanceResponseData.
     * 
     * @return accountID
     */
    public java.lang.Integer getAccountID() {
        return accountID;
    }


    /**
     * Sets the accountID value for this BalanceResponseData.
     * 
     * @param accountID
     */
    public void setAccountID(java.lang.Integer accountID) {
        this.accountID = accountID;
    }


    /**
     * Gets the accountName value for this BalanceResponseData.
     * 
     * @return accountName
     */
    public java.lang.String getAccountName() {
        return accountName;
    }


    /**
     * Sets the accountName value for this BalanceResponseData.
     * 
     * @param accountName
     */
    public void setAccountName(java.lang.String accountName) {
        this.accountName = accountName;
    }


    /**
     * Gets the vcoin value for this BalanceResponseData.
     * 
     * @return vcoin
     */
    public java.lang.Integer getVcoin() {
        return vcoin;
    }


    /**
     * Sets the vcoin value for this BalanceResponseData.
     * 
     * @param vcoin
     */
    public void setVcoin(java.lang.Integer vcoin) {
        this.vcoin = vcoin;
    }


    /**
     * Gets the vcoinFreeze value for this BalanceResponseData.
     * 
     * @return vcoinFreeze
     */
    public java.lang.Integer getVcoinFreeze() {
        return vcoinFreeze;
    }


    /**
     * Sets the vcoinFreeze value for this BalanceResponseData.
     * 
     * @param vcoinFreeze
     */
    public void setVcoinFreeze(java.lang.Integer vcoinFreeze) {
        this.vcoinFreeze = vcoinFreeze;
    }


    /**
     * Gets the vcoinGame value for this BalanceResponseData.
     * 
     * @return vcoinGame
     */
    public java.lang.Integer getVcoinGame() {
        return vcoinGame;
    }


    /**
     * Sets the vcoinGame value for this BalanceResponseData.
     * 
     * @param vcoinGame
     */
    public void setVcoinGame(java.lang.Integer vcoinGame) {
        this.vcoinGame = vcoinGame;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BalanceResponseData)) return false;
        BalanceResponseData other = (BalanceResponseData) obj;
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
            ((this.vcoin==null && other.getVcoin()==null) || 
             (this.vcoin!=null &&
              this.vcoin.equals(other.getVcoin()))) &&
            ((this.vcoinFreeze==null && other.getVcoinFreeze()==null) || 
             (this.vcoinFreeze!=null &&
              this.vcoinFreeze.equals(other.getVcoinFreeze()))) &&
            ((this.vcoinGame==null && other.getVcoinGame()==null) || 
             (this.vcoinGame!=null &&
              this.vcoinGame.equals(other.getVcoinGame())));
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
        if (getVcoin() != null) {
            _hashCode += getVcoin().hashCode();
        }
        if (getVcoinFreeze() != null) {
            _hashCode += getVcoinFreeze().hashCode();
        }
        if (getVcoinGame() != null) {
            _hashCode += getVcoinGame().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BalanceResponseData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "BalanceResponseData"));
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
        elemField.setFieldName("vcoin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "Vcoin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vcoinFreeze");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "VcoinFreeze"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vcoinGame");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "VcoinGame"));
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
