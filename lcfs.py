def lcfs(processes):
    n = len(processes)
    if n == 0:
        print("No processes to schedule.")
        return
    # Sortowanie procesów według czasu przyjścia (arrival time) w odwrotnej kolejności
    processes.sort(key=lambda x: x[1], reverse=True)

    # Inicjalizacja czasu oczekiwania, czasu obrotu i czasu procesora
    waiting_time = [0] * n
    turnaround_time = [0] * n
    cpu_time = 0
    # Obliczanie czasu oczekiwania i czasu obrotu dla każdego procesu
    while turnaround_time.count(0) >= 1:
        for e in range (0,n):
            if cpu_time >= processes[e][1]:
                if turnaround_time[e]<1:
                    waiting_time[e] = cpu_time - processes[e][1]
                    cpu_time = cpu_time + processes[e][2] + waiting_time[e]
                    turnaround_time[e] = waiting_time[e] + processes[e][2]
                    u=0
                    for i in range (0,e):
                        if cpu_time >= processes[i][1]:
                            u=1
                    if u== 1:

                        break
        else:
            cpu_time+=1

    n = len(processes)
    # Średni czas oczekiwania i średni czas obrotu
    avg_waiting_time = sum(waiting_time) / n
    avg_turnaround_time = sum(turnaround_time) / n

    # Wyświetlanie wyników
    print("Proces\t Czas przyjścia\t Czas wykonania\t Czas oczekiwania\t Czas obrotu")
    for i in range(n):
        print(
            f"{processes[i][0]}\t\t\t\t {processes[i][1]}\t\t\t\t {processes[i][2]}\t\t\t\t {waiting_time[i]}\t\t\t\t {turnaround_time[i]}")

    print(f"\nŚredni czas oczekiwania: {avg_waiting_time}")
    print(f"Średni czas obrotu: {avg_turnaround_time}")


# Przykładowe użycie:
if __name__ == "__main__":
    # Format procesu: (ID, czas przyjścia, czas wykonania)
    processes = [(1, 0, 5), (2, 2, 4), (3, 4, 2), (4, 6, 8)]
    lcfs(processes)

