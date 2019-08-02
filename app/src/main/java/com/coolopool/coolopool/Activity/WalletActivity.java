package com.coolopool.coolopool.Activity;

import android.os.TransactionTooLargeException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.coolopool.coolopool.Adapter.TransactionAdapter;
import com.coolopool.coolopool.Class.Transaction;
import com.coolopool.coolopool.R;

import java.util.ArrayList;

public class WalletActivity extends AppCompatActivity {

    ArrayList<Transaction> mTransactions;
    TransactionAdapter mAdapter;
    RecyclerView mTransactionRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        mTransactions = new ArrayList<>();
        mTransactions.add(new Transaction("Hudson", "03 Jul 2019", "67538298", "03:30 Pm", 100, 70, 0));
        mTransactions.add(new Transaction("Hote Inn", "01 Jul 2019", "67538456", "01:00 Pm", 20, 170, 1));
        mTransactions.add(new Transaction("Hudson", "28 Jun 2019", "67538786", "11:00 Am", 50, 150, 1));
        mTransactions.add(new Transaction("Hudson", "15 Jun 2019", "67567539", "04:45 Pm", 70, 100, 0));
        mTransactions.add(new Transaction("Hudson", "03 Jul 2019", "67538298", "03:30 Pm", 100, 70, 0));
        mTransactions.add(new Transaction("Hote Inn", "01 Jul 2019", "67538456", "01:00 Pm", 20, 170, 1));
        mTransactions.add(new Transaction("Hudson", "28 Jun 2019", "67538786", "11:00 Am", 50, 150, 1));
        mTransactions.add(new Transaction("Hudson", "15 Jun 2019", "67567539", "04:45 Pm", 70, 100, 0));

        mAdapter = new TransactionAdapter(mTransactions, this);
        mTransactionRecyclerView = (RecyclerView)findViewById(R.id.wallet_activity_transaction_rV);
        mTransactionRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mTransactionRecyclerView.setHasFixedSize(false);
        mTransactionRecyclerView.setAdapter(mAdapter);
        mTransactionRecyclerView.addItemDecoration(new DividerItemDecoration(this, 1));



    }
}
