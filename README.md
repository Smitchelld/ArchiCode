ArchiCode Interpreter
![alt text](https://img.shields.io/badge/Java-11%2B-blue.svg)

![alt text](https://img.shields.io/badge/ANTLR-4-orange.svg)

![alt text](https://img.shields.io/badge/License-MIT-yellow.svg)
Prosty, interaktywny interpreter dla języka programowania ArchiCode, zaimplementowany w Javie przy użyciu ANTLR4.
📜 Opis projektu
ArchiCode to edukacyjny język programowania zaprojektowany z myślą o czytelności i intuicyjności. Jego składnia czerpie inspirację z terminologii architektonicznej, gdzie funkcje to blueprinty (plany), a główny punkt programu to jego Core (rdzeń).
Interpreter ten pozwala na wykonywanie skryptów ArchiCode, obsługując zmienne, pętle, instrukcje warunkowe, funkcje oraz prosty system typów.
✨ Główne cechy języka
Prosta składnia: Słowa kluczowe takie jak define, show, request, check i repeat są łatwe do zrozumienia.
Funkcje (blueprinty): Definiowanie własnych funkcji z parametrami i wartościami zwracanymi.
System typów: Obsługa typów int, float, bool, char i string z inferencją i jawnym rzutowaniem.
Zakresy zmiennych: Poprawna obsługa zakresu globalnego i lokalnego (wewnątrz funkcji i bloków).
Operatory: Pełen zestaw operatorów arytmetycznych, logicznych i relacyjnych.
Obsługa błędów: Czytelne komunikaty o błędach składniowych i wykonania, wraz ze śledzeniem stosu wywołań funkcji.
🚀 Uruchomienie
Wymagania
Java Development Kit (JDK) w wersji 11 lub nowszej.
ANTLR 4 Complete JAR (biblioteka wykonawcza). Można ją pobrać tutaj.
Struktura projektu (sugerowana)
Generated code
.
├── lib/
│   └── antlr-4.x-complete.jar
├── src/
│   ├── main/
│   │   └── Main.java
│   ├── memory/
│   │   └── Memory.java
│   │   └── ...
│   └── gen/  <-- Tutaj ANTLR generuje pliki parsera
│       └── ...
├── program.ArchC
└── README.md
Use code with caution.
Kompilacja
Umieść pobrany plik antlr-4.x-complete.jar w folderze lib/.
Otwórz terminal w głównym katalogu projektu.
Skompiluj źródła (zastąp x odpowiednią wersją ANTLR):
Generated bash
# Utwórz folder na skompilowane klasy
mkdir bin

# Kompiluj (dla Windows użyj średnika ; jako separatora w classpath)
javac -cp ".:lib/antlr-4.x-complete.jar" -d bin src/**/*.java src/*.java
Use code with caution.
Bash
Użycie
Aby uruchomić interpreter, wykonaj poniższą komendę, podając ścieżkę do pliku ze skryptem ArchiCode:
Generated bash
# Uruchom interpreter na pliku program.ArchC
# (dla Windows użyj średnika ; jako separatora w classpath)
java -cp ".:bin:lib/antlr-4.x-complete.jar" Main program.ArchC
Use code with caution.
Bash
🛠️ Przykłady kodu ArchiCode
1. Zmienne i wyświetlanie
Generated plaintext
>> Prosty program witający użytkownika <<

Core() delivers int result {
    define string name = "Architekt"
    show "Witaj, " name "!"

    define int rok = 2024
    show "Jest rok: " rok
}
Use code with caution.
2. Pętle i warunki
Generated plaintext
>> Wyświetlanie liczb parzystych do 10 <<

Core() delivers int result {
    show "Liczby parzyste od 0 do 10:"
    repeat 11 {
        check step % 2 == 0 then {
            show step
        }
    }
}
Use code with caution.
3. Funkcje (blueprinty) i rekurencja
Generated java
// Obliczanie silni przy użyciu rekurencji i funkcji
blueprint Silnia(int n) delivers int result {
    check n <= 1 then {
        result = 1
    } otherwise {
        result = n * Silnia(n - 1)
    }
}

// Główny blok programu
Core() delivers int coreResult {
    define int liczba = 0
    show "Podaj liczbę do obliczenia silni:"
    request liczba

    define int wynik = Silnia(liczba)
    show "Silnia z " liczba " wynosi: " wynik
}
Use code with caution.
Java
🏗️ Architektura i technologia
Język implementacji: Java
Generator parsera: ANTLR4
Wzorzec projektowy: Interpreter jest zaimplementowany przy użyciu wzorca Visitor. ArchiCodeVisitorImpl.java odwiedza węzły drzewa składni wygenerowanego przez ANTLR i wykonuje odpowiednie akcje.
Zarządzanie pamięcią: Klasa Memory.java obsługuje zakresy zmiennych przy użyciu stosu map, co pozwala na poprawne przesłanianie zmiennych (shadowing).
🔮 Możliwe rozszerzenia
Dodanie instrukcji break i continue do pętli.
Wprowadzenie złożonych struktur danych (np. box jako tablica, catalog jako mapa).
Stworzenie systemu modułów i importów (import "another.ArchC").
Rozbudowa o narzędzia deweloperskie, takie jak debugger krokowy.
📄 Licencja
Projekt jest udostępniany na licencji MIT. Zobacz plik LICENSE, aby uzyskać więcej informacji
