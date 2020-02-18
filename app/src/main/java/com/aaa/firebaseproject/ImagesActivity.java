package com.aaa.firebaseproject;


import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


public class ImagesActivity extends AppCompatActivity {
    private static final String TAG = "ImagesActivity";

    //    private RecyclerView mRecyclerView;
//    private ImageAdapter mAdapter;
//    private DatabaseReference mDatabaseRef;
//    private List<Upload> mUploads ;
    private RecyclerView mPeopleRV;
    private DatabaseReference mDatabase;
    private FirebaseRecyclerAdapter<Upload, ImagesActivity.NewsViewHolder> mPeopleRVAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("i'm Krasavchik");

        //"News" here will reflect what you have called your database in Firebase.
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Data");
        mDatabase.keepSynced(true);

        mPeopleRV = (RecyclerView) findViewById(R.id.recyclerView);

        DatabaseReference personsRef = FirebaseDatabase.getInstance().getReference().child("Data");
        Query personsQuery = personsRef.orderByKey();

        mPeopleRV.hasFixedSize();
        mPeopleRV.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Upload> personsOptions = new FirebaseRecyclerOptions.Builder<Upload>().setQuery(personsQuery, Upload.class).build();

        mPeopleRVAdapter = new FirebaseRecyclerAdapter<Upload, ImagesActivity.NewsViewHolder>(personsOptions) {
            @Override
            protected void onBindViewHolder(@NonNull ImagesActivity.NewsViewHolder holder, final int position, @NonNull final Upload model) {
                holder.setTitle(model.getTitle());
                holder.setDesc(model.getDesc());
                holder.setImage(getBaseContext(), model.getImage());

                holder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        final String url = model.getUrl();
//                        Intent intent = new Intent(getApplicationContext(), NewsWebView.class);
//                        intent.putExtra("id", url);
//                        startActivity(intent);
                        Toast.makeText(ImagesActivity.this, "onClick", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @NonNull
            @Override
            public ImagesActivity.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_card, parent, false);

                return new ImagesActivity.NewsViewHolder(view);
            }
        };

        mPeopleRV.setAdapter(mPeopleRVAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        mPeopleRVAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPeopleRVAdapter.stopListening();


    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public NewsViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setTitle(String title) {
            TextView post_title = (TextView) mView.findViewById(R.id.title_tv);
            post_title.setText(title);
        }

        public void setDesc(String desc) {
            TextView post_desc = (TextView) mView.findViewById(R.id.description_tv);
            post_desc.setText(desc);
        }

        public void setImage(Context ctx, String image) {
            ImageView post_image = (ImageView) mView.findViewById(R.id.imageView);

            Glide.with(ctx).load(image).into(post_image);
        }
//        mUploads= new ArrayList<>();
//        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Data/");
//
//        mRecyclerView = findViewById(R.id.recyclerView);
//        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//
//        Log.d(TAG, "onCreate:+++++++++++++++ " + mDatabaseRef + mUploads);
//
//        mDatabaseRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
//                    Upload upload = postSnapshot.getValue(Upload.class);
//                    mUploads.add(upload);
//                    Log.d(TAG, "onDataChange: ******************" + dataSnapshot + upload);
//                }
//                Toast.makeText(ImagesActivity.this,dataSnapshot.toString(), Toast.LENGTH_SHORT).show();
//
//                mAdapter = new ImageAdapter(ImagesActivity.this, mUploads);
//
//                mRecyclerView.setAdapter(mAdapter);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
