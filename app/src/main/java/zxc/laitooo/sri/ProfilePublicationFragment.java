package zxc.laitooo.sri;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Zizo on 12/29/2017.
 */
public class ProfilePublicationFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.profile_publication,container,false);
        RecyclerView re = (RecyclerView)v.findViewById(R.id.PublicationRecycler);
        Context c = getActivity().getApplicationContext();

        ArrayList<Publications> list = new ArrayList<>();
        list.add(new Publications("Concomitant tuberculosis and hydatid cyst in actionBar solitary pulmonary nodule of left lower lobe",
                "Ahmed AH,Elhassan NB,Elhassan AM.","BMJ case reposts","9/7/09 12:00 AM"));
        list.add(new Publications("Grown-up congenital heart disease new_language done by one surgon in Sudan",
                "Elsayed, A>Bafadny,M.","Clinics Cardive Publishing","11/1/08 12:00 AM"));
        re.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(c);
        re.setLayoutManager(layoutManager);
        PublicationsAdapter adapter = new PublicationsAdapter(list,c);
        re.setAdapter(adapter);
        return v;
    }
}
