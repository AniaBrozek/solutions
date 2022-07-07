using System;
namespace cash_register
{
    class Program
    {
        static double how_munch_cost(double A, double B)
        {
            return A * B;

        }
        public struct article
        {
            public string name;
            public double cost_per_item;
            public double cos_per_kg;
            public double weight;
            public int numbers_of_items;
            public double sum;
        }

        static void Main(string[] args)
        {
            article article_1;
            article article_2;
            article article_3;
            article_1.name = "Water";
            article_1.cost_per_item = 1.50;
            article_1.cos_per_kg = 1.20;
            article_1.weight = 0;
            article_1.numbers_of_items = 0;
            article_1.sum = 0;
            article_2.name = "Carrot";
            article_2.cost_per_item = 4.10;
            article_2.cos_per_kg = 3.20;
            article_2.weight = 0;
            article_2.numbers_of_items = 0;
            article_2.sum = 0;
            article_3.name = "Pasta";
            article_3.cost_per_item = 4;
            article_3.cos_per_kg = 13.50;
            article_3.weight = 0;
            article_3.numbers_of_items = 0;
            article_3.sum = 0;

            string[] names_of_articles = { article_1.name, article_2.name, article_3.name };
            double[,] cost_of_articles = new double[3, 3]
            {
                {article_1.cost_per_item, article_2.cost_per_item, article_3.cost_per_item},
                {article_1.cos_per_kg, article_2.cos_per_kg, article_3.cos_per_kg},
                {article_1.weight, article_2.weight, article_3.weight}
            };
            int[] array_of_items = { article_1.numbers_of_items, article_2.numbers_of_items, article_3.numbers_of_items };
            double[] array_of_sums = { article_1.sum, article_2.sum, article_3.sum };
            bool a = true;
            double bill = 0;

            Console.WriteLine("Welcome in the cash register!");
            do
            {
                Console.WriteLine("Choose your article \n");
                for (int c = 0; c < names_of_articles.Length; c++)
                {
                    Console.WriteLine($"{c + 1}.{names_of_articles[c]}, Cost per item: {cost_of_articles[0, c]}$, Cost per kg: {cost_of_articles[1, c]}$");
                }
                Console.WriteLine($"Your bill: {Math.Round(bill, 2)}$");
                int article = int.Parse(Console.ReadLine()) - 1;
                Console.Clear();
                Console.WriteLine("\n1 - Items\n2 - Weight");
                int wheight_or_items = int.Parse(Console.ReadLine());
                Console.Clear();
                if (wheight_or_items == 1)
                {

                    Console.WriteLine("Entry quantity:");
                    array_of_items[article] = int.Parse(Console.ReadLine());
                    array_of_sums[article] += how_munch_cost((double)array_of_items[article], cost_of_articles[0, article]);
                    bill += Math.Round(array_of_sums[article], 2);
                }
                if
                    {
                    Console.WriteLine("Entery weight:");
                    cost_of_articles[2, article] = double.Parse(Console.ReadLine());
                    array_of_sums[article] += jaka_cena(cost_of_articles[2, article], cost_of_articles[1, article]);
                    bill += Math.Round(array_of_sums[article], 2);
                }
                else {
                    while (wheight_or_items!=1||wheight_or_items!=2) {
                        Console.WriteLine("This isn't 1 or 2")
                        Console.WriteLine("\n1 - Items\n2 - Weight");
                        int wheight_or_items = int.Parse(Console.ReadLine());
                        Console.Clear();
                        if (wheight_or_items == 1)
                        {

                            Console.WriteLine("Entry quantity:");
                            array_of_items[article] = int.Parse(Console.ReadLine());
                            array_of_sums[article] += how_munch_cost((double)array_of_items[article], cost_of_articles[0, article]);
                            bill += Math.Round(array_of_sums[article], 2);
                        }
                        if
                        {
                            Console.WriteLine("Entry weight:");
                            cost_of_articles[2, article] = double.Parse(Console.ReadLine());
                            array_of_sums[article] += jaka_cena(cost_of_articles[2, article], cost_of_articles[1, article]);
                            bill += Math.Round(array_of_sums[article], 2);
                        }
                    }
                }
                Console.Clear();
                Console.WriteLine($"Add {array_of_sums[article]}$ to bill! Your bill is {Math.Round(bill, 2)}$");
                Console.WriteLine("Continue shopping?\n1.Continue\n2.End and bill");
                int b = int.Parse(Console.ReadLine());
                Console.Clear();
                if (b == 2)
                {
                    for (int x = 0; x < names_of_articles.Length; x++)
                    {

                        if (array_of_sums[x] != 0)
                        {
                            Console.WriteLine($"{names_of_articles[x]} Quantity : {array_of_items[x]} Weight: {cost_of_articles[2, x]}kg\nCost of item: {array_of_sums[x]}$");
                        }

                    }
                    Console.WriteLine($"Bill is: {bill} $");
                    Console.WriteLine("Press any key to continue..");
                    Console.ReadKey();
                    Console.Clear();
                    Console.WriteLine("1 - New costomer \n2 - Exit program");
                    int new_bill = int.Parse(Console.ReadLine());
                    if (new_bill == 1)
                    {
                        for (int x = 0; x < names_of_articles.Length; x++)
                        {
                            array_of_items[x] = 0;
                            cost_of_articles[2, x] = 0;
                            array_of_sums[x] = 0;

                        }
                        a = true;
                        Console.Clear();
                    }
                    else
                    {
                        a = false;
                    }
                }
            }
            while (a == true);
        }

    }
}
