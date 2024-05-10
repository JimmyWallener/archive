#include <iostream>
#include <string>
#include "CoffeeAction.h"

using namespace std;

int main() {
    char product; // Karaktär för att lagra användarens val av produkt
    double money{ 0 }; // Variabel för att lagra pengar insatta av användaren

    // Loop som kör tills användaren gör ett giltigt val av produkt
    while (true) {
        cout << "\tWelcome to the Coffee Machine!" << endl;
        cout << "\t=============================" << endl;
        cout << "\n\tPlease select a product: " << endl;
        // Visa val av produkter med priser
        cout << "\n\tK(affe)" << "\t\t\t" << "12.00 kr" << endl;
        cout << "\tE(spresso)" << "\t\t" << "14.00 kr" << endl;
        cout << "\tC(hocolate)" << "\t\t" << "11.50 kr" << endl;
        cout << "\tL(atte)" << "\t\t\t" << "13.00 kr" << endl;
        cout << "\tP(Cappucino)" << "\t\t" << "13.50 kr" << endl;

        cout << "\n\tYour choice: ";
        cin >> product; // Läs in användarens val

        // Kontrollera om användarens val är en av de giltiga bokstäverna
        if (toupper(product) == 'K' || toupper(product) == 'E' ||
            toupper(product) == 'C' || toupper(product) == 'L' ||
            toupper(product) == 'P') {
            break; // Bryt loopen om valet är giltigt
        }
        else {
            cout << "\n\tInvalid choice. Please try again." << endl;
        }
    }

    double totalPayment{ 0 }; // Summan av användarens betalningar
    CoffeeAction* coffeeAction = nullptr; // Pekare till CoffeeAction objektet

    // Loop för att hantera betalningsprocessen
    do {
        cout << "\n\tPlease insert money: ";

        // Läs in och validera användarens inmatning av pengar
        if (!(cin >> money)) {
            cout << "\n\tInvalid input. Please try again." << endl;
            cin.clear(); // Rensa inmatningsströmmen
            cin.ignore(numeric_limits<streamsize>::max(), '\n'); // Ignorera återstående innehåll i strömmen
            continue; // Fortsätt till nästa iteration i loopen
        }

        // Kontrollera om inmatade pengar är ett negativt belopp
        if (money < 0) {
            cout << "\n\tInvalid amount. Please try again." << endl;
            continue;
        }

        totalPayment += money; // Lägg till inmatade pengar till totala betalningen

        // Skapa ett nytt CoffeeAction-objekt eller uppdatera det befintliga med ny betalning
        if (coffeeAction == nullptr) {
            coffeeAction = new CoffeeAction(product, totalPayment);
        }
        else {
            coffeeAction->updatePayment(totalPayment);
        }

        // Kontrollera om användaren har lagt in tillräckligt med pengar
        if (money < coffeeAction->getPrice()) {
            double amountNeeded = coffeeAction->getPrice() - totalPayment;
            cout << "\n\tInsufficient funds." << endl;
            cout << "\tYou added: " << totalPayment << " kr" << endl;
            cout << "\tYou need to insert: " << amountNeeded << " kr more" << endl;
        }
        else if (money > coffeeAction->getPrice()) {
            cout << "\n\tYou added: " << totalPayment << " kr" << endl;
            cout << "\tYour change: " << totalPayment - coffeeAction->getPrice() << " kr" << endl;
            if (totalPayment - coffeeAction->getPrice() > 0) coffeeAction->changeInCoins(); // Beräkna och visa växel
            break; // Avsluta loopen om tillräckligt med pengar har lagts in
        }
        else {
            cout << "\n\tYou added: " << totalPayment << " kr" << endl;
            cout << "\tYour change: " << totalPayment - coffeeAction->getPrice() << " kr" << endl;
            if(totalPayment - coffeeAction->getPrice() > 0) coffeeAction->changeInCoins(); 
            break;
        }

    } while (true);

    delete coffeeAction; // Rensa upp minne
}
