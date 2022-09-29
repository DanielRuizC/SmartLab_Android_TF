package com.project.smartlab_tf.ui.historialSolicitudes;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.project.smartlab_tf.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HistorialSolicitudesFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
/*
    private OnFragmentInteractionListener mListener;*/

    RecyclerView recyclerSolicitudes;
    ArrayList<SolicitudModel> listaSolicitudes;
    ProgressDialog dialog;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    public HistorialSolicitudesFragment(){

    }

    public static HistorialSolicitudesFragment newInstance(String param1, String param2){
        HistorialSolicitudesFragment fragment  = new HistorialSolicitudesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_historialsolicitudes,container,false);

        listaSolicitudes = new ArrayList<>();

        recyclerSolicitudes = (RecyclerView) vista.findViewById(R.id.recyclerSolicitudes);
        recyclerSolicitudes.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerSolicitudes.setHasFixedSize(true);

        request = Volley.newRequestQueue(getContext());
        
        cargarWebService();

        return vista;
    }

    private void cargarWebService() {

        dialog = new ProgressDialog(getContext());
        dialog.setMessage("Consultando...");
        dialog.show();

        String url = "http://181.66.138.91:8080/laboratorio_db/solicitudes.php";

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        request.add(jsonObjectRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(), "No se puede conectar" + error.toString(), Toast.LENGTH_SHORT).show();
        System.out.println();
        Log.d("ERROR: ", error.toString());
        dialog.hide();
    }

    @Override
    public void onResponse(JSONObject response) {

        SolicitudModel solicitudModel = null;

        JSONArray json = response.optJSONArray("solicitudes");

        try {

            for (int i = 0; i < json.length(); i++) {
                solicitudModel = new SolicitudModel();
                JSONObject jsonObject = null;
                jsonObject = json.getJSONObject(i);

                solicitudModel.setIdCodigoSolicitud(jsonObject.optString("codigo"));
                solicitudModel.setStrEstadoSolicitud(jsonObject.optString("estado"));
                solicitudModel.setStrFechaRegistroSolicitud(jsonObject.optString("fecha"));
                listaSolicitudes.add(solicitudModel);
            }
            dialog.hide();
            SolicitudAdapter adapter = new SolicitudAdapter(listaSolicitudes);
            recyclerSolicitudes.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "No se pudo establecer conexión con el servidor"
                    + " "+response, Toast.LENGTH_SHORT).show();
            dialog.hide();
        }

    }

    /*public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener. onFragmentInteraction(uri);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }*/
}


