package com.example.android.newapp;

import android.app.Activity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     * @param context The current context. Used to inflate the layout file.
     * @param newsList  List of objects to display in a list.
     */
    public NewsAdapter(Activity context, List<News> newsList){

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context,0, newsList);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link News} object located at this position in the list
        News currentNews = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID section
        TextView sectionTextView = (TextView) listItemView.findViewById(R.id.section_text_view);

        // Get color background for section
        int sectionColor = getSectionColor(currentNews.getPillarName());
        //Set color background for section
        sectionTextView.setBackgroundColor(sectionColor);

        // Get the Section from the current News object and
        // set this text on the sectionTextView
        sectionTextView.setText(currentNews.getSection());



        // Find the TextView in the list_item.xml layout with the ID title
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        // Get the title from the current News object and
        // set this text on the titleTextView
        titleTextView.setText(currentNews.getTitle());

        // Get the date from the current News object
        String date = currentNews.getDate();

        // Prepare appropriate date format
        String dateOfPublication;

        String[] parts = date.split("T");
        dateOfPublication = parts[0];

        // Find the TextView in the list_item.xml layout with the ID date?_date
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_date_text_view);
        // Set date as a text on the dateTextView
        dateTextView.setText(dateOfPublication);

        // Find the TextView in the list_item.xml layout with the ID author
        TextView authorTextView =(TextView) listItemView.findViewById(R.id.author_text_view);
        // Set author as a text on the authorTextView
        authorTextView.setText(currentNews.getAuthor());


        // Return the whole list item layout
        // so that it can be shown in the ListView
        return listItemView;

    }

    // Choose a color for appropriate section
    private int getSectionColor(String pillarSection){
        int sectionColorID ;

        switch (pillarSection) {
            case "News":
                sectionColorID = R.color.section_news;
                break;
            case "Opinion":
                sectionColorID = R.color.section_opinion;
                break;
            case "Sport":
                sectionColorID = R.color.section_sport;
                break;
            case "Arts":
                sectionColorID = R.color.section_culture;
                break;
            case "Lifestyle":
                sectionColorID = R.color.section_lifestyle;
                break;
            default:
                sectionColorID = R.color.section_other;
                break;
        }

        return ContextCompat.getColor(getContext(), sectionColorID);
    }
}
