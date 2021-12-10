package com.example.projeto_amu.telas.dialogos;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

/**
 * Gerador de diálogos da aplicação
 * @author Felipe Nathan
 * @version 1.0 08/12/2021
 * @since 08/12/2021
 */
public class Dialogo extends AppCompatDialogFragment {

    private String titulo;
    private String mensagem;

    public Dialogo(String titulo, String mensagem) {
        this.titulo = titulo;
        this.mensagem = mensagem;
    }


    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(titulo)
                .setMessage(mensagem)
                .setPositiveButton("entendi", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();
    }
}
