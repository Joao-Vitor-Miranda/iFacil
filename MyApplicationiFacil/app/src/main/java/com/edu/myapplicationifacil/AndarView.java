package com.edu.myapplicationifacil;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class AndarView {

    private boolean isTerreoExpanded = false;
    private boolean isAndar1Expanded = false;
    private boolean isAndar2Expanded = false;
    private boolean isAndar3Expanded = false;

    public AndarView(Activity activity) {
        Button btnTerreo = activity.findViewById(R.id.btn_terreo);
        Button btnAndar1 = activity.findViewById(R.id.btn_andar1);
        Button btnAndar2 = activity.findViewById(R.id.btn_andar2);
        Button btnAndar3 = activity.findViewById(R.id.btn_andar3);

        LinearLayout layoutTerreo = activity.findViewById(R.id.layout_terreo);
        LinearLayout layoutAndar1 = activity.findViewById(R.id.layout_andar1);
        LinearLayout layoutAndar2 = activity.findViewById(R.id.layout_andar2);
        LinearLayout layoutAndar3 = activity.findViewById(R.id.layout_andar3);

        btnTerreo.setOnClickListener(v -> {
            isTerreoExpanded = !isTerreoExpanded;
            layoutTerreo.setVisibility(isTerreoExpanded ? View.VISIBLE : View.GONE);
        });

        btnAndar1.setOnClickListener(v -> {
            isAndar1Expanded = !isAndar1Expanded;
            layoutAndar1.setVisibility(isAndar1Expanded ? View.VISIBLE : View.GONE);
        });

        btnAndar2.setOnClickListener(v -> {
            isAndar2Expanded = !isAndar2Expanded;
            layoutAndar2.setVisibility(isAndar2Expanded ? View.VISIBLE : View.GONE);
        });

        btnAndar3.setOnClickListener(v -> {
            isAndar3Expanded = !isAndar3Expanded;
            layoutAndar3.setVisibility(isAndar3Expanded ? View.VISIBLE : View.GONE);
        });

        layoutTerreo.setOnClickListener(v -> openAgenda(activity));
        layoutAndar1.setOnClickListener(v -> openAgenda(activity));
        layoutAndar2.setOnClickListener(v -> openAgenda(activity));
        layoutAndar3.setOnClickListener(v -> openAgenda(activity));
    }

    private void openAgenda(Activity activity) {
        Intent intent = new Intent(activity, AgendaView.class);
        activity.startActivity(intent);
    }
}



