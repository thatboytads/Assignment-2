from random import randint
file= open("///home/tadiwa/Downloads/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt")
data= []

for line in file:
    data.append(line)
file.close()

Nsamps=["number 1","number 2","number 3","number 4","number 5","number 6","number 7","number 8","number 9","number 10"]

size= 300

for samps in Nsamps:
    file1= open(samps,"w+")
    file2= open(sample+"Test","w+")