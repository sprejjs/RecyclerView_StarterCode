package com.spreys.viewholderexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.spreys.viewholderexample.Model.Contact;
import com.spreys.viewholderexample.Model.MockDataGenerator;

import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private List<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        contacts = MockDataGenerator.getMockContacts(1000);

        //TODO Step 3: Replace ListView with RecyclerView in the Java file
        ListView listView = (ListView) findViewById(R.id.list);

        //TODO Step 10: Attach the new adapter
        listView.setAdapter(new ContactsAdapter(this, contacts));

        //TODO Step 11: Attach a LayoutManager
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Contact selectedContact = contacts.get(position);

                Intent intent = new Intent(getBaseContext(), DetailsActivity.class);
                intent.putExtra(DetailsActivity.EXTRA_CONTACT, selectedContact);
                startActivity(intent);
            }
        });
    }
}