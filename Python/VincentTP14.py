def cesar(mot,d):
    #Initialisation du mot final
    mot_final = ""
    #Parcours de mes lettres dans mon mot
    for lettre in mot:
        #si il y a un estpace je met un espace
        if( lettre == " "):
            mot_final += lettre
        else:
            #passage en ASCII,
            val = ord(lettre) + d
            #si val est supérieur à 122, la valeur de 'z' en ascii, on soustrait 26
            if(val > 122):
                val -= 26
            #si val ests inférieur à 97, la valeur de 'a' en ascii, on additionne 26
            if( val < 97):
                val += 26
            #on repasse en caractère
            l = chr(val)
            #on concatène le mot final et la lettre
            mot_final += l
    return mot_final

def freq_lettres(mot):
    #on utilise un dictionnaire, les lettres sont les clés,
    #le nombre de fois qu'elle apparaissent les valeurs
    dico_lettres = {}
    #parcours de mon mot
    for i in mot:
        #si la lettre est dans le dico, je rajoute 1 à la valeur de la lettre
        if i in dico_lettres:
            dico_lettres[i] += 1
        #sinon j'ajoute la lettre dans le dico et lui donne la valeur de 1
        else:
            dico_lettres[i] = 1
    return dico_lettres


def cesar_dechiffre(textchiffre): #utiliser un mot chiffré/une phrase avec plein de 'e'
                                    #des lettres de [a-z] et des espaces
    #je récupère la fréquence de me lettres
    freqs = freq_lettres(textchiffre)

    max_freq = 0
    lettre_la_plus_freq = ''
    #je recherche la lettre la plus fréquente
    for letter in freqs.keys():
        if freqs[letter] > max_freq:
            max_freq = freqs[letter]
            lettre_la_plus_freq = letter
    
    #je récupère la clé en comparaison avec la valeur ascii en 'e'
    key = (ord(lettre_la_plus_freq) - ord('e')) % 26

    mot_final = cesar(textchiffre,-key)

    return key, mot_final