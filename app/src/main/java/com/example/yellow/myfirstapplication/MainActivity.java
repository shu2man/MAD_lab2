package com.example.yellow.myfirstapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void hideKeyBoard(){
        View view=getCurrentFocus();
        if(view!=null){
            ((InputMethodManager)getSystemService(getApplicationContext().INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(view.getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public void imgClick(View target){
        final AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        final String[] choose={"拍摄", "从相册选择"};
        alertDialog.setTitle("上传头像").setItems(choose,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "您选择了["+choose[which]+"]",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "您选择了[取消]", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    public void signInClick(View target){
        hideKeyBoard();

    }

}