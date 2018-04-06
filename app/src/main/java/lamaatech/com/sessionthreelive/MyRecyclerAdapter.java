package lamaatech.com.sessionthreelive;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyRecyclerAdapter
        extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {
    private ArrayList<String> nameArrayList;
    private Context context;
    private LayoutInflater inflater;

    public MyRecyclerAdapter(Context newContext, ArrayList<String> newNames) {
        nameArrayList = newNames;
        context = newContext;
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_row, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String selectedName = nameArrayList.get(position);
        holder.textViewName.setText(selectedName);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, selectedName, Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return nameArrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        View view;
        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            textViewName = itemView.findViewById(R.id.textViewName);

        }
    }
}
