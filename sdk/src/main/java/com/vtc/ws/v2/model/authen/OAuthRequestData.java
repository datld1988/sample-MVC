/**
 * OAuthRequestData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.model.authen;

public class OAuthRequestData  extends com.vtc.ws.v2.model.RequestData  implements java.io.Serializable {
    private java.lang.String clientIP;

    private java.lang.Integer deviceType;

    private java.lang.String fbBussinessIDs;

    private java.lang.String fbEmail;

    private java.lang.Boolean isAutoCreate;

    private java.lang.Boolean isDisableCheckSecure;

    private java.lang.String OAuthAccount;

    private java.lang.Integer OAuthSystemID;

    private java.lang.String secureCode;

    private org.apache.axis.types.UnsignedByte secureType;

    private java.lang.Integer serviceID;

    private java.lang.String serviceKey;

    private java.lang.String signDisableSecure;

    public OAuthRequestData() {
    }

    public OAuthRequestData(
           java.lang.String sign,
           java.lang.String clientIP,
           java.lang.Integer deviceType,
           java.lang.String fbBussinessIDs,
           java.lang.String fbEmail,
           java.lang.Boolean isAutoCreate,
           java.lang.Boolean isDisableCheckSecure,
           java.lang.String OAuthAccount,
           java.lang.Integer OAuthSystemID,
           java.lang.String secureCode,
           org.apache.axis.types.UnsignedByte secureType,
           java.lang.Integer serviceID,
           java.lang.String serviceKey,
           java.lang.String signDisableSecure) {
        super(
            sign);
        this.clientIP = clientIP;
        this.deviceType = deviceType;
        this.fbBussinessIDs = fbBussinessIDs;
        this.fbEmail = fbEmail;
        this.isAutoCreate = isAutoCreate;
        this.isDisableCheckSecure = isDisableCheckSecure;
        this.OAuthAccount = OAuthAccount;
        this.OAuthSystemID = OAuthSystemID;
        this.secureCode = secureCode;
        this.secureType = secureType;
        this.serviceID = serviceID;
        this.serviceKey = serviceKey;
        this.signDisableSecure = signDisableSecure;
    }


    /**
     * Gets the clientIP value for this OAuthRequestData.
     * 
     * @return clientIP
     */
    public java.lang.String getClientIP() {
        return clientIP;
    }


    /**
     * Sets the clientIP value for this OAuthRequestData.
     * 
     * @param clientIP
     */
    public void setClientIP(java.lang.String clientIP) {
        this.clientIP = clientIP;
    }


    /**
     * Gets the deviceType value for this OAuthRequestData.
     * 
     * @return deviceType
     */
    public java.lang.Integer getDeviceType() {
        return deviceType;
    }


    /**
     * Sets the deviceType value for this OAuthRequestData.
     * 
     * @param deviceType
     */
    public void setDeviceType(java.lang.Integer deviceType) {
        this.deviceType = deviceType;
    }


    /**
     * Gets the fbBussinessIDs value for this OAuthRequestData.
     * 
     * @return fbBussinessIDs
     */
    public java.lang.String getFbBussinessIDs() {
        return fbBussinessIDs;
    }


    /**
     * Sets the fbBussinessIDs value for this OAuthRequestData.
     * 
     * @param fbBussinessIDs
     */
    public void setFbBussinessIDs(java.lang.String fbBussinessIDs) {
        this.fbBussinessIDs = fbBussinessIDs;
    }


    /**
     * Gets the fbEmail value for this OAuthRequestData.
     * 
     * @return fbEmail
     */
    public java.lang.String getFbEmail() {
        return fbEmail;
    }


    /**
     * Sets the fbEmail value for this OAuthRequestData.
     * 
     * @param fbEmail
     */
    public void setFbEmail(java.lang.String fbEmail) {
        this.fbEmail = fbEmail;
    }


    /**
     * Gets the isAutoCreate value for this OAuthRequestData.
     * 
     * @return isAutoCreate
     */
    public java.lang.Boolean getIsAutoCreate() {
        return isAutoCreate;
    }


    /**
     * Sets the isAutoCreate value for this OAuthRequestData.
     * 
     * @param isAutoCreate
     */
    public void setIsAutoCreate(java.lang.Boolean isAutoCreate) {
        this.isAutoCreate = isAutoCreate;
    }


    /**
     * Gets the isDisableCheckSecure value for this OAuthRequestData.
     * 
     * @return isDisableCheckSecure
     */
    public java.lang.Boolean getIsDisableCheckSecure() {
        return isDisableCheckSecure;
    }


    /**
     * Sets the isDisableCheckSecure value for this OAuthRequestData.
     * 
     * @param isDisableCheckSecure
     */
    public void setIsDisableCheckSecure(java.lang.Boolean isDisableCheckSecure) {
        this.isDisableCheckSecure = isDisableCheckSecure;
    }


    /**
     * Gets the OAuthAccount value for this OAuthRequestData.
     * 
     * @return OAuthAccount
     */
    public java.lang.String getOAuthAccount() {
        return OAuthAccount;
    }


    /**
     * Sets the OAuthAccount value for this OAuthRequestData.
     * 
     * @param OAuthAccount
     */
    public void setOAuthAccount(java.lang.String OAuthAccount) {
        this.OAuthAccount = OAuthAccount;
    }


    /**
     * Gets the OAuthSystemID value for this OAuthRequestData.
     * 
     * @return OAuthSystemID
     */
    public java.lang.Integer getOAuthSystemID() {
        return OAuthSystemID;
    }


    /**
     * Sets the OAuthSystemID value for this OAuthRequestData.
     * 
     * @param OAuthSystemID
     */
    public void setOAuthSystemID(java.lang.Integer OAuthSystemID) {
        this.OAuthSystemID = OAuthSystemID;
    }


    /**
     * Gets the secureCode value for this OAuthRequestData.
     * 
     * @return secureCode
     */
    public java.lang.String getSecureCode() {
        return secureCode;
    }


    /**
     * Sets the secureCode value for this OAuthRequestData.
     * 
     * @param secureCode
     */
    public void setSecureCode(java.lang.String secureCode) {
        this.secureCode = secureCode;
    }


    /**
     * Gets the secureType value for this OAuthRequestData.
     * 
     * @return secureType
     */
    public org.apache.axis.types.UnsignedByte getSecureType() {
        return secureType;
    }


    /**
     * Sets the secureType value for this OAuthRequestData.
     * 
     * @param secureType
     */
    public void setSecureType(org.apache.axis.types.UnsignedByte secureType) {
        this.secureType = secureType;
    }


    /**
     * Gets the serviceID value for this OAuthRequestData.
     * 
     * @return serviceID
     */
    public java.lang.Integer getServiceID() {
        return serviceID;
    }


    /**
     * Sets the serviceID value for this OAuthRequestData.
     * 
     * @param serviceID
     */
    public void setServiceID(java.lang.Integer serviceID) {
        this.serviceID = serviceID;
    }


    /**
     * Gets the serviceKey value for this OAuthRequestData.
     * 
     * @return serviceKey
     */
    public java.lang.String getServiceKey() {
        return serviceKey;
    }


    /**
     * Sets the serviceKey value for this OAuthRequestData.
     * 
     * @param serviceKey
     */
    public void setServiceKey(java.lang.String serviceKey) {
        this.serviceKey = serviceKey;
    }


    /**
     * Gets the signDisableSecure value for this OAuthRequestData.
     * 
     * @return signDisableSecure
     */
    public java.lang.String getSignDisableSecure() {
        return signDisableSecure;
    }


    /**
     * Sets the signDisableSecure value for this OAuthRequestData.
     * 
     * @param signDisableSecure
     */
    public void setSignDisableSecure(java.lang.String signDisableSecure) {
        this.signDisableSecure = signDisableSecure;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OAuthRequestData)) return false;
        OAuthRequestData other = (OAuthRequestData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.clientIP==null && other.getClientIP()==null) || 
             (this.clientIP!=null &&
              this.clientIP.equals(other.getClientIP()))) &&
            ((this.deviceType==null && other.getDeviceType()==null) || 
             (this.deviceType!=null &&
              this.deviceType.equals(other.getDeviceType()))) &&
            ((this.fbBussinessIDs==null && other.getFbBussinessIDs()==null) || 
             (this.fbBussinessIDs!=null &&
              this.fbBussinessIDs.equals(other.getFbBussinessIDs()))) &&
            ((this.fbEmail==null && other.getFbEmail()==null) || 
             (this.fbEmail!=null &&
              this.fbEmail.equals(other.getFbEmail()))) &&
            ((this.isAutoCreate==null && other.getIsAutoCreate()==null) || 
             (this.isAutoCreate!=null &&
              this.isAutoCreate.equals(other.getIsAutoCreate()))) &&
            ((this.isDisableCheckSecure==null && other.getIsDisableCheckSecure()==null) || 
             (this.isDisableCheckSecure!=null &&
              this.isDisableCheckSecure.equals(other.getIsDisableCheckSecure()))) &&
            ((this.OAuthAccount==null && other.getOAuthAccount()==null) || 
             (this.OAuthAccount!=null &&
              this.OAuthAccount.equals(other.getOAuthAccount()))) &&
            ((this.OAuthSystemID==null && other.getOAuthSystemID()==null) || 
             (this.OAuthSystemID!=null &&
              this.OAuthSystemID.equals(other.getOAuthSystemID()))) &&
            ((this.secureCode==null && other.getSecureCode()==null) || 
             (this.secureCode!=null &&
              this.secureCode.equals(other.getSecureCode()))) &&
            ((this.secureType==null && other.getSecureType()==null) || 
             (this.secureType!=null &&
              this.secureType.equals(other.getSecureType()))) &&
            ((this.serviceID==null && other.getServiceID()==null) || 
             (this.serviceID!=null &&
              this.serviceID.equals(other.getServiceID()))) &&
            ((this.serviceKey==null && other.getServiceKey()==null) || 
             (this.serviceKey!=null &&
              this.serviceKey.equals(other.getServiceKey()))) &&
            ((this.signDisableSecure==null && other.getSignDisableSecure()==null) || 
             (this.signDisableSecure!=null &&
              this.signDisableSecure.equals(other.getSignDisableSecure())));
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
        if (getClientIP() != null) {
            _hashCode += getClientIP().hashCode();
        }
        if (getDeviceType() != null) {
            _hashCode += getDeviceType().hashCode();
        }
        if (getFbBussinessIDs() != null) {
            _hashCode += getFbBussinessIDs().hashCode();
        }
        if (getFbEmail() != null) {
            _hashCode += getFbEmail().hashCode();
        }
        if (getIsAutoCreate() != null) {
            _hashCode += getIsAutoCreate().hashCode();
        }
        if (getIsDisableCheckSecure() != null) {
            _hashCode += getIsDisableCheckSecure().hashCode();
        }
        if (getOAuthAccount() != null) {
            _hashCode += getOAuthAccount().hashCode();
        }
        if (getOAuthSystemID() != null) {
            _hashCode += getOAuthSystemID().hashCode();
        }
        if (getSecureCode() != null) {
            _hashCode += getSecureCode().hashCode();
        }
        if (getSecureType() != null) {
            _hashCode += getSecureType().hashCode();
        }
        if (getServiceID() != null) {
            _hashCode += getServiceID().hashCode();
        }
        if (getServiceKey() != null) {
            _hashCode += getServiceKey().hashCode();
        }
        if (getSignDisableSecure() != null) {
            _hashCode += getSignDisableSecure().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OAuthRequestData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "OAuthRequestData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientIP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "ClientIP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deviceType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "DeviceType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fbBussinessIDs");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "FbBussinessIDs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fbEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "FbEmail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAutoCreate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "IsAutoCreate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isDisableCheckSecure");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "IsDisableCheckSecure"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
        elemField.setFieldName("secureCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "SecureCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secureType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "SecureType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "ServiceKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("signDisableSecure");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "SignDisableSecure"));
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
