import unittest
from io import StringIO
from unittest.mock import patch
from sjf import sjf


class TestSJFlgorithm(unittest.TestCase):
    def test_sjf(self):
        input_file_path = "input_data.txt"

        # czytanie danych z pliku
        with open(input_file_path, 'r') as file:
            input_text = file.read()

        # rozdzielanie
        lines = input_text.split('\n')
        input_data = [tuple(map(int, line.split(','))) for line in lines if line]

        # Przekieruj stdout i uruchom funkcjê sjf
        with patch('sys.stdout', new_callable=StringIO) as mock_stdout:
            sjf(input_data)
        with open("output_sjf.txt", 'w') as output_file:
            output_file.write(mock_stdout.getvalue())

        # Przeczytaj oczekiwane wyjœcie z pliku
        with open("output_sjf.txt", 'r') as output_file:
            expected_output = output_file.readlines()


        # porównanie
        actual_output = mock_stdout.getvalue().split('\n')
        for expected, actual in zip(expected_output, actual_output):
            self.assertEqual(expected.strip(), actual.strip())

        print(mock_stdout.getvalue())


if __name__ == '__main__':
    unittest.main()
