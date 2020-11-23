Feature: Abonnement
la creation dun utilisateur dans la base
Scenario: creation abonne
Given lutilisateur cree son abonnement
When lutilisateur rempli "Yoyo" , "tata" et "tatayoyo@gmail.com"
Then lutilisateur est ajoute

Scenario: creation vulnerabilite
Given ladmin cree une vulnerabilite
When ladmin rempli 1, "titre", "synthese", "description", "logiciels"
Then la vulnerabilite est ajoutee


