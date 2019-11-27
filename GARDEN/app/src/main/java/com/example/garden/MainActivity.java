package com.example.garden;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.common.Constant;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import com.yzq.zxinglibrary.common.Constant;
import com.yzq.zxinglibrary.encode.CodeCreator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.BreakIterator;


public class MainActivity extends AppCompatActivity {
public int REQUEST_CODE_SCAN;
    private BreakIterator result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_qrcode;
        Button btn_map;
        Button btn_us;
        Button btn_quyuchuangguan;
        btn_qrcode= (Button) findViewById(R.id.qrcode);
        btn_map=(Button)findViewById(R.id.map);
        btn_us=(Button)findViewById(R.id.us);
        btn_quyuchuangguan=(Button)findViewById(R.id.quyuchuangguan);
        btn_qrcode.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            }
        });
        btn_map.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            }
        });
        btn_us.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            }
        });
        btn_quyuchuangguan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            }
        });

        btn_qrcode.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){



                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SCAN);
               //startActivityForResult(intent, 0);
            }
        });
        btn_map.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){



                Intent i = new Intent(MainActivity.this , Map.class);
////启动
                startActivity(i);
            }
        });
        btn_us.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){



                Intent i = new Intent(MainActivity.this , US.class);
////启动
                startActivity(i);
            }
        });
        btn_quyuchuangguan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){



                Intent i = new Intent(MainActivity.this , Quyuchuangguan.class);
////启动
                startActivity(i);
            }
        });




    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {

                String content = data.getStringExtra(Constant.CODED_CONTENT);
                result.setText("扫描结果为：" + content);
            }
        }
    }

}
