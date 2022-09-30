package com.project.smartlab_tf.ui.tiposAnalisis;

import static androidx.navigation.Navigation.findNavController;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.project.smartlab_tf.R;
import com.project.smartlab_tf.databinding.FragmentTiposanalisisBinding;
import com.project.smartlab_tf.ui.historialSolicitudes.HistorialSolicitudesFragment;
import com.project.smartlab_tf.ui.historialSolicitudes.SolicitudAdapter;
import com.project.smartlab_tf.ui.historialSolicitudes.SolicitudModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TiposAnalisisFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    RecyclerView recyclerAnalisis;
    ArrayList<AnalisisModel> listaAnalisis;
    ProgressDialog dialog;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    public TiposAnalisisFragment (){

    }

    public static TiposAnalisisFragment newInstance(String param1, String param2){
        TiposAnalisisFragment fragment  = new TiposAnalisisFragment();
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
        View vista = inflater.inflate(R.layout.fragment_tiposanalisis,container,false);

        listaAnalisis = new ArrayList<>();

        recyclerAnalisis = (RecyclerView) vista.findViewById(R.id.recyclerAnalisis);
        recyclerAnalisis.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerAnalisis.setHasFixedSize(true);

        request = Volley.newRequestQueue(getContext());

        cargarWebService();

        return vista;
    }

    private void cargarWebService() {

        dialog = new ProgressDialog(getContext());
        dialog.setMessage("Consultando...");
        dialog.show();

        String url = "http://192.168.0.109:8080/laboratorio_db/analisis.php";
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        request.add(jsonObjectRequest);
    }

    @Override
    public void onResponse(JSONObject response) {

        AnalisisModel analisisModel = null;

        JSONArray json = response.optJSONArray("analisis");

        try {

            for (int i = 0; i < json.length(); i++) {
                analisisModel = new AnalisisModel();
                JSONObject jsonObject = null;
                jsonObject = json.getJSONObject(i);

                analisisModel.setStrTitulo(jsonObject.optString("titulo"));
                analisisModel.setStrDetalleBreve(jsonObject.optString("detalleBreve"));
                analisisModel.setrutaImagen(jsonObject.optString("ruta_imagen"));
                listaAnalisis.add(analisisModel);
            }
            dialog.hide();
            AnalisisAdapter adapter = new AnalisisAdapter(listaAnalisis, getContext());
            recyclerAnalisis.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "No se pudo establecer conexión con el servidor"
                    + " " + response, Toast.LENGTH_SHORT).show();
            dialog.hide();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(), "No se puede conectar" + error.toString(), Toast.LENGTH_SHORT).show();
        System.out.println();
        Log.d("ERROR: ", error.toString());
        dialog.hide();
    }
}