package com.example.lxrent.mytestapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.lxrent.mytestapplication.api.vo.account.Account;
import com.example.lxrent.mytestapplication.api.vo.transaction.Transaction;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Rpc rpc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eos_activity_main);
        ((TextView) findViewById(R.id.eos_create)).setOnClickListener(this);
        ((TextView) findViewById(R.id.import_privateKey)).setOnClickListener(this);
        ((TextView) findViewById(R.id.import_Keystore)).setOnClickListener(this);
        ((TextView) findViewById(R.id.import_memory)).setOnClickListener(this);
        ((TextView) findViewById(R.id.eos_transfer)).setOnClickListener(this);
//        ActivityMainBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        UserBean userBean = new UserBean("hhahah", 18);
//        dataBinding.setUser(userBean);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.eos_create:
                break;
            case R.id.import_privateKey:
                break;
            case R.id.import_Keystore:
                break;
            case R.id.import_memory:
                break;
            case R.id.eos_transfer:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                    } else {
                        transfer();
                    }
                } else {
                    transfer();
                }
                break;
        }

    }

    private void transfer() {
//        rpc = new Rpc("http://mainnet.genereos.io");
        rpc = new Rpc("http://47.75.212.115:8888");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Account account = rpc.getAccount("rand11111131");
//                    Transaction t1 = rpc.transfer("5JSqBZRjLxVtm4UdYJpJSAw4kbA44Yw75fqDUwZrpAiS5RaEfsN", "espritblocke", "Rand11111131", "Rand11111132", "12.2821 MSP", "1");
//                    Transaction t1 = rpc.transfer("5K81TfawD48JMP6zwsg1JQPY3QvXc1mifbAJ6PqLTrds39QTLz3",
//                            "eosio.token",
//                            "heyiandxwg55",
//                            "pragamespace", "0.0821 EOS", "1");
                    Transaction t1 = rpc.transfer("5JSqBZRjLxVtm4UdYJpJSAw4kbA44Yw75fqDUwZrpAiS5RaEfsN",
                            "eosio.token",
                            "rand11111131",
                            "rand11111132", "12 EOS", "1");
//                    account = rpc.getAccount("heyiandxwg55");
                    System.out.println("转账成功 = " + t1.getTransactionId() + " \n ");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }
}
