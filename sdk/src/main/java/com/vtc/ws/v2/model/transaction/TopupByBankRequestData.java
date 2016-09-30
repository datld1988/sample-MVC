/**
 * TopupByBankRequestData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.model.transaction;

public class TopupByBankRequestData  implements java.io.Serializable {
    private java.lang.String accountName;

    private java.lang.String bankCode;

    private java.lang.Integer CPID;

    private java.lang.String clientIP;

    private java.util.Calendar clientTime;

    private java.lang.Integer createdUserID;

    private java.lang.String createdUserName;

    private java.lang.Integer deductServiceID;

    private java.lang.String deductServiceKey;

    private java.lang.String description;

    private java.lang.Integer deviceType;

    private java.lang.String notifyUrl;

    private java.lang.String orderCode;

    private java.lang.Integer productID;

    private java.lang.String returnUrl;

    private java.lang.Integer vcoin;

    public TopupByBankRequestData() {
    }

    public TopupByBankRequestData(
           java.lang.String accountName,
           java.lang.String bankCode,
           java.lang.Integer CPID,
           java.lang.String clientIP,
           java.util.Calendar clientTime,
           java.lang.Integer createdUserID,
           java.lang.String createdUserName,
           java.lang.Integer deductServiceID,
           java.lang.String deductServiceKey,
           java.lang.String description,
           java.lang.Integer deviceType,
           java.lang.String notifyUrl,
           java.lang.String orderCode,
           java.lang.Integer productID,
           java.lang.String returnUrl,
           java.lang.Integer vcoin) {
           this.accountName = accountName;
           this.bankCode = bankCode;
           this.CPID = CPID;
           this.clientIP = clientIP;
           this.clientTime = clientTime;
           this.createdUserID = createdUserID;
           this.createdUserName = createdUserName;
           this.deductServiceID = deductServiceID;
           this.deductServiceKey = deductServiceKey;
           this.description = description;
           this.deviceType = deviceType;
           this.notifyUrl = notifyUrl;
           this.orderCode = orderCode;
           this.productID = productID;
           this.returnUrl = returnUrl;
           this.vcoin = vcoin;
    }


    /**
     * Gets the accountName value for this TopupByBankRequestData.
     * 
     * @return accountName
     */
    public java.lang.String getAccountName() {
        return accountName;
    }


    /**
     * Sets the accountName value for this TopupByBankRequestData.
     * 
     * @param accountName
     */
    public void setAccountName(java.lang.String accountName) {
        this.accountName = accountName;
    }


    /**
     * Gets the bankCode value for this TopupByBankRequestData.
     * 
     * @return bankCode
     */
    public java.lang.String getBankCode() {
        return bankCode;
    }


    /**
     * Sets the bankCode value for this TopupByBankRequestData.
     * 
     * @param bankCode
     */
    public void setBankCode(java.lang.String bankCode) {
        this.bankCode = bankCode;
    }


    /**
     * Gets the CPID value for this TopupByBankRequestData.
     * 
     * @return CPID
     */
    public java.lang.Integer getCPID() {
        return CPID;
    }


    /**
     * Sets the CPID value for this TopupByBankRequestData.
     * 
     * @param CPID
     */
    public void setCPID(java.lang.Integer CPID) {
        this.CPID = CPID;
    }


    /**
     * Gets the clientIP value for this TopupByBankRequestData.
     * 
     * @return clientIP
     */
    public java.lang.String getClientIP() {
        return clientIP;
    }


    /**
     * Sets the clientIP value for this TopupByBankRequestData.
     * 
     * @param clientIP
     */
    public void setClientIP(java.lang.String clientIP) {
        this.clientIP = clientIP;
    }


    /**
     * Gets the clientTime value for this TopupByBankRequestData.
     * 
     * @return clientTime
     */
    public java.util.Calendar getClientTime() {
        return clientTime;
    }


    /**
     * Sets the clientTime value for this TopupByBankRequestData.
     * 
     * @param clientTime
     */
    public void setClientTime(java.util.Calendar clientTime) {
        this.clientTime = clientTime;
    }


    /**
     * Gets the createdUserID value for this TopupByBankRequestData.
     * 
     * @return createdUserID
     */
    public java.lang.Integer getCreatedUserID() {
        return createdUserID;
    }


    /**
     * Sets the createdUserID value for this TopupByBankRequestData.
     * 
     * @param createdUserID
     */
    public void setCreatedUserID(java.lang.Integer createdUserID) {
        this.createdUserID = createdUserID;
    }


    /**
     * Gets the createdUserName value for this TopupByBankRequestData.
     * 
     * @return createdUserName
     */
    public java.lang.String getCreatedUserName() {
        return createdUserName;
    }


    /**
     * Sets the createdUserName value for this TopupByBankRequestData.
     * 
     * @param createdUserName
     */
    public void setCreatedUserName(java.lang.String createdUserName) {
        this.createdUserName = createdUserName;
    }


    /**
     * Gets the deductServiceID value for this TopupByBankRequestData.
     * 
     * @return deductServiceID
     */
    public java.lang.Integer getDeductServiceID() {
        return deductServiceID;
    }


    /**
     * Sets the deductServiceID value for this TopupByBankRequestData.
     * 
     * @param deductServiceID
     */
    public void setDeductServiceID(java.lang.Integer deductServiceID) {
        this.deductServiceID = deductServiceID;
    }


    /**
     * Gets the deductServiceKey value for this TopupByBankRequestData.
     * 
     * @return deductServiceKey
     */
    public java.lang.String getDeductServiceKey() {
        return deductServiceKey;
    }


    /**
     * Sets the deductServiceKey value for this TopupByBankRequestData.
     * 
     * @param deductServiceKey
     */
    public void setDeductServiceKey(java.lang.String deductServiceKey) {
        this.deductServiceKey = deductServiceKey;
    }


    /**
     * Gets the description value for this TopupByBankRequestData.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this TopupByBankRequestData.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the deviceType value for this TopupByBankRequestData.
     * 
     * @return deviceType
     */
    public java.lang.Integer getDeviceType() {
        return deviceType;
    }


    /**
     * Sets the deviceType value for this TopupByBankRequestData.
     * 
     * @param deviceType
     */
    public void setDeviceType(java.lang.Integer deviceType) {
        this.deviceType = deviceType;
    }


    /**
     * Gets the notifyUrl value for this TopupByBankRequestData.
     * 
     * @return notifyUrl
     */
    public java.lang.String getNotifyUrl() {
        return notifyUrl;
    }


    /**
     * Sets the notifyUrl value for this TopupByBankRequestData.
     * 
     * @param notifyUrl
     */
    public void setNotifyUrl(java.lang.String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }


    /**
     * Gets the orderCode value for this TopupByBankRequestData.
     * 
     * @return orderCode
     */
    public java.lang.String getOrderCode() {
        return orderCode;
    }


    /**
     * Sets the orderCode value for this TopupByBankRequestData.
     * 
     * @param orderCode
     */
    public void setOrderCode(java.lang.String orderCode) {
        this.orderCode = orderCode;
    }


    /**
     * Gets the productID value for this TopupByBankRequestData.
     * 
     * @return productID
     */
    public java.lang.Integer getProductID() {
        return productID;
    }


    /**
     * Sets the productID value for this TopupByBankRequestData.
     * 
     * @param productID
     */
    public void setProductID(java.lang.Integer productID) {
        this.productID = productID;
    }


    /**
     * Gets the returnUrl value for this TopupByBankRequestData.
     * 
     * @return returnUrl
     */
    public java.lang.String getReturnUrl() {
        return returnUrl;
    }


    /**
     * Sets the returnUrl value for this TopupByBankRequestData.
     * 
     * @param returnUrl
     */
    public void setReturnUrl(java.lang.String returnUrl) {
        this.returnUrl = returnUrl;
    }


    /**
     * Gets the vcoin value for this TopupByBankRequestData.
     * 
     * @return vcoin
     */
    public java.lang.Integer getVcoin() {
        return vcoin;
    }


    /**
     * Sets the vcoin value for this TopupByBankRequestData.
     * 
     * @param vcoin
     */
    public void setVcoin(java.lang.Integer vcoin) {
        this.vcoin = vcoin;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TopupByBankRequestData)) return false;
        TopupByBankRequestData other = (TopupByBankRequestData) obj;
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
            ((this.bankCode==null && other.getBankCode()==null) || 
             (this.bankCode!=null &&
              this.bankCode.equals(other.getBankCode()))) &&
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
            ((this.deductServiceID==null && other.getDeductServiceID()==null) || 
             (this.deductServiceID!=null &&
              this.deductServiceID.equals(other.getDeductServiceID()))) &&
            ((this.deductServiceKey==null && other.getDeductServiceKey()==null) || 
             (this.deductServiceKey!=null &&
              this.deductServiceKey.equals(other.getDeductServiceKey()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.deviceType==null && other.getDeviceType()==null) || 
             (this.deviceType!=null &&
              this.deviceType.equals(other.getDeviceType()))) &&
            ((this.notifyUrl==null && other.getNotifyUrl()==null) || 
             (this.notifyUrl!=null &&
              this.notifyUrl.equals(other.getNotifyUrl()))) &&
            ((this.orderCode==null && other.getOrderCode()==null) || 
             (this.orderCode!=null &&
              this.orderCode.equals(other.getOrderCode()))) &&
            ((this.productID==null && other.getProductID()==null) || 
             (this.productID!=null &&
              this.productID.equals(other.getProductID()))) &&
            ((this.returnUrl==null && other.getReturnUrl()==null) || 
             (this.returnUrl!=null &&
              this.returnUrl.equals(other.getReturnUrl()))) &&
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
        int _hashCode = 1;
        if (getAccountName() != null) {
            _hashCode += getAccountName().hashCode();
        }
        if (getBankCode() != null) {
            _hashCode += getBankCode().hashCode();
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
        if (getDeductServiceID() != null) {
            _hashCode += getDeductServiceID().hashCode();
        }
        if (getDeductServiceKey() != null) {
            _hashCode += getDeductServiceKey().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getDeviceType() != null) {
            _hashCode += getDeviceType().hashCode();
        }
        if (getNotifyUrl() != null) {
            _hashCode += getNotifyUrl().hashCode();
        }
        if (getOrderCode() != null) {
            _hashCode += getOrderCode().hashCode();
        }
        if (getProductID() != null) {
            _hashCode += getProductID().hashCode();
        }
        if (getReturnUrl() != null) {
            _hashCode += getReturnUrl().hashCode();
        }
        if (getVcoin() != null) {
            _hashCode += getVcoin().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TopupByBankRequestData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "TopupByBankRequestData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "AccountName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "BankCode"));
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
        elemField.setFieldName("deductServiceID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "DeductServiceID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deductServiceKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "DeductServiceKey"));
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
        elemField.setFieldName("notifyUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "NotifyUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "OrderCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "ProductID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "ReturnUrl"));
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
