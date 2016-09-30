/**
 * TopupIAPRequestData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.model;

public class TopupIAPRequestData  extends RequestData  implements java.io.Serializable {
    private java.lang.String accountName;

    private java.lang.Integer CPID;

    private java.lang.String clientIP;

    private java.lang.Integer createdUserID;

    private java.lang.String createdUserName;

    private java.lang.String description;

    private java.lang.Integer deviceType;

    private java.lang.String packetID;

    private java.util.Calendar purchaseDate;

    private java.lang.Integer quantity;

    private java.lang.String receiptBase;

    private java.lang.String receiptBaseMD5;

    private java.lang.String receiptData;

    private java.lang.String relatedTransactionID;

    private java.lang.Integer serviceID;

    private java.lang.String serviceKey;

    private java.lang.String uuid;

    public TopupIAPRequestData() {
    }

    public TopupIAPRequestData(
           java.lang.String sign,
           java.lang.String accountName,
           java.lang.Integer CPID,
           java.lang.String clientIP,
           java.lang.Integer createdUserID,
           java.lang.String createdUserName,
           java.lang.String description,
           java.lang.Integer deviceType,
           java.lang.String packetID,
           java.util.Calendar purchaseDate,
           java.lang.Integer quantity,
           java.lang.String receiptBase,
           java.lang.String receiptBaseMD5,
           java.lang.String receiptData,
           java.lang.String relatedTransactionID,
           java.lang.Integer serviceID,
           java.lang.String serviceKey,
           java.lang.String uuid) {
        super(
            sign);
        this.accountName = accountName;
        this.CPID = CPID;
        this.clientIP = clientIP;
        this.createdUserID = createdUserID;
        this.createdUserName = createdUserName;
        this.description = description;
        this.deviceType = deviceType;
        this.packetID = packetID;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
        this.receiptBase = receiptBase;
        this.receiptBaseMD5 = receiptBaseMD5;
        this.receiptData = receiptData;
        this.relatedTransactionID = relatedTransactionID;
        this.serviceID = serviceID;
        this.serviceKey = serviceKey;
        this.uuid = uuid;
    }


    /**
     * Gets the accountName value for this TopupIAPRequestData.
     * 
     * @return accountName
     */
    public java.lang.String getAccountName() {
        return accountName;
    }


    /**
     * Sets the accountName value for this TopupIAPRequestData.
     * 
     * @param accountName
     */
    public void setAccountName(java.lang.String accountName) {
        this.accountName = accountName;
    }


    /**
     * Gets the CPID value for this TopupIAPRequestData.
     * 
     * @return CPID
     */
    public java.lang.Integer getCPID() {
        return CPID;
    }


    /**
     * Sets the CPID value for this TopupIAPRequestData.
     * 
     * @param CPID
     */
    public void setCPID(java.lang.Integer CPID) {
        this.CPID = CPID;
    }


    /**
     * Gets the clientIP value for this TopupIAPRequestData.
     * 
     * @return clientIP
     */
    public java.lang.String getClientIP() {
        return clientIP;
    }


    /**
     * Sets the clientIP value for this TopupIAPRequestData.
     * 
     * @param clientIP
     */
    public void setClientIP(java.lang.String clientIP) {
        this.clientIP = clientIP;
    }


    /**
     * Gets the createdUserID value for this TopupIAPRequestData.
     * 
     * @return createdUserID
     */
    public java.lang.Integer getCreatedUserID() {
        return createdUserID;
    }


    /**
     * Sets the createdUserID value for this TopupIAPRequestData.
     * 
     * @param createdUserID
     */
    public void setCreatedUserID(java.lang.Integer createdUserID) {
        this.createdUserID = createdUserID;
    }


    /**
     * Gets the createdUserName value for this TopupIAPRequestData.
     * 
     * @return createdUserName
     */
    public java.lang.String getCreatedUserName() {
        return createdUserName;
    }


    /**
     * Sets the createdUserName value for this TopupIAPRequestData.
     * 
     * @param createdUserName
     */
    public void setCreatedUserName(java.lang.String createdUserName) {
        this.createdUserName = createdUserName;
    }


    /**
     * Gets the description value for this TopupIAPRequestData.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this TopupIAPRequestData.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the deviceType value for this TopupIAPRequestData.
     * 
     * @return deviceType
     */
    public java.lang.Integer getDeviceType() {
        return deviceType;
    }


    /**
     * Sets the deviceType value for this TopupIAPRequestData.
     * 
     * @param deviceType
     */
    public void setDeviceType(java.lang.Integer deviceType) {
        this.deviceType = deviceType;
    }


    /**
     * Gets the packetID value for this TopupIAPRequestData.
     * 
     * @return packetID
     */
    public java.lang.String getPacketID() {
        return packetID;
    }


    /**
     * Sets the packetID value for this TopupIAPRequestData.
     * 
     * @param packetID
     */
    public void setPacketID(java.lang.String packetID) {
        this.packetID = packetID;
    }


    /**
     * Gets the purchaseDate value for this TopupIAPRequestData.
     * 
     * @return purchaseDate
     */
    public java.util.Calendar getPurchaseDate() {
        return purchaseDate;
    }


    /**
     * Sets the purchaseDate value for this TopupIAPRequestData.
     * 
     * @param purchaseDate
     */
    public void setPurchaseDate(java.util.Calendar purchaseDate) {
        this.purchaseDate = purchaseDate;
    }


    /**
     * Gets the quantity value for this TopupIAPRequestData.
     * 
     * @return quantity
     */
    public java.lang.Integer getQuantity() {
        return quantity;
    }


    /**
     * Sets the quantity value for this TopupIAPRequestData.
     * 
     * @param quantity
     */
    public void setQuantity(java.lang.Integer quantity) {
        this.quantity = quantity;
    }


    /**
     * Gets the receiptBase value for this TopupIAPRequestData.
     * 
     * @return receiptBase
     */
    public java.lang.String getReceiptBase() {
        return receiptBase;
    }


    /**
     * Sets the receiptBase value for this TopupIAPRequestData.
     * 
     * @param receiptBase
     */
    public void setReceiptBase(java.lang.String receiptBase) {
        this.receiptBase = receiptBase;
    }


    /**
     * Gets the receiptBaseMD5 value for this TopupIAPRequestData.
     * 
     * @return receiptBaseMD5
     */
    public java.lang.String getReceiptBaseMD5() {
        return receiptBaseMD5;
    }


    /**
     * Sets the receiptBaseMD5 value for this TopupIAPRequestData.
     * 
     * @param receiptBaseMD5
     */
    public void setReceiptBaseMD5(java.lang.String receiptBaseMD5) {
        this.receiptBaseMD5 = receiptBaseMD5;
    }


    /**
     * Gets the receiptData value for this TopupIAPRequestData.
     * 
     * @return receiptData
     */
    public java.lang.String getReceiptData() {
        return receiptData;
    }


    /**
     * Sets the receiptData value for this TopupIAPRequestData.
     * 
     * @param receiptData
     */
    public void setReceiptData(java.lang.String receiptData) {
        this.receiptData = receiptData;
    }


    /**
     * Gets the relatedTransactionID value for this TopupIAPRequestData.
     * 
     * @return relatedTransactionID
     */
    public java.lang.String getRelatedTransactionID() {
        return relatedTransactionID;
    }


    /**
     * Sets the relatedTransactionID value for this TopupIAPRequestData.
     * 
     * @param relatedTransactionID
     */
    public void setRelatedTransactionID(java.lang.String relatedTransactionID) {
        this.relatedTransactionID = relatedTransactionID;
    }


    /**
     * Gets the serviceID value for this TopupIAPRequestData.
     * 
     * @return serviceID
     */
    public java.lang.Integer getServiceID() {
        return serviceID;
    }


    /**
     * Sets the serviceID value for this TopupIAPRequestData.
     * 
     * @param serviceID
     */
    public void setServiceID(java.lang.Integer serviceID) {
        this.serviceID = serviceID;
    }


    /**
     * Gets the serviceKey value for this TopupIAPRequestData.
     * 
     * @return serviceKey
     */
    public java.lang.String getServiceKey() {
        return serviceKey;
    }


    /**
     * Sets the serviceKey value for this TopupIAPRequestData.
     * 
     * @param serviceKey
     */
    public void setServiceKey(java.lang.String serviceKey) {
        this.serviceKey = serviceKey;
    }


    /**
     * Gets the uuid value for this TopupIAPRequestData.
     * 
     * @return uuid
     */
    public java.lang.String getUuid() {
        return uuid;
    }


    /**
     * Sets the uuid value for this TopupIAPRequestData.
     * 
     * @param uuid
     */
    public void setUuid(java.lang.String uuid) {
        this.uuid = uuid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TopupIAPRequestData)) return false;
        TopupIAPRequestData other = (TopupIAPRequestData) obj;
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
            ((this.CPID==null && other.getCPID()==null) || 
             (this.CPID!=null &&
              this.CPID.equals(other.getCPID()))) &&
            ((this.clientIP==null && other.getClientIP()==null) || 
             (this.clientIP!=null &&
              this.clientIP.equals(other.getClientIP()))) &&
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
            ((this.packetID==null && other.getPacketID()==null) || 
             (this.packetID!=null &&
              this.packetID.equals(other.getPacketID()))) &&
            ((this.purchaseDate==null && other.getPurchaseDate()==null) || 
             (this.purchaseDate!=null &&
              this.purchaseDate.equals(other.getPurchaseDate()))) &&
            ((this.quantity==null && other.getQuantity()==null) || 
             (this.quantity!=null &&
              this.quantity.equals(other.getQuantity()))) &&
            ((this.receiptBase==null && other.getReceiptBase()==null) || 
             (this.receiptBase!=null &&
              this.receiptBase.equals(other.getReceiptBase()))) &&
            ((this.receiptBaseMD5==null && other.getReceiptBaseMD5()==null) || 
             (this.receiptBaseMD5!=null &&
              this.receiptBaseMD5.equals(other.getReceiptBaseMD5()))) &&
            ((this.receiptData==null && other.getReceiptData()==null) || 
             (this.receiptData!=null &&
              this.receiptData.equals(other.getReceiptData()))) &&
            ((this.relatedTransactionID==null && other.getRelatedTransactionID()==null) || 
             (this.relatedTransactionID!=null &&
              this.relatedTransactionID.equals(other.getRelatedTransactionID()))) &&
            ((this.serviceID==null && other.getServiceID()==null) || 
             (this.serviceID!=null &&
              this.serviceID.equals(other.getServiceID()))) &&
            ((this.serviceKey==null && other.getServiceKey()==null) || 
             (this.serviceKey!=null &&
              this.serviceKey.equals(other.getServiceKey()))) &&
            ((this.uuid==null && other.getUuid()==null) || 
             (this.uuid!=null &&
              this.uuid.equals(other.getUuid())));
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
        if (getCPID() != null) {
            _hashCode += getCPID().hashCode();
        }
        if (getClientIP() != null) {
            _hashCode += getClientIP().hashCode();
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
        if (getPacketID() != null) {
            _hashCode += getPacketID().hashCode();
        }
        if (getPurchaseDate() != null) {
            _hashCode += getPurchaseDate().hashCode();
        }
        if (getQuantity() != null) {
            _hashCode += getQuantity().hashCode();
        }
        if (getReceiptBase() != null) {
            _hashCode += getReceiptBase().hashCode();
        }
        if (getReceiptBaseMD5() != null) {
            _hashCode += getReceiptBaseMD5().hashCode();
        }
        if (getReceiptData() != null) {
            _hashCode += getReceiptData().hashCode();
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
        if (getUuid() != null) {
            _hashCode += getUuid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TopupIAPRequestData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "TopupIAPRequestData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("packetID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "PacketID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("purchaseDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "PurchaseDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "Quantity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiptBase");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "ReceiptBase"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiptBaseMD5");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "ReceiptBaseMD5"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiptData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "ReceiptData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relatedTransactionID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "RelatedTransactionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
        elemField.setFieldName("uuid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "Uuid"));
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
