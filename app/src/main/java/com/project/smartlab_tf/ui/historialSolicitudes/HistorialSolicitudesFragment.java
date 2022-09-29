package com.project.smartlab_tf.ui.historialSolicitudes;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
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


public class HistorialSolicitudesFragment extends Fragment {

    private ArrayList<SolicitudModel> listaSolicitudesModel;
    private RequestQueue rq;
    private RecyclerView rv1;
    private AdaptadorSolicitud adaptadorSolicitud;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_historialsolicitudes);
        listaSolicitudesModel = new ArrayList<>();
        rq = Volley.newRequestQueue(this);
        for (int f = 0; f < 10; f++)
            cargaPersona();
        rv1 =
        rv1 = findViewById(R.id.rv1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv1.setLayoutManager(linearLayoutManager);
        adaptadorSolicitud = new AdaptadorSolicitud();
        rv1.setAdapter(adaptadorSolicitud);
    }

    private void cargaPersona() {
        String url = "http://181.66.138.91:8080/laboratorio_db/solicitudes.php";
        JsonObjectRequest requerimiento = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String valor = response.get("solicitudes").toString();
                            JSONArray arreglo = new JSONArray(valor);
                            JSONObject objeto = new JSONObject(arreglo.get(0).toString());
                            String codigo = objeto.getString("codigo");
                            String estadoSoli = objeto.getString("estado");
                            String fechaSoli = objeto.getString("fecha");
                            SolicitudModel solicitudModel = new SolicitudModel(codigo, estadoSoli, fechaSoli);
                            listaSolicitudesModel.add(solicitudModel);
                            adaptadorSolicitud.notifyItemRangeInserted(listaSolicitudesModel.size(), 1);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){

                    }
                });
        rq.add(requerimiento);
    }

    private class AdaptadorSolicitud extends RecyclerView.Adapter<AdaptadorSolicitud.AdaptadorSolicitudHolder> {

        public AdaptadorSolicitudHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
            return new AdaptadorSolicitudHolder(getLayoutInflater().inflate(R.layout.fila_historial_solicitudes,parent,false));
        }

        public void onBindViewHolder(@NonNull AdaptadorSolicitudHolder holder, int position){
            holder.imprimir(position);
        }

        public int getItemCount(){
            return listaSolicitudesModel.size();
        }

        class AdaptadorSolicitudHolder extends RecyclerView.ViewHolder {
            TextView codigo, fechaSolicitud, estadoAtencion;

            public AdaptadorSolicitudHolder(@NonNull View itemView) {
                super(itemView);
                codigo = itemView.findViewById(R.id.txtCodigo);
                fechaSolicitud = itemView.findViewById(R.id.txtFechaSol);
                estadoAtencion = itemView.findViewById(R.id.txtEstadoSol);
            }
            public void imprimir (int position){
                codigo.setText("Codigo:"+listaSolicitudesModel.get(position).getIdCodigoSolicitud());
                fechaSolicitud.setText("Fecha:"+listaSolicitudesModel.get(position).getStrFechaRegistroSolicitud());
                estadoAtencion.setText("Estado:"+listaSolicitudesModel.get(position).getStrEstadoSolicitud());
            }
        }
    }
}

    /*@Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_historialsolicitudes);
        listaSolicitudesModel = new ArrayList<>();
        rq = Volley.newRequestQueue(this);
        cargaPersona();
    }*/


    /*private static final String URL_solicitudes = "http://181.66.138.91:8080/laboratorio_db/select_solicitudes.php";
    List<SolicitudModel> solicitudList;
    RecyclerView recyclerView;

    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.fragment_historialsolicitudes);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerSolicitudes);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        solicitudList = new ArrayList<>();

        loadsolicitudes();
    }

    private void loadsolicitudes() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_solicitudes,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject solicitud = array.getJSONObject(i);

                                solicitudList.add(new SolicitudModel(
                                        solicitud.getString("codigo"),
                                        solicitud.getString("estadoAtencion"),
                                        solicitud.getString("fechaSolicitud")
                                ));
                            }

                            SolicitudAdapter adapter = SolicitudAdapter(mCtx:;
                            HistorialSolicitudesFragment.this, solicitudList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        Volley.newRequestQueue(this).add(StringRequest);

    }

    private Object findViewById(int recyclerSolicitudes) {
    }

    private void setContentView(int fragment_historialsolicitudes) {
    }

}*/

    /*private FragmentHistorialsolicitudesBinding binding;
    private RequestQueue cola;
    private String url;
    //private ArrayList<SolicitudModel> habitaciones;
    //private final String url = "http://181.66.138.91:8080/laboratorio_db/solicitudes.php";

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHistorialsolicitudesBinding.inflate(inflater, container, false);
        *//*View root = binding.getRoot();*//*
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerSolicitudes.setLayoutManager(new LinearLayoutManager(requireContext()));
        url = "http://181.66.138.91:8080/laboratorio_db/solicitudes.php";

        cola = Volley.newRequestQueue(requireContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,
                response -> {
                    try {
                        JSONArray jsonArray = response.getJSONArray("solicitudes");
                        Gson gson = new Gson();
                        Type type = new TypeToken<ArrayList<SolicitudModel>>() {}.getType();
                        List<SolicitudModel> solicitudModelList = gson.fromJson(String.valueOf(jsonArray), type);
                        SolicitudAdapter adapterRecycler = new SolicitudAdapter(solicitudModelList);

                    }
                    catch (){

                    }
                }
                )

       *//*obtenerHistorial();*//*

    }

    *//*private void obtenerHistorial() {
        final String url = "http://181.66.138.91:8080/laboratorio_db/solicitudes.php";
        JsonObjectRequest JsonRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        binding.txtLista.setVisibility(View.VISIBLE);
                        JSONArray jsonArray = response.getJSONArray("solicitudes");
                        Gson gson = new Gson();
                        Type type = new TypeToken<ArrayList<SolicitudModel>>() {}.getType();
                        List<SolicitudModel> listaSolicitudes = gson.fromJson(String.valueOf(jsonArray), type);
                        SolicitudAdapter adapterRecyclerView = new SolicitudAdapter(listaSolicitudes);
                        binding.recyclerSolicitudes.setAdapter(adapterRecyclerView);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //Log.e("Log","Entro");
                }, error -> {
            Log.e("Log", error.toString());
        });
        this.cola.add(JsonRequest);
    }*//*

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}*/
