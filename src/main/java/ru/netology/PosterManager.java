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


}
