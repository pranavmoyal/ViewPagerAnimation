package com.example.baltech.viewpageranimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SplashScreen extends AppCompatActivity implements View.OnClickListener {

    private Button btn_zoom,btn_depth,btn_slide,btn_cube_out,btn_flip_horizontal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();
        setListener();
    }

    private void init(){
        btn_zoom=(Button) findViewById(R.id.btn_zoom);
        btn_depth=(Button) findViewById(R.id.btn_depth);
        btn_slide=(Button) findViewById(R.id.btn_slide);
        btn_cube_out=(Button) findViewById(R.id.btn_cube_out);
        btn_flip_horizontal=(Button) findViewById(R.id.btn_flip_horizontal);
    }

    private void setListener(){
        btn_zoom.setOnClickListener(this);
        btn_depth.setOnClickListener(this);
        btn_slide.setOnClickListener(this);
        btn_cube_out.setOnClickListener(this);
        btn_flip_horizontal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_zoom:

                Intent intent_zoom=new Intent(getApplicationContext(),MainActivity.class);
                intent_zoom.putExtra("zoom","zoom");
                startActivity(intent_zoom);

                break;

            case R.id.btn_depth:

                Intent intent_depth=new Intent(getApplicationContext(),MainActivity.class);
                intent_depth.putExtra("zoom","depth");
                startActivity(intent_depth);

                break;

            case R.id.btn_slide:

                Intent intent_slide=new Intent(getApplicationContext(),MainActivity.class);
                intent_slide.putExtra("zoom","slide");
                startActivity(intent_slide);

                break;

            case R.id.btn_cube_out:

                Intent intent_cube_out=new Intent(getApplicationContext(),MainActivity.class);
                intent_cube_out.putExtra("zoom","cubeout");
                startActivity(intent_cube_out);

                break;


            case R.id.btn_flip_horizontal:

                Intent intent_flip_horizontal=new Intent(getApplicationContext(),MainActivity.class);
                intent_flip_horizontal.putExtra("zoom","fliphorizontal");
                startActivity(intent_flip_horizontal);

                break;
        }
    }
}
