/**
 * SMSPlus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.model.plus;

public class SMSPlus  implements java.io.Serializable {
    private java.lang.Integer accountID;

    private java.lang.Integer accountStatus;

    private java.lang.Boolean balanceDesc;

    private java.lang.Boolean balanceInc;

    private java.util.Calendar createdTime;

    private java.lang.Integer error;

    private java.lang.Integer minAmount;

    private java.lang.String OTP;

    private java.lang.Integer SMSServiceID;

    private java.lang.String securityCode;

    private java.lang.String serviceName;

    private java.lang.Integer serviceStatus;

    private java.lang.String userID;

    private java.lang.String userName;

    public SMSPlus() {
    }

    public SMSPlus(
           java.lang.Integer accountID,
           java.lang.Integer accountStatus,
           java.lang.Boolean balanceDesc,
           java.lang.Boolean balanceInc,
           java.util.Calendar createdTime,
           java.lang.Integer error,
           java.lang.Integer minAmount,
           java.lang.String OTP,
           java.lang.Integer SMSServiceID,
           java.lang.String securityCode,
           java.lang.String serviceName,
           java.lang.Integer serviceStatus,
           java.lang.String userID,
           java.lang.String userName) {
           this.accountID = accountID;
           this.accountStatus = accountStatus;
           this.balanceDesc = balanceDesc;
           this.balanceInc = balanceInc;
           this.createdTime = createdTime;
           this.error = error;
           this.minAmount = minAmount;
           this.OTP = OTP;
           this.SMSServiceID = SMSServiceID;
           this.securityCode = securityCode;
           this.serviceName = serviceName;
           this.serviceStatus = serviceStatus;
           this.userID = userID;
           this.userName = userName;
    }


    /**
     * Gets the accountID value for this SMSPlus.
     * 
     * @return accountID
     */
    public java.lang.Integer getAccountID() {
        return accountID;
    }


    /**
     * Sets the accountID value for this SMSPlus.
     * 
     * @param accountID
     */
    public void setAccountID(java.lang.Integer accountID) {
        this.accountID = accountID;
    }


    /**
     * Gets the accountStatus value for this SMSPlus.
     * 
     * @return accountStatus
     */
    public java.lang.Integer getAccountStatus() {
        return accountStatus;
    }


    /**
     * Sets the accountStatus value for this SMSPlus.
     * 
     * @param accountStatus
     */
    public void setAccountStatus(java.lang.Integer accountStatus) {
        this.accountStatus = accountStatus;
    }


    /**
     * Gets the balanceDesc value for this SMSPlus.
     * 
     * @return balanceDesc
     */
    public java.lang.Boolean getBalanceDesc() {
        return balanceDesc;
    }


    /**
     * Sets the balanceDesc value for this SMSPlus.
     * 
     * @param balanceDesc
     */
    public void setBalanceDesc(java.lang.Boolean balanceDesc) {
        this.balanceDesc = balanceDesc;
    }


    /**
     * Gets the balanceInc value for this SMSPlus.
     * 
     * @return balanceInc
     */
    public java.lang.Boolean getBalanceInc() {
        return balanceInc;
    }


    /**
     * Sets the balanceInc value for this SMSPlus.
     * 
     * @param balanceInc
     */
    public void setBalanceInc(java.lang.Boolean balanceInc) {
        this.balanceInc = balanceInc;
    }


    /**
     * Gets the createdTime value for this SMSPlus.
     * 
     * @return createdTime
     */
    public java.util.Calendar getCreatedTime() {
        return createdTime;
    }


    /**
     * Sets the createdTime value for this SMSPlus.
     * 
     * @param createdTime
     */
    public void setCreatedTime(java.util.Calendar createdTime) {
        this.createdTime = createdTime;
    }


    /**
     * Gets the error value for this SMSPlus.
     * 
     * @return error
     */
    public java.lang.Integer getError() {
        return error;
    }


    /**
     * Sets the error value for this SMSPlus.
     * 
     * @param error
     */
    public void setError(java.lang.Integer error) {
        this.error = error;
    }


    /**
     * Gets the minAmount value for this SMSPlus.
     * 
     * @return minAmount
     */
    public java.lang.Integer getMinAmount() {
        return minAmount;
    }


    /**
     * Sets the minAmount value for this SMSPlus.
     * 
     * @param minAmount
     */
    public void setMinAmount(java.lang.Integer minAmount) {
        this.minAmount = minAmount;
    }


    /**
     * Gets the OTP value for this SMSPlus.
     * 
     * @return OTP
     */
    public java.lang.String getOTP() {
        return OTP;
    }


    /**
     * Sets the OTP value for this SMSPlus.
     * 
     * @param OTP
     */
    public void setOTP(java.lang.String OTP) {
        this.OTP = OTP;
    }


    /**
     * Gets the SMSServiceID value for this SMSPlus.
     * 
     * @return SMSServiceID
     */
    public java.lang.Integer getSMSServiceID() {
        return SMSServiceID;
    }


    /**
     * Sets the SMSServiceID value for this SMSPlus.
     * 
     * @param SMSServiceID
     */
    public void setSMSServiceID(java.lang.Integer SMSServiceID) {
        this.SMSServiceID = SMSServiceID;
    }


    /**
     * Gets the securityCode value for this SMSPlus.
     * 
     * @return securityCode
     */
    public java.lang.String getSecurityCode() {
        return securityCode;
    }


    /**
     * Sets the securityCode value for this SMSPlus.
     * 
     * @param securityCode
     */
    public void setSecurityCode(java.lang.String securityCode) {
        this.securityCode = securityCode;
    }


    /**
     * Gets the serviceName value for this SMSPlus.
     * 
     * @return serviceName
     */
    public java.lang.String getServiceName() {
        return serviceName;
    }


    /**
     * Sets the serviceName value for this SMSPlus.
     * 
     * @param serviceName
     */
    public void setServiceName(java.lang.String serviceName) {
        this.serviceName = serviceName;
    }


    /**
     * Gets the serviceStatus value for this SMSPlus.
     * 
     * @return serviceStatus
     */
    public java.lang.Integer getServiceStatus() {
        return serviceStatus;
    }


    /**
     * Sets the serviceStatus value for this SMSPlus.
     * 
     * @param serviceStatus
     */
    public void setServiceStatus(java.lang.Integer serviceStatus) {
        this.serviceStatus = serviceStatus;
    }


    /**
     * Gets the userID value for this SMSPlus.
     * 
     * @return userID
     */
    public java.lang.String getUserID() {
        return userID;
    }


    /**
     * Sets the userID value for this SMSPlus.
     * 
     * @param userID
     */
    public void setUserID(java.lang.String userID) {
        this.userID = userID;
    }


    /**
     * Gets the userName value for this SMSPlus.
     * 
     * @return userName
     */
    public java.lang.String getUserName() {
        return userName;
    }


    /**
     * Sets the userName value for this SMSPlus.
     * 
     * @param userName
     */
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SMSPlus)) return false;
        SMSPlus other = (SMSPlus) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accountID==null && other.getAccountID()==null) || 
             (this.accountID!=null &&
              this.accountID.equals(other.getAccountID()))) &&
            ((this.accountStatus==null && other.getAccountStatus()==null) || 
             (this.accountStatus!=null &&
              this.accountStatus.equals(other.getAccountStatus()))) &&
            ((this.balanceDesc==null && other.getBalanceDesc()==null) || 
             (this.balanceDesc!=null &&
              this.balanceDesc.equals(other.getBalanceDesc()))) &&
            ((this.balanceInc==null && other.getBalanceInc()==null) || 
             (this.balanceInc!=null &&
              this.balanceInc.equals(other.getBalanceInc()))) &&
            ((this.createdTime==null && other.getCreatedTime()==null) || 
             (this.createdTime!=null &&
              this.createdTime.equals(other.getCreatedTime()))) &&
            ((this.error==null && other.getError()==null) || 
             (this.error!=null &&
              this.error.equals(other.getError()))) &&
            ((this.minAmount==null && other.getMinAmount()==null) || 
             (this.minAmount!=null &&
              this.minAmount.equals(other.getMinAmount()))) &&
            ((this.OTP==null && other.getOTP()==null) || 
             (this.OTP!=null &&
              this.OTP.equals(other.getOTP()))) &&
            ((this.SMSServiceID==null && other.getSMSServiceID()==null) || 
             (this.SMSServiceID!=null &&
              this.SMSServiceID.equals(other.getSMSServiceID()))) &&
            ((this.securityCode==null && other.getSecurityCode()==null) || 
             (this.securityCode!=null &&
              this.securityCode.equals(other.getSecurityCode()))) &&
            ((this.serviceName==null && other.getServiceName()==null) || 
             (this.serviceName!=null &&
              this.serviceName.equals(other.getServiceName()))) &&
            ((this.serviceStatus==null && other.getServiceStatus()==null) || 
             (this.serviceStatus!=null &&
              this.serviceStatus.equals(other.getServiceStatus()))) &&
            ((this.userID==null && other.getUserID()==null) || 
             (this.userID!=null &&
              this.userID.equals(other.getUserID()))) &&
            ((this.userName==null && other.getUserName()==null) || 
             (this.userName!=null &&
              this.userName.equals(other.getUserName())));
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
        if (getAccountID() != null) {
            _hashCode += getAccountID().hashCode();
        }
        if (getAccountStatus() != null) {
            _hashCode += getAccountStatus().hashCode();
        }
        if (getBalanceDesc() != null) {
            _hashCode += getBalanceDesc().hashCode();
        }
        if (getBalanceInc() != null) {
            _hashCode += getBalanceInc().hashCode();
        }
        if (getCreatedTime() != null) {
            _hashCode += getCreatedTime().hashCode();
        }
        if (getError() != null) {
            _hashCode += getError().hashCode();
        }
        if (getMinAmount() != null) {
            _hashCode += getMinAmount().hashCode();
        }
        if (getOTP() != null) {
            _hashCode += getOTP().hashCode();
        }
        if (getSMSServiceID() != null) {
            _hashCode += getSMSServiceID().hashCode();
        }
        if (getSecurityCode() != null) {
            _hashCode += getSecurityCode().hashCode();
        }
        if (getServiceName() != null) {
            _hashCode += getServiceName().hashCode();
        }
        if (getServiceStatus() != null) {
            _hashCode += getServiceStatus().hashCode();
        }
        if (getUserID() != null) {
            _hashCode += getUserID().hashCode();
        }
        if (getUserName() != null) {
            _hashCode += getUserName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SMSPlus.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.SMSPlusAPI.DTO", "SMSPlus"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.SMSPlusAPI.DTO", "AccountID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.SMSPlusAPI.DTO", "AccountStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("balanceDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.SMSPlusAPI.DTO", "BalanceDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("balanceInc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.SMSPlusAPI.DTO", "BalanceInc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createdTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.SMSPlusAPI.DTO", "CreatedTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("error");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.SMSPlusAPI.DTO", "Error"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("minAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.SMSPlusAPI.DTO", "MinAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OTP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.SMSPlusAPI.DTO", "OTP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SMSServiceID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.SMSPlusAPI.DTO", "SMSServiceID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("securityCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.SMSPlusAPI.DTO", "SecurityCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.SMSPlusAPI.DTO", "ServiceName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.SMSPlusAPI.DTO", "ServiceStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.SMSPlusAPI.DTO", "UserID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.SMSPlusAPI.DTO", "UserName"));
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
