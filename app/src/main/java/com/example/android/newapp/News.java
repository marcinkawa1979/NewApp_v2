package com.example.android.newapp;

public class News {

    // Title of News from database
    private String mTitle;

    // Section group form database
    private String mSectionName;

    // Url address of news item from database
    private String mWebUrl;

    // Date of publication of News
    private String mDate;

    // Author name
    private String mAuthor;

    // Pillar name
    private String mPillarName;

    /**
     * Creates new News object
     * @param sectionName name of group news
     * @param title of the news
     * @param webUrl of news
     * @param author of a news
     */
    public News(String sectionName, String title, String webUrl, String date, String author, String pillarName){

        this.mSectionName = sectionName;
        this.mTitle = title;
        this.mWebUrl = webUrl;
        this.mDate = date;
        this.mAuthor = author;
        this.mPillarName = pillarName;
    }


    public String getSection() {
        return mSectionName;
    }


    public String getTitle() {
        return mTitle;
    }


    public String getWebUrl() {
        return mWebUrl;
    }


    public String getDate() {
        return mDate;
    }


    public String getAuthor() {
        return mAuthor;
    }


    public String getPillarName() {
        return mPillarName;
    }
}
