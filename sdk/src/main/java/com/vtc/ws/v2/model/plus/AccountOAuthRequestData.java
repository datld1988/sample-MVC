/**
 * AccountOAuthRequestData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.model.plus;

public class AccountOAuthRequestData  implements java.io.Serializable {
    private java.lang.String accountName;

    private java.lang.String clientIP;

    private java.lang.String OAuthAccount;

    private java.lang.Integer OAuthSystemID;

    private java.lang.Integer serviceID;

    public AccountOAuthRequestData() {
    }

    public AccountOAuthRequestData(
           java.lang.String accountName,
           java.lang.String clientIP,
           java.lang.String OAuthAccount,
           java.lang.Integer OAuthSystemID,
           java.lang.Integer serviceID) {
           this.accountName = accountName;
           this.clientIP = clientIP;
           this.OAuthAccount = OAuthAccount;
           this.OAuthSystemID = OAuthSystemID;
           this.serviceID = serviceID;
    }


    /**
     * Gets the accountName value for this AccountOAuthRequestData.
     * 
     * @return accountName
     */
    public java.lang.String getAccountName() {
        return accountName;
    }


    /**
     * Sets the accountName value for this AccountOAuthRequestData.
     * 
     * @param accountName
     */
    public void setAccountName(java.lang.String accountName) {
        this.accountName = accountName;
    }


    /**
     * Gets the clientIP value for this AccountOAuthRequestData.
     * 
     * @return clientIP
     */
    public java.lang.String getClientIP() {
        return clientIP;
    }


    /**
     * Sets the clientIP value for this AccountOAuthRequestData.
     * 
     * @param clientIP
     */
    public void setClientIP(java.lang.String clientIP) {
        this.clientIP = clientIP;
    }


    /**
     * Gets the OAuthAccount value for this AccountOAuthRequestData.
     * 
     * @return OAuthAccount
     */
    public java.lang.String getOAuthAccount() {
        return OAuthAccount;
    }


    /**
     * Sets the OAuthAccount value for this AccountOAuthRequestData.
     * 
     * @param OAuthAccount
     */
    public void setOAuthAccount(java.lang.String OAuthAccount) {
        this.OAuthAccount = OAuthAccount;
    }


    /**
     * Gets the OAuthSystemID value for this AccountOAuthRequestData.
     * 
     * @return OAuthSystemID
     */
    public java.lang.Integer getOAuthSystemID() {
        return OAuthSystemID;
    }


    /**
     * Sets the OAuthSystemID value for this AccountOAuthRequestData.
     * 
     * @param OAuthSystemID
     */
    public void setOAuthSystemID(java.lang.Integer OAuthSystemID) {
        this.OAuthSystemID = OAuthSystemID;
    }


    /**
     * Gets the serviceID value for this AccountOAuthRequestData.
     * 
     * @return serviceID
     */
    public java.lang.Integer getServiceID() {
        return serviceID;
    }


    /**
     * Sets the serviceID value for this AccountOAuthRequestData.
     * 
     * @param serviceID
     */
    public void setServiceID(java.lang.Integer serviceID) {
        this.serviceID = serviceID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccountOAuthRequestData)) return false;
        AccountOAuthRequestData other = (AccountOAuthRequestData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accountName==null && other.getAccountName()==null) || 
             (this.accountName!=null &&
              this.accountName.equals(other.getAccountName()))) &&
            ((this.clientIP==null && other.getClientIP()==null) || 
             (this.clientIP!=null &&
              this.clientIP.equals(other.getClientIP()))) &&
            ((this.OAuthAccount==null && other.getOAuthAccount()==null) || 
             (this.OAuthAccount!=null &&
              this.OAuthAccount.equals(other.getOAuthAccount()))) &&
            ((this.OAuthSystemID==null && other.getOAuthSystemID()==null) || 
             (this.OAuthSystemID!=null &&
              this.OAuthSystemID.equals(other.getOAuthSystemID()))) &&
            ((this.serviceID==null && other.getServiceID()==null) || 
             (this.serviceID!=null &&
              this.serviceID.equals(other.getServiceID())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAccountName() != null) {
            _hashCode += getAccountName().hashCode();
        }
        if (getClientIP() != null) {
            _hashCode += getClientIP().hashCode();
        }
        if (getOAuthAccount() != null) {
            _hashCode += getOAuthAccount().hashCode();
        }
        if (getOAuthSystemID() != null) {
            _hashCode += getOAuthSystemID().hashCode();
        }
        if (getServiceID() != null) {
            _hashCode += getServiceID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AccountOAuthRequestData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "AccountOAuthRequestData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "AccountName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientIP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "ClientIP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OAuthAccount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "OAuthAccount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OAuthSystemID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "OAuthSystemID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "ServiceID"));
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
