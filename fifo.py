def fifo(page_references, buffer_size):
    page_faults = 0
    page_buffer = []

    with open('output_fifo.txt', 'w') as output_file:
        for page in page_references:
            if page not in page_buffer:
                page_faults += 1
                if len(page_buffer) < buffer_size:
                    page_buffer.append(page)
                else:
                    # Usuwamy najstarszą stronę (pierwszą dodaną)
                    page_buffer.pop(0)
                    page_buffer.append(page)

            output_line = f"Strony w buforze po odwołaniu do strony {page}: {page_buffer}\n"
            print(output_line)
            output_file.write(output_line)

        output_line = f"Liczba błędów stron: {page_faults}"
        print(output_line)
        output_file.write(output_line)

# Przykładowa sekwencja odwołań do stron
with open('test.txt', 'r') as file:
    # Odczytaj całą zawartość pliku
    page_references = [int(line.strip()) for line in file.readlines()]

buffer_size = 4

# Wywołanie funkcji symulującej algorytm FIFO
fifo(page_references, buffer_size)
