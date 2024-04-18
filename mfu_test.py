import unittest
from io import StringIO
from unittest.mock import patch
from mfu import mfu

class TestMFUAlgorithm(unittest.TestCase):
    def test_mfu_with_file_input(self):
        # Przygotuj dane testowe
        input_file_path = "test.txt"
        output_file_path = "output_mfu.txt"

        # Wczytaj dane wejœciowe z pliku
        with open(input_file_path, 'r') as file:
            page_references = [int(line.strip()) for line in file.readlines()]

        # Wywo³aj funkcjê MFU, przechwytuj¹c stdout
        with patch('sys.stdout', new_callable=StringIO) as mock_stdout:
            buffer_size = 3
            with open(input_file_path, 'r') as file:
                page_references = [int(line.strip()) for line in file.readlines()]
                mfu(page_references, buffer_size)

        # Zapisz dane wyjœciowe do pliku
        with open(output_file_path, 'w') as output_file:
            output_file.write(mock_stdout.getvalue())

        # Przechwyæ dane wyjœciowe (stdout)
        with patch('sys.stdout', new_callable=StringIO) as mock_stdout:
            mfu(page_references, buffer_size)

        # Optional: Usuñ tymczasowe pliki
        # os.remove(input_file_path)
        # os.remove(output_file_path)

if __name__ == '__main__':
    unittest.main()
