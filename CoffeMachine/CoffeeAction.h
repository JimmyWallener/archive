#ifndef COFFEEACTION_H
#define COFFEEACTION_H

#pragma once

#include <string>

class CoffeeAction{
private:
	std::string productName;
	double price;
	double payment;
	double change;
public:
	CoffeeAction(char product, double money);

	void changeInCoins();
	void updatePayment(double newPayment);

	// getters

	double getPrice() const { return price; }
	double getPayment() const { return payment; }
};

#endif // !COFFEEACTION_H