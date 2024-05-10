#include <iostream>
#include <string>
#include "CoffeeAction.h"

using namespace std;

// Konstruktor f�r CoffeeAction-klassen som tar emot anv�ndarens val av produkt och betalning som parametrar
CoffeeAction::CoffeeAction(char product, double money) : price(0), payment(0), change(0) {

     // S�tt produktnamn och pris baserat p� anv�ndarens val
    switch (toupper(product)) {
    case 'K':
        productName = "Coffee";
        price = 12.00;
        break;
    case 'E':
        productName = "Espresso";
        price = 14.00;
        break;
    case 'C':
        productName = "Chocolate";
        price = 11.50;
        break;
    case 'L':
        productName = "Latte";
        price = 13.00;
        break;
    case 'P':
        productName = "Cappuccino";
        price = 13.50;
        break;
    default:
        productName = "Unknown";
        price = 0.00;
        break;
    }
    // S�tt betalningen och ber�kna v�xeln
    payment = money;
    change = payment - price;
}

// Metod f�r att visa v�xeln i mynt
void CoffeeAction::changeInCoins() {
    // Konvertera v�xeln till �ren f�r att underl�tta ber�kningen
    int total = static_cast<int>(change * 100);

    // Ber�kna antalet mynt av varje val�r som ska ges tillbaka
    int ten = total / 1000;
    int five = (total % 1000) / 500;
    int one = ((total % 1000) % 500) / 100;
    int half = (((total % 1000) % 500) % 100) / 50;
    int rest = (((total % 1000) % 500) % 100) % 50;

    // Skriv ut detaljerad information om v�xeln
    cout << "\tDetailed Change Information: \n\t" << ten << " x 10 kr\n\t " << five << " x 5 kr\n\t "
        << one << " x 1 kr\n\t " << half << " x 0.5 kr\n\t " << rest << " x 0.01 kr\n" << endl;
}

// Metod f�r att uppdatera betalningen
void CoffeeAction::updatePayment(double newPayment) {
    // S�tt den nya betalningen och uppdatera v�xeln
    payment = newPayment;
    change = payment - price;
}
