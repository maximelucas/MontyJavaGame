Monty Java and the Holy Grail
=============

This is a 2D game project for an OOP class in Java, using the MVC design pattern.  
It was written for a course project.

##Story
You are a part of King Arthur's Round Table and have one goal in life to find the Holy Grail.
For this, you will have to find it and more important, be brave enough to earn it ! 
During your quest, you will come accross people willing to help you and others to stop you.
One more thing ! You do not have much time, the police is looking after you.
You killed that historian, remember ...?

##How to play
The player plays alone with a knight (represented by the letter "p" for player) whose two main skills are fighting and joking.
When you launch the game, you are asked to choose your difficulty level. **to be implemented**
The difficulty level influences on the total of fighting and joking skill points the player begins with : more difficult, less skilled.

Now the game begins.  
The player finds himself on a map, represented by tiles, and can move using the arrow keys, one tile by one.  
The player can only see two tiles far around him, the rest hidden.  
The goal is to reach the tile where the *Holy Grail* (represented by a "t" for trophy) is, and to be skilled enough (at least 15 fighting or joking skill points) to earn it and win.  
Beware : the player has a finite number of steps to do, or lose.

*How to improve the player's skills ?*  
The player may encounter minstrels that will help him (represented by a "h" for *helper*). 
When so, the player is asked if he wants improve his fighting or joking skills, or gain some extra steps.  
The player may also encounter *enemies* ("e"), which he will have to beat in a fight, or make laugh enough with a joke. 
The skills points needed to beat the enemy, depends on each of them and is random. If the enemy is beaten, the player will gain some skill points according to the chosen type of "combat" : joke or fight.  

*What is the score based on ?*  
Every time the player beats an enemy, the score is increased. Hence, even if the player loses the game (ie do not win the trophy), the high score can be beaten. Winning the Holy Grail obviously makes it easier to do so, since it incrases the score much.
