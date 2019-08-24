package com.example.omy.tab.expandable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.omy.tab.R;
import com.example.omy.tab.expandable.model.Phone;
import com.example.omy.tab.expandable.model.PhoneCategory;

import java.util.ArrayList;
import java.util.List;

import iammert.com.expandablelib.ExpandableLayout;
import iammert.com.expandablelib.Section;

public class ExpandableActivity extends AppCompatActivity {

    public boolean expandet = false;
    public ArrayList<View>views;
    public ArrayList<Boolean> isExpandent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);

        views = new ArrayList<>();
        isExpandent = new ArrayList<>();

        ExpandableLayout layout = findViewById(R.id.expandable_layout);
        layout.setRenderer(new ExpandableLayout.Renderer<PhoneCategory,Phone>(){
            @Override
            public void renderParent(View view, PhoneCategory phoneCategory, boolean isExpanded, int parentPosition) {
                expandet = isExpanded;
                ((TextView)view.findViewById(R.id.tv_parent_name)).setText(phoneCategory.name);
                view.findViewById(R.id.arrow).setBackgroundResource(expandet?R.drawable.ic_arror_up : R.drawable.ic_arror_dow);
                views.add(view);
                isExpandent.add(isExpanded);
            }

            @Override
            public void renderChild(View view, Phone phone, int parentPosition, int chilPosition) {
                View padre = views.get(parentPosition);
                if(!isExpandent.get(parentPosition)) {
                    padre.findViewById(R.id.arrow).setBackgroundResource(R.drawable.ic_arror_up);
                    isExpandent.set(parentPosition,true);
                }
                else {
                    padre.findViewById(R.id.arrow).setBackgroundResource(R.drawable.ic_arror_dow);
                    isExpandent.set(parentPosition,false);
                }
                ((TextView)view.findViewById(R.id.tv_child_name)).setText(phone.name);

            }
        });

        layout.addSection(getSection()); //todo se añaden las secciones
        layout.addSection(getSection());
        layout.addSection(getSection());
    }

    private Section<PhoneCategory,Phone> getSection() { //todo categorita y dentro de la seccion
        Section<PhoneCategory, Phone> section = new Section<>();
        PhoneCategory phoneCategory = new PhoneCategory("phone");
        List<Phone> listPhone = new ArrayList<>();
        for (int i = 0; i < 0; i++) {
            listPhone.add(new Phone("Phone " + i));
        }
        section.parent = phoneCategory;
        section.children.addAll(listPhone);
        return section;
    }
}
