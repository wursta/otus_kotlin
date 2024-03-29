# Учебный проект по Kotlin

Учебный проект курса https://otus.ru/lessons/kotlin/ \
Поток курса 2023-02.

## Описание

В данном учебном проекте реализуется один из микросервисов для сервиса/мобильного приложения по учёту финансов (расходы) и получению статистики.

Общие задачи приложения (общая идея):

- Интеграция с разными банками для автоматического учёта доходов/расходов в приложении (предполагаем, что банки
  распологают API для оповещения приложения о совершаемых транзакциях)
- Категоризация доходов/расходов из разных источников (банковские карты, наличные)
- Аналитика расходов (за месяц, квартал, год...)
- Уведомления о регулярных платежах

В учебном проекте будет реализован микросервис по:

- CRUD для банковских карт
- CRUD для расходов
- Аналитика расходов за промежуток времени с группировкой по категориям

## Визуальное представление фронтенда

![Макет приложения](/docs/marketing/design-layout.png)

## Документация

1. Маркетинг
    1. [Заинтересанты](/docs/marketing/stakeholders.md)
    2. [Целевая аудитория](/docs/marketing/target-audience.md)
    3. [Конкурентный анализ](/docs/marketing/concurrency.md)
    4. [Анализ экономики](/docs/marketing/economy.md)
    5. [Пользовательские истории](/docs/marketing/user-stories.md)
2. DevOps
    1. [Схема инфраструктуры](/docs/devops/infrastruture.md)
    2. [Схема мониторинга](/docs/devops/monitoring.md)
3. Тестирование
    1. [Тестирование пользовательских историй](/docs/testing/README.md)
4. Архитектура
    1. [Архитектурная диаграмма](/docs/architecture/arch.md)
    2. [Схема интеграции](/docs/architecture/integration.md)
    3. [Описание API](/docs/architecture/api.md)

## Структура проекта

| Название             | Описание                                                                                                             |
|----------------------|----------------------------------------------------------------------------------------------------------------------|
| _m1l1-helloworld_    | Учебный модуль. Выводит площадь круга по введённому пользователем радиусу                                            |
| _m1l3-oop_           | Учебный модуль. Практика по созданию классов и интерфейсов. Unit-тесты.                                              |
| _m1l3-dsl_           | Учебный модуль. Практика по созданию DSL для Builder'а SQL запросов. Unit-тесты. [Описание DSL](/m1l4-dsl/README.md) |
| **fm-acceptance**    | Модуль с приёмочными тестами                                                                                         |
| **fm-api**           | Модуль с сериализацией DTO                                                                                           |
| **fm-common**        | Модуль с внутренними моделями проекта                                                                                |
| **fm-mappers**       | Модуль с мапперами для превращения из DTO во внутренние модели и обратно                                             |
| **fm-biz**           | Модуль с бизнес-логикой приложения                                                                                   |
| **fm-stubs**         | Модуль со заглушками для различных транспортов                                                                       |
| **fm-app-ktor**      | Модуль приложения основанный на фреймворке Ktor                                                                      |
| **fm-app-kafka**     | Модуль приложения основанный на Apache Kafka [Подробнее](/fm-app-kafka/README.md)                                    |
| **fm-repo-inmemory** | Модуль реализации InMemory репозитория для тестового окружения                                                       |
| **fm-repo-arcadedb** | Модуль реализации репозитория на основе ArcadeDb для продовского окружения                                           |
