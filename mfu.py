def mfu(page_references, buffer_size):
    page_faults = 0
    page_buffer = []

    for i in range(0, len(page_references)):
        if page_references[i] not in page_buffer:
            page_faults += 1
            if len(page_buffer) < buffer_size:
                page_buffer.append(page_references[i])
            else:
                # Wybieramy stronę, która była najczęściej używana
                appearances = 0
                most_frequent_page = page_references[i]
                copied_array = page_references[0:i]
                for p in copied_array:
                    if (copied_array.count(p) >= appearances and
                    page_buffer.count(p) != 0):
                                appearances = copied_array.count(p)
                                most_frequent_page = p
                page_buffer.remove(most_frequent_page)
                page_buffer.append(page_references[i])

        print(f"Strony w buforze po odwołaniu do strony {page_references[i]}: {page_buffer}")

    print(f"Liczba błędów stron: {page_faults}")


# Przykładowa sekwencja odwołań do stron
with open('test.txt', 'r') as file:
    # Odczytaj całą zawartość pliku
    page_references = list(file.read())
buffer_size = 6

# Wywołanie funkcji symulującej algorytm MFU
mfu(page_references, buffer_size)
