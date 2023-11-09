package edu.gatech.seclass.diabetes360.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OfferManager {
    private static OfferManager instance;
    private List<JobOffer> offers;
    private CurrentJob currJob;
    private JobScoreCalculator scoreCalculator;
    private List<Job> ranking;
    private Integer currentJobRanking;

    private Map<String, Number> weigths = new HashMap<>();

    private OfferManager() {
        this.offers = new ArrayList<>();
        this.ranking = new ArrayList<>();
        this.scoreCalculator = new JobScoreCalculator();
    }

    public static void startup() {
        instance = new OfferManager();
    }

    public static OfferManager getInstance() {
        if (instance == null) {
            startup();
        }
        return instance;
    }

    public void editCurrentJob(CurrentJob job) {
        this.currJob = job;
    }

    public void addOffer(JobOffer offer) {
        this.offers.add(offer);
        updateRanking();
    }

    public List<JobOffer> getOffers() {
        return this.offers;
    }

    public void removeOffer(JobOffer offer) {
        this.offers.remove(offer);
        updateRanking();
    }

    public void updateRanking() {
        // TODO
    }

    public Map<String, Number> getWeights() {
        return weigths;
    }
}
