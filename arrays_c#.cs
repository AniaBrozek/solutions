using System;

namespace coordinatesystem
{
    class Program
    {
        static void Main(string[] args)
        {
            void funkcja(string[,] d, int a, int b, string c int r) //funcion fills the array squere rxr of given char, starting with point [a,b]
            {
                 for (int i=a; i<a+e; i++)
                {
                    for (int j = b; j < b+e; j++)
                    {
                        d [i, j] = c;

                    }
                }
            }s




            string[,] tablica = new string[6, 6];
            funkcja(tablica, 0, 0, "[%]",3);
            funkcja(tablica, 0, 3, "[#]",3);
            funkcja(tablica, 3, 0, "[*]",3);
            funkcja(tablica, 3, 3, "[+]",3);
            
            for (int i = 0; i < 6; i++)
            {
                for (int j = 0; j < 6; j++)
                {
                    Console.Write(tablica[i, j]);
                }
                Console.WriteLine();
            }
        }
    }
}