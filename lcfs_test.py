import unittest
import random
from io import StringIO
from unittest.mock import patch
from lcfs import lcfs

class TestLCFSAlgorithm(unittest.TestCase):
    def test_lcfs_with_random_processes(self):
        # generowanie randomowych procesów
        random_processes = [(i, random.randint(0, 10), random.randint(1, 10)) for i in range(1, 6)]

        # zapisanie do pliku
        input_file_path = "input_data.txt"
        with open(input_file_path, 'w') as input_file:
            for process in random_processes:
                input_file.write(f"{process[0]},{process[1]},{process[2]}\n")

        # Przechwyć dane wyjściowe (stdout)
        with patch('sys.stdout', new_callable=StringIO) as mock_stdout:
            lcfs(random_processes)

        # zapisanie jw pliku
        output_file_path = "output_lcfs.txt"
        with open(output_file_path, 'w') as output_file:
            output_file.write(mock_stdout.getvalue())

        # Pobierz dane wejściowe
        with open(input_file_path, 'r') as input_file:
            input_data = input_file.read()

        # Pobierz dane wyjściowe
        with open(output_file_path, 'r') as output_file:
            output_data = output_file.read()

        # Sprawdź, czy wyniki są zgodne z oczekiwanymi
        self.assertIn("Proces\t Czas przyjścia\t Czas wykonania\t Czas oczekiwania\t Czas obrotu", output_data)
        self.assertIn("Średni czas oczekiwania:", output_data)
        self.assertIn("Średni czas obrotu:", output_data)

        # Optional: Remove temporary files
        #os.remove(input_file_path)
        #os.remove(output_file_path)

if __name__ == '__main__':
    unittest.main()
