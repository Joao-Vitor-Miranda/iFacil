package com.edu.myapplicationifacil;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;

public class AgendaView extends AppCompatActivity {
    private LinearLayout expandableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda); // Define o layout da agenda

        setupView(); // Configura a visualização após o layout ser definido
    }

    private void setupView() {
        Button btnSemana = findViewById(R.id.btnSemana);
        expandableLayout = findViewById(R.id.expandableLayout);

        // Botão para mostrar/esconder as semanas
        btnSemana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableLayout.getVisibility() == View.GONE) {
                    expandableLayout.setVisibility(View.VISIBLE);
                } else {
                    expandableLayout.setVisibility(View.GONE);
                }
            }
        });

        setupTimeSlotListeners();
    }

    private void setupTimeSlotListeners() {
        setClickListener(R.id.h1Box);
        setClickListener(R.id.h2Box);
        setClickListener(R.id.h3Box);
        setClickListener(R.id.h1BoxTerca);
        setClickListener(R.id.h2BoxTerca);
        setClickListener(R.id.h3BoxTerca);
        setClickListener(R.id.h1BoxQuarta);
        setClickListener(R.id.h2BoxQuarta);
        setClickListener(R.id.h3BoxQuarta);
        setClickListener(R.id.h1BoxQuinta);
        setClickListener(R.id.h2BoxQuinta);
        setClickListener(R.id.h3BoxQuinta);
        setClickListener(R.id.h1BoxSexta);
        setClickListener(R.id.h2BoxSexta);
        setClickListener(R.id.h3BoxSexta);
        setClickListener(R.id.h1BoxSabado);
        setClickListener(R.id.h2BoxSabado);
        setClickListener(R.id.h3BoxSabado);
    }

    private void setClickListener(int viewId) {
        TextView timeSlot = findViewById(viewId);
        timeSlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationDialog(timeSlot);
            }
        });
    }

    private void showConfirmationDialog(TextView timeSlot) {
        final int currentColor = ((ColorDrawable) timeSlot.getBackground()).getColor();

        boolean isOccupied = currentColor == getResources().getColor(android.R.color.holo_red_light);

        String message = isOccupied ? "Deseja desocupar o horário " + timeSlot.getText().toString() + "?" :
                "Deseja ocupar o horário " + timeSlot.getText().toString() + "?";

        new AlertDialog.Builder(this)
                .setTitle("Confirmação")
                .setMessage(message)
                .setPositiveButton("Sim", (dialog, which) -> {
                    int newColor;
                    if (isOccupied) {
                        newColor = Color.parseColor("#99cc00"); // Usando a cor verde
                    } else {
                        newColor = getResources().getColor(android.R.color.holo_red_light);
                    }
                    timeSlot.setBackgroundColor(newColor);
                })
                .setNegativeButton("Não", null)
                .show();
    }
}


