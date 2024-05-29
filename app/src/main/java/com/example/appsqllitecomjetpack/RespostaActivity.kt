package com.example.appsqllitecomjetpack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.appsqllitecomjetpack.db.DBHelper

class RespostaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNome: EditText = findViewById(R.id.edtNome)
        val edtEndereco: EditText = findViewById(R.id.edtEndereco)
        val edtBairro: EditText = findViewById(R.id.edtBairro)
        val edtCep: EditText = findViewById(R.id.edtCep)
        val edtTelefone: EditText = findViewById(R.id.edtTelefone)
        val btnConfirmar: Button = findViewById(R.id.btnCadastrar)

        edtNome.setText(intent.getStringExtra("nome"))
        edtEndereco.setText(intent.getStringExtra("endereco"))
        edtBairro.setText(intent.getStringExtra("bairro"))
        edtCep.setText(intent.getStringExtra("cep"))
        edtTelefone.setText(intent.getStringExtra("telefone"))


        //SQLite

        val db = DBHelper(this, null)

        btnConfirmar.setOnClickListener {
            db.addPessoa(edtNome.text.toString(), edtEndereco.text.toString(), edtBairro.text.toString(),
                edtCep.text.toString(), edtTelefone.text.toString())
            finish()
        }
    }
}
