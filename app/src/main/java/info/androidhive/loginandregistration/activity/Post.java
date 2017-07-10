package info.androidhive.loginandregistration.activity;

/**
 * Created by liliz on 2017/7/10.
 */

import java.util.ArrayList;
import java.util.List;

import info.androidhive.loginandregistration.R;

/**
 * Created by liliz on 2017/7/10.
 */

public class Post {
    private String name;
    private int imageId;
    private String Pcontext;
    private int PostImageId;
    private String date;

    public Post(String name,int imageId,String Pcontext,int PostImageId,String date){
        this.name = name;
        this.imageId = imageId;
        this.Pcontext = Pcontext;
        this.PostImageId = PostImageId;
        this.date = date;
    }
    public  static List<Post> getAllPosts(){
        List<Post> Posts = new ArrayList<Post>();
        Posts.add(new Post("厦门大学竹蜻蜓", R.drawable.zhx,"welcome to here",R.drawable.zhx,"7-10"));
        Posts.add(new Post("李特特",R.drawable.cj,"我是大美女",R.drawable.cj,"7-8"));
        Posts.add(new Post("子木",R.drawable.yw,"今天天气好好噢",R.drawable.yw,"7-7"));

        return Posts;
    }

    public  String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
    public String getPcontext(){
        return Pcontext;
    }
    public int getPostImageId(){
        return PostImageId;
    }
    public String getDate(){
        return date;
    }
    public void setImageId(int imageId){
        this.imageId = imageId;
    }
    public void setPcontext(String pcontext){
        this.Pcontext = pcontext;
    }
    public  void setPostImageId(int PostImageId){
        this.PostImageId = PostImageId;
    }
}
