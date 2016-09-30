/**
 * ChangeQuestionRequestData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.model.update;

public class ChangeQuestionRequestData  extends com.vtc.ws.v2.model.RequestData  implements java.io.Serializable {
    private java.lang.String accountName;

    private java.lang.String answer;

    private java.lang.String clientIP;

    private java.lang.String email;

    private java.lang.String mobile;

    private java.lang.String newAnswer;

    private java.lang.Integer newQuestionID;

    private java.lang.String passport;

    private java.lang.Integer questionID;

    private java.lang.String secureCode;

    private org.apache.axis.types.UnsignedByte type;

    public ChangeQuestionRequestData() {
    }

    public ChangeQuestionRequestData(
           java.lang.String sign,
           java.lang.String accountName,
           java.lang.String answer,
           java.lang.String clientIP,
           java.lang.String email,
           java.lang.String mobile,
           java.lang.String newAnswer,
           java.lang.Integer newQuestionID,
           java.lang.String passport,
           java.lang.Integer questionID,
           java.lang.String secureCode,
           org.apache.axis.types.UnsignedByte type) {
        super(
            sign);
        this.accountName = accountName;
        this.answer = answer;
        this.clientIP = clientIP;
        this.email = email;
        this.mobile = mobile;
        this.newAnswer = newAnswer;
        this.newQuestionID = newQuestionID;
        this.passport = passport;
        this.questionID = questionID;
        this.secureCode = secureCode;
        this.type = type;
    }


    /**
     * Gets the accountName value for this ChangeQuestionRequestData.
     * 
     * @return accountName
     */
    public java.lang.String getAccountName() {
        return accountName;
    }


    /**
     * Sets the accountName value for this ChangeQuestionRequestData.
     * 
     * @param accountName
     */
    public void setAccountName(java.lang.String accountName) {
        this.accountName = accountName;
    }


    /**
     * Gets the answer value for this ChangeQuestionRequestData.
     * 
     * @return answer
     */
    public java.lang.String getAnswer() {
        return answer;
    }


    /**
     * Sets the answer value for this ChangeQuestionRequestData.
     * 
     * @param answer
     */
    public void setAnswer(java.lang.String answer) {
        this.answer = answer;
    }


    /**
     * Gets the clientIP value for this ChangeQuestionRequestData.
     * 
     * @return clientIP
     */
    public java.lang.String getClientIP() {
        return clientIP;
    }


    /**
     * Sets the clientIP value for this ChangeQuestionRequestData.
     * 
     * @param clientIP
     */
    public void setClientIP(java.lang.String clientIP) {
        this.clientIP = clientIP;
    }


    /**
     * Gets the email value for this ChangeQuestionRequestData.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this ChangeQuestionRequestData.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the mobile value for this ChangeQuestionRequestData.
     * 
     * @return mobile
     */
    public java.lang.String getMobile() {
        return mobile;
    }


    /**
     * Sets the mobile value for this ChangeQuestionRequestData.
     * 
     * @param mobile
     */
    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }


    /**
     * Gets the newAnswer value for this ChangeQuestionRequestData.
     * 
     * @return newAnswer
     */
    public java.lang.String getNewAnswer() {
        return newAnswer;
    }


    /**
     * Sets the newAnswer value for this ChangeQuestionRequestData.
     * 
     * @param newAnswer
     */
    public void setNewAnswer(java.lang.String newAnswer) {
        this.newAnswer = newAnswer;
    }


    /**
     * Gets the newQuestionID value for this ChangeQuestionRequestData.
     * 
     * @return newQuestionID
     */
    public java.lang.Integer getNewQuestionID() {
        return newQuestionID;
    }


    /**
     * Sets the newQuestionID value for this ChangeQuestionRequestData.
     * 
     * @param newQuestionID
     */
    public void setNewQuestionID(java.lang.Integer newQuestionID) {
        this.newQuestionID = newQuestionID;
    }


    /**
     * Gets the passport value for this ChangeQuestionRequestData.
     * 
     * @return passport
     */
    public java.lang.String getPassport() {
        return passport;
    }


    /**
     * Sets the passport value for this ChangeQuestionRequestData.
     * 
     * @param passport
     */
    public void setPassport(java.lang.String passport) {
        this.passport = passport;
    }


    /**
     * Gets the questionID value for this ChangeQuestionRequestData.
     * 
     * @return questionID
     */
    public java.lang.Integer getQuestionID() {
        return questionID;
    }


    /**
     * Sets the questionID value for this ChangeQuestionRequestData.
     * 
     * @param questionID
     */
    public void setQuestionID(java.lang.Integer questionID) {
        this.questionID = questionID;
    }


    /**
     * Gets the secureCode value for this ChangeQuestionRequestData.
     * 
     * @return secureCode
     */
    public java.lang.String getSecureCode() {
        return secureCode;
    }


    /**
     * Sets the secureCode value for this ChangeQuestionRequestData.
     * 
     * @param secureCode
     */
    public void setSecureCode(java.lang.String secureCode) {
        this.secureCode = secureCode;
    }


    /**
     * Gets the type value for this ChangeQuestionRequestData.
     * 
     * @return type
     */
    public org.apache.axis.types.UnsignedByte getType() {
        return type;
    }


    /**
     * Sets the type value for this ChangeQuestionRequestData.
     * 
     * @param type
     */
    public void setType(org.apache.axis.types.UnsignedByte type) {
        this.type = type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ChangeQuestionRequestData)) return false;
        ChangeQuestionRequestData other = (ChangeQuestionRequestData) obj;
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
            ((this.answer==null && other.getAnswer()==null) || 
             (this.answer!=null &&
              this.answer.equals(other.getAnswer()))) &&
            ((this.clientIP==null && other.getClientIP()==null) || 
             (this.clientIP!=null &&
              this.clientIP.equals(other.getClientIP()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.mobile==null && other.getMobile()==null) || 
             (this.mobile!=null &&
              this.mobile.equals(other.getMobile()))) &&
            ((this.newAnswer==null && other.getNewAnswer()==null) || 
             (this.newAnswer!=null &&
              this.newAnswer.equals(other.getNewAnswer()))) &&
            ((this.newQuestionID==null && other.getNewQuestionID()==null) || 
             (this.newQuestionID!=null &&
              this.newQuestionID.equals(other.getNewQuestionID()))) &&
            ((this.passport==null && other.getPassport()==null) || 
             (this.passport!=null &&
              this.passport.equals(other.getPassport()))) &&
            ((this.questionID==null && other.getQuestionID()==null) || 
             (this.questionID!=null &&
              this.questionID.equals(other.getQuestionID()))) &&
            ((this.secureCode==null && other.getSecureCode()==null) || 
             (this.secureCode!=null &&
              this.secureCode.equals(other.getSecureCode()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType())));
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
        if (getAnswer() != null) {
            _hashCode += getAnswer().hashCode();
        }
        if (getClientIP() != null) {
            _hashCode += getClientIP().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getMobile() != null) {
            _hashCode += getMobile().hashCode();
        }
        if (getNewAnswer() != null) {
            _hashCode += getNewAnswer().hashCode();
        }
        if (getNewQuestionID() != null) {
            _hashCode += getNewQuestionID().hashCode();
        }
        if (getPassport() != null) {
            _hashCode += getPassport().hashCode();
        }
        if (getQuestionID() != null) {
            _hashCode += getQuestionID().hashCode();
        }
        if (getSecureCode() != null) {
            _hashCode += getSecureCode().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ChangeQuestionRequestData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "ChangeQuestionRequestData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "AccountName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("answer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "Answer"));
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
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "Email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "Mobile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newAnswer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "NewAnswer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newQuestionID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "NewQuestionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("passport");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "Passport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("questionID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "QuestionID"));
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
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/VTCApp.WcfService.BankModels", "Type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
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
