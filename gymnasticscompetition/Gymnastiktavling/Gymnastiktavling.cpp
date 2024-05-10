#include <iostream>
#include <algorithm>
#include <string>
#include <random>
#include <cstdlib>

using namespace std;


// should return a random number between 1 and 100
int random_number()
{
    return 1 + rand() % 100;
}

// should return the sum of the three numbers in the array
int total_sum(const int sum[])
{
    int total{ 0 };
    for (int i = 0; i < 3; i++)
    {
        total += sum[i];
    }
    return total;
}

// should return the name of the competitor with the highest score
string max_score(int player_one_score, int player_two_score, int player_three_score)
{
    // get the max score with library function max from algorithm
    int score = std::max(player_one_score, std::max(player_two_score, player_three_score));
    string winner;

    // check if there is a tie between two or three competitors
    if (player_one_score == player_two_score && player_two_score == player_three_score)
    {
        winner = "T\x84vlande 1, T\x84vlande 2, T\x84vlande 3";
    }
    else if (player_one_score == player_two_score)
    {
        winner = "T\x84vlande 1, T\x84vlande 2";
    }
    else if (player_one_score == player_three_score)
    {
        winner = "T\x84vlande 1, T\x84vlande 3";
    }
    else if (player_two_score == player_three_score)
    {
        winner = "T\x84vlande 2, T\x84vlande 3";
    }
    else
    {
        // check which competitor has the max score
        if (score == player_one_score)
        {
            winner = "T\x84vlande 1";
        }
        else if (score == player_two_score)
        {
            winner = "T\x84vlande 2";
        }
        else if (score == player_three_score)
        {
            winner = "T\x84vlande 3";
        }
    }


    return winner;

}

void testcases()
{

    cout << "\nTestar max_score\n" << endl;

    // test if player 3 wins
    int player_one_score = 10;
    int player_two_score = 20;
    int player_three_score = 30;
    string expected = "T\x84vlande 3";
    string actual = max_score(player_one_score, player_two_score, player_three_score);
    if (expected == actual)
    {
        cout << "Test 1 lyckades.\n" << "expected: " << expected << " actual: " << actual << endl;
    }
    else
    {
        cout << "Test 1 misslyckades.\n" << "expected: " << expected << " actual: " << actual << endl;
    }

    // test if player 1 wins
    player_one_score = 20;
    player_two_score = 10;
    player_three_score = 5;
    expected = "T\x84vlande 1";
    actual = max_score(player_one_score, player_two_score, player_three_score);
    if (expected == actual)
    {
        cout << "Test 2 lyckades.\n" << "expected: " << expected << " actual: " << actual << endl;
    }
    else
    {
        cout << "Test 2 misslyckades.\n" << "expected: " << expected << " actual: " << actual << endl;
    }

    // test if player 2 wins
    player_one_score = 5;
    player_two_score = 20;
    player_three_score = 10;
    expected = "T\x84vlande 2";
    actual = max_score(player_one_score, player_two_score, player_three_score);
    if (expected == actual)
    {
        cout << "Test 3 lyckades.\n" << "expected: " << expected << " actual: " << actual << endl;
    }
    else
    {
        cout << "Test 3 misslyckades.\n" << "expected: " << expected << " actual: " << actual << endl;
    }

    // test if there is a tie between player 1 and 2
    player_one_score = 10;
    player_two_score = 10;
    player_three_score = 30;
    expected = "T\x84vlande 1, T\x84vlande 2";
    actual = max_score(player_one_score, player_two_score, player_three_score);
    if (expected == actual)
    {
        cout << "Test 4 lyckades.\n" << "expected: " << expected << " actual: " << actual << endl;
    }
    else
    {
        cout << "Test 4 misslyckades.\n" << "expected: " << expected << " actual: " << actual << endl;
    }

    // test if there is a tie between player 2 and 3
    player_one_score = 10;
    player_two_score = 20;
    player_three_score = 20;
    expected = "T\x84vlande 2, T\x84vlande 3";
    actual = max_score(player_one_score, player_two_score, player_three_score);
    if (expected == actual)
    {
        cout << "Test 5 lyckades.\n" << "expected: " << expected << " actual: " << actual << endl;
    }
    else
    {
        cout << "Test 5 misslyckades.\n" << "expected: " << expected << " actual: " << actual << endl;
    }

    // test if there is a tie between player 1, 2 and 3
    player_one_score = 10;
    player_two_score = 10;
    player_three_score = 10;
    expected = "T\x84vlande 1, T\x84vlande 2, T\x84vlande 3";
    actual = max_score(player_one_score, player_two_score, player_three_score);
    if (expected == actual)
    {
        cout << "Test 5 lyckades.\n" << "expected: " << expected << " actual: " << actual << endl;
    }
    else
    {
        cout << "Test 5 misslyckades.\n" << "expected: " << expected << " actual: " << actual << endl;
    }

    // test if there is a tie between player 1 and 3
    player_one_score = 10;
    player_two_score = 20;
    player_three_score = 10;
    expected = "T\x84vlande 1, T\x84vlande 3";
    actual = max_score(player_one_score, player_two_score, player_three_score);
    if (expected == actual)
    {
        cout << "Test 6 lyckades. \n" << "expected: " << expected << " actual: " << actual << endl;
    }
    else
    {
        cout << "Test 6 misslyckades. \n" << "expected: " << expected << " actual: " << actual << endl;
    }

    // test if there is a tie between player 2 and 3
    player_one_score = 20;
    player_two_score = 10;
    player_three_score = 10;
    expected = "T\x84vlande 2, T\x84vlande 3";
    actual = max_score(player_one_score, player_two_score, player_three_score);
    if (expected == actual)
    {
        cout << "Test 7 lyckades. \n" << "expected: " << expected << " actual: " << actual << endl;
    }
    else
    {
        cout << "Test 7 misslyckades.\n" << "expected: " << expected << " actual: " << actual << endl;
    }

}

int main() {
    
    // seed the random number generator with the current time in seconds
    srand(static_cast<unsigned int>(time(nullptr)));

    // create three arrays with three random numbers
    int competitor_one[3] { random_number(), random_number(), random_number() };
    int competitor_two[3] { random_number(), random_number(), random_number() };
    int competitor_three[3] { random_number(), random_number(), random_number() };
    

    int competitor_one_total = total_sum(competitor_one);
    int competitor_two_total = total_sum(competitor_two);
    int competitor_three_total = total_sum(competitor_three);

    // call the max_score function with the three total scores and get the winner
    string competitor_name = max_score(competitor_one_total, competitor_two_total, competitor_three_total);

    cout << "\tDe t\x84vlandes totalpo\x84ng:\n" << endl;
    cout << "\tT\x84vlande 1:\t " << competitor_one_total << endl;
    cout << "\tT\x84vlande 2:\t " << competitor_two_total << endl;
    cout << "\tT\x84vlande 3:\t " << competitor_three_total << "\n" << endl;
    cout << "\t" << competitor_name << " har vunnit t\x84vlingen." << endl;

    // Remove the comment below to run the testcases function
    testcases();

    return 0;

}
