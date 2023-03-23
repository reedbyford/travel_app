package android.reedbyford.travelapp.UI;

import android.content.Context;
import android.content.Intent;
import android.reedbyford.travelapp.R;
import android.reedbyford.travelapp.entities.Excursion;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExcursionAdapter extends RecyclerView.Adapter<ExcursionAdapter.ExcursionViewHolder> {
    class ExcursionViewHolder extends RecyclerView.ViewHolder{
        private final TextView excursionItemView;
        private final TextView excursionItemView2;
        private ExcursionViewHolder(View itemview){
            super(itemview);
            excursionItemView = itemview.findViewById(R.id.textViewexcursiontitle);
            excursionItemView2 = itemview.findViewById(R.id.textViewexcursiondate);

            itemview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    final Excursion current = mExcursions.get(position);
                    Intent intent = new Intent(context, ExcursionDetails.class);
                    intent.putExtra("excursionID", current.getExcursionID());
                    intent.putExtra("title", current.getTitle());
                    intent.putExtra("date", current.getDate());
                    intent.putExtra("vacationID", current.getVacationID());
                    context.startActivity(intent);
                }
            });
        }
    }
    private List<Excursion> mExcursions;
    private final Context context;
    private final LayoutInflater mInflater;
    public ExcursionAdapter(Context context){
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }
    @NonNull
    @Override
    public ExcursionAdapter.ExcursionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.excursion_list_item,parent,false);
        return new ExcursionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExcursionAdapter.ExcursionViewHolder holder, int position) {
        if(mExcursions != null){
            Excursion current = mExcursions.get(position);
            String title = current.getTitle();
            String date = current.getDate();
            holder.excursionItemView.setText(title);
            holder.excursionItemView2.setText(date);

        }else{
            holder.excursionItemView.setText("No Excursion Name");
            holder.excursionItemView.setText("No excursion date");
        }
    }

    public void setExcursions(List<Excursion> excursions){
        mExcursions = excursions;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mExcursions.size();
    }

}
