using System;
using System.Collections;

namespace phone_book
{
    class Program
    {
        static void Main(string[] args)
        {
            Hashtable phone_book = new Hashtable()
            {
                { "Kinga Borkowska","235 535 964" },
                { "Lara Krajewska", "672 854 185" },
                { "Mirosława Szewczyk", "395 743 355" },
                { "Alice Lis","468 578 235" },
                { "Dominika Górska","963 573 467" },
                { "Faustyna Baran","584 468 247" },
                { "Nina Głowacka","373 573 578" },
                { "Magda Głowacka","357 957 472" },
                { "Ewelina Czarnecka","478 257 457" },
                { "Elżbieta Sobczak","379 257 345" },
            };
            void not_exist()
            {
                Console.WriteLine("This entery doesn't exist");
                Console.WriteLine("Enter this entery to phone book? Enter yes or no");
                string yes_or_no = Console.ReadLine();
                do
                {
                    if (yes_or_no=="yes")
                    {
                        new_number();
                    }
                    else if (yes_or_no!="no")
                    {
                        Console.WriteLine("This isn't yes or no. Enter yes or no");
                        string yes_or_no = Console.ReadLine();
                    }
                } while (yes_or_no!="yes"||yes_or_no=!"no")
            }
            string name = "a";
            string number = "111 111 111";
           void new_number()
            {
                try
                {
                    Console.WriteLine("Entry first and last name");
                    name=Console.ReadLine();
                    Console.WriteLine("Entry number");
                    number=Console.ReadLine();
                    phone_book.Add(name, number);
                }
                catch (ArgumentException)
                {

                    Console.WriteLine("This entry already exist");
                }
            }

           void display()
            {
                Console.WriteLine("This is your phone book:");
                if (phone_book.Count == 0)
                {
                    Console.WriteLine("Your phone book is empty, make it up");
                }
                else
                {
                    foreach (DictionaryEntry entry in phone_book)
                    {
                        Console.WriteLine($" - {entry.Key}: {entry.Value}");
                    }
                }
            }

           void searching_for_name()
            {
                Console.WriteLine("\n Searching for name:");
                Console.WriteLine("\nEntery first and last name of owner searching number:");
                string name = Console.ReadLine();
                if (phone_book.Contains(name))
                {
                    string number = (string)phone_book[name];
                    Console.WriteLine($"Number of {name}: {number}");
                }
                else
                {
                    not_exist();
            }

           void searching_for_number()
            {
                Console.WriteLine("\n Searching for number:");
                Console.WriteLine("\n Enter number in the form of 000 000 000:");
                string phone_number = Console.ReadLine();
                if (phone_book.Contains(phone_number))
                {
                    string name = (string)phone_book[phone_number];
                    Console.WriteLine($"Owner of number {number} is: {name}");
                }
                else
                {
                        not_exist();
                }
            }

            char x = 'b';


            do {
                Console.WriteLine("Choose what you want to do:");
                Console.WriteLine("- [w]  Display your phone book");
                Console.WriteLine("- [s] Searching for name");
                Console.WriteLine("- [a] Searching for number");
                Console.WriteLine("- [d] Add new phone number");
                Console.WriteLine("- [x] Exit");
                x=char.Parse(Console.ReadLine());
                    Console.Clear();

                switch (x)
                {
                    case 'w':
                        display();
                        break;
                    case 's':
                        searching_for_name();
                        break;
                    case 'a':
                        searching_for_number();
                        break;
                    case 'd':
                        new_number();
                        break;
                    default:
                        break;
                }

            }
            while (x!='x');


           
        }
    }
}
