/**
 * TopupIAPRequestData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.model.transaction;

public class TopupIAPRequestData  extends com.vtc.ws.v2.model.TopupIAPRequestData  implements java.io.Serializable {
    private java.lang.Integer deductServiceID;

    private java.lang.String deductServiceKey;

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
           java.lang.String uuid,
           java.lang.Integer deductServiceID,
           java.lang.String deductServiceKey) {
        super(
            sign,
            accountName,
            CPID,
            clientIP,
            createdUserID,
            createdUserName,
            description,
            deviceType,
            packetID,
            purchaseDate,
            quantity,
            receiptBase,
            receiptBaseMD5,
            receiptData,
            relatedTransactionID,
            serviceID,
            serviceKey,
            uuid);
        this.deductServiceID = deductServiceID;
        this.deductServiceKey = deductServiceKey;
    }


    /**
     * Gets the deductServiceID value for this TopupIAPRequestData.
     * 
     * @return deductServiceID
     */
    public java.lang.Integer getDeductServiceID() {
        return deductServiceID;
    }


    /**
     * Sets the deductServiceID value for this TopupIAPRequestData.
     * 
     * @param deductServiceID
     */
    public void setDeductServiceID(java.lang.Integer deductServiceID) {
        this.deductServiceID = deductServiceID;
    }


    /**
     * Gets the deductServiceKey value for this TopupIAPRequestData.
     * 
     * @return deductServiceKey
     */
    public java.lang.String getDeductServiceKey() {
        return deductServiceKey;
    }


    /**
     * Sets the deductServiceKey value for this TopupIAPRequestData.
     * 
     * @param deductServiceKey
     */
    public void setDeductServiceKey(java.lang.String deductServiceKey) {
        this.deductServiceKey = deductServiceKey;
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
            ((this.deductServiceID==null && other.getDeductServiceID()==null) || 
             (this.deductServiceID!=null &&
              this.deductServiceID.equals(other.getDeductServiceID()))) &&
            ((this.deductServiceKey==null && other.getDeductServiceKey()==null) || 
             (this.deductServiceKey!=null &&
              this.deductServiceKey.equals(other.getDeductServiceKey())));
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
        if (getDeductServiceID() != null) {
            _hashCode += getDeductServiceID().hashCode();
        }
        if (getDeductServiceKey() != null) {
            _hashCode += getDeductServiceKey().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TopupIAPRequestData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.GameService.Models", "TopupIAPRequestData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deductServiceID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.GameService.Models", "DeductServiceID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deductServiceKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.GameService.Models", "DeductServiceKey"));
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
