//package com.aaa.firebaseproject;
//
//import android.content.Context;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.view.LayoutInflater;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//import com.bumptech.glide.Glide;
//import java.util.List;
//
//public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
//
//    private Context mContext;
//    private List<Upload> mUploads;
//
//    public class ImageViewHolder extends RecyclerView.ViewHolder {
//        public TextView textViewTitle;
//        public ImageView imageView;
//        public TextView textViewDescription;
//
//        public ImageViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            textViewTitle = itemView.findViewById(R.id.title_tv);
//            imageView = itemView.findViewById(R.id.imageView);
//            textViewDescription = itemView.findViewById(R.id.description_tv);
//        }
//    }
//
//    public ImageAdapter(Context context, List<Upload> uploads) {
//        mContext = context;
//        mUploads = uploads;
//    }
//
//    @NonNull
//    @Override
//    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(mContext).inflate(R.layout.item_card, parent, false);
//        return new ImageViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
//        Upload uploadCurrent = mUploads.get(position);
//        holder.textViewTitle.setText(uploadCurrent.getmTitle());
//        holder.textViewDescription.setText(uploadCurrent.getmDescription());
//        Glide.with(mContext).load(uploadCurrent.getmImageUrl()).into(holder.imageView);
////        Picasso.get().load(uploadCurrent.getmImageUrl()).into(holder.imageView);
////        Picasso.get().load(uploadCurrent.getmImageUrl()).fit().centerCrop().into(holder.imageView);    }
//    }
//
//    @Override
//    public int getItemCount() {
//        return mUploads.size();
//    }
//}
