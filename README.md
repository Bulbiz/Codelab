# CODELAB 3

## Update semaine du 30/03

Liste des choses ajoutées cette semaine
- Grégoire a implémenté la suppression d'instruction, optimisé et factorisé le code des instructions, et commencé sur une autre branche a implémenter l'éditeur de niveau
- Thierry a réparé les instructions If et While. 
- Rémy a commencé sur une autre branche à implémenter sa partie de l'éditeur de niveau. La semaine prochaine, sa partie et celle de Grégoire seront fusionnées et ajoutées à develop
- Antoine a implémenté les popups de victoire et de défaite

Instructions pour tester le code : 
- Pour compiler et lancer, faites : make && make run
- Pour tester d'entrer différentes instructions pour déplacer le personnage, cliquez sur un générateur gris à droite et faites un glisser-déposer sur une instruction à gauche pour l'ajouter à la suite (au début, relâcher la souris au dessus de l'instruction begin). Pour les If et les While, il faut entrer une condition et une action. Pour cela, cliquer sur un générateur de condition à droite et relâchez la souris au dessus de l'emplacement bleu. Faites de même pour ajouter une ou plusieurs actions sur l'emplacement orange. N'hésitez pas à déplacer des actions existantes dans tous les sens, le code est censé pouvoir être manipulé librement.
- Pour tester votre liste d'instructions et constater ses effets sur le plateau, cliquez sur le bouton "Run or Stop" (en vous assurant que tous les champs des if et while sont remplis). Vous pouvez interrompre la lecture des instructions en cliquant sur le bouton "Run or Stop" ou "Restart". A la fin de la lecture de vos instructions, un message est affiché sur le terminal en cas d'échec ou de victoire (si le personnage a atteint l'arrivée ou non). Vous pouvez réappuyer sur "Run or Stop" pour tester de nouvelles instructions.
- Pour tester le loading de level, rendez-vous dans la branche loadLevel, faites : make && make run, une fenêtre devrait alors apparaitre, entrez "test" dans la zone de texte, cela devrait charger le niveau de test
-Pour tester la création d'un fichier JSON depuis un level déjà initier,(branche develop) il faut aller dans le test.java. Il faut enlever le commentaire testLevelToJson dans begin() puis faire un make andrun pour qu'il crée le fichier. Apres avoir obtenu ce fichier vous pouvez eventuellement replacer test.json par ce nouveau Json pour voir qu'il fonctionne bien.


## Equipe

- Thierry CHHOA,
- Antoine KHOW,
- Gregoire  MARIN,
- Remy PHOLASA

## Mails perso

- chhoathierryprojet@gmail.com
- ano.kh@hotmail.fr
- gregoire.marin124@orange.fr
- pholasa2@outlook.fr

## Mails universitaires

- gregoire.marin@etu.univ-paris-diderot.fr
- remy.phol@etu.univ-paris-diderot.fr
- thierry.chhoa@etu.univ-paris-diderot.fr
- antoine.khow@etu.univ-paris-diderot.fr
