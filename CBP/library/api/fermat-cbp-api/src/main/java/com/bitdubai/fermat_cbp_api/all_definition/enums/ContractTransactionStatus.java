package com.bitdubai.fermat_cbp_api.all_definition.enums;

import com.bitdubai.fermat_api.layer.all_definition.enums.interfaces.FermatEnum;
import com.bitdubai.fermat_api.layer.all_definition.exceptions.InvalidParameterException;

/**
 * Created by Manuel Perez (darkpriestrelative@gmail.com) on 30/11/15.
 */
public enum ContractTransactionStatus implements FermatEnum {

    ACK_OFFLINE_MERCHANDISE("AFM"),
    ACK_ONLINE_MERCHANDISE("ANM"),
    ACK_OFFLINE_PAYMENT("AFP"),
    ACK_ONLINE_PAYMENT("ANP"),
    CHECKING_CLOSING_CONTRACT("CCC"),
    CHECKING_HASH("CHA"),
    CLOSING_CONTRACT("CLC"),
    CONFIRM_CLOSED_CONTRACT("CCLC"),
    CONFIRM_ONLINE_ACK_MERCHANDISE("COAM"),
    CONFIRM_OFFLINE_ACK_PAYMENT("CFAP"),
    CONFIRM_ONLINE_ACK_PAYMENT("COAP"),
    CONFIRM_OFFLINE_ACK_MERCHANDISE("CFAM"),
    CONFIRM_OFFLINE_PAYMENT("CFP"),
    CONFIRM_ONLINE_PAYMENT("COP"),
    CONFIRM_OFFLINE_CONSIGNMENT("COS"),
    CONFIRM_ONLINE_CONSIGNMENT("COS"),
    CONTRACT_COMPLETED("CNC"),
    CONTRACT_CONFIRMED("COC"),
    CONTRACT_OPENED("COO"),
    CREATING_CONTRACT("CRC"),
    CRYPTO_MERCHANDISE_SUBMITTED("CMS"),
    CRYPTO_PAYMENT_SUBMITTED("CPS"),
    HASH_REJECTED("HRJ"),
    OFFLINE_MERCHANDISE_ACK("FMA"),
    OFFLINE_MERCHANDISE_SUBMITTED("FMS"),
    OFFLINE_PAYMENT_SUBMITTED("FPS"),
    OFFLINE_PAYMENT_ACK("FPA"),
    ONLINE_MERCHANDISE_ACK("OMA"),
    ONLINE_MERCHANDISE_SUBMITTED("OMS"),
    ONLINE_PAYMENT_ACK("OPA"),
    ONLINE_PAYMENT_SUBMITTED("OPS"),
    PENDING_CONFIRMATION("PEC"),
    PENDING_ACK_OFFLINE_MERCHANDISE("PAFM"),
    PENDING_ACK_ONLINE_MERCHANDISE("PAOM"),
    PENDING_ONLINE_MERCHANDISE_CONFIRMATION("POMC"),
    PENDING_ACK_ONLINE_MERCHANDISE_NOTIFICATION("PAOMN"),
    PENDING_ACK_OFFLINE_PAYMENT("PAFP"),
    PENDING_ACK_ONLINE_PAYMENT("PAOP"),
    PENDING_ACK_OFFLINE_PAYMENT_NOTIFICATION("PAFPN"),
    PENDING_ACK_ONLINE_PAYMENT_CONFIRMATION("PAOPC"),
    PENDING_ACK_ONLINE_PAYMENT_NOTIFICATION("PAOPN"),
    PENDING_OFFLINE_PAYMENT_CONFIRMATION("POFC"),
    PENDING_OFFLINE_DE_STOCK("PFDS"),
    PENDING_ONLINE_DE_STOCK("PODS"),
    PENDING_OFFLINE_MERCHANDISE_CONFIRMATION("PFMC"),
    PENDING_OFFLINE_MERCHANDISE_NOTIFICATION("PFMN"),
    PENDING_ONLINE_PAYMENT_CONFIRMATION("POPC"),
    PENDING_OFFLINE_PAYMENT_NOTIFICATION("POFP"),
    PENDING_ONLINE_PAYMENT_NOTIFICATION("POPN"),
    PENDING_SUBMIT_OFFLINE_MERCHANDISE_NOTIFICATION("PSFMN"),
    PENDING_SUBMIT_ONLINE_MERCHANDISE_NOTIFICATION("PSOMN"),
    PENDING_PAYMENT("PEP"),
    PENDING_RESPONSE("PER"),
    PENDING_SUBMIT("PES"),
    PENDING_SUBMIT_OFFLINE_MERCHANDISE("PSFM"),
    PENDING_SUBMIT_ONLINE_MERCHANDISE("PSOM"),
    SUBMIT_CLOSING_CONTRACT_CONFIRMATION("SCCC"),
    SUBMIT_OFFLINE_MERCHANDISE("SFM"),
    SUBMIT_ONLINE_MERCHANDISE("SNM"),
    SUBMIT_OFFLINE_PAYMENT("SFP"),
    SUBMIT_ONLINE_PAYMENT("SNP"),
    ;

    String code;
    ContractTransactionStatus(String code){
        this.code=code;
    }

    //PUBLIC METHODS

    public static ContractTransactionStatus getByCode(String code) throws InvalidParameterException {
        for (ContractTransactionStatus value : values()) {
            if (value.getCode().equals(code)) return value;
        }
        throw new InvalidParameterException(InvalidParameterException.DEFAULT_MESSAGE, null, "Code Received: " + code, "This Code Is Not Valid for the ContractTransactionStatus enum.");
    }

    @Override
    public String toString() {
        return "OpenContractStatus{" +
                "code='" + code + '\'' +
                '}';
    }

    //GETTER AND SETTERS
    @Override
    public String getCode() {
        return code;
    }
}
