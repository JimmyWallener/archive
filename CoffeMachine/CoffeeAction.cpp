#include <iostream>
#include <string>
#include "CoffeeAction.h"

using namespace std;

// Konstruktor för CoffeeAction-klassen som tar emot användarens val av produkt och betalning som parametrar
CoffeeAction::CoffeeAction(char product, double money) : price(0), payment(0), change(0) {

     // Sätt produktnamn och pris baserat på användarens val
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
    // Sätt betalningen och beräkna växeln
    payment = money;
    change = payment - price;
}

// Metod för att visa växeln i mynt
void CoffeeAction::changeInCoins() {
    // Konvertera växeln till ören för att underlätta beräkningen
    int total = static_cast<int>(change * 100);

    // Beräkna antalet mynt av varje valör som ska ges tillbaka
    int ten = total / 1000;
    int five = (total % 1000) / 500;
    int one = ((total % 1000) % 500) / 100;
    int half = (((total % 1000) % 500) % 100) / 50;
    int rest = (((total % 1000) % 500) % 100) % 50;

    // Skriv ut detaljerad information om växeln
    cout << "\tDetailed Change Information: \n\t" << ten << " x 10 kr\n\t " << five << " x 5 kr\n\t "
        << one << " x 1 kr\n\t " << half << " x 0.5 kr\n\t " << rest << " x 0.01 kr\n" << endl;
}

// Metod för att uppdatera betalningen
void CoffeeAction::updatePayment(double newPayment) {
    // Sätt den nya betalningen och uppdatera växeln
    payment = newPayment;
    change = payment - price;
}
