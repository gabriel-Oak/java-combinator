package com.example;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        int cardsAmount = 0;
        Scanner input = new Scanner(System.in);

        final String[] baseArgs = input.nextLine().split(" ");
        cardsAmount = Integer.parseInt(baseArgs[0]);
        final Prassodia prassodia = new Prassodia(
                Integer.parseInt(baseArgs[1]),
                Integer.parseInt(baseArgs[2]),
                Integer.parseInt(baseArgs[3]));

        Card[] cards = new Card[cardsAmount];
        for (int index = 0; index < cardsAmount; index++) {
            System.out.println("Enter card: ");
            final Card card = Card.fromLine(input.nextLine());
            cards[index] = card;
            System.out.println("Got it: " + card);
        }
        input.close();

        if (cardsAmount < 2) {
            System.out.println("N");
            return;
        }

        processCards(cards, prassodia);
    }

    static boolean combineCards(
            Card[] cards,
            Card[] data,
            int start,
            int index,
            int range,
            Prassodia prassodia) {
        boolean canSummonPrassodia = false;

        if (index == range) {
            prassodia.reset();
            for (int j = 0; j < range; j++) {
                prassodia.addCard(data[j]);
            }

            final CalculationResult result = prassodia.calculate();
            return result == CalculationResult.equals;
        }

        for (int i = start; i <= cards.length && cards.length - i >= range - index; i++) {
            data[index] = cards[i];
            final boolean test = combineCards(
                    cards,
                    data,
                    i + 1,
                    index + 1,
                    range,
                    prassodia);

            if (test) {
                canSummonPrassodia = true;
                return canSummonPrassodia;
            }
        }

        return false;
    }

    static void processCards(Card[] cards, Prassodia prassodia) {
        Boolean canSummonPrassodia = false;

        for (int range = 2; range <= cards.length; range++) {
            Card[] data = new Card[range];
            canSummonPrassodia = combineCards(cards, data, 0, 0, range, prassodia);

            if (canSummonPrassodia)
                break;
        }

        System.out.println(canSummonPrassodia ? "Y" : "N");
    }
}