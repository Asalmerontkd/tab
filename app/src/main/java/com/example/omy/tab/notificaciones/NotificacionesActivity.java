package com.example.omy.tab.notificaciones;

import android.app.Notification;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.omy.tab.R;
import com.example.omy.tab.Utilerias.Utils;
import com.example.omy.tab.databinding.ActivityNotificacionesBinding;

public class NotificacionesActivity extends AppCompatActivity {

    private ActivityNotificacionesBinding binding;
    private boolean isHighImportan = false;
    private NotificacionesHandler notificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_notificaciones);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_notificaciones);

        binding.btnEnviarnotificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btnEnviarnotificacion.setEnabled(false);
                sendNotificacion();
            }
        });

        binding.swImportan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isHighImportan = isChecked;
            }
        });

      notificar = new NotificacionesHandler(this);
    }

   private void sendNotificacion()
    {
        if(!binding.etTitle.getText().toString().isEmpty() && !binding.edMensaje.getText().toString().isEmpty())
        {
            Notification.Builder notifiacionBuilder = notificar.crearNotificacion(binding.etTitle.getText().toString(),binding.edMensaje.getText().toString(),isHighImportan);
            notificar.getManager().notify(1,notifiacionBuilder.build());
        }

        binding.btnEnviarnotificacion.setEnabled(true);
    }
}
