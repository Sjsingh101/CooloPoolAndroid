package com.coolopool.coolopool.Adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coolopool.coolopool.Class.Transaction;
import com.coolopool.coolopool.R;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {

    ArrayList<Transaction> transactions;
    Context context;

    public TransactionAdapter(ArrayList<Transaction> transactions, Context context) {
        this.transactions = transactions;
        this.context = context;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.transaction_list_item, viewGroup, false);
        return new TransactionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder transactionViewHolder, int i) {
        Transaction c = transactions.get(i);
        transactionViewHolder.mDate.setText(c.getmDate());
        transactionViewHolder.mDetails.setText(c.getmDetails());
        transactionViewHolder.mTransactionId.setText("Txn id: "+c.getmTransactionId());
        transactionViewHolder.mTime.setText(c.getmTime());
        transactionViewHolder.mAmount.setText(c.getmAmount());
        transactionViewHolder.mClosingBalance.setText("Closing Balance: ₹"+c.getmClosingBalance());
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    public class TransactionViewHolder extends RecyclerView.ViewHolder{

        TextView mDate;
        TextView mDetails;
        TextView mTransactionId;
        TextView mTime;
        TextView mAmount;
        TextView mClosingBalance;

        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);
            mDate = itemView.findViewById(R.id.transaction_list_item_date_textView);
            mDetails = itemView.findViewById(R.id.transaction_list_item_detail_textView);
            mTransactionId = itemView.findViewById(R.id.transaction_list_item_txn_id_textView);
            mTime = itemView.findViewById(R.id.transaction_list_item_time_textView);
            mAmount = itemView.findViewById(R.id.transaction_list_item_ammount_textView);
            mClosingBalance = itemView.findViewById(R.id.transaction_list_item_closing_balance_textView);
        }
    }
}
