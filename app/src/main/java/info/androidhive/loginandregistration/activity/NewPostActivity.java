package info.androidhive.loginandregistration.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import info.androidhive.loginandregistration.R;

public class NewPostActivity extends AppCompatActivity {
    private ImageButton new_back;
    private ImageButton new_post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        new_back = (ImageButton)findViewById(R.id.newpost_back);
        new_post = (ImageButton)findViewById(R.id.newpost_post);

        new_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(NewPostActivity.this,Friend_ZoneActivity.class);
                startActivity(intent);
                finish();
            }
        });
        new_post.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(NewPostActivity.this,Friend_ZoneActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
