/**
 * UnVerifyMobileByAdminRequestData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.model.update;

public class UnVerifyMobileByAdminRequestData  extends com.vtc.ws.v2.model.RequestData  implements java.io.Serializable {
    private java.lang.String accountName;

    private java.lang.String clientIP;

    private java.lang.String createdUser;

    private java.lang.String description;

    public UnVerifyMobileByAdminRequestData() {
    }

    public UnVerifyMobileByAdminRequestData(
           java.lang.String sign,
           java.lang.String accountName,
           java.lang.String clientIP,
           java.lang.String createdUser,
           java.lang.String description) {
        super(
            sign);
        this.accountName = accountName;
        this.clientIP = clientIP;
        this.createdUser = createdUser;
        this.description = description;
    }


    /**
     * Gets the accountName value for this UnVerifyMobileByAdminRequestData.
     * 
     * @return accountName
     */
    public java.lang.String getAccountName() {
        return accountName;
    }


    /**
     * Sets the accountName value for this UnVerifyMobileByAdminRequestData.
     * 
     * @param accountName
     */
    public void setAccountName(java.lang.String accountName) {
        this.accountName = accountName;
    }


    /**
     * Gets the clientIP value for this UnVerifyMobileByAdminRequestData.
     * 
     * @return clientIP
     */
    public java.lang.String getClientIP() {
        return clientIP;
    }


    /**
     * Sets the clientIP value for this UnVerifyMobileByAdminRequestData.
     * 
     * @param clientIP
     */
    public void setClientIP(java.lang.String clientIP) {
        this.clientIP = clientIP;
    }


    /**
     * Gets the createdUser value for this UnVerifyMobileByAdminRequestData.
     * 
     * @return createdUser
     */
    public java.lang.String getCreatedUser() {
        return createdUser;
    }


    /**
     * Sets the createdUser value for this UnVerifyMobileByAdminRequestData.
     * 
     * @param createdUser
     */
    public void setCreatedUser(java.lang.String createdUser) {
        this.createdUser = createdUser;
    }


    /**
     * Gets the description value for this UnVerifyMobileByAdminRequestData.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this UnVerifyMobileByAdminRequestData.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UnVerifyMobileByAdminRequestData)) return false;
        UnVerifyMobileByAdminRequestData other = (UnVerifyMobileByAdminRequestData) obj;
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
            ((this.clientIP==null && other.getClientIP()==null) || 
             (this.clientIP!=null &&
              this.clientIP.equals(other.getClientIP()))) &&
            ((this.createdUser==null && other.getCreatedUser()==null) || 
             (this.createdUser!=null &&
              this.createdUser.equals(other.getCreatedUser()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription())));
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
        if (getClientIP() != null) {
            _hashCode += getClientIP().hashCode();
        }
        if (getCreatedUser() != null) {
            _hashCode += getCreatedUser().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UnVerifyMobileByAdminRequestData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "UnVerifyMobileByAdminRequestData"));
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
        elemField.setFieldName("createdUser");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "CreatedUser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "Description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
