package com.example.android.miwok.Words;

public class Word {
    private final String defaultTranslation;
    private final String miwokTranslation;
    private final int imageId;
    private final int soundId;

    public Word(String defaultTranslation, String miwokTranslation, int imageSrc, int soundId) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.imageId = imageSrc;
        this.soundId = soundId;
    }

    public Word(String defaultTranslation, String miwokTranslation, int soundId) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.imageId = 0;
        this.soundId = soundId;
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

    public int getSoundId() {
        return soundId;
    }
}
