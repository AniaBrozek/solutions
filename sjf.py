def sjf(processes):
    n = len(processes)
    if n == 0:
        print("No processes to schedule.")
        return
    # Inicjalizacja czasu oczekiwania i czasu obrotu
    waiting_time = [0] * n
    turnaround_time = [0] * n
    cpu_time = 0

    # Sortowanie procesów według czasu wykonania (burst time)
    processes.sort(key=lambda x: x[2])
    processes_copy=processes.copy()
    # Obliczanie czasu oczekiwania i czasu obrotu dla każdego procesu
    while len(processes)>0:
        possible_processes=[]
        for i in range(0, n):
            if cpu_time>=processes[i][1]:
                possible_processes.append(processes[i])
        if len(possible_processes)==0:
            cpu_time+=1
        else:
            index=processes_copy.index(possible_processes[0])
            waiting_time[index]=cpu_time-possible_processes[0][1]
            turnaround_time[index]=waiting_time[index]+possible_processes[0][2]
            cpu_time = cpu_time + possible_processes[0][2] + waiting_time[0]
            processes.remove(possible_processes[0])
            n=n-1

    # Średni czas oczekiwania i średni czas obrotu
    n=len(processes_copy)
    avg_waiting_time = sum(waiting_time) / n
    avg_turnaround_time = sum(turnaround_time) / n

    # Wyświetlanie wyników
    print("Proces\t Czas przyjścia\t Czas wykonania\t Czas oczekiwania\t Czas obrotu")
    for i in range(n):
        print(
            f"{processes_copy[i][0]}\t\t\t\t {processes_copy[i][1]}\t\t\t\t {processes_copy[i][2]}\t\t\t\t {waiting_time[i]}\t\t\t\t {turnaround_time[i]}")

    print(f"\nŚredni czas oczekiwania: {avg_waiting_time}")
    print(f"Średni czas obrotu: {avg_turnaround_time}")


# Przykładowe użycie:
if __name__ == "__main__":
    # Format procesu: (ID, czas przyjścia, czas wykonania)
    processes = [(1, 7, 7), (2, 8, 6), (3, 7, 10), (4, 2, 7)]
    sjf(processes)
