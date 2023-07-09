# steam-test
## Описание задачи
Тестирование страниц сайта https://userinyerface.com.
В данном проекте тестируется [Steam](https://store.steampowered.com/)
## ТК 1
1. Открытие главной страницы
2. Нажатие кнопки About
3. Сравнение игроков онлайн и в игре
4. Переход на страницу магазина

## ТК 2
1. Открытие главной страницы
2. Открытие страницы Community Market (COMMUNITY -> MARKET)
3. Открытие формы настройки поиска по торговой площадке (Show advanced options...)
4. Выбор следующие параметры для поиска: Game - Dota 2, hero -  Lifestealer, Rarity - Immortal, Search - golden
5. Нажатие кнопки 'Search'
6. Удаление фильтров 'golden' и 'Immortal'
7. Переход на страницу первого предмета списка
8. Проверка наличия фильтров на страницы предмета

## ТК 3
1. Открытие главной страницы
2. Наведение курсора на 'Новое и примечательное' в меню страницы
3. Нажатие кнопки 'Просмотреть больше лидеров продаж'
4. В правом меню, в блоке 'Операционная система' выбран чекбокс 'SteamOS + Linux'
5. В правом меню, в блоке 'Количество игроков' выбран чекбокс 'Кооператив (LAN)'
6. В правом меню, в блоке 'Метки' выбран чекбокс 'Экшен'
7. Для первого результата из списка получены название игры, дату релиза и цену
8. Кликнут первый результат в списке
9. Игра со страницы TopSellers эквивалентна нажатой игре
## Структура проекта
* **SteamTest\src\test**
    * **java** - Часть, связанная с проектом, с объектами страницы, моделями и утилитами
        * **pages** - Страницы
        * **tests** - Тест кейсы
        * **utils** - Утилиты
        * **models** - Модели
        * **consts** - Константы
          * **navbarstore** - Всплывающие кнопки под кнопками Your, Category, Noteworthy в меню с синими кнопками
          * **navbartop** - Всплывающие кнопки под кнопками Community, Language, Store верхнего черного меню
          * **topsellerswithfilters** - Описание чекбоксов к каждому блоку, находящемуся на странице Top Sellers с фильтрами
        * **steps** - Шаги
    * **resources** - Файлы ресурсов, такие как конфигурации и тестовые данные

## Настройка проекта
Настройка проекта происходит в файле [settings.json](https://github.com/aquality-automation/aquality-selenium-java-template/blob/master/aquality-selenium-template/src/main/resources/settings.json), который содержит в себе настройки Aquality Selenium библиотеки. Дополнительная информация [здесь](https://github.com/aquality-automation/aquality-selenium-java/wiki/Overview-(Russian)).

## Запуск тестов
```bash
mvn clean test
```