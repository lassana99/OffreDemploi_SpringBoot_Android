package sn.esmt.dembe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import sn.esmt.dembe.model.Cv;
import sn.esmt.dembe.R;


public class CvAdaptater extends BaseAdapter {

    private ArrayList<Cv> cvs;
    private LayoutInflater myInflater;

    public CvAdaptater(Context context, ArrayList<Cv> cvs) {
        this.myInflater = LayoutInflater.from(context);
        this.cvs = cvs;
    }

    @Override
    public int getCount() {
        return this.cvs.size();
    }

    @Override
    public Object getItem(int arg0) {
        return this.cvs.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        TextView textid;
        TextView textemail;
        TextView textadresse;

        TextView textnom;
        TextView textprenom;
        TextView textage;
        TextView texttelephone;
        TextView textspecialite;
        TextView textniveauEtude;
        TextView textexperienceProfessionnelle;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = myInflater.inflate(R.layout.list_cv_item, null);
            holder = new ViewHolder();
            holder.textemail = (TextView) convertView.findViewById(R.id.cvListItem_email);
            holder.textadresse = (TextView) convertView.findViewById(R.id.cvListItem_adresse);
            holder.textnom = (TextView) convertView.findViewById(R.id.cvListItem_nom);
            holder.textprenom = (TextView) convertView.findViewById(R.id.cvListItem_prenom);
            holder.textage = (TextView) convertView.findViewById(R.id.cvListItem_age);
            holder.texttelephone = (TextView) convertView.findViewById(R.id.cvListItem_telephone);
            holder.textspecialite = (TextView) convertView.findViewById(R.id.cvListItem_specialite);
            holder.textniveauEtude = (TextView) convertView.findViewById(R.id.cvListItem_niveauEtude);
            holder.textexperienceProfessionnelle = (TextView) convertView.findViewById(R.id.cvListItem_experienceProfessionnelle);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textemail.setText(cvs.get(position).getEmail());
        holder.textadresse.setText(cvs.get(position).getAdresse());
        holder.textnom.setText(cvs.get(position).getNom());
        holder.textprenom.setText(cvs.get(position).getPrenom());
        holder.textage.setText(cvs.get(position).getAge() + "");
        holder.texttelephone.setText(cvs.get(position).getTelephone());
        holder.textspecialite.setText(cvs.get(position).getSpecialite());
        holder.textniveauEtude.setText(cvs.get(position).getNiveauEtude());
        holder.textexperienceProfessionnelle.setText(cvs.get(position).getExperienceProfessionnelle());

        return convertView;

    }
}
