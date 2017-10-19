package com.example.yellow.myfirstapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RadioGroup;
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
        hideKeyBoard();
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
                    }}).show();
    }

    private void snackBarListener(){
        Toast.makeText(MainActivity.this, "Snackbar的确定按钮被点击了", Toast.LENGTH_SHORT).show();
    }

    private void logIn(int t){
        String msg="登录成功";
        if(t==2) msg="学号/教工号或密码错误";
        Snackbar.make(getWindow().getDecorView(),msg,Snackbar.LENGTH_LONG).
            setAction("确定", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Snackbar的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                }}).show();
    }

    public void errorEnableToFalse(View target){
        TextInputLayout idinput=(TextInputLayout) findViewById(R.id.studentidholder);
        TextInputLayout pswinput=(TextInputLayout) findViewById(R.id.passwordholder);
        idinput.setErrorEnabled(false);
        pswinput.setErrorEnabled(false);
    }

    public void signInClick(View target){
        TextInputLayout idinput=(TextInputLayout) findViewById(R.id.studentidholder);
        TextInputLayout pswinput=(TextInputLayout) findViewById(R.id.passwordholder);
        String studentid=idinput.getEditText().getText().toString();
        String password=pswinput.getEditText().getText().toString();
        if(studentid.equals("")) idinput.setError("学号不能为空");
        else if(password.equals("")) pswinput.setError("密码不能为空");
        else{
            idinput.setErrorEnabled(false);
            pswinput.setErrorEnabled(false);
            if(studentid.equals("123456") && password.equals("6666")) logIn(1);
            else logIn(2);
        }
    }

    String chosen="学生";
    //something wrong here
    public void rdgpClick(View target){
        RadioGroup rdgp=(RadioGroup) findViewById(R.id.rg1);
        rdgp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.student:
                        chosen="学生";
                        break;
                    case R.id.stuff:
                        chosen="教职工";
                        break;
                }}});
        Snackbar.make(getWindow().getDecorView(),"您选择了"+chosen,Snackbar.LENGTH_LONG).
                setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Snackbar的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                    }}).show();
    }

    public void signUpClick(View target){
        Snackbar.make(getWindow().getDecorView(),chosen+"注册功能尚未启用",Snackbar.LENGTH_LONG).
                setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Snackbar的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                    }}).show();
    }

}