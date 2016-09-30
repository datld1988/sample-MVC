/**
 * AccountFull.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vtc.ws.v2.model.info;

public class AccountFull  extends com.vtc.ws.v2.model.info.Account  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedByte accountTypeID;

    private java.lang.String address;

    private java.lang.String answer;

    private java.util.Calendar birthday;

    private java.lang.Integer birthdayUnixTime;

    private java.lang.String captcha;

    private java.util.Calendar changedTime;

    private java.lang.Integer confirmCode;

    private java.lang.Integer districtID;

    private java.lang.Integer error;

    private java.lang.Integer freezeVcoin;

    private java.lang.String fullName;

    private java.lang.String gameService;

    private org.apache.axis.types.UnsignedByte gender;

    private java.lang.Boolean isUpdateSecurityInfo;

    private java.lang.Integer joinFrom;

    private java.util.Calendar lastLoginedTime;

    private java.lang.Integer locationID;

    private java.lang.Integer nationalID;

    private java.lang.Long partnerAccountID;

    private java.lang.String passport;

    private java.lang.Integer paygateID;

    private java.lang.Integer questionID;

    private java.lang.Boolean receiveEmail;

    private java.lang.String smsPlusMobile;

    private java.lang.Integer totalVcoin;

    private java.lang.Integer totalVcoinPayment;

    private java.lang.Integer userSN;

    private java.lang.Integer VCoin;

    private java.lang.Integer VCoinPayment;

    private org.apache.axis.types.UnsignedByte verifiedType;

    private java.lang.Integer wardID;

    public AccountFull() {
    }

    public AccountFull(
           java.lang.Integer accountID,
           java.lang.String accountName,
           java.lang.String email,
           java.util.Calendar joinedTime,
           java.lang.Integer joinedUnixTime,
           java.lang.String mobile,
           java.lang.String password,
           java.lang.Integer status,
           org.apache.axis.types.UnsignedByte accountTypeID,
           java.lang.String address,
           java.lang.String answer,
           java.util.Calendar birthday,
           java.lang.Integer birthdayUnixTime,
           java.lang.String captcha,
           java.util.Calendar changedTime,
           java.lang.Integer confirmCode,
           java.lang.Integer districtID,
           java.lang.Integer error,
           java.lang.Integer freezeVcoin,
           java.lang.String fullName,
           java.lang.String gameService,
           org.apache.axis.types.UnsignedByte gender,
           java.lang.Boolean isUpdateSecurityInfo,
           java.lang.Integer joinFrom,
           java.util.Calendar lastLoginedTime,
           java.lang.Integer locationID,
           java.lang.Integer nationalID,
           java.lang.Long partnerAccountID,
           java.lang.String passport,
           java.lang.Integer paygateID,
           java.lang.Integer questionID,
           java.lang.Boolean receiveEmail,
           java.lang.String smsPlusMobile,
           java.lang.Integer totalVcoin,
           java.lang.Integer totalVcoinPayment,
           java.lang.Integer userSN,
           java.lang.Integer VCoin,
           java.lang.Integer VCoinPayment,
           org.apache.axis.types.UnsignedByte verifiedType,
           java.lang.Integer wardID) {
        super(
            accountID,
            accountName,
            email,
            joinedTime,
            joinedUnixTime,
            mobile,
            password,
            status);
        this.accountTypeID = accountTypeID;
        this.address = address;
        this.answer = answer;
        this.birthday = birthday;
        this.birthdayUnixTime = birthdayUnixTime;
        this.captcha = captcha;
        this.changedTime = changedTime;
        this.confirmCode = confirmCode;
        this.districtID = districtID;
        this.error = error;
        this.freezeVcoin = freezeVcoin;
        this.fullName = fullName;
        this.gameService = gameService;
        this.gender = gender;
        this.isUpdateSecurityInfo = isUpdateSecurityInfo;
        this.joinFrom = joinFrom;
        this.lastLoginedTime = lastLoginedTime;
        this.locationID = locationID;
        this.nationalID = nationalID;
        this.partnerAccountID = partnerAccountID;
        this.passport = passport;
        this.paygateID = paygateID;
        this.questionID = questionID;
        this.receiveEmail = receiveEmail;
        this.smsPlusMobile = smsPlusMobile;
        this.totalVcoin = totalVcoin;
        this.totalVcoinPayment = totalVcoinPayment;
        this.userSN = userSN;
        this.VCoin = VCoin;
        this.VCoinPayment = VCoinPayment;
        this.verifiedType = verifiedType;
        this.wardID = wardID;
    }


    /**
     * Gets the accountTypeID value for this AccountFull.
     * 
     * @return accountTypeID
     */
    public org.apache.axis.types.UnsignedByte getAccountTypeID() {
        return accountTypeID;
    }


    /**
     * Sets the accountTypeID value for this AccountFull.
     * 
     * @param accountTypeID
     */
    public void setAccountTypeID(org.apache.axis.types.UnsignedByte accountTypeID) {
        this.accountTypeID = accountTypeID;
    }


    /**
     * Gets the address value for this AccountFull.
     * 
     * @return address
     */
    public java.lang.String getAddress() {
        return address;
    }


    /**
     * Sets the address value for this AccountFull.
     * 
     * @param address
     */
    public void setAddress(java.lang.String address) {
        this.address = address;
    }


    /**
     * Gets the answer value for this AccountFull.
     * 
     * @return answer
     */
    public java.lang.String getAnswer() {
        return answer;
    }


    /**
     * Sets the answer value for this AccountFull.
     * 
     * @param answer
     */
    public void setAnswer(java.lang.String answer) {
        this.answer = answer;
    }


    /**
     * Gets the birthday value for this AccountFull.
     * 
     * @return birthday
     */
    public java.util.Calendar getBirthday() {
        return birthday;
    }


    /**
     * Sets the birthday value for this AccountFull.
     * 
     * @param birthday
     */
    public void setBirthday(java.util.Calendar birthday) {
        this.birthday = birthday;
    }


    /**
     * Gets the birthdayUnixTime value for this AccountFull.
     * 
     * @return birthdayUnixTime
     */
    public java.lang.Integer getBirthdayUnixTime() {
        return birthdayUnixTime;
    }


    /**
     * Sets the birthdayUnixTime value for this AccountFull.
     * 
     * @param birthdayUnixTime
     */
    public void setBirthdayUnixTime(java.lang.Integer birthdayUnixTime) {
        this.birthdayUnixTime = birthdayUnixTime;
    }


    /**
     * Gets the captcha value for this AccountFull.
     * 
     * @return captcha
     */
    public java.lang.String getCaptcha() {
        return captcha;
    }


    /**
     * Sets the captcha value for this AccountFull.
     * 
     * @param captcha
     */
    public void setCaptcha(java.lang.String captcha) {
        this.captcha = captcha;
    }


    /**
     * Gets the changedTime value for this AccountFull.
     * 
     * @return changedTime
     */
    public java.util.Calendar getChangedTime() {
        return changedTime;
    }


    /**
     * Sets the changedTime value for this AccountFull.
     * 
     * @param changedTime
     */
    public void setChangedTime(java.util.Calendar changedTime) {
        this.changedTime = changedTime;
    }


    /**
     * Gets the confirmCode value for this AccountFull.
     * 
     * @return confirmCode
     */
    public java.lang.Integer getConfirmCode() {
        return confirmCode;
    }


    /**
     * Sets the confirmCode value for this AccountFull.
     * 
     * @param confirmCode
     */
    public void setConfirmCode(java.lang.Integer confirmCode) {
        this.confirmCode = confirmCode;
    }


    /**
     * Gets the districtID value for this AccountFull.
     * 
     * @return districtID
     */
    public java.lang.Integer getDistrictID() {
        return districtID;
    }


    /**
     * Sets the districtID value for this AccountFull.
     * 
     * @param districtID
     */
    public void setDistrictID(java.lang.Integer districtID) {
        this.districtID = districtID;
    }


    /**
     * Gets the error value for this AccountFull.
     * 
     * @return error
     */
    public java.lang.Integer getError() {
        return error;
    }


    /**
     * Sets the error value for this AccountFull.
     * 
     * @param error
     */
    public void setError(java.lang.Integer error) {
        this.error = error;
    }


    /**
     * Gets the freezeVcoin value for this AccountFull.
     * 
     * @return freezeVcoin
     */
    public java.lang.Integer getFreezeVcoin() {
        return freezeVcoin;
    }


    /**
     * Sets the freezeVcoin value for this AccountFull.
     * 
     * @param freezeVcoin
     */
    public void setFreezeVcoin(java.lang.Integer freezeVcoin) {
        this.freezeVcoin = freezeVcoin;
    }


    /**
     * Gets the fullName value for this AccountFull.
     * 
     * @return fullName
     */
    public java.lang.String getFullName() {
        return fullName;
    }


    /**
     * Sets the fullName value for this AccountFull.
     * 
     * @param fullName
     */
    public void setFullName(java.lang.String fullName) {
        this.fullName = fullName;
    }


    /**
     * Gets the gameService value for this AccountFull.
     * 
     * @return gameService
     */
    public java.lang.String getGameService() {
        return gameService;
    }


    /**
     * Sets the gameService value for this AccountFull.
     * 
     * @param gameService
     */
    public void setGameService(java.lang.String gameService) {
        this.gameService = gameService;
    }


    /**
     * Gets the gender value for this AccountFull.
     * 
     * @return gender
     */
    public org.apache.axis.types.UnsignedByte getGender() {
        return gender;
    }


    /**
     * Sets the gender value for this AccountFull.
     * 
     * @param gender
     */
    public void setGender(org.apache.axis.types.UnsignedByte gender) {
        this.gender = gender;
    }


    /**
     * Gets the isUpdateSecurityInfo value for this AccountFull.
     * 
     * @return isUpdateSecurityInfo
     */
    public java.lang.Boolean getIsUpdateSecurityInfo() {
        return isUpdateSecurityInfo;
    }


    /**
     * Sets the isUpdateSecurityInfo value for this AccountFull.
     * 
     * @param isUpdateSecurityInfo
     */
    public void setIsUpdateSecurityInfo(java.lang.Boolean isUpdateSecurityInfo) {
        this.isUpdateSecurityInfo = isUpdateSecurityInfo;
    }


    /**
     * Gets the joinFrom value for this AccountFull.
     * 
     * @return joinFrom
     */
    public java.lang.Integer getJoinFrom() {
        return joinFrom;
    }


    /**
     * Sets the joinFrom value for this AccountFull.
     * 
     * @param joinFrom
     */
    public void setJoinFrom(java.lang.Integer joinFrom) {
        this.joinFrom = joinFrom;
    }


    /**
     * Gets the lastLoginedTime value for this AccountFull.
     * 
     * @return lastLoginedTime
     */
    public java.util.Calendar getLastLoginedTime() {
        return lastLoginedTime;
    }


    /**
     * Sets the lastLoginedTime value for this AccountFull.
     * 
     * @param lastLoginedTime
     */
    public void setLastLoginedTime(java.util.Calendar lastLoginedTime) {
        this.lastLoginedTime = lastLoginedTime;
    }


    /**
     * Gets the locationID value for this AccountFull.
     * 
     * @return locationID
     */
    public java.lang.Integer getLocationID() {
        return locationID;
    }


    /**
     * Sets the locationID value for this AccountFull.
     * 
     * @param locationID
     */
    public void setLocationID(java.lang.Integer locationID) {
        this.locationID = locationID;
    }


    /**
     * Gets the nationalID value for this AccountFull.
     * 
     * @return nationalID
     */
    public java.lang.Integer getNationalID() {
        return nationalID;
    }


    /**
     * Sets the nationalID value for this AccountFull.
     * 
     * @param nationalID
     */
    public void setNationalID(java.lang.Integer nationalID) {
        this.nationalID = nationalID;
    }


    /**
     * Gets the partnerAccountID value for this AccountFull.
     * 
     * @return partnerAccountID
     */
    public java.lang.Long getPartnerAccountID() {
        return partnerAccountID;
    }


    /**
     * Sets the partnerAccountID value for this AccountFull.
     * 
     * @param partnerAccountID
     */
    public void setPartnerAccountID(java.lang.Long partnerAccountID) {
        this.partnerAccountID = partnerAccountID;
    }


    /**
     * Gets the passport value for this AccountFull.
     * 
     * @return passport
     */
    public java.lang.String getPassport() {
        return passport;
    }


    /**
     * Sets the passport value for this AccountFull.
     * 
     * @param passport
     */
    public void setPassport(java.lang.String passport) {
        this.passport = passport;
    }


    /**
     * Gets the paygateID value for this AccountFull.
     * 
     * @return paygateID
     */
    public java.lang.Integer getPaygateID() {
        return paygateID;
    }


    /**
     * Sets the paygateID value for this AccountFull.
     * 
     * @param paygateID
     */
    public void setPaygateID(java.lang.Integer paygateID) {
        this.paygateID = paygateID;
    }


    /**
     * Gets the questionID value for this AccountFull.
     * 
     * @return questionID
     */
    public java.lang.Integer getQuestionID() {
        return questionID;
    }


    /**
     * Sets the questionID value for this AccountFull.
     * 
     * @param questionID
     */
    public void setQuestionID(java.lang.Integer questionID) {
        this.questionID = questionID;
    }


    /**
     * Gets the receiveEmail value for this AccountFull.
     * 
     * @return receiveEmail
     */
    public java.lang.Boolean getReceiveEmail() {
        return receiveEmail;
    }


    /**
     * Sets the receiveEmail value for this AccountFull.
     * 
     * @param receiveEmail
     */
    public void setReceiveEmail(java.lang.Boolean receiveEmail) {
        this.receiveEmail = receiveEmail;
    }


    /**
     * Gets the smsPlusMobile value for this AccountFull.
     * 
     * @return smsPlusMobile
     */
    public java.lang.String getSmsPlusMobile() {
        return smsPlusMobile;
    }


    /**
     * Sets the smsPlusMobile value for this AccountFull.
     * 
     * @param smsPlusMobile
     */
    public void setSmsPlusMobile(java.lang.String smsPlusMobile) {
        this.smsPlusMobile = smsPlusMobile;
    }


    /**
     * Gets the totalVcoin value for this AccountFull.
     * 
     * @return totalVcoin
     */
    public java.lang.Integer getTotalVcoin() {
        return totalVcoin;
    }


    /**
     * Sets the totalVcoin value for this AccountFull.
     * 
     * @param totalVcoin
     */
    public void setTotalVcoin(java.lang.Integer totalVcoin) {
        this.totalVcoin = totalVcoin;
    }


    /**
     * Gets the totalVcoinPayment value for this AccountFull.
     * 
     * @return totalVcoinPayment
     */
    public java.lang.Integer getTotalVcoinPayment() {
        return totalVcoinPayment;
    }


    /**
     * Sets the totalVcoinPayment value for this AccountFull.
     * 
     * @param totalVcoinPayment
     */
    public void setTotalVcoinPayment(java.lang.Integer totalVcoinPayment) {
        this.totalVcoinPayment = totalVcoinPayment;
    }


    /**
     * Gets the userSN value for this AccountFull.
     * 
     * @return userSN
     */
    public java.lang.Integer getUserSN() {
        return userSN;
    }


    /**
     * Sets the userSN value for this AccountFull.
     * 
     * @param userSN
     */
    public void setUserSN(java.lang.Integer userSN) {
        this.userSN = userSN;
    }


    /**
     * Gets the VCoin value for this AccountFull.
     * 
     * @return VCoin
     */
    public java.lang.Integer getVCoin() {
        return VCoin;
    }


    /**
     * Sets the VCoin value for this AccountFull.
     * 
     * @param VCoin
     */
    public void setVCoin(java.lang.Integer VCoin) {
        this.VCoin = VCoin;
    }


    /**
     * Gets the VCoinPayment value for this AccountFull.
     * 
     * @return VCoinPayment
     */
    public java.lang.Integer getVCoinPayment() {
        return VCoinPayment;
    }


    /**
     * Sets the VCoinPayment value for this AccountFull.
     * 
     * @param VCoinPayment
     */
    public void setVCoinPayment(java.lang.Integer VCoinPayment) {
        this.VCoinPayment = VCoinPayment;
    }


    /**
     * Gets the verifiedType value for this AccountFull.
     * 
     * @return verifiedType
     */
    public org.apache.axis.types.UnsignedByte getVerifiedType() {
        return verifiedType;
    }


    /**
     * Sets the verifiedType value for this AccountFull.
     * 
     * @param verifiedType
     */
    public void setVerifiedType(org.apache.axis.types.UnsignedByte verifiedType) {
        this.verifiedType = verifiedType;
    }


    /**
     * Gets the wardID value for this AccountFull.
     * 
     * @return wardID
     */
    public java.lang.Integer getWardID() {
        return wardID;
    }


    /**
     * Sets the wardID value for this AccountFull.
     * 
     * @param wardID
     */
    public void setWardID(java.lang.Integer wardID) {
        this.wardID = wardID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccountFull)) return false;
        AccountFull other = (AccountFull) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.accountTypeID==null && other.getAccountTypeID()==null) || 
             (this.accountTypeID!=null &&
              this.accountTypeID.equals(other.getAccountTypeID()))) &&
            ((this.address==null && other.getAddress()==null) || 
             (this.address!=null &&
              this.address.equals(other.getAddress()))) &&
            ((this.answer==null && other.getAnswer()==null) || 
             (this.answer!=null &&
              this.answer.equals(other.getAnswer()))) &&
            ((this.birthday==null && other.getBirthday()==null) || 
             (this.birthday!=null &&
              this.birthday.equals(other.getBirthday()))) &&
            ((this.birthdayUnixTime==null && other.getBirthdayUnixTime()==null) || 
             (this.birthdayUnixTime!=null &&
              this.birthdayUnixTime.equals(other.getBirthdayUnixTime()))) &&
            ((this.captcha==null && other.getCaptcha()==null) || 
             (this.captcha!=null &&
              this.captcha.equals(other.getCaptcha()))) &&
            ((this.changedTime==null && other.getChangedTime()==null) || 
             (this.changedTime!=null &&
              this.changedTime.equals(other.getChangedTime()))) &&
            ((this.confirmCode==null && other.getConfirmCode()==null) || 
             (this.confirmCode!=null &&
              this.confirmCode.equals(other.getConfirmCode()))) &&
            ((this.districtID==null && other.getDistrictID()==null) || 
             (this.districtID!=null &&
              this.districtID.equals(other.getDistrictID()))) &&
            ((this.error==null && other.getError()==null) || 
             (this.error!=null &&
              this.error.equals(other.getError()))) &&
            ((this.freezeVcoin==null && other.getFreezeVcoin()==null) || 
             (this.freezeVcoin!=null &&
              this.freezeVcoin.equals(other.getFreezeVcoin()))) &&
            ((this.fullName==null && other.getFullName()==null) || 
             (this.fullName!=null &&
              this.fullName.equals(other.getFullName()))) &&
            ((this.gameService==null && other.getGameService()==null) || 
             (this.gameService!=null &&
              this.gameService.equals(other.getGameService()))) &&
            ((this.gender==null && other.getGender()==null) || 
             (this.gender!=null &&
              this.gender.equals(other.getGender()))) &&
            ((this.isUpdateSecurityInfo==null && other.getIsUpdateSecurityInfo()==null) || 
             (this.isUpdateSecurityInfo!=null &&
              this.isUpdateSecurityInfo.equals(other.getIsUpdateSecurityInfo()))) &&
            ((this.joinFrom==null && other.getJoinFrom()==null) || 
             (this.joinFrom!=null &&
              this.joinFrom.equals(other.getJoinFrom()))) &&
            ((this.lastLoginedTime==null && other.getLastLoginedTime()==null) || 
             (this.lastLoginedTime!=null &&
              this.lastLoginedTime.equals(other.getLastLoginedTime()))) &&
            ((this.locationID==null && other.getLocationID()==null) || 
             (this.locationID!=null &&
              this.locationID.equals(other.getLocationID()))) &&
            ((this.nationalID==null && other.getNationalID()==null) || 
             (this.nationalID!=null &&
              this.nationalID.equals(other.getNationalID()))) &&
            ((this.partnerAccountID==null && other.getPartnerAccountID()==null) || 
             (this.partnerAccountID!=null &&
              this.partnerAccountID.equals(other.getPartnerAccountID()))) &&
            ((this.passport==null && other.getPassport()==null) || 
             (this.passport!=null &&
              this.passport.equals(other.getPassport()))) &&
            ((this.paygateID==null && other.getPaygateID()==null) || 
             (this.paygateID!=null &&
              this.paygateID.equals(other.getPaygateID()))) &&
            ((this.questionID==null && other.getQuestionID()==null) || 
             (this.questionID!=null &&
              this.questionID.equals(other.getQuestionID()))) &&
            ((this.receiveEmail==null && other.getReceiveEmail()==null) || 
             (this.receiveEmail!=null &&
              this.receiveEmail.equals(other.getReceiveEmail()))) &&
            ((this.smsPlusMobile==null && other.getSmsPlusMobile()==null) || 
             (this.smsPlusMobile!=null &&
              this.smsPlusMobile.equals(other.getSmsPlusMobile()))) &&
            ((this.totalVcoin==null && other.getTotalVcoin()==null) || 
             (this.totalVcoin!=null &&
              this.totalVcoin.equals(other.getTotalVcoin()))) &&
            ((this.totalVcoinPayment==null && other.getTotalVcoinPayment()==null) || 
             (this.totalVcoinPayment!=null &&
              this.totalVcoinPayment.equals(other.getTotalVcoinPayment()))) &&
            ((this.userSN==null && other.getUserSN()==null) || 
             (this.userSN!=null &&
              this.userSN.equals(other.getUserSN()))) &&
            ((this.VCoin==null && other.getVCoin()==null) || 
             (this.VCoin!=null &&
              this.VCoin.equals(other.getVCoin()))) &&
            ((this.VCoinPayment==null && other.getVCoinPayment()==null) || 
             (this.VCoinPayment!=null &&
              this.VCoinPayment.equals(other.getVCoinPayment()))) &&
            ((this.verifiedType==null && other.getVerifiedType()==null) || 
             (this.verifiedType!=null &&
              this.verifiedType.equals(other.getVerifiedType()))) &&
            ((this.wardID==null && other.getWardID()==null) || 
             (this.wardID!=null &&
              this.wardID.equals(other.getWardID())));
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
        if (getAccountTypeID() != null) {
            _hashCode += getAccountTypeID().hashCode();
        }
        if (getAddress() != null) {
            _hashCode += getAddress().hashCode();
        }
        if (getAnswer() != null) {
            _hashCode += getAnswer().hashCode();
        }
        if (getBirthday() != null) {
            _hashCode += getBirthday().hashCode();
        }
        if (getBirthdayUnixTime() != null) {
            _hashCode += getBirthdayUnixTime().hashCode();
        }
        if (getCaptcha() != null) {
            _hashCode += getCaptcha().hashCode();
        }
        if (getChangedTime() != null) {
            _hashCode += getChangedTime().hashCode();
        }
        if (getConfirmCode() != null) {
            _hashCode += getConfirmCode().hashCode();
        }
        if (getDistrictID() != null) {
            _hashCode += getDistrictID().hashCode();
        }
        if (getError() != null) {
            _hashCode += getError().hashCode();
        }
        if (getFreezeVcoin() != null) {
            _hashCode += getFreezeVcoin().hashCode();
        }
        if (getFullName() != null) {
            _hashCode += getFullName().hashCode();
        }
        if (getGameService() != null) {
            _hashCode += getGameService().hashCode();
        }
        if (getGender() != null) {
            _hashCode += getGender().hashCode();
        }
        if (getIsUpdateSecurityInfo() != null) {
            _hashCode += getIsUpdateSecurityInfo().hashCode();
        }
        if (getJoinFrom() != null) {
            _hashCode += getJoinFrom().hashCode();
        }
        if (getLastLoginedTime() != null) {
            _hashCode += getLastLoginedTime().hashCode();
        }
        if (getLocationID() != null) {
            _hashCode += getLocationID().hashCode();
        }
        if (getNationalID() != null) {
            _hashCode += getNationalID().hashCode();
        }
        if (getPartnerAccountID() != null) {
            _hashCode += getPartnerAccountID().hashCode();
        }
        if (getPassport() != null) {
            _hashCode += getPassport().hashCode();
        }
        if (getPaygateID() != null) {
            _hashCode += getPaygateID().hashCode();
        }
        if (getQuestionID() != null) {
            _hashCode += getQuestionID().hashCode();
        }
        if (getReceiveEmail() != null) {
            _hashCode += getReceiveEmail().hashCode();
        }
        if (getSmsPlusMobile() != null) {
            _hashCode += getSmsPlusMobile().hashCode();
        }
        if (getTotalVcoin() != null) {
            _hashCode += getTotalVcoin().hashCode();
        }
        if (getTotalVcoinPayment() != null) {
            _hashCode += getTotalVcoinPayment().hashCode();
        }
        if (getUserSN() != null) {
            _hashCode += getUserSN().hashCode();
        }
        if (getVCoin() != null) {
            _hashCode += getVCoin().hashCode();
        }
        if (getVCoinPayment() != null) {
            _hashCode += getVCoinPayment().hashCode();
        }
        if (getVerifiedType() != null) {
            _hashCode += getVerifiedType().hashCode();
        }
        if (getWardID() != null) {
            _hashCode += getWardID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AccountFull.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "AccountFull"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountTypeID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "AccountTypeID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "Address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("answer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "Answer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("birthday");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "Birthday"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("birthdayUnixTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "BirthdayUnixTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("captcha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "Captcha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("changedTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "ChangedTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confirmCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "ConfirmCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("districtID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "DistrictID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("error");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "Error"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("freezeVcoin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "FreezeVcoin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fullName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "FullName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gameService");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "GameService"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gender");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "Gender"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isUpdateSecurityInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "IsUpdateSecurityInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("joinFrom");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "JoinFrom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastLoginedTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "LastLoginedTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("locationID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "LocationID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nationalID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "NationalID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partnerAccountID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "PartnerAccountID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("passport");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "Passport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paygateID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "PaygateID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("questionID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "QuestionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiveEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "ReceiveEmail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smsPlusMobile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "SmsPlusMobile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalVcoin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "TotalVcoin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalVcoinPayment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "TotalVcoinPayment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userSN");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "UserSN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VCoin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "VCoin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VCoinPayment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "VCoinPayment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("verifiedType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "VerifiedType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wardID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DataAccess.CoreAPI.DTO", "WardID"));
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
