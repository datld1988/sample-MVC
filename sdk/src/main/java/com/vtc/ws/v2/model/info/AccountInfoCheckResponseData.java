/**
 * AccountInfoCheckResponseData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.model.info;

import com.vtc.ws.v2.model.ResponseData;

public class AccountInfoCheckResponseData  extends ResponseData  implements java.io.Serializable {
    private java.lang.Integer accountID;

    private java.lang.String accountName;

    private java.lang.Boolean isEmail;

    private java.lang.Boolean isMobile;

    private java.lang.Boolean isPassport;

    private java.lang.Boolean isQuestion;

    public AccountInfoCheckResponseData() {
    }

    public AccountInfoCheckResponseData(
           java.lang.String description,
           java.lang.String extend,
           java.lang.Integer responseCode,
           java.lang.Integer accountID,
           java.lang.String accountName,
           java.lang.Boolean isEmail,
           java.lang.Boolean isMobile,
           java.lang.Boolean isPassport,
           java.lang.Boolean isQuestion) {
        super(
            description,
            extend,
            responseCode);
        this.accountID = accountID;
        this.accountName = accountName;
        this.isEmail = isEmail;
        this.isMobile = isMobile;
        this.isPassport = isPassport;
        this.isQuestion = isQuestion;
    }


    /**
     * Gets the accountID value for this AccountInfoCheckResponseData.
     * 
     * @return accountID
     */
    public java.lang.Integer getAccountID() {
        return accountID;
    }


    /**
     * Sets the accountID value for this AccountInfoCheckResponseData.
     * 
     * @param accountID
     */
    public void setAccountID(java.lang.Integer accountID) {
        this.accountID = accountID;
    }


    /**
     * Gets the accountName value for this AccountInfoCheckResponseData.
     * 
     * @return accountName
     */
    public java.lang.String getAccountName() {
        return accountName;
    }


    /**
     * Sets the accountName value for this AccountInfoCheckResponseData.
     * 
     * @param accountName
     */
    public void setAccountName(java.lang.String accountName) {
        this.accountName = accountName;
    }


    /**
     * Gets the isEmail value for this AccountInfoCheckResponseData.
     * 
     * @return isEmail
     */
    public java.lang.Boolean getIsEmail() {
        return isEmail;
    }


    /**
     * Sets the isEmail value for this AccountInfoCheckResponseData.
     * 
     * @param isEmail
     */
    public void setIsEmail(java.lang.Boolean isEmail) {
        this.isEmail = isEmail;
    }


    /**
     * Gets the isMobile value for this AccountInfoCheckResponseData.
     * 
     * @return isMobile
     */
    public java.lang.Boolean getIsMobile() {
        return isMobile;
    }


    /**
     * Sets the isMobile value for this AccountInfoCheckResponseData.
     * 
     * @param isMobile
     */
    public void setIsMobile(java.lang.Boolean isMobile) {
        this.isMobile = isMobile;
    }


    /**
     * Gets the isPassport value for this AccountInfoCheckResponseData.
     * 
     * @return isPassport
     */
    public java.lang.Boolean getIsPassport() {
        return isPassport;
    }


    /**
     * Sets the isPassport value for this AccountInfoCheckResponseData.
     * 
     * @param isPassport
     */
    public void setIsPassport(java.lang.Boolean isPassport) {
        this.isPassport = isPassport;
    }


    /**
     * Gets the isQuestion value for this AccountInfoCheckResponseData.
     * 
     * @return isQuestion
     */
    public java.lang.Boolean getIsQuestion() {
        return isQuestion;
    }


    /**
     * Sets the isQuestion value for this AccountInfoCheckResponseData.
     * 
     * @param isQuestion
     */
    public void setIsQuestion(java.lang.Boolean isQuestion) {
        this.isQuestion = isQuestion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccountInfoCheckResponseData)) return false;
        AccountInfoCheckResponseData other = (AccountInfoCheckResponseData) obj;
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
            ((this.isEmail==null && other.getIsEmail()==null) || 
             (this.isEmail!=null &&
              this.isEmail.equals(other.getIsEmail()))) &&
            ((this.isMobile==null && other.getIsMobile()==null) || 
             (this.isMobile!=null &&
              this.isMobile.equals(other.getIsMobile()))) &&
            ((this.isPassport==null && other.getIsPassport()==null) || 
             (this.isPassport!=null &&
              this.isPassport.equals(other.getIsPassport()))) &&
            ((this.isQuestion==null && other.getIsQuestion()==null) || 
             (this.isQuestion!=null &&
              this.isQuestion.equals(other.getIsQuestion())));
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
        if (getIsEmail() != null) {
            _hashCode += getIsEmail().hashCode();
        }
        if (getIsMobile() != null) {
            _hashCode += getIsMobile().hashCode();
        }
        if (getIsPassport() != null) {
            _hashCode += getIsPassport().hashCode();
        }
        if (getIsQuestion() != null) {
            _hashCode += getIsQuestion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AccountInfoCheckResponseData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "AccountInfoCheckResponseData"));
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
        elemField.setFieldName("isEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "IsEmail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isMobile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "IsMobile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isPassport");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "IsPassport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isQuestion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "IsQuestion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
