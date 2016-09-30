/**
 * TransactionHistory.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.model.info;

public class TransactionHistory  implements java.io.Serializable {
    private java.lang.Long accountID;

    private java.lang.String clientIP;

    private java.util.Calendar dateUse;

    private java.lang.String description;

    private java.lang.String inOut;

    private java.lang.String serviceName;

    private java.lang.Integer transType;

    private java.lang.Long transactionID;

    private java.lang.Integer vcoin;

    public TransactionHistory() {
    }

    public TransactionHistory(
           java.lang.Long accountID,
           java.lang.String clientIP,
           java.util.Calendar dateUse,
           java.lang.String description,
           java.lang.String inOut,
           java.lang.String serviceName,
           java.lang.Integer transType,
           java.lang.Long transactionID,
           java.lang.Integer vcoin) {
           this.accountID = accountID;
           this.clientIP = clientIP;
           this.dateUse = dateUse;
           this.description = description;
           this.inOut = inOut;
           this.serviceName = serviceName;
           this.transType = transType;
           this.transactionID = transactionID;
           this.vcoin = vcoin;
    }


    /**
     * Gets the accountID value for this TransactionHistory.
     * 
     * @return accountID
     */
    public java.lang.Long getAccountID() {
        return accountID;
    }


    /**
     * Sets the accountID value for this TransactionHistory.
     * 
     * @param accountID
     */
    public void setAccountID(java.lang.Long accountID) {
        this.accountID = accountID;
    }


    /**
     * Gets the clientIP value for this TransactionHistory.
     * 
     * @return clientIP
     */
    public java.lang.String getClientIP() {
        return clientIP;
    }


    /**
     * Sets the clientIP value for this TransactionHistory.
     * 
     * @param clientIP
     */
    public void setClientIP(java.lang.String clientIP) {
        this.clientIP = clientIP;
    }


    /**
     * Gets the dateUse value for this TransactionHistory.
     * 
     * @return dateUse
     */
    public java.util.Calendar getDateUse() {
        return dateUse;
    }


    /**
     * Sets the dateUse value for this TransactionHistory.
     * 
     * @param dateUse
     */
    public void setDateUse(java.util.Calendar dateUse) {
        this.dateUse = dateUse;
    }


    /**
     * Gets the description value for this TransactionHistory.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this TransactionHistory.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the inOut value for this TransactionHistory.
     * 
     * @return inOut
     */
    public java.lang.String getInOut() {
        return inOut;
    }


    /**
     * Sets the inOut value for this TransactionHistory.
     * 
     * @param inOut
     */
    public void setInOut(java.lang.String inOut) {
        this.inOut = inOut;
    }


    /**
     * Gets the serviceName value for this TransactionHistory.
     * 
     * @return serviceName
     */
    public java.lang.String getServiceName() {
        return serviceName;
    }


    /**
     * Sets the serviceName value for this TransactionHistory.
     * 
     * @param serviceName
     */
    public void setServiceName(java.lang.String serviceName) {
        this.serviceName = serviceName;
    }


    /**
     * Gets the transType value for this TransactionHistory.
     * 
     * @return transType
     */
    public java.lang.Integer getTransType() {
        return transType;
    }


    /**
     * Sets the transType value for this TransactionHistory.
     * 
     * @param transType
     */
    public void setTransType(java.lang.Integer transType) {
        this.transType = transType;
    }


    /**
     * Gets the transactionID value for this TransactionHistory.
     * 
     * @return transactionID
     */
    public java.lang.Long getTransactionID() {
        return transactionID;
    }


    /**
     * Sets the transactionID value for this TransactionHistory.
     * 
     * @param transactionID
     */
    public void setTransactionID(java.lang.Long transactionID) {
        this.transactionID = transactionID;
    }


    /**
     * Gets the vcoin value for this TransactionHistory.
     * 
     * @return vcoin
     */
    public java.lang.Integer getVcoin() {
        return vcoin;
    }


    /**
     * Sets the vcoin value for this TransactionHistory.
     * 
     * @param vcoin
     */
    public void setVcoin(java.lang.Integer vcoin) {
        this.vcoin = vcoin;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TransactionHistory)) return false;
        TransactionHistory other = (TransactionHistory) obj;
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
            ((this.clientIP==null && other.getClientIP()==null) || 
             (this.clientIP!=null &&
              this.clientIP.equals(other.getClientIP()))) &&
            ((this.dateUse==null && other.getDateUse()==null) || 
             (this.dateUse!=null &&
              this.dateUse.equals(other.getDateUse()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.inOut==null && other.getInOut()==null) || 
             (this.inOut!=null &&
              this.inOut.equals(other.getInOut()))) &&
            ((this.serviceName==null && other.getServiceName()==null) || 
             (this.serviceName!=null &&
              this.serviceName.equals(other.getServiceName()))) &&
            ((this.transType==null && other.getTransType()==null) || 
             (this.transType!=null &&
              this.transType.equals(other.getTransType()))) &&
            ((this.transactionID==null && other.getTransactionID()==null) || 
             (this.transactionID!=null &&
              this.transactionID.equals(other.getTransactionID()))) &&
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
        if (getAccountID() != null) {
            _hashCode += getAccountID().hashCode();
        }
        if (getClientIP() != null) {
            _hashCode += getClientIP().hashCode();
        }
        if (getDateUse() != null) {
            _hashCode += getDateUse().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getInOut() != null) {
            _hashCode += getInOut().hashCode();
        }
        if (getServiceName() != null) {
            _hashCode += getServiceName().hashCode();
        }
        if (getTransType() != null) {
            _hashCode += getTransType().hashCode();
        }
        if (getTransactionID() != null) {
            _hashCode += getTransactionID().hashCode();
        }
        if (getVcoin() != null) {
            _hashCode += getVcoin().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TransactionHistory.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "TransactionHistory"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "AccountID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientIP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "ClientIP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateUse");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "DateUse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "Description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inOut");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "InOut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "ServiceName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "TransType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "TransactionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vcoin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "Vcoin"));
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
