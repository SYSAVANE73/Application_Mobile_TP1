package univavignon.fr.tp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    @NonNull
    private String[] pays = {"France",
            "Allemagne",
            "Espagne",
            "Afrique du Sud",
            "Etats-Unis",
            "Japon"
    };
    private String[] capitale = {"Paris",
            "Berlin",
            "Madrid",
            "Pretoria",
            "Washinton",
            "Tokio"
    };
    private int[] images = {
            R.drawable.ic_flag_of_france_320px,
            R.drawable.ic_flag_of_germany_320px,
            R.drawable.ic_flag_of_spain_320px,
            R.drawable.ic_flag_of_south_africa_320px,
            R.drawable.ic_flag_of_the_united_states_320px,
            R.drawable.ic_flag_of_japan_320px
    };
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imagePays;
        TextView itemPays;
        TextView itemCapitale;

        ViewHolder(View itemView) {
            super(itemView);
            imagePays = itemView.findViewById(R.id.listPays);
            itemPays = itemView.findViewById(R.id.textView);
            itemCapitale = itemView.findViewById(R.id.textView2);

            int position = getAdapterPosition();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    ListFragmentDirections.ActionListFragmentToDetailFragment action = ListFragmentDirections.actionListFragmentToDetailFragment();
                    action.setKeyChaterId(position);
                    Navigation.findNavController(v).navigate(action);
                }
            });

        }
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.itemPays.setText(pays[i]);
        viewHolder.itemCapitale.setText(capitale[i]);
        viewHolder.imagePays.setImageResource(images[i]);
    }
    @Override
    public int getItemCount() {
        return pays.length;
    }
}
