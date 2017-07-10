package info.androidhive.loginandregistration.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.loginandregistration.R;

/**
 * Created by liliz on 2017/7/10.
 */

public class PostAdapter extends ArrayAdapter<Post>{
    public PostAdapter(Context Pcontext,int resource,List<Post> objects){
        super(Pcontext,resource,objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Post post_item = getItem(position);

        View onePostView = LayoutInflater.from(getContext()).inflate(R.layout.single_post,parent,false);
        ImageView imageView = (ImageView) onePostView.findViewById(R.id.post_ImageId);
        TextView textView = (TextView) onePostView.findViewById(R.id.post_name);
        ImageView imageView1 = (ImageView) onePostView.findViewById(R.id.post_PostImageId);
        TextView textView1 = (TextView) onePostView.findViewById(R.id.post_date);
        TextView textView2 = (TextView) onePostView.findViewById(R.id.post_Pcontext);

        imageView.setImageResource(post_item.getImageId());
        textView.setText(post_item.getName());
        imageView1.setImageResource(post_item.getPostImageId());
        textView1.setText(post_item.getDate());
        textView2.setText(post_item.getPcontext());

        return onePostView;
    }
}