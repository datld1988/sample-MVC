/**
 * TransactionOutputRequestData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.model.transaction;

public class TransactionOutputRequestData  extends com.vtc.ws.v2.model.RequestData  implements java.io.Serializable {
    private java.lang.Integer accountID;

    private java.lang.String accountName;

    private java.lang.Integer CPID;

    private java.lang.String clientIP;

    private java.util.Calendar clientTime;

    private java.lang.Integer createdUserID;

    private java.lang.String createdUserName;

    private java.lang.String description;

    private java.lang.Integer deviceType;

    private java.lang.Long relatedTransactionID;

    private java.lang.Integer serviceID;

    private java.lang.String serviceKey;

    private java.lang.Integer vcoin;

    public TransactionOutputRequestData() {
    }

    public TransactionOutputRequestData(
           java.lang.String sign,
           java.lang.Integer accountID,
           java.lang.String accountName,
           java.lang.Integer CPID,
           java.lang.String clientIP,
           java.util.Calendar clientTime,
           java.lang.Integer createdUserID,
           java.lang.String createdUserName,
           java.lang.String description,
           java.lang.Integer deviceType,
           java.lang.Long relatedTransactionID,
           java.lang.Integer serviceID,
           java.lang.String serviceKey,
           java.lang.Integer vcoin) {
        super(
            sign);
        this.accountID = accountID;
        this.accountName = accountName;
        this.CPID = CPID;
        this.clientIP = clientIP;
        this.clientTime = clientTime;
        this.createdUserID = createdUserID;
        this.createdUserName = createdUserName;
        this.description = description;
        this.deviceType = deviceType;
        this.relatedTransactionID = relatedTransactionID;
        this.serviceID = serviceID;
        this.serviceKey = serviceKey;
        this.vcoin = vcoin;
    }


    /**
     * Gets the accountID value for this TransactionOutputRequestData.
     * 
     * @return accountID
     */
    public java.lang.Integer getAccountID() {
        return accountID;
    }


    /**
     * Sets the accountID value for this TransactionOutputRequestData.
     * 
     * @param accountID
     */
    public void setAccountID(java.lang.Integer accountID) {
        this.accountID = accountID;
    }


    /**
     * Gets the accountName value for this TransactionOutputRequestData.
     * 
     * @return accountName
     */
    public java.lang.String getAccountName() {
        return accountName;
    }


    /**
     * Sets the accountName value for this TransactionOutputRequestData.
     * 
     * @param accountName
     */
    public void setAccountName(java.lang.String accountName) {
        this.accountName = accountName;
    }


    /**
     * Gets the CPID value for this TransactionOutputRequestData.
     * 
     * @return CPID
     */
    public java.lang.Integer getCPID() {
        return CPID;
    }


    /**
     * Sets the CPID value for this TransactionOutputRequestData.
     * 
     * @param CPID
     */
    public void setCPID(java.lang.Integer CPID) {
        this.CPID = CPID;
    }


    /**
     * Gets the clientIP value for this TransactionOutputRequestData.
     * 
     * @return clientIP
     */
    public java.lang.String getClientIP() {
        return clientIP;
    }


    /**
     * Sets the clientIP value for this TransactionOutputRequestData.
     * 
     * @param clientIP
     */
    public void setClientIP(java.lang.String clientIP) {
        this.clientIP = clientIP;
    }


    /**
     * Gets the clientTime value for this TransactionOutputRequestData.
     * 
     * @return clientTime
     */
    public java.util.Calendar getClientTime() {
        return clientTime;
    }


    /**
     * Sets the clientTime value for this TransactionOutputRequestData.
     * 
     * @param clientTime
     */
    public void setClientTime(java.util.Calendar clientTime) {
        this.clientTime = clientTime;
    }


    /**
     * Gets the createdUserID value for this TransactionOutputRequestData.
     * 
     * @return createdUserID
     */
    public java.lang.Integer getCreatedUserID() {
        return createdUserID;
    }


    /**
     * Sets the createdUserID value for this TransactionOutputRequestData.
     * 
     * @param createdUserID
     */
    public void setCreatedUserID(java.lang.Integer createdUserID) {
        this.createdUserID = createdUserID;
    }


    /**
     * Gets the createdUserName value for this TransactionOutputRequestData.
     * 
     * @return createdUserName
     */
    public java.lang.String getCreatedUserName() {
        return createdUserName;
    }


    /**
     * Sets the createdUserName value for this TransactionOutputRequestData.
     * 
     * @param createdUserName
     */
    public void setCreatedUserName(java.lang.String createdUserName) {
        this.createdUserName = createdUserName;
    }


    /**
     * Gets the description value for this TransactionOutputRequestData.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this TransactionOutputRequestData.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the deviceType value for this TransactionOutputRequestData.
     * 
     * @return deviceType
     */
    public java.lang.Integer getDeviceType() {
        return deviceType;
    }


    /**
     * Sets the deviceType value for this TransactionOutputRequestData.
     * 
     * @param deviceType
     */
    public void setDeviceType(java.lang.Integer deviceType) {
        this.deviceType = deviceType;
    }


    /**
     * Gets the relatedTransactionID value for this TransactionOutputRequestData.
     * 
     * @return relatedTransactionID
     */
    public java.lang.Long getRelatedTransactionID() {
        return relatedTransactionID;
    }


    /**
     * Sets the relatedTransactionID value for this TransactionOutputRequestData.
     * 
     * @param relatedTransactionID
     */
    public void setRelatedTransactionID(java.lang.Long relatedTransactionID) {
        this.relatedTransactionID = relatedTransactionID;
    }


    /**
     * Gets the serviceID value for this TransactionOutputRequestData.
     * 
     * @return serviceID
     */
    public java.lang.Integer getServiceID() {
        return serviceID;
    }


    /**
     * Sets the serviceID value for this TransactionOutputRequestData.
     * 
     * @param serviceID
     */
    public void setServiceID(java.lang.Integer serviceID) {
        this.serviceID = serviceID;
    }


    /**
     * Gets the serviceKey value for this TransactionOutputRequestData.
     * 
     * @return serviceKey
     */
    public java.lang.String getServiceKey() {
        return serviceKey;
    }


    /**
     * Sets the serviceKey value for this TransactionOutputRequestData.
     * 
     * @param serviceKey
     */
    public void setServiceKey(java.lang.String serviceKey) {
        this.serviceKey = serviceKey;
    }


    /**
     * Gets the vcoin value for this TransactionOutputRequestData.
     * 
     * @return vcoin
     */
    public java.lang.Integer getVcoin() {
        return vcoin;
    }


    /**
     * Sets the vcoin value for this TransactionOutputRequestData.
     * 
     * @param vcoin
     */
    public void setVcoin(java.lang.Integer vcoin) {
        this.vcoin = vcoin;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TransactionOutputRequestData)) return false;
        TransactionOutputRequestData other = (TransactionOutputRequestData) obj;
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
            ((this.CPID==null && other.getCPID()==null) || 
             (this.CPID!=null &&
              this.CPID.equals(other.getCPID()))) &&
            ((this.clientIP==null && other.getClientIP()==null) || 
             (this.clientIP!=null &&
              this.clientIP.equals(other.getClientIP()))) &&
            ((this.clientTime==null && other.getClientTime()==null) || 
             (this.clientTime!=null &&
              this.clientTime.equals(other.getClientTime()))) &&
            ((this.createdUserID==null && other.getCreatedUserID()==null) || 
             (this.createdUserID!=null &&
              this.createdUserID.equals(other.getCreatedUserID()))) &&
            ((this.createdUserName==null && other.getCreatedUserName()==null) || 
             (this.createdUserName!=null &&
              this.createdUserName.equals(other.getCreatedUserName()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.deviceType==null && other.getDeviceType()==null) || 
             (this.deviceType!=null &&
              this.deviceType.equals(other.getDeviceType()))) &&
            ((this.relatedTransactionID==null && other.getRelatedTransactionID()==null) || 
             (this.relatedTransactionID!=null &&
              this.relatedTransactionID.equals(other.getRelatedTransactionID()))) &&
            ((this.serviceID==null && other.getServiceID()==null) || 
             (this.serviceID!=null &&
              this.serviceID.equals(other.getServiceID()))) &&
            ((this.serviceKey==null && other.getServiceKey()==null) || 
             (this.serviceKey!=null &&
              this.serviceKey.equals(other.getServiceKey()))) &&
            ((this.vcoin==null && other.getVcoin()==null) || 
             (this.vcoin!=null &&
              this.vcoin.equals(other.getVcoin())));
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
        if (getCPID() != null) {
            _hashCode += getCPID().hashCode();
        }
        if (getClientIP() != null) {
            _hashCode += getClientIP().hashCode();
        }
        if (getClientTime() != null) {
            _hashCode += getClientTime().hashCode();
        }
        if (getCreatedUserID() != null) {
            _hashCode += getCreatedUserID().hashCode();
        }
        if (getCreatedUserName() != null) {
            _hashCode += getCreatedUserName().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getDeviceType() != null) {
            _hashCode += getDeviceType().hashCode();
        }
        if (getRelatedTransactionID() != null) {
            _hashCode += getRelatedTransactionID().hashCode();
        }
        if (getServiceID() != null) {
            _hashCode += getServiceID().hashCode();
        }
        if (getServiceKey() != null) {
            _hashCode += getServiceKey().hashCode();
        }
        if (getVcoin() != null) {
            _hashCode += getVcoin().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TransactionOutputRequestData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "TransactionOutputRequestData"));
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
        elemField.setFieldName("CPID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "CPID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientIP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "ClientIP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "ClientTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "Description"));
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
        elemField.setFieldName("relatedTransactionID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "RelatedTransactionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
        elemField.setFieldName("vcoin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "Vcoin"));
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
