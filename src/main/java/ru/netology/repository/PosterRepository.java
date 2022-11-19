package ru.netology.repository;

import ru.netology.domain.PosterItem;

public class PosterRepository {
    private PosterItem[] movies = new PosterItem[0]; // менеджер не содержит фильмы после создания

    public void save(PosterItem movie) { // метод принимает новый элемент movie массива String
        PosterItem[] tmp = new PosterItem[movies.length + 1]; // увеличение массива на 1 ячейку
        for (int i = 0; i < movies.length; i++) { // проходим циклом по старому массиву
            tmp[i] = movies[i]; // копируем все элементы из старого массива в новый (в новом на 1 элемент больше)
        }
        tmp[tmp.length - 1] = movie; // добавляем элемент в новый массив
        movies = tmp;
    }

    public PosterItem[] findAll() {
        return movies;
    }

    public void findById(int id) {
        PosterItem[] tmp = new PosterItem[1];
        int index = 0;
        for (PosterItem movie : movies) {
            if (movie.getId() == id) {
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;
    }

    public PosterItem[] getMovies() {
        return movies;
    }
}
