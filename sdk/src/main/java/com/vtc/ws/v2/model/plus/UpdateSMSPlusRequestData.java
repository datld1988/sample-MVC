/**
 * UpdateSMSPlusRequestData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.model.plus;

public class UpdateSMSPlusRequestData  implements java.io.Serializable {
    private java.lang.Integer accountID;

    private java.lang.String accountName;

    private java.lang.Integer adv;

    private java.lang.Integer chudong;

    private java.lang.String code;

    private java.lang.Integer desc;

    private java.lang.Integer inc;

    private java.lang.Integer minAmount;

    private java.lang.Integer payment;

    public UpdateSMSPlusRequestData() {
    }

    public UpdateSMSPlusRequestData(
           java.lang.Integer accountID,
           java.lang.String accountName,
           java.lang.Integer adv,
           java.lang.Integer chudong,
           java.lang.String code,
           java.lang.Integer desc,
           java.lang.Integer inc,
           java.lang.Integer minAmount,
           java.lang.Integer payment) {
           this.accountID = accountID;
           this.accountName = accountName;
           this.adv = adv;
           this.chudong = chudong;
           this.code = code;
           this.desc = desc;
           this.inc = inc;
           this.minAmount = minAmount;
           this.payment = payment;
    }


    /**
     * Gets the accountID value for this UpdateSMSPlusRequestData.
     * 
     * @return accountID
     */
    public java.lang.Integer getAccountID() {
        return accountID;
    }


    /**
     * Sets the accountID value for this UpdateSMSPlusRequestData.
     * 
     * @param accountID
     */
    public void setAccountID(java.lang.Integer accountID) {
        this.accountID = accountID;
    }


    /**
     * Gets the accountName value for this UpdateSMSPlusRequestData.
     * 
     * @return accountName
     */
    public java.lang.String getAccountName() {
        return accountName;
    }


    /**
     * Sets the accountName value for this UpdateSMSPlusRequestData.
     * 
     * @param accountName
     */
    public void setAccountName(java.lang.String accountName) {
        this.accountName = accountName;
    }


    /**
     * Gets the adv value for this UpdateSMSPlusRequestData.
     * 
     * @return adv
     */
    public java.lang.Integer getAdv() {
        return adv;
    }


    /**
     * Sets the adv value for this UpdateSMSPlusRequestData.
     * 
     * @param adv
     */
    public void setAdv(java.lang.Integer adv) {
        this.adv = adv;
    }


    /**
     * Gets the chudong value for this UpdateSMSPlusRequestData.
     * 
     * @return chudong
     */
    public java.lang.Integer getChudong() {
        return chudong;
    }


    /**
     * Sets the chudong value for this UpdateSMSPlusRequestData.
     * 
     * @param chudong
     */
    public void setChudong(java.lang.Integer chudong) {
        this.chudong = chudong;
    }


    /**
     * Gets the code value for this UpdateSMSPlusRequestData.
     * 
     * @return code
     */
    public java.lang.String getCode() {
        return code;
    }


    /**
     * Sets the code value for this UpdateSMSPlusRequestData.
     * 
     * @param code
     */
    public void setCode(java.lang.String code) {
        this.code = code;
    }


    /**
     * Gets the desc value for this UpdateSMSPlusRequestData.
     * 
     * @return desc
     */
    public java.lang.Integer getDesc() {
        return desc;
    }


    /**
     * Sets the desc value for this UpdateSMSPlusRequestData.
     * 
     * @param desc
     */
    public void setDesc(java.lang.Integer desc) {
        this.desc = desc;
    }


    /**
     * Gets the inc value for this UpdateSMSPlusRequestData.
     * 
     * @return inc
     */
    public java.lang.Integer getInc() {
        return inc;
    }


    /**
     * Sets the inc value for this UpdateSMSPlusRequestData.
     * 
     * @param inc
     */
    public void setInc(java.lang.Integer inc) {
        this.inc = inc;
    }


    /**
     * Gets the minAmount value for this UpdateSMSPlusRequestData.
     * 
     * @return minAmount
     */
    public java.lang.Integer getMinAmount() {
        return minAmount;
    }


    /**
     * Sets the minAmount value for this UpdateSMSPlusRequestData.
     * 
     * @param minAmount
     */
    public void setMinAmount(java.lang.Integer minAmount) {
        this.minAmount = minAmount;
    }


    /**
     * Gets the payment value for this UpdateSMSPlusRequestData.
     * 
     * @return payment
     */
    public java.lang.Integer getPayment() {
        return payment;
    }


    /**
     * Sets the payment value for this UpdateSMSPlusRequestData.
     * 
     * @param payment
     */
    public void setPayment(java.lang.Integer payment) {
        this.payment = payment;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UpdateSMSPlusRequestData)) return false;
        UpdateSMSPlusRequestData other = (UpdateSMSPlusRequestData) obj;
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
            ((this.accountName==null && other.getAccountName()==null) || 
             (this.accountName!=null &&
              this.accountName.equals(other.getAccountName()))) &&
            ((this.adv==null && other.getAdv()==null) || 
             (this.adv!=null &&
              this.adv.equals(other.getAdv()))) &&
            ((this.chudong==null && other.getChudong()==null) || 
             (this.chudong!=null &&
              this.chudong.equals(other.getChudong()))) &&
            ((this.code==null && other.getCode()==null) || 
             (this.code!=null &&
              this.code.equals(other.getCode()))) &&
            ((this.desc==null && other.getDesc()==null) || 
             (this.desc!=null &&
              this.desc.equals(other.getDesc()))) &&
            ((this.inc==null && other.getInc()==null) || 
             (this.inc!=null &&
              this.inc.equals(other.getInc()))) &&
            ((this.minAmount==null && other.getMinAmount()==null) || 
             (this.minAmount!=null &&
              this.minAmount.equals(other.getMinAmount()))) &&
            ((this.payment==null && other.getPayment()==null) || 
             (this.payment!=null &&
              this.payment.equals(other.getPayment())));
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
        if (getAccountName() != null) {
            _hashCode += getAccountName().hashCode();
        }
        if (getAdv() != null) {
            _hashCode += getAdv().hashCode();
        }
        if (getChudong() != null) {
            _hashCode += getChudong().hashCode();
        }
        if (getCode() != null) {
            _hashCode += getCode().hashCode();
        }
        if (getDesc() != null) {
            _hashCode += getDesc().hashCode();
        }
        if (getInc() != null) {
            _hashCode += getInc().hashCode();
        }
        if (getMinAmount() != null) {
            _hashCode += getMinAmount().hashCode();
        }
        if (getPayment() != null) {
            _hashCode += getPayment().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UpdateSMSPlusRequestData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "UpdateSMSPlusRequestData"));
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
        elemField.setFieldName("adv");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "Adv"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chudong");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "Chudong"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "Code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("desc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "Desc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "Inc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("minAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "MinAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "Payment"));
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
