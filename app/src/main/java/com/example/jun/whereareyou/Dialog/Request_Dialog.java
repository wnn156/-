package com.example.jun.whereareyou.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.jun.whereareyou.Data.ListViewChatItem;
import com.example.jun.whereareyou.R;

public class Request_Dialog extends Dialog implements View.OnClickListener {
    private static final int LAYOUT = R.layout.request_dialog;

    public interface MyDialogListener {
        public void onPositiveClicked();
        public void onNegativeClicked();
    }
    private MyDialogListener dialogListener;

    private TextView cancelTv;
    private TextView searchTv;
    private Context context;

    public Request_Dialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        cancelTv = (TextView) findViewById(R.id.findPwDialogCancelTv);
        searchTv = (TextView) findViewById(R.id.findPwDialogFindTv);

        cancelTv.setOnClickListener(this);
        searchTv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.findPwDialogCancelTv:
                cancel();
                break;
            case R.id.findPwDialogFindTv:
                dialogListener.onPositiveClicked();
                dismiss();
                break;
        }
    }
    public void setDialogListener(MyDialogListener dialogListener){
        this.dialogListener = dialogListener;
    }

}