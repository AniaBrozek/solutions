using System;

namespace Searching
{
    class Program 
    {
        static void Main(string[] args)
        {
            void searching_name(string a, string b, int i)
            {
                if (i<a.Length)
                {
                    if (a[i].CompareTo(b[i])==0)
                    {
                        i++;
                        searching_name(a, b, i);
                    }
                }
                else
                {
                    Console.WriteLine(b);
                }

            }
            string name = "Anna";
            var txt = System.IO.File.ReadAllLines(@"C:list.txt");
            Console.WriteLine("Enter name, which you want to search:");
            name=Console.ReadLine();
            name+=" ";
            foreach (var item in txt)
            {
                int i = 0;
                searching_name(name, item, i);
            }

        }

    }
}