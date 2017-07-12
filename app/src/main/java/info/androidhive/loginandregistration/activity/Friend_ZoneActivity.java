package info.androidhive.loginandregistration.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import info.androidhive.loginandregistration.R;
import info.androidhive.loginandregistration.app.AppConfig;
import info.androidhive.loginandregistration.app.AppController;

public class Friend_ZoneActivity extends AppCompatActivity {
    private ImageButton NewPost;
    private ProgressDialog pDialog;
    private static final String TAG = RegisterActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend__zone);

        //Post.getAllPosts()
        PostAdapter postAdapter = new PostAdapter(this,R.layout.single_post,getpost("test"));
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

    private List<Post> getpost(final String username) {
        final List<Post> Posts = new ArrayList<Post>();
        // Tag used to cancel the request
        String tag_string_req = "req_flash";

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_GETPOST, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Login Response: " + response.toString());

                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        if(jsonObject!=null){
                            String name = jsonObject.optString("name");
                            String pcontext = jsonObject.optString("pcontext");
                            String date = jsonObject.optString("date");
                            Posts.add(new Post(name,R.drawable.beau1,pcontext,R.drawable.beau2,date));
                        }
                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", username);
                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
        return Posts;
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

}
