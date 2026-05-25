# Todo List REST API

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.4-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![MariaDB](https://img.shields.io/badge/MariaDB-Supported-blue.svg)](https://mariadb.org/)

Wydajne i proste REST API do zarządzania zadaniami, zbudowane w oparciu o ekosystem Spring Boot. Aplikacja pozwala na obsługę użytkowników, list zadań (To-Do) oraz samych zadań, z pełnym wsparciem dla relacyjnych powiązań między tymi encjami.

## 🚀 Funkcjonalności

- **Zarządzanie Użytkownikami:** Rejestracja, edycja i usuwanie kont.
- **Inteligentne Listy Zadań:** Po utworzeniu konta, system automatycznie generuje dla użytkownika domyślną listę zadań ("default"). Możliwość tworzenia wielu własnych list.
- **Obsługa Zadań (CRUD):** Pełne zarządzanie poszczególnymi zadaniami, w tym śledzenie statusu ukończenia (`isCompleted`), dodawanie opisów oraz terminów (`dueDate`).
- **Warstwowa Architektura:** Klasyczny podział na Kontrolery, Serwisy i Repozytoria z wykorzystaniem wzorców projektowych typowych dla Springa.

## 🛠️ Stack technologiczny

- **Java 21**
- **Spring Boot 3.2.4** (Web, Data JPA)
- **MariaDB** (baza danych)
- **Lombok** (redukcja boilerplate code)
- **Maven**

## ⚙️ Wymagania wstępne

Aby uruchomić ten projekt lokalnie, upewnij się, że w Twoim środowisku zainstalowane są:
- JDK 21 lub nowsze
- Maven 3.6+
- Serwer MariaDB

## 💻 Uruchomienie lokalne

1. **Sklonuj repozytorium**
   ```bash
   git clone https://github.com/Darsonn/todolistrestapi.git
   cd TodoListRestApi
   ```

2. **Skonfiguruj bazę danych**
   Upewnij się, że w Twojej instancji MariaDB istnieje baza o nazwie `todolistapp`. 
   Jeśli używasz innego hasła niż domyślne, zaktualizuj plik `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mariadb://127.0.0.1:3306/todolistapp
   spring.datasource.username=root
   spring.datasource.password=twoje_haslo
   ```

3. **Uruchom aplikację**
   Zbuduj i uruchom projekt przy pomocy Mavena:
   ```bash
   mvn spring-boot:run
   ```
   Serwer wystartuje lokalnie na porcie **10000** (zgodnie z konfiguracją `server.port`).

## 📖 Dokumentacja API

Pełna dokumentacja endpointów została wygenerowana i jest utrzymywana na zewnętrznej platformie. Można się z nią zapoznać pod poniższym linkiem:

👉 **[Dokumentacja Todo List REST API (Bump.sh)](https://bump.sh/darsonn/doc/todo-list-rest-api)**

### Główne Endpointy
* `/api/users` - Zarządzanie użytkownikami
* `/api/todolists` - Zarządzanie listami zadań (możliwość wyszukiwania list po nazwie i ID użytkownika)
* `/api/tasks` - Operacje na konkretnych zadaniach

## 🏗️ Struktura projektu

Projekt trzyma się konwencji standardowego REST API w Springu:
* `controller/` - Wystawia interfejsy HTTP/REST.
* `service/` - Zawiera główną logikę biznesową.
* `repository/` - Interfejsy Spring Data JPA.
* `model/` - Modele danych/Encje (User, TodoList, Task).
