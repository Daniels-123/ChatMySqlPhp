package com.example.chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.chat.Request.RegisterRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class Registro extends AppCompatActivity {

	EditText nombre, correo, password;
	Button btnregistrarse;
	RequestQueue requestQueue;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro);

		nombre = findViewById(R.id.txtNombre);
		correo = findViewById(R.id.txtCorreo);
		password = findViewById(R.id.txtPassword);
		btnregistrarse = findViewById(R.id.btnregistro);
		requestQueue = Volley.newRequestQueue(Registro.this);



		btnregistrarse.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				final String strnombre = nombre.getText().toString();
				final String strcorreo = correo.getText().toString();
				final String strpassword = password.getText().toString();

				if (strnombre.isEmpty() || strcorreo.isEmpty() || strpassword.isEmpty()){
					Toast.makeText(Registro.this, "No olvides todos los campos", Toast.LENGTH_SHORT).show();
				}else{

					RegisterRequest registerRequest = new RegisterRequest(strnombre, strcorreo, strpassword, new Response.Listener<String>() {
						@Override
						public void onResponse(String response) {
							
							Log.e("Response from server", response);

							try {
								if (new JSONObject(response).getBoolean("success")) {

									Toast.makeText(Registro.this, "Registrado Correctamente", Toast.LENGTH_SHORT).show();
									finish();
									

								} else
									Toast.makeText(Registro.this, "El usuario ya existe", Toast.LENGTH_SHORT).show();

							} catch (JSONException e) {
								e.printStackTrace();
								Toast.makeText(Registro.this, "Falló la conexión al registrarse", Toast.LENGTH_SHORT).show();
							}
						}
					});
					requestQueue.add(registerRequest);

				}
			}
		});

	}
}
