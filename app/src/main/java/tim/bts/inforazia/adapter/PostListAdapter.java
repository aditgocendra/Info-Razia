package tim.bts.inforazia.adapter;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import java.util.List;

import tim.bts.inforazia.R;
import tim.bts.inforazia.model.DataUpload_model;

import tim.bts.inforazia.model.Users_model;
import tim.bts.inforazia.view.DetailRaziaActivity;
import tim.bts.inforazia.view.ProfileActivity;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.PostViewHolder> {

    List<DataUpload_model> mUpload;
    List<Users_model> mUserUpload;
    Context mContext;


    public PostListAdapter( Context context, List<DataUpload_model> upload, List<Users_model> userUpload){
        mUpload = upload;
        mContext = context;
        mUserUpload = userUpload;
    }



    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        final DataUpload_model dataUpload_model = mUpload.get(position);
        final Users_model users_model = mUserUpload.get(position);

        holder.postUsername.setText(dataUpload_model.getNamaUser());
        holder.postLokasi.setText(dataUpload_model.getAlamat());

        Picasso.get()
                .load(dataUpload_model.getmImageUrl())
                .into(holder.postImageView);

    }

    @Override
    public int getItemCount() {
        return mUpload.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{

        public ImageView postImageView, postUserImage;
        public TextView  postUsername, postLokasi;


        View mView;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            mView = itemView;

            postImageView =  mView.findViewById(R.id.image_post_view);
            postUsername = mView.findViewById(R.id.Username_post);
            postUserImage = mView.findViewById(R.id.user_upload);
            postLokasi = mView.findViewById(R.id.lokasi_post);


        }
    }




}
