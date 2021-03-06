package umn.ac.week11_elisabethhutabarat_42524;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public interface PostServices {
    @GET("posts")
    Call<List<PostModel>> getPosts();
}

public class DataRepository {
    static String placeholderUrl = "https://jsonplaceholder.typicode.com/";
    static final PostServices create() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(placeholderUrl)
                .build();
        return retrofit.create(PostServices.class);
    }
}