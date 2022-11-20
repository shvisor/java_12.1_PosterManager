package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.PosterItem;
import ru.netology.repository.PosterRepository;

import static org.mockito.Mockito.*;

public class PosterManagerTest {

    PosterRepository repo = Mockito.mock(PosterRepository.class);
    PosterManager manager = new PosterManager(repo);

    PosterItem item1 = new PosterItem(3, "Movie 1");
    PosterItem item2 = new PosterItem(6, "Movie 2");
    PosterItem item3 = new PosterItem(8, "Movie 3");
    PosterItem item4 = new PosterItem(5, "Movie 4");
    PosterItem item5 = new PosterItem(12, "Movie 5");

    @Test
    public void shouldFindLast() {
        PosterItem[] items = {item5, item4, item3, item2, item1};
        doReturn(items).when(repo).getMovies();

        PosterItem[] expected = {item5, item4, item3, item2, item1};
        PosterItem[] actual = repo.getMovies();

        Assertions.assertArrayEquals(expected, actual);
    }
}
