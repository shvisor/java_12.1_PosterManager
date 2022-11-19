package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterItem;
import ru.netology.repository.PosterRepository;

public class PosterRepositoryTest {
    PosterRepository repo = new PosterRepository();

    PosterItem item1 = new PosterItem(3, "Movie 1");
    PosterItem item2 = new PosterItem(6, "Movie 2");
    PosterItem item3 = new PosterItem(8, "Movie 3");
    PosterItem item4 = new PosterItem(5, "Movie 4");
    PosterItem item5 = new PosterItem(12, "Movie 5");

    @BeforeEach
    public void setup() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
    }

    @Test
    public void shouldAllPoster() {

        PosterItem[] expected = {item1, item2, item3, item4, item5};
        PosterItem[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldById() {
        repo.findById(8);

        PosterItem[] expected = {item3};
        PosterItem[] actual = repo.getMovies();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.removeById(5);

        PosterItem[] expected = {item1, item2, item3, item5};
        PosterItem[] actual = repo.getMovies();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        PosterRepository repo = new PosterRepository();

        repo.removeAll();

        PosterItem[] expected = {};
        PosterItem[] actual = repo.getMovies();

        Assertions.assertArrayEquals(expected, actual);
    }
}
