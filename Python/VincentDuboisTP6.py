import random

def creachaine():
    L1="ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    L2 =  "abcdefghijklmnopqrstuvwxyz"
    L3 = "0123465789"
    L4 = "*$+&<>="
    L = L1 + L2 + L3 + L4
    mdp = ""
    long = random.randint(8,12)
    for n in range(long):
        a =random.randint(0, len(L) - 1)
        mdp = mdp + L [a]

    return mdp

def verification(mdp):
    L1="ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    L2 =  "abcdefghijklmnopqrstuvwxyz"
    L3 = "0123465789"
    L4 = "*$+&<>="
    nbmajs = 0
    nbminus = 0
    nbval = 0
    nbsignes = 0
    for i in range(len(mdp)):
        if mdp[i] in L1:
            nbmajs += 1
        if mdp[i] in L2:
            nbminus += 1
        if mdp[i] in L3:
            nbval += 1
        if mdp[i] in L4:
            nbsignes += 1
    if(nbmajs > 0 and nbminus > 0 and nbval > 0 and nbsignes > 0 and len(mdp) >= 8 and len(mdp) <= 12):
        print("le mot de passe est valide")
    else:
        print("le mot de passe est invalide")
        
