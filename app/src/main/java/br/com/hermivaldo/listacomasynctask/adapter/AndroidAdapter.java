package br.com.hermivaldo.listacomasynctask.adapter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.hermivaldo.listacomasynctask.R;
import br.com.hermivaldo.listacomasynctask.model.Android;

public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.AndroidItemViewHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<Android> androids;

    public AndroidAdapter(Context context, List<Android> androids) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.androids = androids;
    }

    @Override
    public AndroidItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_android, parent, false);
        return new AndroidItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AndroidItemViewHolder holder, int position) {
        Android android = androids.get(position);

        holder.tvVersao.setText(android.getVersao());
        holder.tvAPI.setText(android.getApi());
        holder.tvNome.setText(android.getNome());

        Glide.with(context).load(android.getUrlImagem()).
                error(R.drawable.close).
                placeholder(R.mipmap.ic_launcher).into(holder.imgLogo);

    }

    @Override
    public int getItemCount() {
        return androids.size();
    }

    protected class AndroidItemViewHolder extends  RecyclerView.ViewHolder{

        private ImageView imgLogo;
        private TextView tvNome;
        private TextView tvAPI;
        private TextView tvVersao;

        public AndroidItemViewHolder(View itemView) {
            super(itemView);

            this.tvNome = itemView.findViewById(R.id.tvNome);
            this.tvAPI = itemView.findViewById(R.id.tvApi);
            this.tvVersao =  itemView.findViewById(R.id.tvVersao);
            this.imgLogo = itemView.findViewById(R.id.imagemVersao);
        }
    }
}
