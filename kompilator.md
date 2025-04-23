# ArchiCode

W świecie kodowania, gdzie składnia bywa sztywna i nudna, powstał ArchiCode – język, który daje strukturę, ale nie odbiera swobody.

Zaprojektowany jak budynek, składany jak klocki – prosty, czytelny i intuicyjny.

## Zmienne

define (typ) {nazwa*} (= {wartość})

typy: int, float, bool, char, string

*nazwa musi zaczynać sie od małej litery

define zmienna = 4

define int zmienna = 7


## Zbiory danych

define box (typ) {nazwa*} [{rozmiar}] (=[]) - tablica

define chain (typ) {nazwa*} (=[]) - lista

define catalog (typ >> typ) {nazwa*} (={x, y;x2 ,y2}) - mapa

*nazwa musi zaczynać sie od małej litery


## Funkcje



blueprint {nazwa*}(argumenty) delivers (typ) {wynik}{}

*nazwa musi zaczyna sie od dużej litery

wywołanie:

{nazwa} {argumenty rozdzielone spacjami} (; - opcjonalny koniec argumentów)

blueprint Suma(a, b) delivers suma = 0{
    suma = a + b
}
define int a = 7
define int b = 1000
define int sum = Suma a b
define int sum2 = Suma a b // + Suma a 10


## IN/OUT

show {wyrazenie} - wypisanie na konsole

request {zmienna} - pobranie z konsoli

## Pętle

repeat int {}

lub

repeat until {warunek} {}

lub

repeat for x in y {}

step - wbudowany iterator

step@1 step@2 - iterator dla zagnieżdżonych pętli


repeat 5 {}

repeat until x < 5 {}

repeat for x in y {}


## Warunki

check {warunek} then {}

otherwise check {warunek} then{}

otherwise {}

check x < 5 then {
    show " < 5"
}otherwise check x > 5 then{
    show " > 5"
}otherwise {
    show " = '
}


## Komentarze
\>>...<\< - Komentarz w środku lini

\>> Komentarz do konca lini

\>>> ... <<< - Komenatrz wieloliniowy

<


>> To jest komentarz do konca lini

>> to jest komentarz << to już nie

>>> komentarz
na
kilka
lini <<<


### Przykładowy Kod

blueprint Silnia(int n) delivers return{
    check n == 0 then {
        return = 1
    }
    otherwise{
        return = m * Silnia (m - 1)
    }
}

Core(box string args) delivers int return{
    define int n
    request n
    repeat n{
        show Silnia step
    }

    return = 0
}

>>>
Output:
1
1
2
6
24
...
(n-1)!
<<<

