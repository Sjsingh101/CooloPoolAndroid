package com.coolopool.coolopool.Class;

import android.widget.TextView;

public class Transaction {
    String mDetails;
    String mDate;
    String mTransactionId;
    String mTime;
    int mAmount;
    int mClosingBalance;
    int mType;//0: credit & 1: debit

    public Transaction(String mDetails, String mDate, String mTransactionId, String mTime, int mAmount, int mClosingBalance, int mType) {
        this.mDetails = mDetails;
        this.mDate = mDate;
        this.mTransactionId = mTransactionId;
        this.mTime = mTime;
        this.mAmount = mAmount;
        this.mClosingBalance = mClosingBalance;
        this.mType = mType;
    }

    public String getmDetails() {
        return mDetails;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmTransactionId() {
        return mTransactionId;
    }

    public String getmTime() {
        return mTime;
    }

    public String getmAmount() {
        if(this.mType == 0){
            return "- ₹"+this.mAmount;
        }else if(this.mType == 1){
            return "+ ₹"+this.mAmount;
        }else {
            return ""+mAmount;
        }

    }

    public String getmClosingBalance() {
        return ""+mClosingBalance;
    }
}
