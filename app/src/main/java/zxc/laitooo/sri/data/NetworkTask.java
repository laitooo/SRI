package zxc.laitooo.sri.data;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

/**
 * Created by Laitooo San on 06/06/2019.
 */

public class NetworkTask extends AsyncTask {

    ProgressDialog dialog;
    Context c;
    RequestQueue queue;
    boolean isPost;
    String url;
    Response.Listener<String> listener;
    boolean error;
    String error_detail;
    Map<String,String> parameters;
    boolean isDialog;

    public NetworkTask(boolean IsPost,String Url,Response.Listener<String> Listener,Context context
            ,Map<String,String> Parameters) {
        queue = Volley.newRequestQueue(context);
        dialog = new ProgressDialog((Activity)context);
        dialog.setTitle("Loading...");
        c = context;
        url = Url;
        listener = Listener;
        isPost = IsPost;
        parameters = Parameters;
        isDialog = true;
    }

    public NetworkTask(boolean IsPost,String Url,Response.Listener<String> Listener,Context context
            ,Map<String,String> Parameters,boolean IsDialog) {
        queue = Volley.newRequestQueue(context);
        dialog = new ProgressDialog((Activity)context);
        dialog.setTitle("Loading...");
        c = context;
        url = Url;
        listener = Listener;
        isPost = IsPost;
        parameters = Parameters;
        isDialog = IsDialog;
    }

    public void executeTask(){
        executeOnExecutor(THREAD_POOL_EXECUTOR);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        error = false;
        error_detail = "tt";
        if (dialog != null)
            if (isDialog)
                dialog.show();
    }

    @Override
    protected Object doInBackground(final Object[] params) {
        StringRequest request = new StringRequest(isPost ? Request.Method.POST : Request.Method.GET,
                url, listener, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                error = true;
                if (volleyError != null) {
                    error_detail = " " + volleyError.getMessage();
                    //Log.e("DSDASDASDASDAD","Erewrewrewr");
                } else {
                    error_detail = "Network connection error";
                    //Log.e("ASDSADASDASD","iououiouiouo");
                }
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return parameters;
            }
        };

        request.setShouldCache(false);
        queue.add(request);
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        if (dialog != null )
            if (dialog.isShowing())
                dialog.dismiss();
        if (error)
            if (isDialog)
                Toast.makeText(c,error_detail,Toast.LENGTH_LONG).show();
            //Log.e("ERROR","ERROOOOOOOR " +
            //Toast.makeText(c,error_detail,Toast.LENGTH_LONG).show();
    }


}
