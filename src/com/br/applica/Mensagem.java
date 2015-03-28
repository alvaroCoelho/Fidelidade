package com.br.applica;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Mensagem extends Activity {

	TextView txtTituloMensagem;
    EditText etNomePessoa,etEmail,etAssunto,etMensagem;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mensagem);
		
		txtTituloMensagem = (TextView)findViewById(R.id.txttituloMensagem);
		etNomePessoa = (EditText)findViewById(R.id.etNome);
		etEmail = (EditText)findViewById(R.id.etEmail);
		etAssunto = (EditText)findViewById(R.id.etAssunto);
		etMensagem = (EditText)findViewById(R.id.etMensagem);
		
	}
}
