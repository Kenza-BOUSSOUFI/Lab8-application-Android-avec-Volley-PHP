# Lab8-application-Android-avec-Volley-PHP

Partie 1 — Création de la base de données MySQL


La création de la bdd mysql école_lab8 et la table Student:
<img width="945" height="275" alt="image" src="https://github.com/user-attachments/assets/16beb5aa-5340-4c47-a5c5-3b73790622c5" />

Ajouter des enregistrements tests :

<img width="945" height="230" alt="image" src="https://github.com/user-attachments/assets/a081baad-11ad-4341-a1ea-33784fd06f46" />

Partie 2 — Développement du Web Service PHP 8
1- Pour la création du projet php, j'ai travaillé avec l'IDE (visuel studio code).
######################### Structure du projet ########################
<img width="608" height="698" alt="image" src="https://github.com/user-attachments/assets/af1e75d7-0408-4662-b108-9e4e3f036320" />
              2-Tester les Web Services avec Advanced REST Client sur Postman:
2.1: Test du service d’ajout d’un étudiant
1️⃣ Méthode 
Choisir : POST
2️⃣ URL
http://localhost/Lab8-application-Android-avec-Volley-PHP/Ws/createStudent.php

3️⃣ Body
Cliquer sur Body;
Choisir x-www-form-urlencoded

4️⃣ Cliquer sur Send
<img width="945" height="575" alt="image" src="https://github.com/user-attachments/assets/8bc5aedf-71dc-46fe-899d-d889869711e8" />

<img width="945" height="567" alt="image" src="https://github.com/user-attachments/assets/a83bd2d9-564e-4c83-8980-7e344611951b" />

2.2:Test du service de lecture des étudiants
Avec la méthode GET.

<img width="945" height="847" alt="image" src="https://github.com/user-attachments/assets/4f95cb4a-e5a9-4286-957d-731772dd80b2" />


Partie 3 — Application Android (Volley + Gson)
Étape 4.7 – Test et vérification:
1- Aprés faire lancer le serveur Apache et MySQL et exécuter l’application sur l’émulateur (pixel 6).On va essayer de Saisir un étudiant et cliquer sur Inscrire l'etudiant:

<img width="711" height="1102" alt="image" src="https://github.com/user-attachments/assets/2a53e2b2-9269-4376-9877-956b59f2c434" />

2- On va ouvrir Logcat pour observer la réponse du serveur:

<img width="945" height="488" alt="image" src="https://github.com/user-attachments/assets/fb6df3b4-e11f-48b0-b696-d6500ca6452e" />

L'étudiant nommé test1 test que j'ai ajouté, est affiché dans la réponse du serveur.

3- On va afficher la liste des étudiants:

<img width="944" height="1127" alt="image" src="https://github.com/user-attachments/assets/e193b9b8-0a23-4341-b91e-560734e97e71" />






