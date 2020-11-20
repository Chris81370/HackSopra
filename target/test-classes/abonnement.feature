Feature: Abonnement
la creation dun utilisateur dans la base
Scenario Outline: n/a
Given lutilisateur cree son abonnement
When lutilisateur rempli le <"nom"> , le <"prenom"> et le <"email">  
Then lutilisateur est ajoute

Examples:
|nom|prenom|email|
|Yoyo|tata|tatyoyo@gmail.com|
|Montana|Tony|tonymontana@gmail.com|

