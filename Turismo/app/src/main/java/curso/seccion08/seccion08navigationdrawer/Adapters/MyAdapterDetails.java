package curso.seccion08.seccion08navigationdrawer.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import curso.seccion08.seccion08navigationdrawer.Models.Place;
import curso.seccion08.seccion08navigationdrawer.R;

/**
 * Created by Rust on 20/05/2018.
 */

public class MyAdapterDetails extends RecyclerView.Adapter<MyAdapterDetails.ViewHolder>{
    private List<Place> places;
    private int layout;

    private Context context;

    public MyAdapterDetails(List<Place> places, int layout){
        this.places = places;
        this.layout = layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        context = parent.getContext();
        MyAdapterDetails.ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(places.get(position));
    }

    @Override
    public int getItemCount() {

        return places.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //Elementos UI a rellenar
        public TextView textViewName;
        public ImageView imgPlace;


        public ViewHolder(View itemView) {
            //Recibe la vista completa. La pasa la constructor padre y enlazamos referencias UI
            //con nuestras propiedades ViewHolder declaradas justo arriba
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.textViewTitle);
            imgPlace = (ImageView) itemView.findViewById(R.id.imageViewPlace);
        }

        public void  bind(final Place place){
            //procesamos los datos renderizar
            textViewName.setText(place.getNombre());
            //Libreria externa
            Picasso.with(context).load(place.getImgPlace()).fit().into(imgPlace);

        }
    }

}
