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
        PosterItem[] tmp = new PosterItem[1]; // т.к. с определенным id может быть один элемент, длину массива указываем 1
        int index = 0; // задаем индекс для ячеек массива movies
        for (PosterItem movie : movies) { // перебираем массив movies
            if (movie.getId() == id) { // если id элемента равно искомому id
                tmp[index] = movie; // то кладем в ячейку элемент movie
                index++;
            }
        }
        movies = tmp; // присваиваем массиву movies значение массива tmp, с элементом id которго равно искомому id
    }

    public void removeById(int id) {
        PosterItem[] tmp = new PosterItem[movies.length - 1]; // т.к. удаляем ячейку с искомым id, длина массива будет короче на 1
        int index = 0; // задаем индекс для ячеек массива movies
        for (PosterItem movie : movies) { // перебираем массив movies
            if (movie.getId() != id) { // если id элемента не равно искомому id
                tmp[index] = movie; // то кладем в ячейку элемент movie
                index++;
            }
        }
        movies = tmp; // присваиваем массиву movies значение массива tmp, без элемента id которго равно искомому id
    }

    public void removeAll() {
        PosterItem[] tmp = new PosterItem[movies.length];
        if (movies.length == 0) { // если массив пустой
            System.out.println("Репозиторий пуст"); // то выводим данный текст
        }
        movies = tmp;
    }

    public PosterItem[] getMovies() {
        return movies;
    }
}
