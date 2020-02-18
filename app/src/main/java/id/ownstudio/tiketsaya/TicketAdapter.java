package id.ownstudio.tiketsaya;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Willyanto Wijaya Sulaiman on 2020-02-18.
 */
public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.MyViewHolder> {

    Context context;
    ArrayList<MyTicket> myTickets;

    public TicketAdapter(Context context, ArrayList<MyTicket> myTickets) {
        this.context = context;
        this.myTickets = myTickets;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_myticket, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.xnama_wisata.setText(myTickets.get(position).getNama_wisata());
        holder.xlokasi.setText(myTickets.get(position).getLokasi());
        holder.xjumlah_tiket.setText(myTickets.get(position).getJumlah_tiket() + " Tickets");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MyTicketDetailActivity.class);
                intent.putExtra("nama_wisata", myTickets.get(position).getNama_wisata());
                intent.putExtra("lokasi", myTickets.get(position).getLokasi());
                intent.putExtra("jumlah_tiket", myTickets.get(position).getJumlah_tiket());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myTickets.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView xnama_wisata, xlokasi, xjumlah_tiket;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            xnama_wisata = itemView.findViewById(R.id.xnama_wisata);
            xlokasi = itemView.findViewById(R.id.xlokasi);
            xjumlah_tiket = itemView.findViewById(R.id.xjumlah_tiket);
        }
    }
}
