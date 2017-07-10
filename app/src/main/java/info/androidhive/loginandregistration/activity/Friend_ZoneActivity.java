package info.androidhive.loginandregistration.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import info.androidhive.loginandregistration.R;

public class Friend_ZoneActivity extends AppCompatActivity {
    private ImageButton NewPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend__zone);

        PostAdapter postAdapter = new PostAdapter(this,R.layout.single_post,Post.getAllPosts());
        NewPost = (ImageButton)findViewById(R.id.post_new);
        ListView listView = (ListView) findViewById(R.id.post_listView);
        listView.setAdapter(postAdapter);

        Spinner spinner = (Spinner)findViewById(R.id.city);
        final String[] City = {"厦门","上海","长沙"};
        ArrayAdapter<String> cityList = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,City);
        spinner.setAdapter(cityList);

        NewPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Friend_ZoneActivity.this,NewPostActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
