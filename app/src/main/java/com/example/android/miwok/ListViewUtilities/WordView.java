package com.example.android.miwok.ListViewUtilities;

public class WordView {
    private final String defaultTranslation;
    private final String miwokTranslation;
    private final int imageId;

    public WordView(String defaultTranslation, String miwokTranslation, int imageSrc) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.imageId = imageSrc;
    }

    public WordView(String defaultTranslation, String miwokTranslation) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.imageId = 0;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }

    public int getImageId() {
        return imageId;
    }

    public boolean hasImage() {
        return imageId != 0;
    }
}
