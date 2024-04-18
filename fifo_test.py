import unittest
import random
import os
from io import StringIO
from unittest.mock import patch
from fifo import fifo

def generate_and_save_input_data(file_path, num_references=50, max_page=9):
    with open(file_path, 'w') as file:
        for _ in range(num_references):
            page = random.randint(0, max_page)
            file.write(f"{page}\n")

class TestFIFOAlgorithm(unittest.TestCase):
    def test_fifo_with_random_page_references(self):
        input_file_path = "test.txt"

        # Wygeneruj i zapisz losowe dane wejœciowe do pliku
        generate_and_save_input_data(input_file_path)

        # Wczytaj dane wejœciowe z pliku
        with open(input_file_path, 'r') as file:
            page_references = [int(line.strip()) for line in file.readlines()]

        buffer_size = 4

        # Przechwyæ dane wyjœciowe (stdout)
        with patch('sys.stdout', new_callable=StringIO) as mock_stdout:
            fifo(page_references, buffer_size)


if __name__ == '__main__':
    unittest.main()
