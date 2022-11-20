package ru.netology;

import ru.netology.domain.PosterItem;
import ru.netology.repository.PosterRepository;

public class PosterManager {
    private PosterRepository repo;

    public PosterManager(PosterRepository repo) {
        this.repo = repo;
    }

    public void add(PosterItem movie) {
        repo.save(movie);
    }

    public PosterItem[] findLast() {
        PosterItem[] all = repo.getMovies();
        int resultLength;
        int defaultCountMovie = 10;
        if (all.length != defaultCountMovie) {
            resultLength = all.length;
        } else {
            resultLength = defaultCountMovie;
        }
        PosterItem[] tmp = new PosterItem[resultLength];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = all[all.length - 1 - i];
        }
        return tmp;
    }
}
